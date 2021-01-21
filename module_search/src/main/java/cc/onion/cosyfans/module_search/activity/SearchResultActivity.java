package cc.onion.cosyfans.module_search.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import cc.onion.cosyfans.base.BaseActivity;
import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.event.Event;
import cc.onion.cosyfans.base.exception.ExceptionCode;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.KLogUtils;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.base.view.loadView.ULoadView;
import cc.onion.cosyfans.module_search.Envent.HoristerEnvent;
import cc.onion.cosyfans.module_search.Envent.ResultViewEnvent;
import cc.onion.cosyfans.module_search.R;
import cc.onion.cosyfans.module_search.adapter.ProductLinearAdapter;
import cc.onion.cosyfans.module_search.adapter.ProductsItemAdapter;
import cc.onion.cosyfans.module_search.adapter.RecommonItemAdapter;
import cc.onion.cosyfans.module_search.adapter.RecommonLinearAdapter;
import cc.onion.cosyfans.module_search.databinding.SearchResultActivityBinding;
import cc.onion.cosyfans.module_search.entity.RecommendEntity;
import cc.onion.cosyfans.module_search.entity.SeachRequest;
import cc.onion.cosyfans.module_search.entity.SearchResultEntity;
import cc.onion.cosyfans.module_search.viewModel.SearchResultViewModel;
import io.reactivex.disposables.Disposable;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_search.activity
 * @ClassName: SearchResultActivity
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020-01-06 09:58
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-06 09:58
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = RouterPath.Search.ROUTE_SEARCH_HOME_RESULT)
public class SearchResultActivity extends BaseActivity<SearchResultActivityBinding, SearchResultViewModel> {

    private ULoadView loadVew; // 加载视图
    private int pageNum = 1; // 页码
    private int pageSize = 20; // 每页数量



    @Autowired
    String searchWord;

    RecommonItemAdapter recommonItemAdapter;
    ProductsItemAdapter itemAdapter;

    /**
     * 线性布局
     */
    ProductLinearAdapter  productLinearAdapter;
    RecommonLinearAdapter recommonLinearAdapter;

    /**
     * 搜索结果数据展示
     */
    List<SearchResultEntity.DataBean> resultDataList;


    /**
     * 展示推荐数据
     */
    List<RecommendEntity.DataBean> recommonDataList;


    /**
     * 判断是不是空数据返回的
     *
     */
    boolean isCommonData = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding.setViewModel(mViewModel);


    }

    @Override
    public void initParam() {
        // 获取ARouter注入
        ARouter.getInstance().inject(this);

    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.search_result_activity;
    }

    @Override
    public int initVariableId() {
       return cc.onion.cosyfans.module_search.BR.viewModel;
    }


    @Override
    public void initData() {
        super.initData();

        loadVew = new ULoadView(mBinding.body);
        loadVew.showLoading();
        initWithUI();
        mBinding.imgLeft.setOnClickListener(v -> {

            onBackPressed();
        });
//
//
        if(StringUtils.isNotEmpty(searchWord)){
            KLog.i("test","搜索词语："+searchWord);
            mViewModel.searchWord.set(searchWord);
            loadingData(searchWord);
        }else{
            loadRecommon(pageNum);
        }
//
//        loadRecommon();
        // 下拉刷新监听
        mBinding.itemDetailRefreshLayout.setOnRefreshListener(
                refreshLayout -> {
                    pageNum = 1;
                    if(StringUtils.isNotEmpty(searchWord)){
                        loadingData(searchWord);
                    }else{
                        loadRecommon(pageNum);
                    }

                });

        // 上拉加载监听
        mBinding.itemDetailRefreshLayout.setOnLoadMoreListener(
                refreshLayout -> {
                    pageNum++;
                    if(StringUtils.isNotEmpty(searchWord)){
                        loadingData(searchWord);
                    }else{
                        loadRecommon(pageNum);
                    }
                });


    }

    private void initWithUI() {
        recommonItemAdapter  = new RecommonItemAdapter(null,this);
        View header = LayoutInflater.from(SearchResultActivity.this).inflate(R.layout.search_header_no_data, null);
        recommonItemAdapter.addHeaderView(header);

        mBinding.lvListRecyclerview.setLayoutManager(new GridLayoutManager(this,2));
        mBinding.lvListRecyclerview.setAdapter(recommonItemAdapter);


        itemAdapter = new ProductsItemAdapter(null,this);
        mBinding.lvSearchData.setLayoutManager(new GridLayoutManager(this,2));
        mBinding.lvSearchData.setAdapter(itemAdapter);

    }


    /**
     * 切换布局
     */
    public void setLinearLayoutAdapter(){
        productLinearAdapter = new ProductLinearAdapter(null,this);
        mBinding.lvSearchData.setLayoutManager(new LinearLayoutManager(this));
        mBinding.lvSearchData.setAdapter(productLinearAdapter);
        if(resultDataList  != null && resultDataList.size() >0){

            productLinearAdapter.setNewData(resultDataList);
            productLinearAdapter.notifyDataSetChanged();
            loadVew.hide();

        }
    }

    /**
     * 有数据的
     */
    public void setGridViewLayoutAdapter(){
        itemAdapter = new ProductsItemAdapter(null,this);
        mBinding.lvSearchData.setLayoutManager(new GridLayoutManager(this,2));
        mBinding.lvSearchData.setAdapter(itemAdapter);
        if(resultDataList  != null && resultDataList.size() >0){

            itemAdapter.setNewData(resultDataList);
            itemAdapter.notifyDataSetChanged();
            loadVew.hide();

        }
    }


    /**
     * 推荐数据
     */
    public void setRecommonLinearLayoutAdapter(){
        recommonLinearAdapter = new RecommonLinearAdapter(null,this);
        mBinding.lvSearchData.setLayoutManager(new LinearLayoutManager(this));
        mBinding.lvSearchData.setAdapter(recommonLinearAdapter);
        if(recommonDataList  != null && recommonDataList.size() >0){

            recommonLinearAdapter.setNewData(recommonDataList);
            recommonLinearAdapter.notifyDataSetChanged();
            loadVew.hide();

        }
    }


    /**
     * 推荐数据
     */
    public void setRecommonGridViewLayoutAdapter(){

        recommonItemAdapter  = new RecommonItemAdapter(null,this);
        View header = LayoutInflater.from(SearchResultActivity.this).inflate(R.layout.search_header_no_data, null);
        recommonItemAdapter.addHeaderView(header);

        mBinding.lvListRecyclerview.setLayoutManager(new GridLayoutManager(this,2));
        mBinding.lvSearchData.setAdapter(recommonLinearAdapter);
        if(recommonDataList  != null && recommonDataList.size() >0){

            recommonItemAdapter.setNewData(recommonDataList);
            recommonItemAdapter.notifyDataSetChanged();
            loadVew.hide();

        }
    }



    /**
     * 加载数据
     * @param searchWord
     */
    private void loadingData(String searchWord) {

        SeachRequest seachRequest = new SeachRequest();
        seachRequest.setQ(searchWord);
        seachRequest.setPageNum(TypeUtils.toString(pageNum));
        seachRequest.setPageSize(TypeUtils.toString(pageSize));
//
        seachRequest.getKeyMap().put("q",searchWord);
        seachRequest.getKeyMap().put("pageNum",TypeUtils.toString(pageNum));
        seachRequest.getKeyMap().put("pageSize",TypeUtils.toString(pageSize));

        seachRequest.setRequestSign(seachRequest.getKeyMap());
        mViewModel.getSearchResultData(seachRequest, new ResponseListener<SearchResultEntity>() {
            @Override
            public void loadSuccess(SearchResultEntity data) {
                loadVew.hide();
                mBinding.itemDetailRefreshLayout.finishRefresh();
                mBinding.itemDetailRefreshLayout.finishLoadMore();
                KLog.i("test","加载数据～～～～");

                try {

                if(data.getData() != null && data.getData().size() >0) {

                    mBinding.lvSearchData.setVisibility(View.VISIBLE);
                    resultDataList = data.getData();
                    if(data.getPageNum() ==1){
                        //页数1的数据
                        itemAdapter.setNewData(data.getData());
                        itemAdapter.notifyDataSetChanged();
                    }else{
                        //加载多页的数据显示
                        itemAdapter.addData(data.getData());
                        itemAdapter.notifyDataSetChanged();
                    }
                }else{
                    if(pageNum  == 1){
                        //初次数据为0的时候就进行加载推荐数据的显示
                        mBinding.lvSearchData.setVisibility(View.GONE);
                        mBinding.lvListRecyclerview.setVisibility(View.VISIBLE);
                        loadRecommon(pageNum);

                    }else{
                        mBinding.lvSearchData.setVisibility(View.VISIBLE);
                        mBinding.lvListRecyclerview.setVisibility(View.GONE);
                    }


                }
                }catch (Exception e){
                    e.printStackTrace();
                }


            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                mBinding.itemDetailRefreshLayout.finishRefresh();
                mBinding.itemDetailRefreshLayout.finishLoadMore();
                if(StringUtils.isNoneEmpty(errorCode)) {
                    if (errorCode.equals(ExceptionCode.NO_NERWORK_ERROR)) {
                        loadVew.showNetworkError(v -> {
                            // 无网络
                            loadVew.showLoading();
                            loadingData(searchWord);

                        });
                    } else {
                        loadVew.showError("数据加载失败：" + errorCode + "\n" + errorMsg, v -> {
                            loadVew.showLoading();
                            loadingData(searchWord);

                        });
                    }
                }
            }

            @Override
            public void addDisposable(Disposable disposable) {

            }
        });

    }


    /**
     * 加载推荐数据
     * @param pageNum
     */
    public  void loadRecommon(int pageNum){
        mBinding.lvListRecyclerview.setVisibility(View.VISIBLE);
        mBinding.lvSearchData.setVisibility(View.GONE);
        BaseRequestBean  request = new BaseRequestBean();
        request.sign();
        mViewModel.getRecommendItem(request, new ResponseListener<RecommendEntity>() {
            @Override
            public void loadSuccess(RecommendEntity data) {
                loadVew.hide();
                try {

                mBinding.itemDetailRefreshLayout.finishRefresh();
                mBinding.itemDetailRefreshLayout.finishLoadMore();
                mBinding.itemDetailRefreshLayout.setEnableLoadMore(false);
                if(data.getData() != null && data.getData().size() >0){
                    recommonDataList = data.getData();
                    KLog.i("test","加载数据成功");
                    recommonItemAdapter.setNewData(data.getData());
                    recommonItemAdapter.notifyDataSetChanged();
                    recommonItemAdapter.setShoHotStock(true);
                    isCommonData = true;
                }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                mBinding.itemDetailRefreshLayout.finishRefresh();
                mBinding.itemDetailRefreshLayout.finishLoadMore();
                if(StringUtils.isNoneEmpty(errorCode)) {
                    if (errorCode.equals(ExceptionCode.NO_NERWORK_ERROR)) {
                        loadVew.showNetworkError(v -> {
                            // 无网络
                            loadVew.showLoading();
                            loadingData(searchWord);

                        });
                    } else {
                        loadVew.showError("数据加载失败：" + errorCode + "\n" + errorMsg, v -> {
                            loadVew.showLoading();
                            loadingData(searchWord);

                        });
                    }
                }
            }

            @Override
            public void addDisposable(Disposable disposable) {
                    addSubscription(disposable);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeDisposable();
    }



    @Override
    protected void receiveEvent(Event event) {
        // 接受到Event后的相关逻辑
        KLogUtils.logTest("接受切换UI修改");
        try {

        if(!isCommonData){
            loadVew.showLoading();
            switch (event.getCode()) {
                case ResultViewEnvent.VIEW_ONE:
                    mBinding.imgMenu.setImageResource(R.mipmap.icon_grid_menu);
                    setLinearLayoutAdapter();
                    break;
                case ResultViewEnvent.VIEW_TWO:
                    mBinding.imgMenu.setImageResource(R.mipmap.icon_menu_check);
                    setGridViewLayoutAdapter();
                    break;
            }
        }else{
            //空数据时操作业务
        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }
}
