package cc.onion.cosyfans.main.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import org.greenrobot.eventbus.EventBus;

import cc.onion.cosyfans.base.appinfo.AppInfoManager;
import cc.onion.cosyfans.base.appinfo.AppVersion;
import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.base.event.AppEvent;
import cc.onion.cosyfans.base.event.Event;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.utils.AppVersionUtil;
import cc.onion.cosyfans.base.utils.EventBusUtil;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.main.api.MainApi;
import cc.onion.cosyfans.main.entity.AppVersionInfo;
import cc.onion.cosyfans.main.entity.ItemAmonutEntity;
import cc.onion.cosyfans.main.entity.request.AppVersionRequest;
import cc.onion.cosyfans.main.event.CartCount;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @Author guobihai
 * @Created 6/21/19
 * @Editor zrh
 * @Edited 6/21/19
 * @Type
 * @Layout
 * @Api
 */
public class MainViewModel extends AndroidViewModel {

    private CompositeDisposable mDisposable;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mDisposable = new CompositeDisposable();
    }

    /**
     * 检查更新
     */
    public void checkUpdate() {
        AppVersionRequest requestBean  = new AppVersionRequest();
        requestBean.setUserClient(3);
        requestBean.getKeyMap().put("userClient","3");
        requestBean.setKeyMap(requestBean.getKeyMap());
        requestBean.sign();
        RetrofitManager
                .create(MainApi.class)
                .getAppVersion(requestBean)
                .compose(RxUtils.schedulersTransformer())
                .doOnSubscribe(disposable -> mDisposable.add(disposable))
                .subscribe(new ResponseObserver<AppVersionInfo>() {
                    @Override
                    public void onSuccess(AppVersionInfo data) {
                        if (data != null) {
                            AppVersion appVersion = data.getData();
                            AppInfoManager.setLastestAppInfo(appVersion);
                            if (!AppVersionUtil.needUpdate(getApplication(), appVersion.getVersionNo())) {
                                Event<AppVersion> versionEvent = new Event<>(AppEvent.EventCode.carCount, new AppVersion(appVersion.isHasVersion(),
                                        appVersion.getJsVersion(),appVersion.getVersionNo(),appVersion.getUpdateContent()
                                ,appVersion.getUrl(),appVersion.getUpdateIndex(),appVersion.getForceUpdate()));
                                EventBusUtil.sendStickyEvent(new Event(AppEvent.EventCode.AppUpdate,versionEvent));
                            }
                        }
                    }

                    @Override
                    public void onError(String code, String msg) {

                    }
                });
    }


    public void onDestroy() {
        mDisposable.dispose();
    }


    /**
     * 获取购物车数据
     */
    public void getCatRequest(){
        try {
            BaseRequestBean  requestBean = new BaseRequestBean();
            requestBean.sign();
            getCatAmount(requestBean, new ResponseListener<ItemAmonutEntity>() {
                @Override
                public void loadSuccess(ItemAmonutEntity data) {
                    KLog.i("test","获取购物车数据成功");
                    CartCount cartCount = new CartCount(data.getData());
                    Event<CartCount> event = new Event<>(AppEvent.EventCode.carCount, cartCount);
                    EventBusUtil.sendEvent(event);
                }

                @Override
                public void loadFailed(String errorCode, String errorMsg) {


                }

                @Override
                public void addDisposable(Disposable disposable) {
                    mDisposable.add(disposable);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    /**
     * 获取购物车产品数量
     * @param request
     * @param listener
     */
    public void getCatAmount(BaseRequestBean request, ResponseListener<ItemAmonutEntity> listener){
        RetrofitManager
                .createToken(MainApi.class)
                .getCatAmount(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<ItemAmonutEntity>() {
                    @Override
                    public void onSuccess(ItemAmonutEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }




}
