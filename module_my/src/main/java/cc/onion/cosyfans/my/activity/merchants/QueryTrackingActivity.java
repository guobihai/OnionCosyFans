package cc.onion.cosyfans.my.activity.merchants;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.base.BaseToolBarActivity;
import cc.onion.cosyfans.base.dialog.LoadingDialog;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.SystemUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.view.loadView.ULoadView;
import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.module_my.databinding.MyQueryTrackingActivityBinding;
import cc.onion.cosyfans.my.adapter.TrackingOrderListInfoAdapt;
import cc.onion.cosyfans.my.dialogs.NoTrackingDetialDialog;
import cc.onion.cosyfans.my.dialogs.TrackingDetialDialog;
import cc.onion.cosyfans.my.entity.TrackingDetailEntry;
import cc.onion.cosyfans.my.entity.TrackingInfoEntry;
import cc.onion.cosyfans.my.interfaces.ItemOnClickInterface;
import cc.onion.cosyfans.my.viewdModel.QueryTrackingViewModel;
import io.reactivex.disposables.Disposable;

/**
 * 商家中心-查看物流
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.activity.merchants
 * @ClassName: QueryTrackingActivity
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/16 10:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/16 10:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = RouterPath.MyCosy.ROUTE_MIME_MERCHANT_TRACKING)
public class QueryTrackingActivity extends BaseToolBarActivity<MyQueryTrackingActivityBinding, QueryTrackingViewModel> {

    private List<TrackingInfoEntry.DataBean> mList;
    private ULoadView uLoadView;
    private LoadingDialog loadingDialog;

    private TrackingOrderListInfoAdapt mTrackingOrderListInfoAdapt;

    @Autowired
    public String orderNo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_query_tracking_activity);
        setToolbarTitle(getString(R.string.my_order_traking));
        mBinding.setViewModel(mViewModel);
        if (SystemUtils.v21()) {
            mAppBarLayout.setElevation(0);
            mToolBar.setElevation(0);
        }
    }

    @Override
    public void initParam() {
        super.initParam();
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initData() {
        super.initData();
        mList = new ArrayList<>();
        uLoadView = new ULoadView(mBinding.smartRefreshLayout);
        uLoadView.showLoading();
        loadingDialog = new LoadingDialog(this);

        mBinding.queryRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mTrackingOrderListInfoAdapt = new TrackingOrderListInfoAdapt(mList);
        mTrackingOrderListInfoAdapt.setEmptyView(R.layout.my_item_emptry_data_layout, mBinding.queryRecycleView);
        mBinding.queryRecycleView.setAdapter(mTrackingOrderListInfoAdapt);
        KLog.i("=======rev====orderNo=====" + orderNo);
        mViewModel.orderNo.set(orderNo);
        loadTrackingListInfo();
        mTrackingOrderListInfoAdapt.setOnClickInterface(new ItemOnClickInterface<String>() {
            @Override
            public void onClick(View view, String data, int type) {
                loadTrackingDetialInfo(data);
            }

            @Override
            public void onLongClick(View view, String data, int type) {

            }
        });
    }

    //加载数据
    private void loadTrackingListInfo() {
        mViewModel.queryTrackingListInfo(new ResponseListener<TrackingInfoEntry>() {
            @Override
            public void loadSuccess(TrackingInfoEntry data) {
                uLoadView.hide();
                if (null != data.getData()) {
                    mTrackingOrderListInfoAdapt.setNewData(data.getData());
                }
            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                ToastUtil.Short(errorMsg);
                uLoadView.hide();
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }

    private void loadTrackingDetialInfo(String orderNo){
        loadingDialog.show();
        mViewModel.queryTrackingDetailInfo(orderNo, new ResponseListener<TrackingDetailEntry.DataBean>() {
            @Override
            public void loadSuccess(TrackingDetailEntry.DataBean data) {
                loadingDialog.dismiss();
                if(null !=data){
                    new TrackingDetialDialog(QueryTrackingActivity.this,data).show();
                }else{
                    new NoTrackingDetialDialog(QueryTrackingActivity.this).show();
                }
            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                ToastUtil.Short(errorMsg);
                loadingDialog.dismiss();
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }
}
