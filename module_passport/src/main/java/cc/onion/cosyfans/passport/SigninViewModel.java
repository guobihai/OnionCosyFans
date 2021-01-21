package cc.onion.cosyfans.passport;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.Observable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;

import org.greenrobot.eventbus.EventBus;

import cc.onion.cosyfans.base.account.AccountManager;
import cc.onion.cosyfans.base.event.LoginSuccessEvent;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.passport.Event.SigninPageEvent;
import cc.onion.cosyfans.passport.api.SigninApi;
import cc.onion.cosyfans.passport.entity.LoginRequest;
import cc.onion.cosyfans.passport.entity.LoginResponEntity;
import cc.onion.cosyfans.passport.listener.PasswordSeeStateOnClickListener;
import cc.onion.cosyfans.passport.utils.OnionException;
import cc.onion.cosyfans.passport.utils.OnionSecurityBase64Utils;
import cc.onion.cosyfans.passport.utils.StringUtils;

import static cc.onion.cosyfans.passport.NetStateType.NET_STATE_200;
import static cc.onion.cosyfans.passport.NetStateType.NET_STATE_400;
import static cc.onion.cosyfans.passport.NetStateType.NET_STATE_500;

/**
 * 登陆
 * @author guobihai
 * @date 2019 -11-26
 */
public class SigninViewModel extends AndroidViewModel {

    PasswordSeeStateOnClickListener  passwordSeeStateOnClickListener;
    public final ObservableField<String> account = new ObservableField<>();
    public final ObservableField<String> password = new ObservableField<>();

    public final ObservableBoolean showPhoneDelete = new ObservableBoolean(false);
    public final ObservableBoolean showPassDelete = new ObservableBoolean(false);
    public final ObservableBoolean pwdSeeState = new ObservableBoolean(false);

    public final ObservableBoolean loading = new ObservableBoolean(false);

    public SigninViewModel(@NonNull Application application) {
        super(application);
        //account
        AccountManager.clear();
        account.set("15767708601");
        password.set("qwe123");

        account.addOnPropertyChangedCallback(new android.databinding.Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(android.databinding.Observable sender, int propertyId) {
                if (StringUtils.isEmpty(account.get())) {
                    showPhoneDelete.set(false);
                } else {
                    showPhoneDelete.set(true);
                }
            }
        });

        //password
        password.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (StringUtils.isEmpty(password.get())) {
                    showPassDelete.set(false);
                } else {
                    showPassDelete.set(true);
                }
            }
        });

    }

    public void showSeeState(){

        //点击事件
       if(passwordSeeStateOnClickListener != null){
           passwordSeeStateOnClickListener.passwordState(pwdSeeState.get());
       }

    }

    public void deletePhone() {
        account.set(null);
    }

    public void deletePass() {
        password.set(null);
    }

    public void sumbit() {
        // 校验手机号
    }

    public void forgetPassword(){
        ARouter.getInstance().build(RouterPath.Passport.ROUTE_PASSPORT_RESET_PASSWORD)
                .greenChannel()
                .navigation();
    }

    public void submit(){
        try {
            loginAccount();
        } catch (OnionException e) {
            e.printStackTrace();
        }


    }


    public void loginAccount() throws OnionException {

        // 校验手机号
//        if(org.apache.commons.lang3.StringUtils.isNoneEmpty(account.get()) && org.apache.commons.lang3.StringUtils.isNotEmpty(password.get())){
//            return;
//        }
//        String phoneString = StringUtils.getRightPhone(account.get());
//        if (phoneString == null) {
//            ToastUtil.Short("请输入正确的手机号");
//            return;
//        }

        loading.set(true);
        LoginRequest request = new LoginRequest();
        request.setAccount(account.get());
        request.setPassword(OnionSecurityBase64Utils.encode(password.get()));
        request.setNationCode("60");
        request.setImgShopId("1");
        request.getKeyMap().put("imgShopId","1");
        request.getKeyMap().put("account",request.getAccount());
        request.getKeyMap().put("nationCode",request.getNationCode());
        request.getKeyMap().put("password",OnionSecurityBase64Utils.encode(password.get()));
        request.setRequestSign(request.getKeyMap());

        RetrofitManager
                .create(SigninApi.class)
                .login(request)
                .compose(RxUtils.responseTransformer())
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<LoginResponEntity>() {
                    @Override
                    public void onSuccess(LoginResponEntity data) {
                        loading.set(false);
                        AccountManager.clear();
                        KLog.i("test","登陆成功初始化数据:~~~~~~~~~~~");
                        AccountManager.saveInviteShopIdxCode(TypeUtils.toString(data.getInviteShopIdxCode()));
                        AccountManager.saveToken(data.getToken());
                        AccountManager.saveImageShopIdxCode(TypeUtils.toString(data.getImgShopIdxCode()));
                        AccountManager.saveLoginFlag(TypeUtils.toString(data.getLoginFlag()));
                        AccountManager.saveLoginType(TypeUtils.toString(data.getLoginType()));
                        AccountManager.saveShopId(org.apache.commons.lang3.StringUtils.isNoneEmpty(data.getShopId()) ? null:data.getShopId());
                        //判断是否已经登录，是否需要token状态
                        AccountManager.setIsGotoken(true);
                        EventBus.getDefault().post(LoginSuccessEvent.SIGNIN_SUCCESS);
                        EventBus.getDefault().post(SigninPageEvent.SIGNIN_SUCCESS);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        loading.set(false);
                        EventBus.getDefault().post(LoginSuccessEvent.SIGNIN_ERROR);
                        switch (code){
                           case NET_STATE_400:

                                break;
                             case NET_STATE_500:
                                ToastUtil.Short("网络异常");
                                 break;
                        }
                    }
                });
    }

    public PasswordSeeStateOnClickListener getPasswordSeeStateOnClickListener() {
        return passwordSeeStateOnClickListener;
    }

    public void setPasswordSeeStateOnClickListener(PasswordSeeStateOnClickListener passwordSeeStateOnClickListener) {
        this.passwordSeeStateOnClickListener = passwordSeeStateOnClickListener;
    }
}
