package cc.onion.cosyfans.item.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;

import org.apache.commons.lang3.StringUtils;

import cc.onion.cosyfans.base.account.AccountManager;
import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.item.api.ItemApi;
import cc.onion.cosyfans.item.dialog.DiscountDilalog;
import cc.onion.cosyfans.item.entity.ItemDetailRequest;
import cc.onion.cosyfans.item.entity.response.ItemDetailEntity;
import cc.onion.cosyfans.item.listener.ProductItemViewListener;

/**
 * @author guobihai
 * @date 2019 -11- 08
 */
public class DetailAndroidViewModel extends AndroidViewModel {

    ProductItemViewListener viewListener;

    public ObservableField<String> itemPrice1 = new ObservableField<>();
    public ObservableField<String> itemPrice2 = new ObservableField<>();
    public ObservableField<String> itemPrice3 = new ObservableField<>();
    //商品标题
    public ObservableField<String> produtctTitle = new ObservableField<>();
    //物流时效
    public ObservableField<String> deliverytime = new ObservableField<>();
    //促销
    public ObservableField<String> promotion = new ObservableField<>();
    //领劵
    public ObservableField<String> vouchers = new ObservableField<>();
    //关于
    public ObservableField<String> cosyAbout = new ObservableField<>();
    //内容
    public ObservableField<String> context = new ObservableField<>();
    //是否展示销售数据
    public ObservableBoolean isShowWSale = new ObservableBoolean(false);

    //购物车产品数量
    public ObservableField<String> cartAmount = new ObservableField<>();


    public ProductItemViewListener getViewListener() {
        return viewListener;
    }

    public void setViewListener(ProductItemViewListener viewListener) {
        this.viewListener = viewListener;
    }

    public DetailAndroidViewModel(@NonNull Application application) {
        super(application);
        isShowWSale.set(false);
    }


    /**
     * 获取商品详情信息
     * @param request
     * @param listener
     */
    public void getItemDetail(ItemDetailRequest request, ResponseListener<ItemDetailEntity> listener){
        if(StringUtils.isNoneEmpty(AccountManager.getToken())){
            RetrofitManager
                    .createToken(ItemApi.class)
                    .getItemDetail(request)
                    .compose(RxUtils.schedulersTransformer())
                    .subscribe(new ResponseObserver<ItemDetailEntity>() {
                        @Override
                        public void onSuccess(ItemDetailEntity data) {
                            listener.loadSuccess(data);

                        }

                        @Override
                        public void onError(String code, String msg) {
                            listener.loadFailed(code, msg);
                        }
                    });
        }else{
            RetrofitManager
                    .create(ItemApi.class)
                    .getItemDetail(request)
                    .compose(RxUtils.schedulersTransformer())
                    .subscribe(new ResponseObserver<ItemDetailEntity>() {
                        @Override
                        public void onSuccess(ItemDetailEntity data) {
                            listener.loadSuccess(data);

                        }

                        @Override
                        public void onError(String code, String msg) {
                            listener.loadFailed(code, msg);
                        }
                    });
        }

    }


    /**
     * 获取购物车产品数量
     * @param request
     * @param listener
     */
    public void getCatAmount(BaseRequestBean request, ResponseListener<BaseResponse> listener){
        RetrofitManager
                .create(ItemApi.class)
                .getCatAmount(request)
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




    //促销
  public  void onPromotionClick(){

        viewListener.onPromotionClick();

  }

    //领卷
   public void onVouchersClick(){
       viewListener.onVouchersClick();
   }

    //前往主页
    public void toHomeClick(){
        viewListener.toHomeClick();
    }


    //前往购物车
     public void toCartClick(){
         viewListener.toCartClick();
//         ARouter.getInstance().build(RouterPath.Passport.ROUTE_PASSPORT_SIGNIN)
//                 .greenChannel()
//                 .navigation();
//         if(AccountManager.getIsLogin() !=null ){
//             // 购物车
//             viewListener.toCartClick();
//         }else{
//
//         }
//       ;
     }

    //销售
    public void SaleingClick(){
        viewListener.SaleingClick();
//        ARouter.getInstance().build(RouterPath.Passport.ROUTE_PASSPORT_SIGNIN)
//                .greenChannel()
//                .navigation();

//        if(AccountManager.getIsLogin() !=null ){
//            // 购物车
//
//        }else{
//            A
//        }
//        ;
    }

    //加入购物车

   public void toAddCart(){
       viewListener.toAddCart();
//       ARouter.getInstance().build(RouterPath.Passport.ROUTE_PASSPORT_SIGNIN)
//               .greenChannel()
//               .navigation();
//       if(AccountManager.getIsLogin() !=null ){
//           // 购物车
//
//       }else{
//
//       }
//       ;

   }


}
