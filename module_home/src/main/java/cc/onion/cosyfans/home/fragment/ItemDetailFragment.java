package cc.onion.cosyfans.home.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cc.onion.cosyfans.base.config.AppBaseConfig;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.DateFormatUtils;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.MsOnionSecuritySignUtils;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.home.adapter.HomeTablbeItemAdapter;
import cc.onion.cosyfans.home.api.HomeApiServer;
import cc.onion.cosyfans.home.entity.ItemDetailEntity;
import cc.onion.cosyfans.home.entity.response.TableDetailEntity;
import cc.onion.cosyfans.home.weight.ViewPagerForScrollView;
import cc.onion.cosyfans.module_home.R;
import io.reactivex.disposables.Disposable;

/**
 * 动态生成布局代码
 * @author guobihai
 * @date 2019 - 11-15
 */
@SuppressLint("ValidFragment")
public class ItemDetailFragment extends Fragment {

    View contextView;
    String flowTabId;
    RecyclerView rlItemRecyclerView;
    HomeTablbeItemAdapter  homeTablbeItemAdapter;
    ViewPager mPagerForScrollView;
    int position = 0;

    private int pageNum = 1;
    private int pageSize = 4;
    //Fragment的View加载完毕的标记
    private boolean isViewCreated;
    //Fragment对用户可见的标记
    private boolean isUIVisible;





    @SuppressLint("ValidFragment")
    public ItemDetailFragment(ViewPager pagerForScrollView, int i) {
        this.mPagerForScrollView = pagerForScrollView;
        int position = i;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        flowTabId = bundle.getString("flowTabId");
        initReclyView();
        initData();
        isViewCreated = true;
        lazyLoad();

    }





    /** Fragment当前状态是否可见 */
    protected boolean isVisible;


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见
        if (isVisibleToUser) {
            isUIVisible = true;
            lazyLoad();
        } else {
            isUIVisible = false;
        }
    }

    private void lazyLoad() {
        //这里进行双重标记判断,是因为setUserVisibleHint会多次回调,并且会在onCreateView执行前回调,必须确保onCreateView加载完毕且页面可见,才加载数据
        if (isViewCreated && isUIVisible) {
            Bundle bundle = getArguments();
            flowTabId = bundle.getString("flowTabId");
            loadItemDetailData();
            KLog.i("test","Fragment可见状态");
            //数据加载完毕,恢复标记,防止重复加载
            isViewCreated = false;
            isUIVisible = false;

        }
//        KLog.i("test","Fragment不可见状态");
    }








    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         contextView = LayoutInflater.from(getActivity()).inflate(R.layout.home_fragment_item, null);
//        mPagerForScrollView.setObjectForPosition(contextView,position);//0代表tab的位置 0,1,2,3
        KLog.i("test","fragment切换的是"+position);
        return contextView;
    }

    private void initData() {
//        loadItemDetailData();
        homeTablbeItemAdapter.setOnLoadMoreListener(() -> {
            pageNum++;
            loadItemDetailData();
        },rlItemRecyclerView);
//        loadItemDetailData();
    }

    public void loadItemDetailData() {


        ItemDetailEntity request = new ItemDetailEntity();
        request.setFlowTabId(TypeUtils.toString(flowTabId));
        request.setPageNum(pageNum);
        request.setPageSize(pageSize);
        request.getKeyMap().put("flowTabId",flowTabId);
        request.getKeyMap().put("pageNum",pageNum);
        request.getKeyMap().put("pageSize",pageSize);
        request.setKeyMap(request.getKeyMap());
        request.sign();


        getItemDetail(request, new ResponseListener<TableDetailEntity>() {
            @Override
            public void loadSuccess(TableDetailEntity data) {
                homeTablbeItemAdapter.loadMoreEnd();
                homeTablbeItemAdapter.loadMoreComplete();
                if(data.getData() != null && data.getData().size() >0){
                    if(pageNum ==1){
                        KLog.i("test","加载数据:"+"page"+pageSize+"pageNume"+pageNum);
                        List<TableDetailEntity.DataBean> dataBeanList = data.getData();
                        homeTablbeItemAdapter.setNewData(dataBeanList);
                        homeTablbeItemAdapter.notifyDataSetChanged();
                    }else{
                        homeTablbeItemAdapter.addData(data.getData());
                        homeTablbeItemAdapter.notifyDataSetChanged();
                    }


                }else{

                    homeTablbeItemAdapter.setEnableLoadMore(false);
                }


            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                homeTablbeItemAdapter.loadMoreFail();
                homeTablbeItemAdapter.loadMoreEnd();
            }

            @Override
            public void addDisposable(Disposable disposable) {


            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void initReclyView() {
        rlItemRecyclerView = contextView.findViewById(R.id.rl_item_recyclerView);
        homeTablbeItemAdapter = new HomeTablbeItemAdapter(getActivity());
        rlItemRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        rlItemRecyclerView.setNestedScrollingEnabled(false);
        rlItemRecyclerView.setAdapter(homeTablbeItemAdapter);
        homeTablbeItemAdapter.setEnableLoadMore(true);
        // 当列表滑动到倒数第N个Item的时候(默认是1)回调onLoadMoreRequested方法
//        homeTablbeItemAdapter.setPreLoadNumber(3);
        homeTablbeItemAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                pageNum++;
                loadItemDetailData();
            }
        }, rlItemRecyclerView);

        homeTablbeItemAdapter.setOnItemClickListener((adapter, view, position) -> {
            TableDetailEntity.DataBean     adapterItem = (TableDetailEntity.DataBean) adapter.getItem(position);

            //判断是否是专题产品 //类型 1:代表专题，2：商品
            if(adapterItem.getDetailType() ==1){
                KLog.i("test","itemId------"+"~~~"+adapterItem.getItemId());
                //代表专题
                ToastUtil.Short("跳转专题产品");

                ARouter.getInstance()
                        .build(RouterPath.Home.ROUTE_HOME_GROUP)
                        .withString("albumId",TypeUtils.toString(adapterItem.getItemId()))
                        .navigation(getActivity());
            }else{
                ARouter.getInstance()
                        .build(RouterPath.Item.ROUTE_ITEM_PRODUCTS_PATH)
                        .withString("itemId",TypeUtils.toString(adapterItem.getItemId()))
                        .navigation(getActivity());

            }


        });
    }


    /**
     * 获取商品详情数据
     * @param request
     * @param listener
     */
    public void getItemDetail(ItemDetailEntity request, ResponseListener<TableDetailEntity> listener){
        RetrofitManager
                .create(HomeApiServer.class)
                .getHomeFlowTabDetail(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<TableDetailEntity>() {
                    @Override
                    public void onSuccess(TableDetailEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }





}
