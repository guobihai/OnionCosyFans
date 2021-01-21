package cc.onion.cosyfans.my;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;

import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.my.api.MyApi;
import cc.onion.cosyfans.my.entity.AddressListEntity;
import cc.onion.cosyfans.my.entity.MineEntity;
import cc.onion.cosyfans.my.entity.request.AddressRequest;

/**
 * 个人中心
 * @author guobihai
 * @date 2019-11-08
 */
public class PerssonalCenterViewModel extends AndroidViewModel {

    public final ObservableField<String> userName = new ObservableField<String>();
    public final ObservableField<String> couponCount = new ObservableField<String>();
    public final ObservableField<String> lanageType = new ObservableField<String>();

    public final ObservableField<String> unpaid = new ObservableField<String>("0");
    public final ObservableField<String> delivering = new ObservableField<String>("0");
    public final ObservableField<String> afterSale = new ObservableField<String>("0");
    public final ObservableField<MineEntity.DataBean> dataBeanObservableField = new ObservableField<MineEntity.DataBean>();


    public PerssonalCenterViewModel(@NonNull Application application) {
        super(application);
    }


    public void toSetting(){
        ARouter.getInstance().build(RouterPath.MyCosy.ROUTE_MIME_SETTING)
                .greenChannel()
                .navigation();
    }



    public void toAddressList(){

        ARouter.getInstance().build(RouterPath.MyCosy.ROUTE_MIME_ADDRESS_LIST)
                .greenChannel()
                .navigation();
    }


    public void toOrder(){
        //订单
        ARouter.getInstance().build(RouterPath.Order.ROUTE_ORDER_MAIN)
                .greenChannel()
                .navigation();
    }


    /**
     * 获取用户界面数据
     * @param request
     * @param listener
     */
    public void getUserCenter(BaseRequestBean request, ResponseListener<MineEntity> listener){
        RetrofitManager
                .createToken(MyApi.class)
                .getUserCenter(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<MineEntity>() {
                    @Override
                    public void onSuccess(MineEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }




    public void toUnpaid(){
        //订单
        ARouter.getInstance().build(RouterPath.Order.ROUTE_ORDER_MAIN)
                .greenChannel()
                .withInt("orderType",0)
                .navigation();
    }


    public void delivering(){
        //订单
        ARouter.getInstance().build(RouterPath.Order.ROUTE_ORDER_MAIN)
                .greenChannel()
                .withInt("orderType",1)
                .navigation();
    }

    public void afterSale(){
        //订单
        ARouter.getInstance().build(RouterPath.Order.ROUTE_ORDER_MAIN)
                .greenChannel()
                .withInt("orderType",2)
                .navigation();
    }


    public void tohelper(){
        //用户帮助中心
        ARouter.getInstance().build(RouterPath.MyCosy.ROUTE_MIME_USER_HELP)
                .greenChannel()
                .navigation();
    }


}
