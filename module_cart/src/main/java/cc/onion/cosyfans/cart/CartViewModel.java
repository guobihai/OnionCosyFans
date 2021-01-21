package cc.onion.cosyfans.cart;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.cart.api.CartApi;
import cc.onion.cosyfans.cart.entity.CartRequest;
import cc.onion.cosyfans.cart.entity.response.ItemEntity;
import cc.onion.cosyfans.cart.entity.response.CartListEntity;
import cc.onion.cosyfans.cart.listener.CartViewListener;

/**
 * 购物车
 * @author guobihai
 * @email:guobihai@163.com
 *
 */
public class CartViewModel extends AndroidViewModel {

    public final ObservableBoolean isShowBaseView = new ObservableBoolean(false);

    /**
     * 总价格
     */
    public final ObservableField<String> totalMonery = new ObservableField<>();

    /**
     * 优惠折扣
     */
    public final ObservableField<String> disMonery = new ObservableField<>();
    /**
     * 是否显示折扣
     */
    public final ObservableBoolean isShowDisMonery = new ObservableBoolean(true);


    CartViewListener  cartViewListener;
    public CartViewModel(@NonNull Application application) {
        super(application);
        totalMonery.set("RM");
        disMonery.set("已优惠：");
        totalMonery.set("总价：0.00");
        disMonery.set("已优惠￥0.00");
    }



    /**
     * 请求购物车数据
     * @param request
     * @param listener
     */
    public void getCartList(CartRequest request, ResponseListener<CartListEntity> listener){
        RetrofitManager
                .createToken(CartApi.class)
                .getCartList(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<CartListEntity>() {
                    @Override
                    public void onSuccess(CartListEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }


    /**
     * 获取推荐产品
     * @param request
     * @param listener
     */
    public void getRecommendItem(BaseRequestBean request, ResponseListener<ItemEntity> listener){
        RetrofitManager
                .create(CartApi.class)
                .getRecommendItem(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<ItemEntity>() {
                    @Override
                    public void onSuccess(ItemEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }


    /**
     * 选择全部item
     */
    public void selectAllItem(){
        cartViewListener.selectAllItem();

    }


    /**
     * 结算
     */
    public void checkItemCalculation(){
        cartViewListener.checkItemCalculation();
    }


    /**
     * 编辑
     */
    public void editItem(){
        cartViewListener.editItem();
    }

    public CartViewListener getCartViewListener() {
        return cartViewListener;
    }

    public void setCartViewListener(CartViewListener cartViewListener) {
        this.cartViewListener = cartViewListener;
    }
}
