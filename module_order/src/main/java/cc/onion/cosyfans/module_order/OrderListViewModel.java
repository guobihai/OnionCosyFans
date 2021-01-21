package cc.onion.cosyfans.module_order;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.database.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.module_order.api.OrderApi;
import cc.onion.cosyfans.module_order.entity.OderReturnListRequest;
import cc.onion.cosyfans.module_order.entity.OrderDetailEntity;
import cc.onion.cosyfans.module_order.entity.OrderListEntity;
import cc.onion.cosyfans.module_order.entity.OrderListRequest;
import cc.onion.cosyfans.module_order.entity.OrderRequest;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_order
 * @ClassName: OrderListViewModel
 * @Description: Order list
 * @Author: guobihai
 * @CreateDate: 2019-12-16 14:34
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-16 14:34
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderListViewModel extends AndroidViewModel {
    public final ObservableBoolean showList = new ObservableBoolean(false);
    /**
     * 搜素信息
     */
    public final ObservableField<String> searchText = new ObservableField<>();

    /**
     * 设置类型
     */
    String statusType;
    /**
     * 订单详情适配器
     */

    public OrderListViewModel(@NonNull Application application) {
        super(application);
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }


    /**
     * 获取订单详情界面内容
     * @param request
     * @param listener
     */
    public void getOrderList(OrderListRequest request , ResponseListener<OrderListEntity> listener){
        RetrofitManager
                .createToken(OrderApi.class)
                .getOrderList(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<OrderListEntity>() {
                    @Override
                    public void onSuccess(OrderListEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }


    /***
     * 获取售后订单列表
     * @param request
     * @param listener
     */
    public void getReturnOrderList(OderReturnListRequest request , ResponseListener<OrderListEntity> listener){
        RetrofitManager
                .createToken(OrderApi.class)
                .getRefundList(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<OrderListEntity>() {
                    @Override
                    public void onSuccess(OrderListEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }



}
