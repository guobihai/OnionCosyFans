package cc.onion.cosyfans.home.fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
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
import com.wihaohao.PageGridView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.BaseFragment;
import cc.onion.cosyfans.base.account.AccountManager;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.GlideImageLoader;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.home.adapter.HomeFragmentPagerAdapter;
import cc.onion.cosyfans.home.adapter.HomeSpecialItemAdapter;
import cc.onion.cosyfans.home.adapter.HousePricuterdAdapter;
import cc.onion.cosyfans.home.entity.HomeTagItemIconModel;
import cc.onion.cosyfans.home.entity.HomeTagTextModel;
import cc.onion.cosyfans.home.entity.response.AdvertEntity;
import cc.onion.cosyfans.home.entity.ContextModelRequest;
import cc.onion.cosyfans.home.entity.response.DetailItemEntity;
import cc.onion.cosyfans.home.entity.response.TableEntity;
import cc.onion.cosyfans.home.listenter.HomeViewOnClickListener;
import cc.onion.cosyfans.home.type.AdvertType;
import cc.onion.cosyfans.home.type.HomeLayoutType;
import cc.onion.cosyfans.home.type.HomeModelType;
import cc.onion.cosyfans.home.adapter.HomeTopGridAdapter;
import cc.onion.cosyfans.home.entity.HomeGetAllModelRequest;
import cc.onion.cosyfans.home.entity.response.BannerEntity;
import cc.onion.cosyfans.home.entity.response.HomeAllModel;
import cc.onion.cosyfans.home.type.SpecificType;
import cc.onion.cosyfans.home.type.TagShowType;
import cc.onion.cosyfans.home.viewmodel.HomeViewModel;
import cc.onion.cosyfans.home.weight.ViewPagerForScrollView;
import cc.onion.cosyfans.module_home.BR;
import cc.onion.cosyfans.module_home.R;
import cc.onion.cosyfans.module_home.databinding.HomeFrgmHomeBinding;
import io.reactivex.disposables.Disposable;

/**
 * 首页
 * @author guobihai
 * @created 2019/11/6
 */
//@Route(path = RouterPath.Home.ROUTE_HOME_PATH)
public class HomeFragment  extends BaseFragment<HomeFrgmHomeBinding, HomeViewModel> implements HomeViewOnClickListener {

    //宫格适配器
    HomeTopGridAdapter   homeTopGridAdapter;
    List<String> stringList;
    //头布局
    View headerView,headerView1,headerView2,headerView3,headerView4,headerView5,
            headerView6,headerView7,headerView8,headerTag,headerAnnouncement,headerSpecial,headerText,headerActivity,headerTable,headerBaseGrid;
    //广告
    Banner banner;
    //广告背景
    ImageView imgBannerBg;
    RelativeLayout layoutHeaderView;
    List<AdvertEntity.DataBean> entityData;
    //基础布局一
    LinearLayout layoutBase;
    private List<Fragment> fragments;
    private HomeFragmentPagerAdapter mPagerAdapter;
    TableEntity tableEntity;//
    //宫格布局基础类
    LinearLayout headerBaseGridView;
    //宫格背景图片
    ImageView imgGridBase;

    int  baseView = 0;
    RecyclerView recyclerViewSpecial;
    ImageView imgSpecial;




    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.home_frgm_home;
    }


    @Override
    public int initVariableId() {
        return BR.viewModel;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel.setHomeViewOnClickListener(this);
        //开启Token支持，当前不需要验证Token拦截器
        AccountManager.setIsGotoken(false);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void initData() {

        super.initData();

        // 下拉刷新监听
        mBinding.usedHouseRefreshLayout.setEnableLoadMore(false);
        mBinding.usedHouseRefreshLayout.setOnRefreshListener(
                refreshLayout -> {
                    //下拉的时候只加载头部数据
                    initViewAllData();
                });


        layoutBase = mBinding.layoutBase;

        //滑动回到顶部
        setScorTop();
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
        layoutBase.removeAllViews();
        layoutBase.addView(headerView,0);
        KLog.i("test","添加头部的位置headerView:"+layoutBase.getChildCount());
    }


    public void initViewAllData(){
        //添加头部布局，刷新操作重新移除数据
        addHeaderView();

        HomeGetAllModelRequest request = new HomeGetAllModelRequest();
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
        setTitleLayout(data);
        //固定模块--------------
//      1搜素栏
        setFloadDialogLayout(data);

        //固定模块--------------


//        界面布局动态配置数据判断
        setLayout(data);


//        动态话的初始化数据
        setLayoutData(data);


        //信息流数据初始化
        if(data.getFlowModule() !=null){
            //请求标签下面的数据
            getTableDetailLayout(data);
        }



        }

    private void setLayoutData(HomeAllModel data) {
        if(data.getFloatModuleList() != null && data.getFloatModuleList().size() >0){
            try {
                View tmptepView = null;
                for (HomeAllModel.FloatModuleListBean floatModule:data.getFloatModuleList()) {
                    int layoutBaseChildCount = layoutBase.getChildCount();
                    for (int i=0;i<layoutBaseChildCount;i++){
                        if(StringUtils.isNotEmpty(floatModule.getModuleName())){
                            String layoutTag = (String) layoutBase.getChildAt(i).getTag(R.id.home_tag_name);

                            if(StringUtils.isNotEmpty(layoutTag)){
                                KLog.i("test","layout-----tag"+layoutTag);
                                if(layoutTag.equals(floatModule.getModuleName())){
                                    KLog.i("test","子View"+floatModule.getModuleName()+"layout---Tag"+layoutTag);
                                    //现在根据初始化到不同到子View进行赋值操作
                                    tmptepView = layoutBase.getChildAt(i);

                                    //广告位
                                    if(floatModule.getModuleType() == HomeModelType.MODEL_TYPE_1){
                                        //                    广告类型  1广告，2活动广告，3宫格广告
                                        getAdvertLayoutData(floatModule,tmptepView);
                                    }else if(floatModule.getModuleType() == HomeModelType.MODEL_TYPE_2){
                                        //2、公告位
                                        getAdvertLayoutData(floatModule,tmptepView);

                                    }else if(floatModule.getModuleType() == HomeModelType.MODEL_TYPE_3){
                                        //3、标签位
                                        getAdvertLayoutData(floatModule,tmptepView);

                                    }else if(floatModule.getModuleType() == HomeModelType.MODEL_TYPE_4){
                                        //                    4、专题位
                                        addSpecialViewLayout(floatModule,tmptepView);

                                    }




                                }
                            }
                        }

                    }
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    private void setLayout(HomeAllModel data) {
        if(data.getFloatModuleList() != null && data.getFloatModuleList().size() >0){
            for (HomeAllModel.FloatModuleListBean floatModule:data.getFloatModuleList()) {
                //广告位
                if(floatModule.getModuleType() == HomeModelType.MODEL_TYPE_1){
//                    广告类型  1广告，2活动广告，3宫格广告
                    if(floatModule.getAdvertType() == AdvertType.ADVERTYPE_1){
                        //活动广告
                        headerView1 = LayoutInflater.from(getActivity()).inflate(R.layout.home_advert_one,null,false);
                        headerView1.setTag(R.id.home_tag_name,floatModule.getModuleName());
                        layoutBase.addView(headerView1);

                    }else if(floatModule.getAdvertType()  == AdvertType.ADVERTYPE_2){
                        headerActivity = LayoutInflater.from(getActivity()).inflate(R.layout.home_advert_activity,null,false);
                        headerActivity.setTag(R.id.home_tag_name,floatModule.getModuleName());
                        layoutBase.addView(headerActivity);
                    }else{
                        headerBaseGrid = LayoutInflater.from(getActivity()).inflate(R.layout.home_layout_grid_base,null,false);
                        headerBaseGridView = headerBaseGrid.findViewById(R.id.layout_base_grid);
                        imgGridBase = headerBaseGrid.findViewById(R.id.img_grid_base);
                        headerBaseGrid.setTag(R.id.home_tag_name,floatModule.getModuleName());
                        layoutBase.addView(headerBaseGrid);

                    }


                }else if(floatModule.getModuleType() == HomeModelType.MODEL_TYPE_2){
                    //2、公告位
//                    advertTypeLayout(floatModule);
                    KLog.i("test","公告位置:");
                    headerAnnouncement = LayoutInflater.from(getActivity()).inflate(R.layout.home_model_announcement,null,false);
                    headerAnnouncement.setTag(R.id.home_tag_name,floatModule.getModuleName());
                    layoutBase.addView(headerAnnouncement);

                }else if(floatModule.getModuleType() == HomeModelType.MODEL_TYPE_3){
                    //3、标签位
                    headerTag = LayoutInflater.from(getActivity()).inflate(R.layout.home_model_tag,null,false);
                    headerTag.setTag(R.id.home_tag_name,floatModule.getModuleName());
                    layoutBase.addView(headerTag);
                    KLog.i("test","添加头部的位置headerTag:"+layoutBase.getChildCount());


                }else if(floatModule.getModuleType() == HomeModelType.MODEL_TYPE_4){
//                    4、专题位
                    if(floatModule.getSpecificType() == SpecificType.TYPE_1){
                        headerSpecial = LayoutInflater.from(getActivity()).inflate(R.layout.home_model_special_topic,null,false);
                        headerSpecial.setTag(R.id.home_tag_name,floatModule.getModuleName());
                        layoutBase.addView(headerSpecial);
                    }else{
                        //文字专题
                        headerText = LayoutInflater.from(getActivity()).inflate(R.layout.home_model_special_text,null,false);
                        headerText.setTag(R.id.home_tag_name,floatModule.getModuleName());
                        layoutBase.addView(headerText);
                    }

                }

            }

        }
    }

    private void setFloadDialogLayout(HomeAllModel data) {
        if(data.getFixedModuleList() != null && data.getFixedModuleList().size() >0){
            for (HomeAllModel.FixedModuleListBean fixedModel :data.getFixedModuleList()) {
                if(fixedModel.getModuleType() == 7){
                    //搜素栏·

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

    private void setTitleLayout(HomeAllModel data) {
        if(data.getFloatAdModule() != null){
            if(data.getFloatAdModule().getAdvertShowType() == 11){
                //长期显示
                BaseBindingAdapter.loadImage(mBinding.imgFloadIcon,data.getFloatAdModule().getImg());
            }else{
//                12,每隔N小时显示一次
                int hoursApart = data.getFloatAdModule().getHoursApart();
                BaseBindingAdapter.loadImage(mBinding.imgFloadIcon,data.getFloatAdModule().getImg());
            }
            //                链接类型  0 其他 1 列表 2商品详情 3 专辑 4: 分类  5 搜索结果 6 具体分类 7 h5页面
            mBinding.imgFloadIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //处理跳转事件

                }
            });
        }
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

            }

            @Override
            public void addDisposable(Disposable disposable) {
                addDisposable(disposable);
            }
        });
    }

    /**
     * 所有的子View都在这里初始化
     * 统一管理中控台
     * 全部使用layou获取到的子View管理操作
     * @param data
     * @param floatModule
     * @param tmptepView
     */
    private void allLayoutInitData(AdvertEntity data, HomeAllModel.FloatModuleListBean floatModule, View tmptepView) {
        //model1
        if(floatModule.getModuleType() == HomeModelType.MODEL_TYPE_1){
            if(floatModule.getAdvertType() == AdvertType.ADVERTYPE_3){
                if(StringUtils.isNotEmpty(floatModule.getBackgroundImage())){
                    BaseBindingAdapter.loadImage(imgGridBase,floatModule.getBackgroundImage());
                }
                //宫格布局
                addHeaderViewShow(data);
            }else if(floatModule.getAdvertType()  == AdvertType.ADVERTYPE_2){
                //活动广告
                setActivityViewShow(data,tmptepView);
            }
            }else if(floatModule.getModuleType() == HomeModelType.MODEL_TYPE_2){
                //公告位置
                setAnnouncementlayout(floatModule, tmptepView);
            }else if(floatModule.getModuleType() == HomeModelType.MODEL_TYPE_3){
                //  标签
                setHomeTagLayoutView(floatModule,data,tmptepView);


            }else if(floatModule.getModuleType() == HomeModelType.MODEL_TYPE_4){

    //                      //专题

            }
    }

    /**
     * 公告中心布局初始化数据操作
     * @param floatModule
     * @param tmptepView
     */
    private void setAnnouncementlayout(HomeAllModel.FloatModuleListBean floatModule, View tmptepView) {
//        KLog.i("test","公告中心布局初始化数据操作~~~~~~~~~");
//        ImageView imageBg = tmptepView.findViewById(R.id.img_bg);
//        BaseBindingAdapter.loadImageLarge(imageBg,floatModule.getBackgroundImage());
//        ImageView imgAnnpunLeft = tmptepView.findViewById(R.id.img_announ_left);
//        BaseBindingAdapter.loadImage(imgAnnpunLeft,floatModule.getImageUrl());
    }


    /**
     * 单独给专题模块使用，不做融合
     * @param floatModule
     * @param tmptepView
     */
    private void addSpecialViewLayout(HomeAllModel.FloatModuleListBean floatModule, View tmptepView) {
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
                setSpecialTopicLayout(data, floatModule,tmptepView);

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
     * 设置专题数据的加载显示
     * @param data
     * @param floatModule
     * @param tmptepView
     */
    private void setSpecialTopicLayout(AdvertEntity data, HomeAllModel.FloatModuleListBean floatModule, View tmptepView) {
        try {

        AdvertEntity.DataBean model =  data.getData().get(0);
        if(floatModule.getSpecificType() == SpecificType.TYPE_1){

            RecyclerView recyclerViewSpecial = tmptepView.findViewById(R.id.lrl_special_topic);
            ImageView   imgSpecial = tmptepView.findViewById(R.id.img_special);

            KLog.i("test","添加头部的位置:headerSpecial"+layoutBase.getChildCount());


            //设置图片显示
            KLog.i("test","t图片："+model);
            BaseBindingAdapter.loadImageLarge(imgSpecial,model.getImg(),R.mipmap.home_advert_one);
            HomeSpecialItemAdapter specialItemAdapter = new HomeSpecialItemAdapter(null,getActivity());
            recyclerViewSpecial.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
            recyclerViewSpecial.setAdapter(specialItemAdapter);
//            specialItemAdapter.setNewData(model.getDetailItemVos());
            specialItemAdapter.notifyDataSetChanged();
            specialItemAdapter.setOnItemClickListener((adapter, view, position) -> {
                DetailItemEntity adapterItem = (DetailItemEntity) adapter.getItem(position);
                KLog.i("test","itemId"+"~~~"+adapterItem.getItemId());
                //跳转详情页
                ARouter.getInstance()
                        .build(RouterPath.Item.ROUTE_ITEM_PRODUCTS_PATH)
                        .withString("itemId",TypeUtils.toString(adapterItem.getItemId()))
                        .navigation(getActivity());




            });

        }else{
            //文字专题
            RecyclerView recyclerViewSpecial = tmptepView.findViewById(R.id.lrl_special_topic);
            ImageView imgSpecial = tmptepView.findViewById(R.id.img_special);
            ImageView imageLeft = tmptepView.findViewById(R.id.img_left);
            TextView tvTitle = tmptepView.findViewById(R.id.tv_title);

            if(StringUtils.isNotEmpty(model.getImg()) && StringUtils.isNotEmpty(model.getTitle())){
                BaseBindingAdapter.loadImage(imageLeft,model.getImg());
                tvTitle.setText(model.getTitle());

            }
            BaseBindingAdapter.loadImageLarge(imgSpecial,floatModule.getBackgroundImage(),R.mipmap.home_advert_one);
            //设置图片显示
            KLog.i("test","t图片："+model.getImg());
//                                BaseBindingAdapter.loadImageLarge(imgSpecial,modelType.getImg(),R.mipmap.home_advert_one);

            HomeSpecialItemAdapter specialItemAdapter = new HomeSpecialItemAdapter(null,getActivity());
            recyclerViewSpecial.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
            recyclerViewSpecial.setAdapter(specialItemAdapter);
//            specialItemAdapter.setNewData(model.getDetailItemVos());
            specialItemAdapter.notifyDataSetChanged();
            specialItemAdapter.setOnItemClickListener((adapter, view, position) -> {
                DetailItemEntity detailItemEntity = (DetailItemEntity) adapter.getItem(position);
                KLog.i("test","itemId------"+"~~~"+detailItemEntity.getItemId());
                //跳转详情页
                ARouter.getInstance()
                        .build(RouterPath.Item.ROUTE_ITEM_PRODUCTS_PATH)
                        .withString("itemId",TypeUtils.toString(detailItemEntity.getItemId()))
                        .navigation(getActivity());
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
                int size = data.getData().get(0).getDetailIconVos().size();

                ImageView imageView1 = tmptepView.findViewById(R.id.home_advert_activity_1);
                ImageView imageView2 = tmptepView.findViewById(R.id.home_advert_activity_2);
                ImageView imageView3 = tmptepView.findViewById(R.id.home_advert_activity_3);
                ImageView activityImageBg = tmptepView.findViewById(R.id.img_activity_bg);
                //
                BaseBindingAdapter.loadImage(activityImageBg,data.getData().get(0).getImg());

                if(size == 1){
                    BaseBindingAdapter.loadImage(imageView1,data.getData().get(0).getDetailIconVos().get(0).getImg());
                    imageView2.setVisibility(View.GONE);
                    imageView3.setVisibility(View.GONE);

                }else if(size == 2){
                    BaseBindingAdapter.loadImage(imageView1,data.getData().get(0).getDetailIconVos().get(0).getImg());
                    BaseBindingAdapter.loadImage(imageView2,data.getData().get(0).getDetailIconVos().get(1).getImg());
                    imageView3.setVisibility(View.GONE);
                }else{
                    BaseBindingAdapter.loadImage(imageView1,data.getData().get(0).getDetailIconVos().get(0).getImg());
                    BaseBindingAdapter.loadImage(imageView2,data.getData().get(0).getDetailIconVos().get(1).getImg());
                    BaseBindingAdapter.loadImage(imageView3,data.getData().get(0).getDetailIconVos().get(2).getImg());

                }

            }

        }


    }

    private void addHeaderViewShow(AdvertEntity advertEntity) {


            if(advertEntity.getData() !=null && advertEntity.getData().size() >0){

                entityData = advertEntity.getData();
                int advertNum = advertEntity.getData().size();
                if(advertNum == HomeLayoutType.HOME_LAYOUT_1){

                }else if(advertNum == HomeLayoutType.HOME_LAYOUT_2){
                    //2
                    headerView2 = LayoutInflater.from(getActivity()).inflate(R.layout.home_advert_two,null,false);
                    headerBaseGridView.addView(headerView2);
                    ImageView  imageView2_1 = headerView5.findViewById(R.id.home_advert_two_1);
                    ImageView   imageView2_2 = headerView5.findViewById(R.id.home_advert_two_2);

                    BaseBindingAdapter.loadImage(imageView2_1,entityData.get(0).getImg());
                    BaseBindingAdapter.loadImage(imageView2_2,entityData.get(1).getImg());
                }else if(advertNum == HomeLayoutType.HOME_LAYOUT_3){
                    //3
                    headerView3 = LayoutInflater.from(getActivity()).inflate(R.layout.home_advert_three,null,false);
                    headerBaseGridView.addView(headerView3);
                    ImageView  imageView3_1 = headerView5.findViewById(R.id.home_advert_two_1);
                    ImageView   imageView3_2 = headerView5.findViewById(R.id.home_advert_two_2);
                    ImageView imageView3_3 = headerView5.findViewById(R.id.home_advert_two_3);


                    BaseBindingAdapter.loadImage(imageView3_1,entityData.get(0).getImg());
                    BaseBindingAdapter.loadImage(imageView3_2,entityData.get(1).getImg());
                    BaseBindingAdapter.loadImage(imageView3_3,entityData.get(2).getImg());

                }else if(advertNum == HomeLayoutType.HOME_LAYOUT_4){
                    //4
                    headerView4 = LayoutInflater.from(getActivity()).inflate(R.layout.home_advert_four,null,false);
                    headerBaseGridView.addView(headerView4);

                    ImageView  imageView4_1 = headerView5.findViewById(R.id.home_advert_four_1);
                    ImageView   imageView4_2 = headerView5.findViewById(R.id.home_advert_four_1);
                    ImageView imageView4_3 = headerView5.findViewById(R.id.home_advert_four_1);
                    ImageView imageView4_4 = headerView5.findViewById(R.id.home_advert_four_1);


                    BaseBindingAdapter.loadImage(imageView4_1,entityData.get(0).getImg());
                    BaseBindingAdapter.loadImage(imageView4_2,entityData.get(1).getImg());
                    BaseBindingAdapter.loadImage(imageView4_3,entityData.get(2).getImg());
                    BaseBindingAdapter.loadImage(imageView4_4,entityData.get(3).getImg());

                }else if(advertNum == HomeLayoutType.HOME_LAYOUT_5){


                    headerView5 = LayoutInflater.from(getActivity()).inflate(R.layout.home_advert_five,null,false);
                    headerBaseGridView.addView(headerView5);

                    ImageView  imageView5_1 = headerView5.findViewById(R.id.home_advert_five_1);
                    ImageView   imageView5_2 = headerView5.findViewById(R.id.home_advert_five_2);
                    ImageView imageView5_3 = headerView5.findViewById(R.id.home_advert_five_3);
                    ImageView imageView5_4 = headerView5.findViewById(R.id.home_advert_five_4);
                    ImageView   imageView5_5 = headerView5.findViewById(R.id.home_advert_five_5);


                    BaseBindingAdapter.loadImage(imageView5_1,entityData.get(0).getImg());
                    BaseBindingAdapter.loadImage(imageView5_2,entityData.get(1).getImg());
                    BaseBindingAdapter.loadImage(imageView5_3,entityData.get(2).getImg());
                    BaseBindingAdapter.loadImage(imageView5_4,entityData.get(3).getImg());
                    BaseBindingAdapter.loadImage(imageView5_5,entityData.get(4).getImg());

                }else if(advertNum == HomeLayoutType.HOME_LAYOUT_6){
                    //6
                    headerView6 = LayoutInflater.from(getActivity()).inflate(R.layout.home_advert_six,null,false);
                    headerBaseGridView.addView(headerView6);
                    ImageView  imageView6_1 = headerView6.findViewById(R.id.home_advert_six_1);
                    ImageView   imageView6_2 = headerView6.findViewById(R.id.home_advert_six_2);
                    ImageView imageView6_3 = headerView6.findViewById(R.id.home_advert_six_3);
                    ImageView imageView6_4 = headerView6.findViewById(R.id.home_advert_six_4);
                    ImageView   imageView6_5 = headerView6.findViewById(R.id.home_advert_six_5);
                    ImageView   imageView6_6 = headerView6.findViewById(R.id.home_advert_six_6);

                    // 6
                    BaseBindingAdapter.loadImage(imageView6_1,entityData.get(0).getImg());
                    BaseBindingAdapter.loadImage(imageView6_2,entityData.get(1).getImg());
                    BaseBindingAdapter.loadImage(imageView6_3,entityData.get(2).getImg());
                    BaseBindingAdapter.loadImage(imageView6_4,entityData.get(3).getImg());
                    BaseBindingAdapter.loadImage(imageView6_5,entityData.get(4).getImg());
                    BaseBindingAdapter.loadImage(imageView6_6,entityData.get(5).getImg());

                }else if(advertNum == HomeLayoutType.HOME_LAYOUT_7){
                    //7
                    headerView7 = LayoutInflater.from(getActivity()).inflate(R.layout.home_advert_serven,null,false);
                    headerBaseGridView.addView(headerView7);
                    ImageView  imageView7_1 = headerView7.findViewById(R.id.home_advert_serven_1);
                    ImageView   imageView7_2 = headerView7.findViewById(R.id.home_advert_serven_2);
                    ImageView imageView7_3 = headerView7.findViewById(R.id.home_advert_serven_3);
                    ImageView imageView7_4 = headerView7.findViewById(R.id.home_advert_serven_4);
                    ImageView   imageView7_5 = headerView7.findViewById(R.id.home_advert_serven_5);
                    ImageView   imageView7_6 = headerView7.findViewById(R.id.home_advert_serven_6);
                    ImageView   imageView7_7 = headerView7.findViewById(R.id.home_advert_serven_7);

                    // 7
                    BaseBindingAdapter.loadImage(imageView7_1,entityData.get(0).getImg());
                    BaseBindingAdapter.loadImage(imageView7_2,entityData.get(1).getImg());
                    BaseBindingAdapter.loadImage(imageView7_3,entityData.get(2).getImg());
                    BaseBindingAdapter.loadImage(imageView7_4,entityData.get(3).getImg());
                    BaseBindingAdapter.loadImage(imageView7_5,entityData.get(4).getImg());
                    BaseBindingAdapter.loadImage(imageView7_6,entityData.get(5).getImg());
                    BaseBindingAdapter.loadImage(imageView7_7,entityData.get(6).getImg());
                }else if(advertNum == HomeLayoutType.HOME_LAYOUT_8){
                    //8
                    headerView8 = LayoutInflater.from(getActivity()).inflate(R.layout.home_advert_eight,null,false);
                    headerBaseGridView.addView(headerView8);
                    ImageView  imageView8_1 = headerView8.findViewById(R.id.home_advert_eight_1);
                    ImageView   imageView8_2 = headerView8.findViewById(R.id.home_advert_eight_2);
                    ImageView imageView8_3 = headerView8.findViewById(R.id.home_advert_eight_3);
                    ImageView imageView8_4 = headerView8.findViewById(R.id.home_advert_eight_4);
                    ImageView   imageView8_5 = headerView8.findViewById(R.id.home_advert_eight_5);
                    ImageView   imageView8_6 = headerView8.findViewById(R.id.home_advert_eigth_6);
                    ImageView   imageView8_7 = headerView8.findViewById(R.id.home_advert_eigth_7);
                    ImageView   imageView8_8 = headerView8.findViewById(R.id.home_advert_eigth_8);

                    // 8
                    BaseBindingAdapter.loadImage(imageView8_1,entityData.get(0).getImg());
                    BaseBindingAdapter.loadImage(imageView8_2,entityData.get(1).getImg());
                    BaseBindingAdapter.loadImage(imageView8_3,entityData.get(2).getImg());
                    BaseBindingAdapter.loadImage(imageView8_4,entityData.get(3).getImg());
                    BaseBindingAdapter.loadImage(imageView8_5,entityData.get(4).getImg());
                    BaseBindingAdapter.loadImage(imageView8_6,entityData.get(5).getImg());
                    BaseBindingAdapter.loadImage(imageView8_7,entityData.get(6).getImg());
                    BaseBindingAdapter.loadImage(imageView8_8,entityData.get(7).getImg());

                }


            }




    }


    /**
     * 添加标签布局，动态化配置布局
     */
    private void addTableLayout() {
        try {

            if(tableEntity !=null && tableEntity.getData() != null && tableEntity.getData().getFlowTabList().size() >0){
                KLog.i("test","获取标签是否成功");
                headerTable = LayoutInflater.from(getActivity()).inflate(R.layout.home_item_table,null,false);

                if(layoutBase != null){
                    int childCount = layoutBase.getChildCount();
                    KLog.i("test","添加头部的位置layoutBase:"+childCount);

                    int childCountSize = layoutBase.getChildCount();
                    headerTable.setTag(R.id.home_tag_name,"tableLayout");
                    layoutBase.addView(headerTable);
                }


                TabLayout tabLayout = headerTable.findViewById(R.id.item_tabLayout);
                ViewPagerForScrollView viewPager = headerTable.findViewById(R.id.item_view_pageer);

                fragments = new ArrayList<>();

                viewPager.setAdapter(mPagerAdapter);


                for (int i = 0; i < tableEntity.getData().getFlowTabList().size(); i++) {
                    tabLayout.addTab(tabLayout.newTab().setText(tableEntity.getData().getFlowTabList().get(i).getFlowTabName()));
                }


                viewPager.setAdapter(new HousePricuterdAdapter(getChildFragmentManager(),tableEntity.getData().getFlowTabList(),viewPager));
                tabLayout.setupWithViewPager(viewPager);
                for (int i = 0; i < tabLayout.getTabCount(); i++) {
                    TabLayout.Tab tab = tabLayout.getTabAt(i);
                    tab.setText(tableEntity.getData().getFlowTabList().get(i).getFlowTabName());
                }
//            mBinding.layoutThree.viewpagerHouse.setOffscreenPageLimit(2);

                viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float v, int i1) {
                        KLog.i("test","viewPager切换的是"+position);
//                        viewPager.setCurrentItem(position);
                        viewPager.resetHeight(position);
                        viewPager.refreshView(position);
                    }

                    @Override
                    public void onPageSelected(int i) {

                    }

                    @Override
                    public void onPageScrollStateChanged(int i) {

                    }
                });


                tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        int position = tab.getPosition();
                        KLog.i("test","table切换的是"+position);
//                        viewPager.setCurrentItem(position);
                        viewPager.resetHeight(position);
                        viewPager.refreshView(position);
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
    public void toQcCodeClick() {
        //二维码
        ARouter.getInstance().build(RouterPath.Features.ROUTE_QRCODE_SCAN)
                .withBoolean("handle", true)
                // 填上request code在调用的activity的onActivityResult回调中获取二维码：data.getStringExtra("qrcode");
                .navigation();
    }

    @Override
    public void toSearchClick() {

    }

    @Override
    public void toLogin() {

    }




    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setScorTop() {
        mBinding.imgTop.setOnClickListener(v -> {
//            mBinding.netScroview.scrollTo(0,0);
            mBinding.netScroview.smoothScrollTo(0, 1);
        });
        mBinding.netScroview.setOnScrollChangeListener((View.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            try {

                if (scrollY > oldScrollY) {
//                    KLog.e("=====", "下滑");
                    mBinding.imgFloadIcon.setImageAlpha(150);
                    if(scrollY >1000){
                        mBinding.imgTop.setVisibility(View.VISIBLE);
                    }


                }

                if (scrollY < oldScrollY) {
//                    KLog.e("=====", "上滑");
                    if(scrollY < 1000){
                        mBinding.imgTop.setVisibility(View.GONE);
                    }
                }




                if (scrollY == 0) {

                    KLog.e("=====", "滑倒顶部");
                    mBinding.imgFloadIcon.setImageAlpha(255);
                    mBinding.imgTop.setVisibility(View.GONE);
                }



                if (scrollY == (mBinding.netScroview.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())) {
                    KLog.e("=====", "滑倒底部");
                    mBinding.imgFloadIcon.setImageAlpha(255);
//                    mBinding.imgTop.setVisibility(View.GONE);
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    /**
     * 改变透明度
     *
     * @param color
     * @param fraction
     * @return
     */
    private int changeAlpha(int color, float fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = (int) (Color.alpha(color) * fraction);
        return Color.argb(alpha, red, green, blue);
    }
}
