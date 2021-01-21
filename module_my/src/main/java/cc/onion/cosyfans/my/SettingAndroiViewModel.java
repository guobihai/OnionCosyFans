package cc.onion.cosyfans.my;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.List;

import cc.onion.cosyfans.base.account.AccountManager;
import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.item.entity.SkuBaseEntity;
import cc.onion.cosyfans.my.api.MyApi;
import io.reactivex.disposables.Disposable;

/**
 * @author guobihai
 * @version V1.0
 * @Title: AppCommonInfo
 * @Package cc.onion.cosyfans.base.common
 * @date 2019-12-03 14:53
 * @email: anhui-zhuang@msyc.cc
 * @Description: (设置中心)
 */
public class SettingAndroiViewModel extends AndroidViewModel {

    public SettingAndroiViewModel(@NonNull Application application) {
        super(application);
    }


    /**
     * 退出
     */
    public void loginOut(){
        BaseRequestBean requestBean = new BaseRequestBean();
        requestBean.sign();
        logOutUser(requestBean, new ResponseListener<BaseResponse>() {
            @Override
            public void loadSuccess(BaseResponse data) {
                ToastUtil.Short("退出成功");
                AccountManager.clear();
                ARouter.getInstance().build(RouterPath.Passport.ROUTE_PASSPORT_SIGNIN_WITH_LOGIN)
                        .greenChannel()
                        .navigation();

            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                KLog.i("test","退出失敗");
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addDisposable(disposable);
            }
        });
    }

    public void login(){

    }



    /**
     * 退出用戶
     * @param request
     * @param listener
     */
    public void logOutUser(BaseRequestBean request, ResponseListener<BaseResponse> listener){
        RetrofitManager
                .create(MyApi.class)
                .logOut(request)
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



}

