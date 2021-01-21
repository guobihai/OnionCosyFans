package cc.onion.cosyfans.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wihaohao.PageGridView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.BaseFragment;
import cc.onion.cosyfans.base.event.Event;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.GlideImageLoader;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.KLogUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.home.HomeUtils;
import cc.onion.cosyfans.home.adapter.HomeFragmentPagerAdapter;
import cc.onion.cosyfans.home.adapter.HomeSpecialItemAdapter;
import cc.onion.cosyfans.home.adapter.HomeSpecialTextAdapter;
import cc.onion.cosyfans.home.adapter.HomeTextArrayAdapter;
import cc.onion.cosyfans.home.adapter.HomeTopGridAdapter;
import cc.onion.cosyfans.home.adapter.HousePricuterdAdapter;
import cc.onion.cosyfans.home.dialog.AdvertisementDialog;
import cc.onion.cosyfans.home.dialog.CashRollDialog;
import cc.onion.cosyfans.home.entity.CashRequest;
import cc.onion.cosyfans.home.entity.CashRollEntity;
import cc.onion.cosyfans.home.entity.ContextModelRequest;
import cc.onion.cosyfans.home.entity.HomeGetAllModelRequest;
import cc.onion.cosyfans.home.entity.HomeTagItemIconModel;
import cc.onion.cosyfans.home.entity.HomeTagTextModel;
import cc.onion.cosyfans.home.entity.response.AdvertEntity;
import cc.onion.cosyfans.home.entity.response.BannerEntity;
import cc.onion.cosyfans.home.entity.response.DetailAlbumVosEntity;
import cc.onion.cosyfans.home.entity.response.DetailIconVos;
import cc.onion.cosyfans.home.entity.response.DetailItemEntity;
import cc.onion.cosyfans.home.entity.response.DetailItemVosEntity;
import cc.onion.cosyfans.home.entity.response.HomeAllModel;
import cc.onion.cosyfans.home.entity.response.TableEntity;
import cc.onion.cosyfans.home.event.HomeEvent;
import cc.onion.cosyfans.home.listenter.HomeViewOnClickListener;
import cc.onion.cosyfans.home.type.AdvertType;
import cc.onion.cosyfans.home.type.HomeLayoutType;
import cc.onion.cosyfans.home.type.HomeModelType;
import cc.onion.cosyfans.home.type.SpecificType;
import cc.onion.cosyfans.home.type.TagShowType;
import cc.onion.cosyfans.home.viewmodel.HomeViewModel;
import cc.onion.cosyfans.module_home.R;
import cc.onion.cosyfans.module_home.databinding.HomeFragmentNewsBinding;
import ezy.ui.view.NoticeView;
import io.reactivex.disposables.Disposable;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.home
 * @ClassName: HomeNewsFragment
 * @Description: home主界面重构，进行重新架构设置
 * @Author: guobihai
 * @CreateDate: 2020-01-13 10:30
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-13 10:30
 * @UpdateRemark: /**
 *      * app:layout_scrollFlags属性里面必须至少启用scroll这个flag，这样这个view才会滚动出屏幕，否则它将一直固定在顶部。可以使用的其他flag有：
 *      * enterAlways: 一旦向上滚动这个view就可见。
 *      * enterAlwaysCollapsed: 顾名思义，这个flag定义的是何时进入（已经消失之后何时再次显示）。假设你定义了一个最小高度（minHeight）同时enterAlways也定义了，那么view将在到达这个最小高度的时候开始显示，并且从这个时候开始慢慢展开，当滚动到顶部的时候展开完。
 *      * exitUntilCollapsed: 同样顾名思义，这个flag时定义何时退出，当你定义了一个minHeight，这个view将在滚动到达这个最小高度的时候消失。
 *      * 记住，要把带有scroll flag的view放在前面，这样收回的view才能让正常退出，而固定的view继续留在顶部
 *
 * @Version: 1.0
 */
@Route(path = RouterPath.Home.ROUTE_HOME_PATH)
public class HomeNewsFragment extends BaseFragment<HomeFragmentNewsBinding,HomeViewModel> implements HomeViewOnClickListener {


    public static HomeNewsFragment newInstance() {
        Bundle args = new Bundle();

        HomeNewsFragment fragment = new HomeNewsFragment();
        fragment.setArguments(args);
        return fragment;
    }



    //宫格适配器
    HomeTopGridAdapter homeTopGridAdapter;
    List<String> stringList;
    //头布局
    View headerView,headerView1,headerView2,headerView3,headerView4,headerView5,
            headerView6,headerView7,headerView8,headerTag,headerAnnouncement,headerSpecial,headerText,headerActivity,headerTable,headerBaseGrid;
    //广告
    Banner banner;
    //广告背景
    ImageView imgBannerBg;
    RelativeLayout layoutHeaderView;
    //基础布局一
    private List<Fragment> fragments;
    private HomeFragmentPagerAdapter mPagerAdapter;
    TableEntity tableEntity;//
    //宫格布局基础类
    LinearLayout headerBaseGridView;
    //宫格背景图片
    ImageView imgGridBase;

    RecyclerView recyclerViewSpecial;

    /**
     * 现金框显示
     *
     */
    private boolean cashShowState = false;




    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.home_fragment_news;
    }

    @Override
    public int initVariableId() {
        return cc.onion.cosyfans.module_home.BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        mViewModel.setHomeViewOnClickListener(this);
        //获取优惠券数据，展示对话框显示
        loadCouponList();//没有登陆就显示，登陆了就不显示
        initWithUI();
//        mBinding.homeBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
//                    KLogUtils.logTest("滑动的距离"+i);
//                int height = mBinding.homeTitleToolbar.getHeight();
//                KLogUtils.logTest("获取tabar高度"+height);
//
//                setToolbarHeight(height+30);
//            }
//        });

    }

    /**
     * 重置Toolbar高度
     * @param height
     */
    protected void setToolbarHeight(int height){
//        mBinding.homeTitleToolbar.setNavigationIcon(R.mipmap.icon_scan);
//        mBinding.homeTitleToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //二维码
//                ARouter.getInstance().build(RouterPath.Features.ROUTE_QRCODE_SCAN)
//                        .withBoolean("handle", true)
//                        // 填上request code在调用的activity的onActivityResult回调中获取二维码：data.getStringExtra("qrcode");
//                        .navigation(getActivity(),10001);
//            }
//        });
    }



    /**
     * 获取优惠券数据展示
     *
     */
    private void loadCouponList() {
        CashRequest requestBean = new CashRequest();
        Calendar calendar = Calendar.getInstance();
        long time = calendar.getTimeInMillis();

        requestBean.setExpiredTime(TypeUtils.toString(time));
        KLogUtils.logTest("毫秒时间:"+time);
        requestBean.getKeyMap().put("expiredTime",TypeUtils.toString(time));
        requestBean.setRequestSign(requestBean.getKeyMap());

;        mViewModel.getCouponList(requestBean, new ResponseListener<CashRollEntity>() {
            @Override
            public void loadSuccess(CashRollEntity data) {
                if(data.getData() != null ){
                    KLogUtils.logTest("获取优惠券数据成功，展示对话框显示");
                    if(data.getData().isIsLogin()){

                        //  登陆

                    }else{
                        //未登陆
                        if(data.getData() != null && data.getData().getCouponVOList().size() >0){
                            cashShowState = true;//设置显示了
                            CashRollDialog cashRollDialog = new CashRollDialog(getActivity(),data.getData().getCouponVOList());
                            cashRollDialog.show();
                        }
                    }


                }
            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {

            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }

    private void initWithUI() {
//        layoutBase = mBinding.layoutBase;
        // 下拉刷新监听
        mBinding.usedHouseRefreshLayout.setEnableLoadMore(false);
        mBinding.usedHouseRefreshLayout.setOnRefreshListener(
                refreshLayout -> {
                    //下拉的时候只加载头部数据

                    mBinding.layoutBody.removeAllViews();
                    initViewAllData();
                });





        initViewAllData();
    }


    /**
     * 添加头部布局
     */
    private void addHeaderView() {
        //设置banner样式
        homeTopGridAdapter = new HomeTopGridAdapter(null,getActivity());
        //初始化基本头部句，广告位
        headerView = LayoutInflater.from(getActivity()).inflate(R.layout.home_banner,null,false);
        banner = headerView.findViewById(R.id.home_banner);
        imgBannerBg = headerView.findViewById(R.id.img_banner_bg);
        layoutHeaderView = headerView.findViewById(R.id.layout_banner_bg);
        layoutHeaderView.setTag(R.id.home_tag_name,"banner");
        mBinding.layoutBody.addView(headerView);
        KLogUtils.logTest("初始化布局，增加广告轮播布局");


    }




    public void initViewAllData(){
        //添加头部布局，刷新操作重新移除数据
        addHeaderView();

        HomeGetAllModelRequest request = new HomeGetAllModelRequest();
//        if(StringUtils.isNotEmpty(mViewModel.searchText.get())){
//            request.setShopId(mViewModel.searchText.get());
//            request.getKeyMap().put("shopId",mViewModel.searchText.get());
//            KLogUtils.logTest("二维码扫描回来进行重新加载数据操作"+mViewModel.searchText.get());
//        }
        request.setRequestSign(request.getKeyMap());
        //调用接口获取所有的数据形式
        mViewModel.getHomeAllModule(request, new ResponseListener<HomeAllModel>() {
            @Override
            public void loadSuccess(HomeAllModel data) {
                mBinding.usedHouseRefreshLayout.finishRefresh();
                mBinding.usedHouseRefreshLayout.finishLoadMore();
                KLog.i("test","请求主页数据成功~~~~~");
                allViewShow(data);

            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {

            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }


    /**
     * 所有界面舒适化数据开始
     * 所有模板
     * @param data
     */

    private void allViewShow(HomeAllModel data) {

        //浮标广告
//        setTitleLayout(data);
        //弹窗广告

        //现金框显示了就不可以显示当前插屏广告
        screenAdDialog(data);

        //店铺信息设置
        if(data.getShopDto() != null ){
            //设置店铺信息
            if(StringUtils.isNotEmpty(data.getShopDto().getName())){
                mViewModel.searchText.set(data.getShopDto().getName());
            }
        }


        //固定模块--------------
//      1搜素栏
        setFloadDialogLayout(data);

        //固定模块--------------
        setLayout(data);

        KLogUtils.logTest("base Size"+mBinding.layoutBody.getChildCount());


        //信息流数据初始化
        if(data.getFlowModule() !=null){
            //请求标签下面的数据
            getTableDetailLayout(data);
        }



    }

    /**
     *插屏广告
     * @param data
     */
    private void screenAdDialog(HomeAllModel data) {
        //判断是否显示插屏广告
        if(!cashShowState){
            if(data.getScreenAdModule() != null){
                //间隔小时
                int hoursApart = data.getScreenAdModule().getHoursApart();
                AdvertisementDialog advertisementDialog = new AdvertisementDialog(getActivity(),data.getScreenAdModule());
                advertisementDialog.show();

                //1、每次进入显示（关闭后刷新不再显示），2、每次进入显示（关闭后刷新重新显示） 3、每隔N小时显示一次
                int advertShowType = data.getScreenAdModule().getAdvertShowType();
                switch (advertShowType){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }



            }
        }



    }


    private void setLayout(HomeAllModel data) {

        try {


        if(data.getFloatModuleList() != null && data.getFloatModuleList().size() >0){
            for (HomeAllModel.FloatModuleListBean floatModule:data.getFloatModuleList()) {
                //广告位
                if(floatModule.getModuleType() == HomeModelType.MODEL_TYPE_1){
//                    广告类型  1广告，2活动广告，3宫格广告
                    activityLayout(floatModule);
                }else if(floatModule.getModuleType() == HomeModelType.MODEL_TYPE_2){
                    //2、公告位
//                    advertTypeLayout(floatModule);
                    KLog.i("test","公告位置:");
                    announcementLayout(floatModule);
                }else if(floatModule.getModuleType() == HomeModelType.MODEL_TYPE_3){
                    //3、标签位

                    View view5 = LayoutInflater.from(getActivity()).inflate(R.layout.home_model_tag, mBinding.layoutBody, false);
                    view5.setTag(R.id.home_tag_name,floatModule.getModuleName());
                    mBinding.layoutBody.addView(view5);
                    getAdvertLayoutData(floatModule,view5);
                }else if(floatModule.getModuleType() == HomeModelType.MODEL_TYPE_4){
//                    4、专题位
                    if(floatModule.getSpecificType() == SpecificType.TYPE_1){
                        //图文专题
                        photoArrayLayout(floatModule);
                    }else{
                        //文字专题，
                        textArrayLayout(floatModule);

                    }

                }

            }

        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 图文专题
     * @param floatModule
     */
    private void photoArrayLayout(HomeAllModel.FloatModuleListBean floatModule) {
        //获取图文专题数据
        View view6 = LayoutInflater.from(getActivity()).inflate(R.layout.home_model_special_topic, mBinding.layoutBody, false);
        view6.setTag(R.id.home_tag_name,floatModule.getModuleName());
        mBinding.layoutBody.addView(view6);
        RecyclerView pohotArrayItem = view6.findViewById(R.id.lrl_special_topic);
        ImageView img_special = view6.findViewById(R.id.img_special);
        ImageView img_top_bg  =view6.findViewById(R.id.img_top_bg);
        BaseBindingAdapter.loadImageLarge(img_top_bg,floatModule.getBackgroundImage(),R.mipmap.home_advert_one);


        //设置图片显示
        if(floatModule.getDetailList() != null && floatModule.getDetailList().size() >0){
            List<HomeAllModel.FloatModuleListBean.DetailListBean> detailList = floatModule.getDetailList();

            if(floatModule.getDetailList().get(0) != null){
                //getSpecificContent  专题列表内容类型 1、商品列表 2、专辑详情；
                if(floatModule.getDetailList().get(0).getSpecificContent() == 2){
                    KLogUtils.logTest("获取到图文专题专题内容"+floatModule.getDetailList().get(0).getSpecificContent());
                    List<DetailAlbumVosEntity> detailAlbumVos = detailList.get(0).getDetailAlbumVos();
                    //设置背景图
                    String url = floatModule.getDetailList().get(0).getImg();
                    KLogUtils.logTest("专题图片加载数据："+url);
                    BaseBindingAdapter.loadImageLarge(img_special,url,R.mipmap.home_advert_one);
                    img_special.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),floatModule.getDetailList().get(0)));

                    if(detailAlbumVos !=null && detailAlbumVos.size() >0){
                        HomeSpecialItemAdapter specialItemAdapter = new HomeSpecialItemAdapter(null,getActivity());
                        pohotArrayItem.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                        pohotArrayItem.setNestedScrollingEnabled(false);
                        pohotArrayItem.setAdapter(specialItemAdapter);
                        specialItemAdapter.setNewData(detailList.get(0).getDetailAlbumVos());
                        specialItemAdapter.notifyDataSetChanged();
                        specialItemAdapter.setOnItemClickListener((adapter, view, position) -> {
                            DetailAlbumVosEntity  entity = (DetailAlbumVosEntity) adapter.getItem(position);
                            if(entity != null){
                                /**
                                 * 统一处理业务逻辑
                                 */
                                KLogUtils.logTest("entity.getAlbumId()"+entity.getAlbumId());
                                HomeUtils.toJumpAllAdvert(getActivity(),floatModule.getDetailList().get(0));

                            }



                        });
                    }
                }else{
                    KLogUtils.logTest("获取到图文专题商品内容"+floatModule.getDetailList().get(0).getSpecificContent());
                    List<DetailItemVosEntity> detailItemVos = detailList.get(0).getDetailItemVos();
                    //设置背景图
                    String url = floatModule.getDetailList().get(0).getImg();
                    KLogUtils.logTest("专题图片加载数据："+url);
                    BaseBindingAdapter.loadImageLarge(img_special,url,R.mipmap.home_advert_one);
                    img_special.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            HomeUtils.toJumpAllAdvert(getActivity(),floatModule.getDetailList().get(0));
                        }
                    });

                    getPhotoArrayItem(floatModule,pohotArrayItem,img_special);


                }
            }
        }else{
            //detail 为空到时候，获取接口到数据进行操作

            getPhotoArrayItem(floatModule,pohotArrayItem, img_special);
        }
    }

    /**
     * 文字专题
     * @param floatModule
     */
    private void textArrayLayout(HomeAllModel.FloatModuleListBean floatModule) {
        View view7 = LayoutInflater.from(getActivity()).inflate(R.layout.home_model_special_text, mBinding.layoutBody, false);
        view7.setTag(R.id.home_tag_name,floatModule.getModuleName());
        mBinding.layoutBody.addView(view7);
        TextView titleText = view7.findViewById(R.id.tv_title);
        RecyclerView lrTextArray = view7.findViewById(R.id.lrl_special_text);
        ImageView imgTextBg = view7.findViewById(R.id.img_text_bg);
        ImageView imgTag = view7.findViewById(R.id.img_left);

        String url = floatModule.getBackgroundImage();
        KLogUtils.logTest("专题图片加载数据："+url);
        BaseBindingAdapter.loadImageLarge(imgTextBg,url,R.mipmap.home_advert_one);
        getTextItemArray(floatModule,lrTextArray,imgTag,titleText);
    }

    /**
     * 设置滚动条
     * @param floatModule
     */
    private void announcementLayout(HomeAllModel.FloatModuleListBean floatModule) {
        View view4 = LayoutInflater.from(getActivity()).inflate(R.layout.home_model_announcement, mBinding.layoutBody, false);
        view4.setTag(R.id.home_tag_name,floatModule.getModuleName());
        mBinding.layoutBody.addView(view4);


        //设置滚动条公告模块显示代码
        if(floatModule != null){
            //设置背景显示
            ImageView imgBg = view4.findViewById(R.id.img_bg);
            BaseBindingAdapter.loadImage(imgBg,floatModule.getBackgroundImage());
            ImageView imgtag = view4.findViewById(R.id.img_tag);
            BaseBindingAdapter.loadImage(imgtag,floatModule.getImageUrl());


            if(floatModule.getDetailList() != null && floatModule.getDetailList().size() >0){
                List<String> notice = new ArrayList<>();
                for (HomeAllModel.FloatModuleListBean.DetailListBean model:floatModule.getDetailList()) {
                    notice.add(model.getTitle());
                }
                if(notice.size() >0){
                    NoticeView vNotice = view4.findViewById(R.id.notice);
                    vNotice.start(notice);
                    vNotice.setOnClickListener(v -> {
                        int index = vNotice.getIndex();
                        if(floatModule.getDetailList().get(index) != null){
                            KLogUtils.logTest("选择公告的类型:"+index);
                            HomeUtils.toJumpAllAdvert(getActivity(),floatModule.getDetailList().get(index));
                        }

                    });
                }

            }


        }
    }

    /**
     * 设置活动广告布局数据
     * @param floatModule
     */
    private void activityLayout(HomeAllModel.FloatModuleListBean floatModule) {
        if(floatModule.getAdvertType() == AdvertType.ADVERTYPE_1){
            //活动广告
            View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.home_advert_one, mBinding.layoutBody, false);
            view1.setTag(R.id.home_tag_name,floatModule.getModuleName());
            mBinding.layoutBody.addView(view1);
            getAdvertLayoutData(floatModule,view1);

        }else if(floatModule.getAdvertType()  == AdvertType.ADVERTYPE_2){
            //活动广告布局显示

            View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.home_advert_activity, mBinding.layoutBody, false);
            view2.setTag(R.id.home_tag_name,floatModule.getModuleName());
            mBinding.layoutBody.addView(view2);

            ImageView imgActivityBg = view2.findViewById(R.id.img_activity_bg);
            //设置北京界面数据
            BaseBindingAdapter.loadImageFitCenterType(imgActivityBg,floatModule.getBackgroundImage());
            getAdvertLayoutData(floatModule,view2);


        }else if(floatModule.getAdvertType()  == AdvertType.ADVERTYPE_3){
            View view3 = LayoutInflater.from(getActivity()).inflate(R.layout.home_layout_grid_base, mBinding.layoutBody, false);
            view3.setTag(R.id.home_tag_name,floatModule.getModuleName());
            mBinding.layoutBody.addView(view3);
            //设置宫格布局
            LinearLayout layoutGrid = view3.findViewById(R.id.layout_base_grid);
            ImageView imgGridView = view3.findViewById(R.id.img_grid_base);
            BaseBindingAdapter.loadImageLarge(imgGridView,floatModule.getBackgroundImage());
            setGridLayout(floatModule,layoutGrid);

        }else if(floatModule.getAdvertType()  == AdvertType.ADVERTYPE_4){
            //素材中心
            View viewother = LayoutInflater.from(getActivity()).inflate(R.layout.home_layout_posts, mBinding.layoutBody, false);
            viewother.setTag(R.id.home_tag_name,floatModule.getModuleName());
            mBinding.layoutBody.addView(viewother);
            ImageView imgGridView = viewother.findViewById(R.id.img_grid_base);
            BaseBindingAdapter.loadImageLarge(imgGridView,floatModule.getBackgroundImage());
            //调用接口
            getAdvertLayoutData(floatModule,viewother);

        }
    }


    /**
     * 设置标签布局数据显示
     * @param tagDetailData
     * @param tmptepView
     */
    private void setHomeTagLayout(HomeAllModel.FloatModuleListBean tagDta, AdvertEntity tagDetailData, View tmptepView) {
        List<HomeTagItemIconModel> mList;
        List<HomeTagTextModel> mList2;
        PageGridView<HomeTagItemIconModel> mPageGridView = null;
        PageGridView<HomeTagTextModel> mPageGridView2;


        mList=new ArrayList<>();
        mList2=new ArrayList<>();
        PageGridView rlHomeTat = tmptepView.findViewById(R.id.rl_home_tag);
        ImageView homeTagImageBg = tmptepView.findViewById(R.id.img_home_tag);
        if(StringUtils.isNotEmpty(tagDta.getBackgroundImage())){
            BaseBindingAdapter.loadImageLarge(homeTagImageBg,tagDta.getBackgroundImage());
        }



        rlHomeTat.setData(tagDetailData.getData());


        if(tagDta.getLabelPaging() == TagShowType.LABELS_PAGER_NUMBER_0){
            //不分页
        }else{

        }


    }




    /**
     *
     * @param floatModule
     * @param img_special
     * @param titleText
     */
    private void getTextItemArray(HomeAllModel.FloatModuleListBean floatModule, RecyclerView textItem, ImageView img_special, TextView titleText) {
        //请求参数根据动态生成
        ContextModelRequest request = new ContextModelRequest();
        request.setModuleId(TypeUtils.toString(floatModule.getId()));
        request.getKeyMap().put("moduleId",TypeUtils.toString(floatModule.getId()));
        request.setRequestSign(request.getKeyMap());
        KLog.i("test","moduleId数据："+floatModule.getId());
        mViewModel.getModelDetail(request, new ResponseListener<AdvertEntity>() {
            @Override
            public void loadSuccess(AdvertEntity data) {
                //设置专题布局显示
                if(data.getData() !=null && data.getData().size() >0){
                    AdvertEntity.DataBean detailModel = data.getData().get(0);
                    //设置背景图
                    if(StringUtils.isNotEmpty(detailModel.getTitle())){
                        titleText.setText(detailModel.getTitle());
                    }
                    BaseBindingAdapter.loadImageFitCenterType(img_special,detailModel.getImg());


                    if(detailModel.getDetailItemVos() != null && detailModel.getDetailItemVos().size() >0){
                        HomeTextArrayAdapter arrayAdapter = new HomeTextArrayAdapter(detailModel,getActivity());
                        textItem.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                        textItem.setNestedScrollingEnabled(false);
                        textItem.setAdapter(arrayAdapter);
                        arrayAdapter.setNewData(detailModel.getDetailItemVos());
                        arrayAdapter.notifyDataSetChanged();
                    }

                }

            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                KLogUtils.logTest("文字专题获取数据失败");

            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }




    /**
     * @param floatModule
     * @param pohotArrayItem
     * @param img_special
     *
     */
    private void getPhotoArrayItem(HomeAllModel.FloatModuleListBean floatModule, RecyclerView pohotArrayItem, ImageView img_special) {
        //请求参数根据动态生成
        ContextModelRequest request = new ContextModelRequest();
        request.setModuleId(TypeUtils.toString(floatModule.getId()));
        request.getKeyMap().put("moduleId",TypeUtils.toString(floatModule.getId()));
        request.setRequestSign(request.getKeyMap());
        KLog.i("test","moduleId数据："+floatModule.getId());
        mViewModel.getModelDetail(request, new ResponseListener<AdvertEntity>() {
            @Override
            public void loadSuccess(AdvertEntity data) {
                //设置专题布局显示
                if(data.getData() !=null && data.getData().size() >0){
                    AdvertEntity.DataBean detailModel = data.getData().get(0);
                    //设置背景图
                    String url = detailModel.getImg();
                    KLogUtils.logTest("专题图片加载数据："+url);
                    BaseBindingAdapter.loadImageLarge(img_special,url,R.mipmap.home_advert_one);
                    if(detailModel.getDetailItemVos() != null && detailModel.getDetailItemVos().size() >0){
                        HomeSpecialTextAdapter specialItemAdapter = new HomeSpecialTextAdapter(detailModel,getActivity());
                        pohotArrayItem.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                        pohotArrayItem.setNestedScrollingEnabled(false);
                        pohotArrayItem.setAdapter(specialItemAdapter);
                        specialItemAdapter.setNewData(detailModel.getDetailItemVos());
                        specialItemAdapter.notifyDataSetChanged();
                        specialItemAdapter.setOnItemClickListener((adapter, view, position) -> {
                            DetailItemEntity itemEntity = (DetailItemEntity) adapter.getItem(position);
                            if(itemEntity != null){
                                //统一操作业务类型,跳转业务操作
                                HomeUtils.toJumpAllAdvert(getActivity(),detailModel,itemEntity);
                            }
                        });
                    }

                }

            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                KLogUtils.logTest("图文专题获取数据失败");

            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }





    /**
     * 获取标签数据
     * @param data
     */
    private void getTableDetailLayout(HomeAllModel data) {
        //请求参数根据动态生成
        ContextModelRequest request = new ContextModelRequest();
        request.setModuleId(TypeUtils.toString(data.getFlowModule().getId()));
        request.getKeyMap().put("moduleId",TypeUtils.toString(data.getFlowModule().getId()));
        request.setRequestSign(request.getKeyMap());
        mViewModel.getTableLyoutTag(request, new ResponseListener<TableEntity>() {
            @Override
            public void loadSuccess(TableEntity data) {

                tableEntity = data;
                //添加头部位置
                addTableLayout();

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



    /**
     * 添加标签布局，动态化配置布局
     */
    private void addTableLayout() {
        try {

            if(tableEntity !=null && tableEntity.getData() != null && tableEntity.getData().getFlowTabList().size() >0){
                KLog.i("test","获取标签是否成功");

                fragments = new ArrayList<>();

                mBinding.itemViewPageer.setAdapter(mPagerAdapter);


                for (int i = 0; i < tableEntity.getData().getFlowTabList().size(); i++) {
                    mBinding.itemTabLayout.addTab( mBinding.itemTabLayout.newTab().setText(tableEntity.getData().getFlowTabList().get(i).getFlowTabName()));
                }

                HousePricuterdAdapter fragmentAdapter = new HousePricuterdAdapter(getChildFragmentManager(), tableEntity.getData().getFlowTabList(), mBinding.itemViewPageer);
                mBinding.itemViewPageer.setAdapter(fragmentAdapter);
                mBinding.itemTabLayout.setupWithViewPager( mBinding.itemViewPageer);
                for (int i = 0; i < mBinding.itemTabLayout.getTabCount(); i++) {
                    TabLayout.Tab tab = mBinding.itemTabLayout.getTabAt(i);
                    tab.setText(tableEntity.getData().getFlowTabList().get(i).getFlowTabName());
                }
//            mBinding.layoutThree.viewpagerHouse.setOffscreenPageLimit(2);

                mBinding.itemViewPageer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float v, int i1) {

                        try {

                        KLog.i("test","viewPager切换的是"+position);
//                        viewPager.setCurrentItem(position);
//                        mBinding.itemViewPageer.resetHeight(position);
//                        mBinding.itemViewPageer.refreshView(position);
                        //只加载当前页数据
//                        ItemDetailFragment itemDetailFragment = (ItemDetailFragment) fragmentAdapter.getItem(position);
//                        if(itemDetailFragment != null){
//                            itemDetailFragment.loadItemDetailData();
//                        }
                        }catch (Exception e){
                            e.printStackTrace();
                        }


                    }

                    @Override
                    public void onPageSelected(int i) {

                    }

                    @Override
                    public void onPageScrollStateChanged(int i) {

                    }
                });


                mBinding.itemTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        int position = tab.getPosition();
                        KLog.i("test","table切换的是"+position);
//                        viewPager.setCurrentItem(position);
//                        mBinding.itemViewPageer.resetHeight(position);
//                        mBinding.itemViewPageer.refreshView(position);
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });




            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }






    /**
     * 设置标签布局数据显示
     * @param tagDetailData
     * @param tmptepView
     */
    private void setHomeTagLayoutView(HomeAllModel.FloatModuleListBean tagDta, AdvertEntity tagDetailData, View tmptepView) {
        List<HomeTagItemIconModel> mList;
        List<HomeTagTextModel> mList2;
        PageGridView<HomeTagItemIconModel> mPageGridView = null;
        PageGridView<HomeTagTextModel> mPageGridView2;


        mList=new ArrayList<>();
        mList2=new ArrayList<>();
        PageGridView rlHomeTat = tmptepView.findViewById(R.id.rl_home_tag);
        ImageView homeTagImageBg = tmptepView.findViewById(R.id.img_home_tag);
        if(StringUtils.isNotEmpty(tagDta.getBackgroundImage())){
            BaseBindingAdapter.loadImageLarge(homeTagImageBg,tagDta.getBackgroundImage());
        }



        rlHomeTat.setData(tagDetailData.getData());


        if(tagDta.getLabelPaging() == TagShowType.LABELS_PAGER_NUMBER_0){
            //不分页
        }else{

        }


    }

    /**
     * 活动广告初始化数据
     * @param data
     * @param tmptepView
     */
    private void setActivityViewShow(AdvertEntity data, View tmptepView) {
        KLog.i("test","公告中心布局初始化数据操作~~~~~~~~~");
        if(data.getData()!= null && data.getData().size() >0){
            if(data.getData().get(0).getDetailIconVos() != null && data.getData().get(0).getDetailIconVos().size() >0){
                List<DetailIconVos> iconVos = data.getData().get(0).getDetailIconVos();

                ImageView imageView1 = tmptepView.findViewById(R.id.home_advert_activity_1);
                ImageView imageView2 = tmptepView.findViewById(R.id.home_advert_activity_2);
                ImageView imageView3 = tmptepView.findViewById(R.id.home_advert_activity_3);
                ImageView activityImageBg = tmptepView.findViewById(R.id.img_activity_bg);
                //跳转操作

                //
                BaseBindingAdapter.loadImageFitCenterType(activityImageBg,data.getData().get(0).getImg());

                if(iconVos.size() == 1){
                    BaseBindingAdapter.loadImage(imageView1,iconVos.get(0).getImg());
                    imageView2.setVisibility(View.GONE);
                    imageView3.setVisibility(View.GONE);
                    imageView1.setOnClickListener(v -> {
                        //跳转到商品详情
                        if(iconVos != null){
                            //跳转业务
                            HomeUtils.toJumpAllAdvert(getActivity(),data.getData().get(0),iconVos.get(0));
                        }

                    });


                }else if(iconVos.size() == 2){
                    BaseBindingAdapter.loadImageFitCenterType(imageView1,iconVos.get(0).getImg());
                    BaseBindingAdapter.loadImageFitCenterType(imageView2,iconVos.get(1).getImg());
                    imageView3.setVisibility(View.GONE);
                    imageView1.setOnClickListener(v -> {
                        //跳转到商品详情
                        if(iconVos != null){
                            //跳转业务
                            HomeUtils.toJumpAllAdvert(getActivity(),data.getData().get(0),iconVos.get(0));
                        }

                    });
                    imageView1.setOnClickListener(v -> {
                        //跳转到商品详情
                        if(iconVos != null){
                            //跳转业务
                            HomeUtils.toJumpAllAdvert(getActivity(),data.getData().get(0),iconVos.get(1));
                        }

                    });

                }else{
                    BaseBindingAdapter.loadImageFitCenterType(imageView1,iconVos.get(0).getImg());
                    BaseBindingAdapter.loadImageFitCenterType(imageView2,iconVos.get(1).getImg());
                    BaseBindingAdapter.loadImageFitCenterType(imageView3,iconVos.get(2).getImg());

                    imageView1.setOnClickListener(v -> {
                        //跳转到商品详情
                        if(iconVos != null){
                            //跳转业务
                            HomeUtils.toJumpAllAdvert(getActivity(),data.getData().get(0),iconVos.get(0));
                        }

                    });
                    imageView2.setOnClickListener(v -> {
                        //跳转到商品详情
                        if(iconVos != null){
                            //跳转业务
                            HomeUtils.toJumpAllAdvert(getActivity(),data.getData().get(0),iconVos.get(1));
                        }

                    });

                    imageView3.setOnClickListener(v -> {
                        //跳转到商品详情
                        if(iconVos != null){
                            //跳转业务
                            HomeUtils.toJumpAllAdvert(getActivity(),data.getData().get(0),iconVos.get(2));
                        }

                    });




                }

            }

        }


    }





    /**
     * 所有的子View都在这里初始化
     * 统一管理中控台
     * 全部使用layou获取到的子View管理操作
     * @param data
     * @param floatModule
     */
    private void allLayoutInitData(AdvertEntity data, HomeAllModel.FloatModuleListBean floatModule, View view) {
        try {

        //model1
        if(floatModule.getModuleType() == HomeModelType.MODEL_TYPE_1){
            if(floatModule.getAdvertType() == AdvertType.ADVERTYPE_4){
                //素材中心，新增
                setPostsLayout(data,floatModule,view);

            }else if(floatModule.getAdvertType()  == AdvertType.ADVERTYPE_2){
                //活动广告
                setActivityViewShow(data,view);
            }
        }else if(floatModule.getModuleType() == HomeModelType.MODEL_TYPE_3){
            //  标签
            setHomeTagLayout(floatModule,data,view);
        }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 素材广告入口
     * @param data
     * @param floatModule
     * @param view
     */
    private void setPostsLayout(AdvertEntity data, HomeAllModel.FloatModuleListBean floatModule, View view) {

            // 链接类型  0 其他 1 列表 2商品详情 3 专辑 4: 分类  5 搜索结果 6 具体分类 7 h5
        ImageView imgPots = view.findViewById(R.id.img_pots);
        if(data.getData() != null){
            if(data.getData().size() > 0 && data.getData().get(0) != null ){
                AdvertEntity.DataBean postsModel = data.getData().get(0);
                BaseBindingAdapter.loadImageFitCenterType(imgPots,postsModel.getImg());
                imgPots.setOnClickListener(v ->
                        //跳转操作
                        HomeUtils.toJumpAllAdvert(getActivity(),postsModel)
                );
            }


        }
    }

    /**
     * 请求接口获取活动广告内容数据
     * @param floatModule
     * @param tmptepView
     */
    private void getAdvertLayoutData(HomeAllModel.FloatModuleListBean floatModule, View tmptepView) {
        //请求参数根据动态生成
        ContextModelRequest request = new ContextModelRequest();
        request.setModuleId(TypeUtils.toString(floatModule.getId()));
        request.getKeyMap().put("moduleId",TypeUtils.toString(floatModule.getId()));
        request.setRequestSign(request.getKeyMap());
        KLog.i("test","moduleId数据："+floatModule.getId());
        mViewModel.getModelDetail(request, new ResponseListener<AdvertEntity>() {
            @Override
            public void loadSuccess(AdvertEntity data) {
                KLog.i("test","活动广告数据，请求成功.....");
                /**
                 * 所有的子View都在这里初始化
                 * 统一管理中控台
                 * 全部使用layou获取到的子View管理操作
                 */
                allLayoutInitData(data, floatModule, tmptepView);


            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                    KLogUtils.logTest("加载数据失败");
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }


    /**
     * 设置宫格布局
     * @param floatModule
     * @param layoutGrid
     */
    private void setGridLayout(HomeAllModel.FloatModuleListBean floatModule, LinearLayout layoutGrid) {
        //请求参数根据动态生成
        ContextModelRequest request = new ContextModelRequest();
        request.setModuleId(TypeUtils.toString(floatModule.getId()));
        request.getKeyMap().put("moduleId",TypeUtils.toString(floatModule.getId()));
        request.setRequestSign(request.getKeyMap());
        KLog.i("test","moduleId数据："+floatModule.getId());
        mViewModel.getModelDetail(request, new ResponseListener<AdvertEntity>() {
            @Override
            public void loadSuccess(AdvertEntity data) {
                KLog.i("test","活动广告数据，请求成功.....");
                //宫格布局
                addHeaderViewShow(data,layoutGrid);


            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
            KLogUtils.logTest("加载宫格布局错误");
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }


    /**
     * 设置浮动广告
     * @param data
     */
    private void setFloadDialogLayout(HomeAllModel data) {
        if(data.getFixedModuleList() != null && data.getFixedModuleList().size() >0){
            for (HomeAllModel.FixedModuleListBean fixedModel :data.getFixedModuleList()) {
                if(fixedModel.getModuleType() == 7){
                    //搜素栏

                }else if(fixedModel.getModuleType() == HomeModelType.MODEL_TYPE_1){
                    //广告位
                    if(fixedModel.getAdvertType() == 1){{
                        //设置背景
                        if(StringUtils.isNotEmpty(fixedModel.getBackgroundImage())){

                            BaseBindingAdapter.loadImageLarge(imgBannerBg,fixedModel.getBackgroundImage());
                        }
                        KLog.i("test","轮播图Id："+fixedModel.getId());
                        if(fixedModel.getDetailList() !=null && fixedModel.getDetailList().size() >0){
                            initBanner(fixedModel.getDetailList());
                            banner.setOnBannerListener(new OnBannerListener() {
                                @Override
                                public void OnBannerClick(int position) {
                                    //进行轮播图的跳转
                                    if(fixedModel.getDetailList() != null && fixedModel.getDetailList().size() >0){
                                        BannerEntity bannerEntity = fixedModel.getDetailList().get(position);
                                        HomeUtils.toJumpAllAdvert(getActivity(),bannerEntity);
                                    }

                                }
                            });
                            banner.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ToastUtil.Short("ddd");
                                }
                            });
                        }
                    }}

                }else if(fixedModel.getModuleType() == 8){
                    //背景栏
                    if(StringUtils.isNotEmpty(fixedModel.getBackgroundImage())){
//                        BaseBindingAdapter.setLayoutBgShow(getActivity(),mBinding.layoutHomeTitleBg,fixedModel.getBackgroundImage());
                    }
                }
            }
        }
    }


    /**
     * 宫格广告
     * @param advertEntity
     * @param baseGridLaout
     */
    private void addHeaderViewShow(AdvertEntity advertEntity, LinearLayout baseGridLaout) {


        if(advertEntity.getData() !=null && advertEntity.getData().size() >0){

            List<AdvertEntity.DataBean> entityData = advertEntity.getData();

            int advertNum = advertEntity.getData().size();
            if(advertNum == HomeLayoutType.HOME_LAYOUT_1){

            }else if(advertNum == HomeLayoutType.HOME_LAYOUT_2){
                //2
                headerView2 = LayoutInflater.from(getActivity()).inflate(R.layout.home_advert_two,null,false);
                baseGridLaout.addView(headerView2);
                ImageView  imageView2_1 = headerView2.findViewById(R.id.home_advert_two_1);
                ImageView   imageView2_2 = headerView2.findViewById(R.id.home_advert_two_2);

                BaseBindingAdapter.loadImageFitCenterType(imageView2_1,entityData.get(0).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView2_2,entityData.get(1).getImg());
                imageView2_1.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(0)));
                imageView2_2.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(1)));

            }else if(advertNum == HomeLayoutType.HOME_LAYOUT_3){
                //3
                headerView3 = LayoutInflater.from(getActivity()).inflate(R.layout.home_advert_three,null,false);
                baseGridLaout.addView(headerView3);
                ImageView  imageView3_1 = headerView3.findViewById(R.id.home_advert_two_1);
                ImageView   imageView3_2 = headerView3.findViewById(R.id.home_advert_two_2);
                ImageView imageView3_3 = headerView3.findViewById(R.id.home_advert_two_3);


                BaseBindingAdapter.loadImageFitCenterType(imageView3_1,entityData.get(0).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView3_2,entityData.get(1).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView3_3,entityData.get(2).getImg());
                imageView3_1.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(0)));
                imageView3_2.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(1)));
                imageView3_3.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(2)));

            }else if(advertNum == HomeLayoutType.HOME_LAYOUT_4){
                //4
                headerView4 = LayoutInflater.from(getActivity()).inflate(R.layout.home_advert_four,null,false);
                baseGridLaout.addView(headerView4);

                ImageView  imageView4_1 = headerView4.findViewById(R.id.home_advert_four_1);
                ImageView   imageView4_2 = headerView4.findViewById(R.id.home_advert_four_1);
                ImageView imageView4_3 = headerView4.findViewById(R.id.home_advert_four_1);
                ImageView imageView4_4 = headerView4.findViewById(R.id.home_advert_four_1);


                BaseBindingAdapter.loadImageFitCenterType(imageView4_1,entityData.get(0).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView4_2,entityData.get(1).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView4_3,entityData.get(2).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView4_4,entityData.get(3).getImg());
                imageView4_1.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(0)));
                imageView4_2.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(1)));
                imageView4_3.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(2)));
                imageView4_4.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(3)));

            }else if(advertNum == HomeLayoutType.HOME_LAYOUT_5){


                headerView5 = LayoutInflater.from(getActivity()).inflate(R.layout.home_advert_five,null,false);
                baseGridLaout.addView(headerView5);

                ImageView  imageView5_1 = headerView5.findViewById(R.id.home_advert_five_1);
                ImageView   imageView5_2 = headerView5.findViewById(R.id.home_advert_five_2);
                ImageView imageView5_3 = headerView5.findViewById(R.id.home_advert_five_3);
                ImageView imageView5_4 = headerView5.findViewById(R.id.home_advert_five_4);
                ImageView   imageView5_5 = headerView5.findViewById(R.id.home_advert_five_5);


                BaseBindingAdapter.loadImageFitCenterType(imageView5_1,entityData.get(0).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView5_2,entityData.get(1).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView5_3,entityData.get(2).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView5_4,entityData.get(3).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView5_5,entityData.get(4).getImg());
                imageView5_1.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(0)));
                imageView5_2.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(1)));
                imageView5_3.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(2)));
                imageView5_4.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(3)));
                imageView5_5.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(4)));

            }else if(advertNum == HomeLayoutType.HOME_LAYOUT_6){
                //6
                headerView6 = LayoutInflater.from(getActivity()).inflate(R.layout.home_advert_six,null,false);
                baseGridLaout.addView(headerView6);
                ImageView  imageView6_1 = headerView6.findViewById(R.id.home_advert_six_1);
                ImageView   imageView6_2 = headerView6.findViewById(R.id.home_advert_six_2);
                ImageView imageView6_3 = headerView6.findViewById(R.id.home_advert_six_3);
                ImageView imageView6_4 = headerView6.findViewById(R.id.home_advert_six_4);
                ImageView   imageView6_5 = headerView6.findViewById(R.id.home_advert_six_5);
                ImageView   imageView6_6 = headerView6.findViewById(R.id.home_advert_six_6);

                // 6
                BaseBindingAdapter.loadImageFitCenterType(imageView6_1,entityData.get(0).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView6_2,entityData.get(1).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView6_3,entityData.get(2).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView6_4,entityData.get(3).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView6_5,entityData.get(4).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView6_6,entityData.get(5).getImg());
                imageView6_1.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(0)));
                imageView6_2.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(1)));
                imageView6_3.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(2)));
                imageView6_4.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(3)));
                imageView6_5.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(4)));
                imageView6_6.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(5)));

            }else if(advertNum == HomeLayoutType.HOME_LAYOUT_7){
                //7
                headerView7 = LayoutInflater.from(getActivity()).inflate(R.layout.home_advert_serven,null,false);
                baseGridLaout.addView(headerView7);
                ImageView  imageView7_1 = headerView7.findViewById(R.id.home_advert_serven_1);
                ImageView   imageView7_2 = headerView7.findViewById(R.id.home_advert_serven_2);
                ImageView imageView7_3 = headerView7.findViewById(R.id.home_advert_serven_3);
                ImageView imageView7_4 = headerView7.findViewById(R.id.home_advert_serven_4);
                ImageView   imageView7_5 = headerView7.findViewById(R.id.home_advert_serven_5);
                ImageView   imageView7_6 = headerView7.findViewById(R.id.home_advert_serven_6);
                ImageView   imageView7_7 = headerView7.findViewById(R.id.home_advert_serven_7);

                // 7
                BaseBindingAdapter.loadImageFitCenterType(imageView7_1,entityData.get(0).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView7_2,entityData.get(1).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView7_3,entityData.get(2).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView7_4,entityData.get(3).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView7_5,entityData.get(4).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView7_6,entityData.get(5).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView7_7,entityData.get(6).getImg());
                imageView7_1.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(0)));
                imageView7_2.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(1)));
                imageView7_3.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(2)));
                imageView7_4.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(3)));
                imageView7_5.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(4)));
                imageView7_6.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(5)));
                imageView7_7.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(6)));
            }else if(advertNum == HomeLayoutType.HOME_LAYOUT_8){
                //8
                headerView8 = LayoutInflater.from(getActivity()).inflate(R.layout.home_advert_eight,null,false);
                baseGridLaout.addView(headerView8);
                ImageView  imageView8_1 = headerView8.findViewById(R.id.home_advert_eight_1);
                ImageView   imageView8_2 = headerView8.findViewById(R.id.home_advert_eight_2);
                ImageView imageView8_3 = headerView8.findViewById(R.id.home_advert_eight_3);
                ImageView imageView8_4 = headerView8.findViewById(R.id.home_advert_eight_4);
                ImageView   imageView8_5 = headerView8.findViewById(R.id.home_advert_eight_5);
                ImageView   imageView8_6 = headerView8.findViewById(R.id.home_advert_eigth_6);
                ImageView   imageView8_7 = headerView8.findViewById(R.id.home_advert_eigth_7);
                ImageView   imageView8_8 = headerView8.findViewById(R.id.home_advert_eigth_8);

                // 8
                BaseBindingAdapter.loadImageFitCenterType(imageView8_1,entityData.get(0).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView8_2,entityData.get(1).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView8_3,entityData.get(2).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView8_4,entityData.get(3).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView8_5,entityData.get(4).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView8_6,entityData.get(5).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView8_7,entityData.get(6).getImg());
                BaseBindingAdapter.loadImageFitCenterType(imageView8_8,entityData.get(7).getImg());
                imageView8_1.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(0)));
                imageView8_2.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(1)));
                imageView8_3.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(2)));
                imageView8_4.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(3)));
                imageView8_5.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(4)));
                imageView8_6.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(5)));
                imageView8_7.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(6)));
                imageView8_8.setOnClickListener(v -> HomeUtils.toJumpAllAdvert(getActivity(),entityData.get(7)));
            }


        }




    }


    /**
     * 初始化广告图
     * @param detailList
     */
    private void initBanner(List<BannerEntity> detailList) {
        List<String> bannerList =new ArrayList<>();
        List<String>titleList =new ArrayList<>();
        for (BannerEntity model: detailList) {
            bannerList.add(model.getImg());
            titleList.add(model.getTitle());
        }


        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(bannerList);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CIRCLE_INDICATOR);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }


    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        if(banner !=null){
            banner.startAutoPlay();
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        if(banner !=null){
            banner.stopAutoPlay();
        }

    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBusCome(Event event) {

    }


//
    @Override
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEventBusCome(Event event) {
        if (event != null) {
            switch (event.getCode()){
                case HomeEvent.EventCode.codeScan:
                    KLogUtils.logTest("扫描二维码");

                    break;


            }
        }


    }


    @Override
    protected void receiveEvent(Event event) {
        // 接受到Event后的相关逻辑
        if (event != null) {
            switch (event.getCode()){
                case HomeEvent.EventCode.codeScan:
                    //刷新购物车数据
                    KLog.i("test","主界面调用刷新购物车数据");
                    break;
            }
        }

    }

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==10001 && resultCode == 100002){
            String shopId = data.getStringExtra("shopId");
            KLogUtils.logTest("扫描的二维码数据显示"+"shopId"+shopId);
            mViewModel.searchText.set(shopId);
            //进行数据更新操作
            initViewAllData();
        }
    }

    @Override
    public void toQcCodeClick() {
        //二维码
        ARouter.getInstance().build(RouterPath.Features.ROUTE_QRCODE_SCAN)
                .withBoolean("handle", true)
                // 填上request code在调用的activity的onActivityResult回调中获取二维码：data.getStringExtra("qrcode");
                .navigation(getActivity(),10001);
    }

    @Override
    public void toSearchClick() {

    }

    @Override
    public void toLogin() {

    }
}
