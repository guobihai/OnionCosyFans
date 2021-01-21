package cc.onion.cosyfans.my.viewdModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.utils.JsonUtils;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.my.api.MyApi;
import cc.onion.cosyfans.my.entity.OrderInComeEntry;
import cc.onion.cosyfans.my.entity.OrderListEntity;
import cc.onion.cosyfans.my.entity.request.OrderHistoryRequest;
import cc.onion.cosyfans.my.entity.request.OrderInComeRequest;
import cc.onion.cosyfans.my.entity.request.OrderRequest;

/**
 * 商家中心-销售订单
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.viewdModel
 * @ClassName: MySaleOrderViewModel
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/13 14:51
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/13 14:51
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MySaleOrderViewModel extends AndroidViewModel {

    //搜索输入内容
    public final ObservableField<String> searchText = new ObservableField<>();
    //搜索订单状态
    public final ObservableField<String> orderStatus = new ObservableField<>("");

    /**
     * 是否展示删除按钮
     */
    public final ObservableBoolean showDelete = new ObservableBoolean(false);


    public MySaleOrderViewModel(@NonNull Application application) {
        super(application);
    }

    public void deleteSearchWord() {
        searchText.set("");
    }

    /**
     * 开始搜索
     */
    public void toSearch() {

    }

    /**
     * 加载订单信息
     *
     * @param request
     * @param listener
     */
    public void loadHisOrderListInfo(OrderHistoryRequest request, ResponseListener<OrderListEntity.DataBean> listener) {
        if (null == request) {
            throw new NullPointerException("request is not null");
        }
        RetrofitManager.createToken(MyApi.class)
                .queryHistoryListOrdersInfo(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<OrderListEntity>() {
                    @Override
                    public void onSuccess(OrderListEntity data) {
                        if (null != data) {
                            if (data.getStatus() == 200) {
                                if (null != listener)
                                    listener.loadSuccess(data.getData());
                            } else {
                                if (null != listener)
                                    listener.loadFailed(String.valueOf(data.getStatus()), data.getMsg());
                            }
                        } else {
                            if (null != listener)
                                listener.loadFailed("-1", "data is null");
                        }

                    }

                    @Override
                    public void onError(String code, String msg) {
                        super.onError(code, msg);
                        if (null != listener)
                            listener.loadFailed(code, msg);
                    }
                });
    }


    /**
     * 订单列表，查看我的收益
     *
     * @param orderNo  订单号
     * @param listener
     */
    public void loadOrderInComeInfo(String orderNo, ResponseListener<OrderInComeEntry.DataBean> listener) {
        OrderInComeRequest orderRequest = new OrderInComeRequest();
        orderRequest.setOrderNo(orderNo);
        orderRequest.putKeySign("orderNo", orderNo);
        orderRequest.sign();
        RetrofitManager.createToken(MyApi.class)
                .queryOrderInComeInfo(orderRequest)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<OrderInComeEntry>() {
                    @Override
                    public void onSuccess(OrderInComeEntry data) {
                        KLog.i("====OrderInComeEntry====="+JsonUtils.toJson(data));
                        if (null != data) {
                            if (data.getStatus() == 200) {
                                if (null != listener)
                                    listener.loadSuccess(data.getData());
                            } else {
                                if (null != listener)
                                    listener.loadFailed(String.valueOf(data
                                            .getStatus()), data.getMsg());
                            }
                        } else {
                            if (null != listener)
                                listener.loadFailed("-1", "load data is null ");
                        }
                    }

                    @Override
                    public void onError(String code, String msg) {
                        super.onError(code, msg);
                        if (null != listener)
                            listener.loadFailed(code, msg);
                    }
                });
    }


}
