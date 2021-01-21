package cc.onion.cosyfans.module_order;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.module_order.api.OrderApi;
import cc.onion.cosyfans.module_order.entity.OrderAfterEntity;
import cc.onion.cosyfans.module_order.entity.request.AfterRequest;
import cc.onion.cosyfans.module_trade.api.TradeApi;
import cc.onion.cosyfans.module_trade.entity.CashCouponEntity;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_order
 * @ClassName: AfterSaleViewModel
 * @Description: 售后
 * @Author: guobihai
 * @CreateDate: 2019-12-27 15:00
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-27 15:00
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AfterSaleViewModel extends AndroidViewModel {

    public AfterSaleViewModel(@NonNull Application application) {
        super(application);
    }


    /**
     * 获取售后界面数据
     * @param requestBean
     * @param listener
     */
    public void getApplyPage(AfterRequest requestBean, ResponseListener<OrderAfterEntity> listener){
        RetrofitManager
                .createToken(OrderApi.class)
                .getApplyPage(requestBean)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<OrderAfterEntity>() {
                    @Override
                    public void onSuccess(OrderAfterEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }


}
