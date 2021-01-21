package cc.onion.cosyfans.home.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;


import com.alibaba.android.arouter.launcher.ARouter;

import cc.onion.cosyfans.base.entity.BaseListResponse;
import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.event.AppEvent;
import cc.onion.cosyfans.base.event.Event;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.EventBusUtil;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.home.api.HomeApiServer;
import cc.onion.cosyfans.home.entity.CashRequest;
import cc.onion.cosyfans.home.entity.CashRollEntity;
import cc.onion.cosyfans.home.entity.response.AdvertEntity;
import cc.onion.cosyfans.home.entity.ContextModelRequest;
import cc.onion.cosyfans.home.entity.HomeGetAllModelRequest;
import cc.onion.cosyfans.home.entity.response.HomeAllModel;
import cc.onion.cosyfans.home.entity.response.TableDetailEntity;
import cc.onion.cosyfans.home.entity.response.TableEntity;
import cc.onion.cosyfans.home.event.HomeEvent;
import cc.onion.cosyfans.home.listenter.HomeViewOnClickListener;
import io.reactivex.disposables.CompositeDisposable;

/**
 * @Author guobihai
 * @date 2019-11-12
 */
public class HomeViewModel extends AndroidViewModel {

    public final ObservableField<String> searchText = new ObservableField<>();

    private CompositeDisposable mDisposable;



    HomeViewOnClickListener homeViewOnClickListener;

    public HomeViewOnClickListener getHomeViewOnClickListener() {
        return homeViewOnClickListener;
    }

    public void setHomeViewOnClickListener(HomeViewOnClickListener homeViewOnClickListener) {
        this.homeViewOnClickListener = homeViewOnClickListener;
    }

    public HomeViewModel(@NonNull Application application) {
        super(application);
        mDisposable = new CompositeDisposable();
    }



    public void onDestroy() {
        mDisposable.dispose();
    }




    /**
     * 获取当前角色
     */
    public void getHomeAllModule(HomeGetAllModelRequest request, ResponseListener<HomeAllModel> listener){
        RetrofitManager
                .createToken(HomeApiServer.class)
                .getHomeAllModule(request)
                .compose(RxUtils.responseTransformer())
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<HomeAllModel>() {
                    @Override
                    public void onSuccess(HomeAllModel data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }


    /**
     * 获取每个模块的内容
     * @param request
     * @param listener
     */
    public void getModelDetail(ContextModelRequest request, ResponseListener<AdvertEntity> listener){
        RetrofitManager
                .create(HomeApiServer.class)

                .getHomeModuleDetail(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<AdvertEntity>() {
                    @Override
                    public void onSuccess(AdvertEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }


    /**
     * 获取tableLayout标签
     * @param request
     * @param listener
     */
    public void getTableLyoutTag(ContextModelRequest request, ResponseListener<TableEntity> listener){
        RetrofitManager
                .create(HomeApiServer.class)
                .getHomeFlowTab(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<TableEntity>() {
                    @Override
                    public void onSuccess(TableEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }



    //二维码
   public  void toQcCodeClick(){
       EventBusUtil.sendStickyEvent(new Event(HomeEvent.EventCode.codeScan));
       homeViewOnClickListener.toQcCodeClick();
   }

    //搜索界面
    public void toSearchClick(){
        ARouter.getInstance().build(RouterPath.Search.ROUTE_SEARCH_HOME)
                .greenChannel()
                .navigation();
    }

    //登陆界面
    public  void toLogin(){
        ARouter.getInstance().build(RouterPath.Passport.ROUTE_PASSPORT_SIGNIN)
                .greenChannel()
                .navigation();
    }


    /**
     * 获取现金优惠券
     * @param request
     * @param listener
     */
    public void getCouponList(CashRequest request, ResponseListener<CashRollEntity> listener){
        RetrofitManager
                .create(HomeApiServer.class)
                .getCouponList(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<CashRollEntity>() {
                    @Override
                    public void onSuccess(CashRollEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }







}
