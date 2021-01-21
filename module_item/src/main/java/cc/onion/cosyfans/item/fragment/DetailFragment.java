package cc.onion.cosyfans.item.fragment;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.tmall.ultraviewpager.UltraViewPager;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.base.BaseFragment;
import cc.onion.cosyfans.base.dialog.BaseBottomSheetDialog;
import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.base.exception.ExceptionCode;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.GlideImageLoader;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.SoftKeyBoardUtils;
import cc.onion.cosyfans.base.utils.TextMeoneryShowUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.view.loadView.ILoadVew;
import cc.onion.cosyfans.base.view.loadView.ULoadView;
import cc.onion.cosyfans.item.adapter.CoverPagerAdapter;
import cc.onion.cosyfans.item.adapter.DetailItemAdapter;
import cc.onion.cosyfans.item.dialog.CouponDilalog;
import cc.onion.cosyfans.item.dialog.DiscountDilalog;
import cc.onion.cosyfans.item.dialog.ProductAddCartDilalog;
import cc.onion.cosyfans.item.entity.ItemDetailRequest;
import cc.onion.cosyfans.item.entity.SkuBaseEntity;
import cc.onion.cosyfans.item.entity.response.ItemDetailEntity;
import cc.onion.cosyfans.item.listener.ProductItemViewListener;
import cc.onion.cosyfans.item.viewModel.DetailAndroidViewModel;
import cc.onion.cosyfans.main.event.PageMainEvent;
import cc.onion.cosyfans.module_item.R;
import cc.onion.cosyfans.module_item.databinding.ItemFragmentProductsDetailBinding;
import cc.onion.cosyfans.passport.utils.SoftKeyboard;
import io.reactivex.disposables.Disposable;


/**
 * 商品详情
 * @author  guobihai
 * @date 2019 - 11- 08
 */
@SuppressLint("ValidFragment")
@Route(path = RouterPath.Item.ROUTE_ITEM_DETAIL)
public class DetailFragment extends BaseFragment<ItemFragmentProductsDetailBinding, DetailAndroidViewModel> implements ProductItemViewListener {

    //轮播图
    CoverPagerAdapter coverPagerAdapter;
    // 轮播图
    private UltraViewPager coverViewPager;

    private String itemId;

    private ILoadVew loadVew;

    String htmlUrl;

    /**
     * 对话框显示
     * @param itemId
     */
    private BaseBottomSheetDialog  commissionDilalog,discountDilalog,productAddCartDilalog,couponDilalog;

    View.OnScrollChangeListener mScrollChanageListener;

    @SuppressLint("ValidFragment")
    public DetailFragment(String itemId, View.OnScrollChangeListener listener) {
        this.itemId =itemId;
        this.mScrollChanageListener = listener;
    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.item_fragment_products_detail;
    }

    @Override
    public int initVariableId() {
        return cc.onion.cosyfans.module_item.BR.viewModel;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void initData() {
        super.initData();
        mViewModel.setViewListener(this);
        if(StringUtils.isNotEmpty(itemId)){
            loadVew = new ULoadView(mBinding.body);
            loadVew.showLoading();
            loaddingData();
            loadCartAmonut();
            setScorTop();
        }


        mBinding.getRoot().setOnClickListener(v -> {
            SoftKeyBoardUtils.closeKeyBoard(getActivity());
        });
        SoftKeyboard.of(getActivity()).listen(new SoftKeyboard.OnSoftKeyboardChangeListener() {
            @Override
            public void onHide() {
                ToastUtil.Short("AA");
            }

            @Override
            public void onShow() {
                //隐藏布局


            }
        });



    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setScorTop() {
        mBinding.imgTop.setOnClickListener(v -> {
//            mBinding.netScroview.scrollTo(0,0);
            mBinding.scrollView.smoothScrollTo(0, 1);
        });
        mBinding.scrollView.setOnScrollChangeListener((View.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            mScrollChanageListener.onScrollChange(v, scrollX, scrollY, oldScrollX, oldScrollY);
            try {

                if (scrollY > oldScrollY) {
                    KLog.e("=====", "下滑");
                    if(scrollY >1000){
                        mBinding.imgTop.setVisibility(View.VISIBLE);
                    }


                }

                if (scrollY < oldScrollY) {
                    KLog.e("=====", "上滑");
                    if(scrollY < 1000){
                        mBinding.imgTop.setVisibility(View.GONE);
                    }
                }




                if (scrollY == 0) {

                    KLog.e("=====", "滑倒顶部");
                    mBinding.imgTop.setVisibility(View.GONE);
                }



                if (scrollY == (mBinding.scrollView.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())) {
                    KLog.e("=====", "滑倒底部");
//                    mBinding.imgTop.setVisibility(View.GONE);
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }



    /***
     * 获取购物车数量
     */
    private void loadCartAmonut() {
        BaseRequestBean requestBean = new BaseRequestBean();
        requestBean.sign();
        mViewModel.getCatAmount(requestBean, new ResponseListener<BaseResponse>() {
            @Override
            public void loadSuccess(BaseResponse data) {
                if(data.getData() != null){
                    KLog.i("test","购物车数量");
                }

            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {

            }

            @Override
            public void addDisposable(Disposable disposable) {
                addDisposable(disposable);
            }
        });
    }


    private void loaddingData() {
//     126499    15745   29197
//        itemId = 15745+"";

        ItemDetailRequest request = new ItemDetailRequest();
        request.setItemId(itemId);
        request.getKeyMap().put("itemId",itemId);
        request.setRequestSign(request.getKeyMap());
        mViewModel.getItemDetail(request, new ResponseListener<ItemDetailEntity>() {
            @Override
            public void loadSuccess(ItemDetailEntity data) {
                KLog.i("test","加载成功");
                if(data.getData() != null){
                    loadVew.hide();
                    if(data.getData().getItemBaseInfoDTO() != null){
                        ItemDetailEntity.DataBean.ItemBaseInfoDTOBean infoDTO = data.getData().getItemBaseInfoDTO();

                        if(data.getData().getItemBaseInfoDTO().getSwiperList() != null && data.getData().getItemBaseInfoDTO().getSwiperList().size() >0){
                            initBanner(data.getData().getItemBaseInfoDTO().getSwiperList());
                        }

                        TextMeoneryShowUtils.setShowBigMonery(mBinding.tvProductsMonery,infoDTO.getSellingPriceRange());
                        TextMeoneryShowUtils.setShowLineMonery(mBinding.tvProductsMoneryReal,infoDTO.getMarketPriceRange());

                        mViewModel.produtctTitle.set(infoDTO.getName());
                        mViewModel.deliverytime.set("物流时效："+infoDTO.getTimeliness());
                    }



                    //促销
                    if(data.getData().getItemDetailPromotionLevelDTO() != null){
                        ItemDetailEntity.DataBean.ItemDetailPromotionLevelDTOBean promotion = data.getData().getItemDetailPromotionLevelDTO();
                        //折扣
                        if(StringUtils.isNotEmpty(promotion.getPromotionLabel())){
                            mViewModel.promotion.set(promotion.getPromotionLabel());
                            //促销
                            discountDilalog = new DiscountDilalog(getActivity(),promotion.getCfPromotionLevelDTOS());
                        }else{
                            mBinding.layoutPromotion.setVisibility(View.GONE);
                        }
                        //


                    }

                    //优惠券
                    if(data.getData().getCfCouponDTO() != null){
                        String couponLabel = null;
                        if(data.getData().getCfCouponDTO().getCouponLabel() != null){
                            couponLabel = (String) data.getData().getCfCouponDTO().getCouponLabel();
                        }
                        if(StringUtils.isNotEmpty(couponLabel)){
                            mBinding.layoutVochers.setVisibility(View.VISIBLE);
                            mViewModel.vouchers.set(couponLabel);
                            //初始化优惠券对话框
                            couponDilalog = new CouponDilalog(getActivity(),itemId);
                        }else{
                            mBinding.layoutVochers.setVisibility(View.GONE);
                        }
                    }else{
                        mBinding.layoutVochers.setVisibility(View.GONE);
                    }


                    //详情页，初始化详情页后半截
                    if(StringUtils.isNotEmpty(data.getData().getItemBaseInfoDTO().getItemDesc())){
//                        mBinding.webContext.setVisibility(View.VISIBLE);
                        htmlUrl = data.getData().getItemBaseInfoDTO().getItemDesc();
                        initWebView(data.getData().getItemBaseInfoDTO().getItemDesc());
                    }else{
//                        mBinding.webContext.setVisibility(View.GONE);
                    }


                    //是否显示商品描述，0不显示，1显示
                    if(data.getData().getItemBaseInfoDTO().getItemDescFlag() == 1){
                        mBinding.webContext.setVisibility(View.GONE);
                            mBinding.rlItemDetail.setLayoutManager(new LinearLayoutManager(getActivity(),1,false));
                            DetailItemAdapter detailItemAdapter = new DetailItemAdapter(null);
                        mBinding.rlItemDetail.setAdapter(detailItemAdapter);
                        detailItemAdapter.setNewData(data.getData().getItemAttributeDTOList());
                        detailItemAdapter.notifyDataSetChanged();
                        //显示网页
                        if(StringUtils.isNotEmpty(data.getData().getItemBaseInfoDTO().getItemDesc())) {
                            mBinding.webContext.setVisibility(View.VISIBLE);
                            htmlUrl = data.getData().getItemBaseInfoDTO().getItemDesc();
                            initWebView(data.getData().getItemBaseInfoDTO().getItemDesc());
                        }
                    }else{
                        mBinding.webContext.setVisibility(View.GONE);
                    }

                    //获取SKU数据
                    if(data.getData().getSkuInfoShowDTO() != null && data.getData().getSkuInfoShowDTO().getSkuPriceMap() != null){
                        //初始化购物车对话框操作
                        productAddCartDilalog = new ProductAddCartDilalog(request,getActivity());

                    }


                    //销售等级划分

//                    data.getData().getSkuInfoShowDTO()


                }


            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                if (errorCode.equals(ExceptionCode.NO_NERWORK_ERROR)) {
                    loadVew.showNetworkError(v -> {
                        // 无网络
                        loadVew.showLoading();
                        loaddingData();
                    });
                } else {
                    loadVew.showError("数据加载失败：" + errorCode + "\n" + errorMsg, v -> {
                        loadVew.showLoading();
                        loaddingData();
                    });
                }
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addDisposable(disposable);
            }
        });
    }



    /**
     * 初始化广告图
     * @param detailList
     */
    private void initBanner(List<ItemDetailEntity.DataBean.ItemBaseInfoDTOBean.SwiperListBean> detailList) {
        List<String> bannerList =new ArrayList<>();
        List<String>titleList =new ArrayList<>();
        for (ItemDetailEntity.DataBean.ItemBaseInfoDTOBean.SwiperListBean model: detailList) {
            bannerList.add(model.getImageBig());
        }


        mBinding.homeBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        mBinding.homeBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBinding.homeBanner.setImages(bannerList);
        //设置banner动画效果
        mBinding.homeBanner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
        mBinding.homeBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置自动轮播，默认为true
        mBinding.homeBanner.isAutoPlay(true);
        //设置轮播时间
        mBinding.homeBanner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        mBinding.homeBanner.setIndicatorGravity(BannerConfig.CIRCLE_INDICATOR);
        //banner设置方法全部调用完毕时最后调用
        mBinding.homeBanner.start();
    }


    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView(String url) {
    String data = null;
        WebSettings webSettings = mBinding.webContext.getSettings();
        webSettings.setLoadWithOverviewMode(true);//设置WebView是否使用预览模式加载界面。
        mBinding.webContext.setVerticalScrollBarEnabled(false);//不能垂直滑动
        mBinding.webContext.setHorizontalScrollBarEnabled(true);//不能水平滑动
        webSettings.setTextSize(WebSettings.TextSize.NORMAL);//通过设置WebSettings，改变HTML中文字的大小
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);//支持通过JS打开新窗口
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);

        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);

        // 使页面适应用户屏幕
//        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);



        //设置WebView属性，能够执行Javascript脚本
        mBinding.webContext.getSettings().setJavaScriptEnabled(true);//设置js可用
        mBinding.webContext.setWebViewClient(new WebViewClient());
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//支持内容重新布局

        mBinding.webContext.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {

                }
            }
        });


        getNewHtml(url);
        KLog.i("test","网页URL："+getHtmlData(url));
        mBinding.webContext.loadData(getHtmlData(url),"text/html; charset=UTF-8", "utf-8");



    }
    private String getHtmlData(String bodyHTML) {
       String url = "<html>\n" +
               "\t<head>\n" +
               "\t\t<meta charset=\"utf-8\">\n" +
               "\t\t<meta name=\\\"viewport\\\" content=\\\"initial-scale=1.0, maximum-scale=1.0, user-scalable=no\\\" />\n" +
               "\t\t<title></title>\n" +
               "\t\t<style type=\\\"text/css\\\">\n" +
               "\t\t\timg {\n" +
               "\t\t\t\twidth:100%;\n" +
               "\t\t\t\theight:auto;\n" +
               "\t\t\t\tdisplay:block;\n" +
               "\t\t\t\tclear:both;\n" +
               "\t\t\t\tmargin:auto\n" +
               "\t\t\t   } \n" +
               "\t\t\tbody {\n" +
               "\t\t\t\tmargin-right:20px;\n" +
               "\t\t\t\tmargin-left:20px;\n" +
               "\t\t\t\tmargin-top:20px;\n" +
               "\t\t\t\tfont-size:15px;\n" +
               "\t\t\t\tfont-color:#666666\"+\n" +
               "\t\t\t\twidth:window.screen.width%;\n" +
               "\t\t\t\theight:auto;\n" +
               "\t\t\t} \n" +
               "\t\t</style>\n" +
               "\t\t <script type='text/javascript'>\n" +
               "\t\t window.onload = function(){\n" +
               "\t\t\tvar $img = document.getElementsByTagName('img');\n" +
               "\t\t\tfor(var p in  $img){\n" +
               "\t\t\t\t$img[p].style.width = '100%';\n" +
               "\t\t\t\t$img[p].style.height ='auto'\n" +
               "\t\t\t}\n" +
               "\t\t }\n" +
               "\t\t </script>\n" +
               "\t</head>\n" +
               "\t<body>\n" +bodyHTML+
               "\t</body>\n" +
               "</html>";

        return  url;
    }



    private static final String cssStart = "<html>" + "\n"+
       "<header>" + "\n"+
             "<style type=\"text/css\"> img {" +
            "width:100%;" +
              "height:auto;" +
        "display:block;" +
         "clear:both;" +
              "margin:auto" +
          "}" + "\n" +
        "body {" +
             "margin-right:20px;" +
            "margin-left:20px;" +
          "margin-top:20px;" +
          "font-size:14px;" +
            "font-color:#666666"+
      "}" + "\n" +
       "</style>" + "\n" +
           "</header>" + "\n" +
      "<body>" +"\n";
    private static final String cssEnd = "\n"+"</body>"+"\n"+"</html>";

    public  String getNewHtml(String htmlUrl) {

        try{
            htmlUrl = Jsoup.clean(htmlUrl, Whitelist.basicWithImages());
            htmlUrl = getHtmlData(htmlUrl);
            return htmlUrl;
        }catch (Exception e){
            e.printStackTrace();
        }

        return  null;
    }



    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        mBinding.homeBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        mBinding.homeBanner.stopAutoPlay();
    }



    @Override
    public void onDestroy() {

        WebView mWebView = mBinding.webContext;

        if (mWebView != null) {

            // 如果先调用destroy()方法，则会命中if (isDestroyed()) return;这一行代码，需要先onDetachedFromWindow()，再destory
            ViewParent parent = mWebView.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(mWebView);
            }

            mWebView.stopLoading();
            // 退出时调用此方法，移除绑定的服务，否则某些特定系统会报错
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.getSettings().setBlockNetworkImage(false);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
            }
            mWebView.clearHistory();
            mWebView.clearView();
            mWebView.removeAllViews();
            mWebView.destroy();

        }
        super.onDestroy();


    }


    /**
     * 对图片进行重置大小，宽度就是手机屏幕宽度，高度根据宽度比便自动缩放
     **/
    private void imgReset() {
        mBinding.webContext.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByTagName('img'); " +
                "for(var i=0;i<objs.length;i++)  " +
                "{"
                + "var img = objs[i];   " +
                "    img.style.maxWidth = '100%'; img.style.height = 'auto';  " +
                "}" +
                "})()");
    }



    @Override
    public void onPromotionClick() {
        discountDilalog.show();
    }

    @Override
    public void onVouchersClick() {
        //优惠券
        couponDilalog.show();
    }

    @Override
    public void toHomeClick() {
        //主页
        EventBus.getDefault().post(PageMainEvent.PAGE_MAIN);
        ARouter.
                getInstance()
                .build(RouterPath.Main.ROUTE_MAIN_PATH)
                .withInt("page",0)
                .navigation();

    }

    @Override
    public void toCartClick() {
        //购物车
        EventBus.getDefault().post(PageMainEvent.PAGE_CART);
        ARouter.
                getInstance().
                build(RouterPath.Main.ROUTE_MAIN_PATH)
                .withInt("page",3)
                .navigation();


    }

    @Override
    public void SaleingClick() {
        //销售等级
        if(commissionDilalog != null){
            commissionDilalog.show();
        }

    }

    @Override
    public void toAddCart() {
        if(productAddCartDilalog != null){
            productAddCartDilalog.show();
        }


    }


    public class MyWebViewClient extends WebViewClient{

        @Override
        public void onPageFinished(WebView view, String url) {
            imgReset();//重置webview中img标签的图片大小
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(htmlUrl);
            return true;
        }
    }

}
