package cc.onion.cosyfans.home.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import org.apache.commons.lang3.StringUtils;

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
import cc.onion.cosyfans.home.adapter.GrouptemAdapter;
import cc.onion.cosyfans.home.adapter.HomeTablbeItemAdapter;
import cc.onion.cosyfans.home.api.HomeApiServer;
import cc.onion.cosyfans.home.entity.ItemDetailEntity;
import cc.onion.cosyfans.home.entity.response.GroupItemEntity;
import cc.onion.cosyfans.home.entity.response.GroupListRequest;
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
public class GroupDetailFragment extends Fragment {

    View contextView;
    String flowTabId;
    RecyclerView rlItemRecyclerView;
    GrouptemAdapter homeTablbeItemAdapter;
    ViewPagerForScrollView mPagerForScrollView;
    int position = 0;

    private int pageNum = 1;
    private int pageSize = 10;



    @SuppressLint("ValidFragment")
    public GroupDetailFragment(ViewPagerForScrollView pagerForScrollView, int i) {
        this.mPagerForScrollView = pagerForScrollView;
        int position = i;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         contextView = LayoutInflater.from(getActivity()).inflate(R.layout.home_fragment_item, null);
        mPagerForScrollView.setObjectForPosition(contextView,position);//0代表tab的位置 0,1,2,3
        KLog.i("test","fragment切换的是"+position);
        return contextView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        flowTabId = bundle.getString("flowTabId");
        initReclyView();
        initData();

    }

    private void initData() {
        if(StringUtils.isNotEmpty(flowTabId)){
            loadItemDetailData();
        }

    }

    private void loadItemDetailData() {

        GroupListRequest request = new GroupListRequest();
        request.setAlbumTabId(flowTabId);
        request.setPageNum(pageNum);
        request.setPageSize(pageSize);
        request.getKeyMap().put("albumId",flowTabId);
        request.getKeyMap().put("pageNum",pageNum);
        request.getKeyMap().put("pageSize",pageSize);
        request.setRequestSign(request.getKeyMap());
        getGroupItem(request, new ResponseListener<GroupItemEntity>() {
            @Override
            public void loadSuccess(GroupItemEntity data) {
                if(data.getData() != null && data.getData().getData().size() >0){
                    KLog.i("test","加载数据:"+"page"+pageSize+"pageNume"+pageNum);
                    homeTablbeItemAdapter.setNewData(data.getData().getData());
                    homeTablbeItemAdapter.notifyDataSetChanged();
                    homeTablbeItemAdapter.loadMoreComplete();
                    homeTablbeItemAdapter.loadMoreEnd();
                }
            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                homeTablbeItemAdapter.loadMoreFail();
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addDisposable(disposable);
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
        homeTablbeItemAdapter = new GrouptemAdapter(getActivity());
        rlItemRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        rlItemRecyclerView.setNestedScrollingEnabled(false);
        rlItemRecyclerView.setAdapter(homeTablbeItemAdapter);
        homeTablbeItemAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        homeTablbeItemAdapter.setEnableLoadMore(true);
        // 当列表滑动到倒数第N个Item的时候(默认是1)回调onLoadMoreRequested方法
        homeTablbeItemAdapter.setPreLoadNumber(5);
        homeTablbeItemAdapter.setOnLoadMoreListener(() -> {
            pageNum++;
            loadItemDetailData();
        }, rlItemRecyclerView);

        homeTablbeItemAdapter.setOnItemClickListener((adapter, view, position) -> {
            GroupItemEntity.DataBeanX.DataBean     adapterItem = (GroupItemEntity.DataBeanX.DataBean) adapter.getItem(position);

            if(StringUtils.isNotEmpty(adapterItem.getId()))
                //跳转商品详情
            ARouter.getInstance()
                    .build(RouterPath.Item.ROUTE_ITEM_PRODUCTS_PATH)
                    .withString("itemId",TypeUtils.toString(adapterItem.getItemId()))
                    .navigation(getActivity());


        });
    }




    /**
     * 获取专辑列表数据
     * @param request
     * @param listener
     */
    public void getGroupItem(GroupListRequest request, ResponseListener<GroupItemEntity> listener){
        RetrofitManager
                .create(HomeApiServer.class)
                .getGroupItem(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<GroupItemEntity>() {
                    @Override
                    public void onSuccess(GroupItemEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }



}
