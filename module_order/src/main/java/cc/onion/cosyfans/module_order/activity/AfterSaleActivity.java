package cc.onion.cosyfans.module_order.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import org.apache.commons.lang3.StringUtils;

import cc.onion.cosyfans.base.BaseToolBarActivity;
import cc.onion.cosyfans.base.exception.ExceptionCode;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.view.loadView.ULoadView;
import cc.onion.cosyfans.module_order.AfterSaleViewModel;
import cc.onion.cosyfans.module_order.R;
import cc.onion.cosyfans.module_order.adapter.AfterListAdapter;
import cc.onion.cosyfans.module_order.databinding.OrderAfterSaleBinding;
import cc.onion.cosyfans.module_order.entity.OrderAfterEntity;
import cc.onion.cosyfans.module_order.entity.request.AfterRequest;
import io.reactivex.disposables.Disposable;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_order.activity
 * @ClassName: AfterSaleActivity
 * @Description:售后
 * @Author: guobihai
 * @CreateDate: 2019-12-27 14:57
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-27 14:57
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = RouterPath.Order.ROUTE_ORDER_DETAIL_AFTER_SALSE)
public class AfterSaleActivity extends BaseToolBarActivity<OrderAfterSaleBinding, AfterSaleViewModel> {



    @Autowired
    String orderNo;

    /**
     * 订单商品项ID集合，多个以,隔开
     */
    @Autowired
    String orderItemIds;

    /**
     * 时间差（0:整单售后，1：单个售后）
     */
    @Autowired
    String timeDifference;

    AfterListAdapter afterListAdapter;

    private ULoadView loadVew;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_after_sale);
        mBinding.setModel(mViewModel);
        setToolbarTitle(R.string.order_after_Sale);
    }

    @Override
    public void initParam() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initData() {
        super.initData();
        initLayout();
        if(StringUtils.isNotEmpty(orderNo)){
            loadData();
        }

    }

    private void initLayout() {
        loadVew = new ULoadView(mBinding.body);
        loadVew.showLoading();
        mBinding.layoutView1.setVisibility(View.GONE);
        mBinding.layoutView2.setVisibility(View.GONE);
        afterListAdapter = new AfterListAdapter(null,this);
        mBinding.rlItem.setLayoutManager(new LinearLayoutManager(this,1,false));
        mBinding.rlItem.setAdapter(afterListAdapter);
    }

    /**
     *加载数据
     */
    private void loadData() {
        AfterRequest request = new AfterRequest();
        request.setOrderNo(orderNo);
        request.setTimeDifference(timeDifference);

        if(StringUtils.isNotEmpty(orderItemIds)){
            request.setOrderItemIds(orderItemIds);
            request.getKeyMap().put("orderItemIds",orderItemIds);
        }
        request.getKeyMap().put("orderNo",orderNo);
        request.getKeyMap().put("timeDifference",timeDifference);
        request.setRequestSign(request.getKeyMap());

        mViewModel.getApplyPage(request, new ResponseListener<OrderAfterEntity>() {
            @Override
            public void loadSuccess(OrderAfterEntity data) {
                  loadVew.hide();
                if(data.getData() != null){
                    if(data.getData().getItems() != null && data.getData().getItems().size() >0){
                        afterListAdapter.setNewData(data.getData().getItems());
                        afterListAdapter.notifyDataSetChanged();
                    }

                    //layout控制显示
                    try {
                        setAfterLayout(data);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                loadVew.hide();
                if (ExceptionCode.NO_NERWORK_ERROR.equals(errorCode)) {
                    loadVew.showNetworkError(v -> {
                        // 无网络
                        loadVew.showLoading();
                        loadData();
                    });
                } else {
                    loadVew.showError("数据加载失败：" + errorMsg, v -> {
                        loadVew.showLoading();
                        loadData();
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
     * 设置订单处理类型
     * @param data
     */
    private void setAfterLayout(OrderAfterEntity data) {
        if(data.getData().getRefundTypes() != null && data.getData().getRefundTypes().size() >0){
            //当前显示的业务逻辑一
            if(data.getData().getRefundTypes().get(0) != null){
                mBinding.layoutView1.setVisibility(View.VISIBLE);
                if(StringUtils.isNotEmpty(data.getData().getRefundTypes().get(0).getName())){
                    mBinding.tvTitle1.setText(data.getData().getRefundTypes().get(0).getName());
                    mBinding.layoutView1.setOnClickListener(v -> {
                        toActivity();
                    });
                }



            }
            if(data.getData().getRefundTypes().size() >1){
                //当前显示的业务逻辑二
                if(data.getData().getRefundTypes().get(1) != null){
                    mBinding.layoutView2.setVisibility(View.VISIBLE);
                    if(StringUtils.isNotEmpty(data.getData().getRefundTypes().get(1).getName())){
                        mBinding.tvTitle2.setText(data.getData().getRefundTypes().get(1).getName());
                        mBinding.layoutView1.setOnClickListener(v -> {
                            toActivity();
                        });
                    }

                }
            }

        }
    }

    /**
     *
     */
    public void toActivity(){
        ARouter.getInstance().build(RouterPath.Order.ROUTE_ORDER_DETAIL_AFTER_SALSE_PROCESS)
                .greenChannel()
                .navigation();
    }
}
