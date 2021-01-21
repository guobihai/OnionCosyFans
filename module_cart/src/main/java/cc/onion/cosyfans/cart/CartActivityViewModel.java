package cc.onion.cosyfans.cart;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.base.event.PageEvent;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.cart.api.CartApi;
import cc.onion.cosyfans.cart.entity.CartPomEntity;
import cc.onion.cosyfans.cart.entity.CartPomListRequest;
import cc.onion.cosyfans.cart.entity.PromotionRequest;
import cc.onion.cosyfans.cart.entity.response.PomptionListEntity;
import cc.onion.cosyfans.cart.listener.PopVIewListener;

/**
 * @author guobihai
 * @version V1.0
 * @Title: AppCommonInfo
 * @Package cc.onion.cosyfans.base.common
 * @date 2019-12-03 14:53
 * @email: anhui-zhuang@msyc.cc
 * @Description: (活动列表类)
 */
public class CartActivityViewModel extends AndroidViewModel {

    public final ObservableField<String> searchWord = new ObservableField<>();


    public final ObservableField<String> pormotion = new ObservableField<>();
    public final ObservableField<String> time = new ObservableField<>();

    //
    public final ObservableField<String> totalMonery = new ObservableField<>();
    public final ObservableField<String> disMonery = new ObservableField<>();
    //totla monery
    public final ObservableField<String> allMonery = new ObservableField<>();


    public final ObservableBoolean isShowBaseView = new ObservableBoolean(true);
    //搜索提示
    public final ObservableBoolean isShowDeleteView = new ObservableBoolean(false);


    PopVIewListener popVIewListener;


    
    public CartActivityViewModel(@NonNull Application application) {
        super(application);
    }

//    getPromotionList

    /**
     * 获取列表
     * @param request
     * @param listener
     */
    public void getPromotioninfo(PromotionRequest request, ResponseListener<BaseResponse<CartPomEntity>> listener){
        RetrofitManager
                .createToken(CartApi.class)
                .getPromotionInfo(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<BaseResponse<CartPomEntity>>() {
                    @Override
                    public void onSuccess(BaseResponse<CartPomEntity> data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }


    /**
     * 获取列表
     * @param request
     * @param listener
     */
    public void getPromotionList(CartPomListRequest request, ResponseListener<PomptionListEntity> listener){
        RetrofitManager
                .createToken(CartApi.class)
                .getPromotionList(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<PomptionListEntity>() {
                    @Override
                    public void onSuccess(PomptionListEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }

    /**
     * 关键字搜索
     */
    public void searchWord(){
        if(popVIewListener != null){
            popVIewListener.searchWord();
        }

    }


    public void deleteSearchWord(){
        if(popVIewListener != null ){
            popVIewListener.deleteSearchWord();
        }
    }
    /**
     * 前往购物车列表
     */
    public void goCartList(){
        if(popVIewListener != null){
            popVIewListener.close();
        }
    }


    public PopVIewListener getPopVIewListener() {
        return popVIewListener;
    }

    public void setPopVIewListener(PopVIewListener popVIewListener) {
        this.popVIewListener = popVIewListener;
    }
}
