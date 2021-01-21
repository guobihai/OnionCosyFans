package cc.onion.cosyfans.module_order.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jakewharton.rxbinding2.view.RxView;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import cc.onion.cosyfans.base.dialog.DeleteOrConfirmCheckDialog;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.base.utils.TextMeoneryShowUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.cart.entity.response.CartListEntity;
import cc.onion.cosyfans.module_order.OrderState;
import cc.onion.cosyfans.module_order.R;
import cc.onion.cosyfans.module_order.api.OrderApi;
import cc.onion.cosyfans.module_order.entity.ConfimOrderEntity;
import cc.onion.cosyfans.module_order.entity.OrderListEntity;
import cc.onion.cosyfans.module_order.entity.request.ConfimRequest;
import cc.onion.cosyfans.module_order.listener.OrderListeViewListener;
import cc.onion.cosyfans.module_trade.dialog.PlayListDialog;
import cc.onion.cosyfans.module_trade.entity.PlayListEntity;
import cc.onion.cosyfans.module_trade.listener.PlayOnClickListener;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_order.adapter
 * @ClassName: OrderListFatherAdapter
 * @Description: 订单列表适配器
 * @Author: guobihai
 * @CreateDate: 2019-12-16 16:33
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-16 16:33
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderListFatherAdapter extends BaseQuickAdapter<OrderListEntity.DataBean, BaseViewHolder> implements PlayOnClickListener{

    private Context mContext;
    PlayOnClickListener listener;
    String orderNumber;
    OrderListeViewListener mOrderListener;

    public OrderListFatherAdapter(@Nullable List<OrderListEntity.DataBean> dat, Context context, PlayOnClickListener listener,OrderListeViewListener listeViewListener) {
        super(R.layout.order_item_products);
        this.mContext = context;
        this.listener =listener;
        this.mOrderListener = listeViewListener;
    }

    @SuppressLint("CheckResult")
    @Override
    protected void convert(BaseViewHolder helper, OrderListEntity.DataBean item) {
        helper.setText(R.id.tv_order_number, item.getOrderNo());
        helper.setText(R.id.tv_order_state, item.getOrderStatus());
        TextView totalMOnery = helper.getView(R.id.tv_order_total_monery);
        TextMeoneryShowUtils.setShowBigMonery(totalMOnery, item.getOrderTotalFee());

        //item
        if (item.getOrderItemList() != null && item.getOrderItemList().size() > 0) {
            OrderListChildenAdapter childenAdapter = new OrderListChildenAdapter(item.getOrderItemList(), mContext);
            RecyclerView chuldenRecyclerView = helper.getView(R.id.lv_childen_revyclerview);
            chuldenRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, 1, false));
            chuldenRecyclerView.setAdapter(childenAdapter);
        }

        helper.getView(R.id.layout_fater_body).setOnClickListener(v -> {
            ARouter.getInstance().build(RouterPath.Order.ROUTE_ORDER_DETAIL)
                    .withString("orderNo", item.getOrderNo())
                    .greenChannel()
                    .navigation();
        });

        //业务操作布局，根据业务变化
        LinearLayout layoutBase = helper.getView(R.id.layout_include);
        layoutBase.setVisibility(View.GONE);
        if (item.getOrderStatusCode() == OrderState.ORDER_ONE) {
            //待支付
            layoutBase.setVisibility(View.VISIBLE);
            helper.getView(R.id.tv_cancale).setOnClickListener(v -> {
                //取消订单
                RxView.clicks(helper.getView(R.id.tv_cancale))
                        .throttleFirst(1, TimeUnit.SECONDS)
                        .subscribe(new Consumer<Object>() {
                            @Override
                            public void accept(Object o) throws Exception {
                                //取消订单
                                DeleteOrConfirmCheckDialog dialog = new DeleteOrConfirmCheckDialog(mContext, mContext.getString(R.string.order_cancle_order),
                                        mContext.getString(R.string.order_concle_ordr_config));
                                dialog.show();
                                dialog.setDialogClickListener(new DeleteOrConfirmCheckDialog.AlertDialogClickListener() {
                                    @Override
                                    public void onCancel() {
                                        dialog.dismiss();

                                    }

                                    @Override
                                    public void onOk() {
                                        //取消订单
                                        cancleOrder(item.getOrderNo());
                                        dialog.dismiss();
                                    }
                                });
                            }
                        });

            });



            //订单号设置值
            this.orderNumber = item.getOrderNo();

            //唤起支付
            helper.getView(R.id.tv_play).setOnClickListener(v -> {

                RxView.clicks(helper.getView(R.id.tv_play))
                        .throttleFirst(1, TimeUnit.SECONDS)
                        .subscribe(new Consumer<Object>() {
                            @Override
                            public void accept(Object o) throws Exception {

                                if(StringUtils.isNotEmpty(item.getOrderNo())){

                                    PlayListDialog playListDialog = new PlayListDialog(mContext,orderNumber,OrderListFatherAdapter.this);
                                    playListDialog.show();

                                }
                            }
                        });


            });

        } else if (item.getOrderStatusCode() == OrderState.ORDER_TWO) {
            //处理运输中流程


        } else if (item.getOrderStatusCode() == OrderState.ORDER_THREE) {
            //已完成

        } else if (item.getOrderStatusCode() == OrderState.ORDER_FOUR) {
            //已取消

        } else if (item.getOrderStatusCode() == OrderState.ORDER_FIVE) {
            //支付超时

        } else if (item.getOrderStatusCode() == OrderState.ORDER_SEVENT) {
            //售后中

        } else {

        }


    }

    /**
     * 取消订单
     * @param orderNo
     */
    private void cancleOrder(String orderNo) {
        ConfimRequest request = new ConfimRequest();
        request.setOrderNo(orderNo);
        request.getKeyMap().put("orderNo", orderNo);
        request.setRequestSign(request.getKeyMap());

        cancelOrder(request, new ResponseListener<BaseResponse>() {
            @Override
            public void loadSuccess(BaseResponse data) {
                if (data.getStatus().equals("200")) {
                    mOrderListener.refeshView();
                } else {
                    ToastUtil.Short(data.getMsg());
                }

            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                KLog.i("test", "取消订单失败");
            }

            @Override
            public void addDisposable(Disposable disposable) {
            }
        });
    }


    /**
     * 取消订单
     * @param request
     * @param listener
     */
    public void cancelOrder(ConfimRequest request,ResponseListener<BaseResponse> listener){
        RetrofitManager
                .createToken(OrderApi.class)
                .cancelOrder(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<BaseResponse>() {
                    @Override
                    public void onSuccess(BaseResponse data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }



    @Override
    public void toPlayResule(PlayListEntity.DataBean item, String orderNo) {
        this.listener.toPlayResule(item,orderNumber);
    }
}

