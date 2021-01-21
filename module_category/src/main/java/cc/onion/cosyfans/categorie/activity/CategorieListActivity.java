package cc.onion.cosyfans.categorie.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.base.BaseToolBarActivity;
import cc.onion.cosyfans.base.exception.ExceptionCode;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.KLogUtils;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.base.view.loadView.ULoadView;
import cc.onion.cosyfans.categorie.R;
import cc.onion.cosyfans.categorie.adapter.ProductGridAdapter;
import cc.onion.cosyfans.categorie.adapter.ProductListAdapter;
import cc.onion.cosyfans.categorie.databinding.CategorieListPtoductsBinding;
import cc.onion.cosyfans.categorie.entity.CaterorieChildenRequest;
import cc.onion.cosyfans.categorie.entity.responer.CategorieListEntity;
import cc.onion.cosyfans.categorie.viewModel.CategorieListViewModel;
import io.reactivex.disposables.Disposable;

/**
 * 分类列表,分类Iitem接口
 * @author guobihai
 * @date  2019/11/06
 */
@Route(path = RouterPath.Categorie.ROUTE_LIST_PRODUCTS)
public class CategorieListActivity extends BaseToolBarActivity<CategorieListPtoductsBinding, CategorieListViewModel> {


    private int pageNum = 1; // 页码
    private int pageSize = 2; // 每页数量



    ProductGridAdapter categoriGridListAdapter;
    ProductListAdapter productListAdapter;
    boolean isCheckLayout = false;
    GridLayoutManager gridLayoutManager;
    LinearLayoutManager linearLayoutManager;
    private ULoadView loadVew; // 加载视图

    @Autowired
    public String id;

    @Autowired
   public String titlename;


    /**
     * 数据缓存
     */
    List<CategorieListEntity.DataBean> categorieListEntity = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorie_list_ptoducts);
        mBinding.setViewModel(mViewModel);
        setToolbarTitle(titlename);
    }

    @Override
    public void initParam() {
        // 获取ARouter注入
        ARouter.getInstance().inject(this);

    }


    @Override
    public void initData() {
        super.initData();
        categoriGridListAdapter = new ProductGridAdapter(null,this);
        productListAdapter = new ProductListAdapter(null,this);
        //Left adapter

        //商品列表数据
        gridLayoutManager = new GridLayoutManager(this, 2);
        linearLayoutManager = new LinearLayoutManager(this,1,false);
        mBinding.lvListRecyclerview.setLayoutManager(gridLayoutManager);
        mBinding.lvListRecyclerview.setAdapter(categoriGridListAdapter);


        loadVew = new ULoadView(mBinding.body);
        loadVew.showLoading();



        if(StringUtils.isNotEmpty(id)){
            loadingData();
        }

        // 下拉刷新监听
        mBinding.itemDetailRefreshLayout.setOnRefreshListener(
                refreshLayout -> {
                    pageNum = 1;
                    loadingData();
                });

        // 上拉加载监听
        mBinding.itemDetailRefreshLayout.setOnLoadMoreListener(
                refreshLayout -> {
                    pageNum++;
                    loadingData();
                });


    }

    /**
     * 加载数据
     */
    private void loadingData() {

        if (pageNum == 1) {
            mBinding.itemDetailRefreshLayout.setEnableAutoLoadMore(true);
        }


        CaterorieChildenRequest childenRequest = new CaterorieChildenRequest();
        childenRequest.getKeyMap().put("pageNum",TypeUtils.toString(pageNum));
        childenRequest.getKeyMap().put("pageSize",TypeUtils.toString(pageSize));
        childenRequest.getKeyMap().put("categoryId",id);
        childenRequest.setPageNum(pageNum);
        childenRequest.setPageSize(pageSize);
        childenRequest.setCategoryId(Integer.parseInt(id));
        childenRequest.setRequestSign(childenRequest.getKeyMap());

        mViewModel.getCatetorieData(childenRequest, new ResponseListener<CategorieListEntity>() {
            @Override
            public void loadSuccess(CategorieListEntity data) {
                try {

                KLog.i("test","加载成功------类目数 据");
                loadVew.hide();
                mBinding.itemDetailRefreshLayout.finishRefresh();
                mBinding.itemDetailRefreshLayout.finishLoadMore();

                if(data.getData() != null && data.getData().size() >0){
                    if(data.getPageNum() ==1){
                        categorieListEntity.clear();
                        categorieListEntity = data.getData();
                        KLogUtils.logTest("数量:"+categorieListEntity.size());
                        if(isCheckLayout){
                            productListAdapter.setNewData(data.getData());
                            productListAdapter.notifyDataSetChanged();
                        }else{
                            categoriGridListAdapter.setNewData(data.getData());
                            categoriGridListAdapter.notifyDataSetChanged();
                        }


                    }else{
                        categorieListEntity.addAll(data.getData());
                        KLogUtils.logTest("数量:"+categorieListEntity.size());
                        if(isCheckLayout){
                            productListAdapter.addData(data.getData());
                            productListAdapter.notifyDataSetChanged();
                        }else{
                            categoriGridListAdapter.addData(data.getData());
                            categoriGridListAdapter.notifyDataSetChanged();
                        }
                    }


                }else {
                    // 没有数据
                    if (pageNum == 1) {
                        loadVew.showEmpty(v -> {
                            // 点击重新加载数据
                            loadVew.showLoading();
                            loadingData();
                        });
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
                if(StringUtils.isNoneEmpty(errorCode)){
                    if (errorCode.equals(ExceptionCode.NO_NERWORK_ERROR)) {
                        loadVew.showNetworkError(v -> {
                            // 无网络
                            loadVew.showLoading();
                            loadingData();

                        });
                    } else {
                        loadVew.showError("数据加载失败：" + errorCode + "\n" + errorMsg, v -> {
                            loadVew.showLoading();
                            loadingData();

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
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.categorie__menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {

        loadVew.showLoading();
        if(isCheckLayout){
            //grid
            mBinding.lvListRecyclerview.setLayoutManager(gridLayoutManager);
            mBinding.lvListRecyclerview.setAdapter(categoriGridListAdapter);
            categoriGridListAdapter.setNewData(categorieListEntity);
            categoriGridListAdapter.notifyDataSetChanged();
            loadVew.hide();

        }else{
            //list
            mBinding.lvListRecyclerview.setLayoutManager(linearLayoutManager);
            mBinding.lvListRecyclerview.setAdapter(productListAdapter);
            productListAdapter.setNewData(categorieListEntity);
            productListAdapter.notifyDataSetChanged();
            loadVew.hide();

        }
        isCheckLayout = !isCheckLayout;

        }catch (Exception e){
            e.printStackTrace();
        }
        return super.onOptionsItemSelected(item);
    }

}
