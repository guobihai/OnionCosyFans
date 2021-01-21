package cc.onion.cosyfans.passport;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.Observable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import org.greenrobot.eventbus.EventBus;

import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.passport.Event.MsgSendEvent;
import cc.onion.cosyfans.passport.api.SigninApi;
import cc.onion.cosyfans.passport.entity.RegisterRequest;
import cc.onion.cosyfans.passport.entity.SmsRequest;
import cc.onion.cosyfans.passport.listener.PasswordSeeStateOnClickListener;
import cc.onion.cosyfans.passport.listener.ResetPasswordViewOnClickListener;
import cc.onion.cosyfans.passport.listener.ResigerViewOnClickListener;
import cc.onion.cosyfans.passport.utils.OnionException;
import cc.onion.cosyfans.passport.utils.OnionSecurityBase64Utils;
import cc.onion.cosyfans.passport.utils.StringUtils;

import static cc.onion.cosyfans.passport.NetStateType.NET_STATE_200;
import static cc.onion.cosyfans.passport.NetStateType.NET_STATE_400;
import static cc.onion.cosyfans.passport.NetStateType.NET_STATE_600;

/**
 * 注册用户
 * @author guobihai
 * @date 2019-11-26
 */
public class RegisterViewModel extends AndroidViewModel {

    ResetPasswordViewOnClickListener listener;
    PasswordSeeStateOnClickListener passwordSeeStateOnClickListener;
    ResigerViewOnClickListener resigerViewOnClickListener;
    /**
     * 邀请码
     */
    public final ObservableField<String> invitationCode = new ObservableField<>();
    /**
     * 手机验证码
     */
    public final ObservableField<String> msgCode = new ObservableField<>();
    public final ObservableField<String> phone = new ObservableField<>();
    public final ObservableField<String> countryNumber = new ObservableField<>();
    public final ObservableField<String> accountName = new ObservableField<>();


    //password
    public final ObservableField<String> password = new ObservableField<>();
    //password again
    public final ObservableField<String> passwordAgain = new ObservableField<>();
    public final ObservableBoolean showPasswordSee1 = new ObservableBoolean(false);
    public final ObservableBoolean showPasswordSee2 = new ObservableBoolean(false);

    public final ObservableBoolean loading = new ObservableBoolean(false);

    /**
     * 是否同意
     */
    public final ObservableBoolean isAgreen = new ObservableBoolean(false);

    boolean isCheckEmailOrMobile = true;




    public RegisterViewModel(@NonNull Application application) {
        super(application);
        countryNumber.set("0060");


        //初始化密码
        password.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (StringUtils.isEmpty(password.get())) {
                    showPasswordSee1.set(false);
                } else {
                    showPasswordSee1.set(true);
                }
            }
        });


        passwordAgain.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (StringUtils.isEmpty(passwordAgain.get())) {
                    showPasswordSee2.set(false);
                } else {
                    showPasswordSee2.set(true);
                }
            }
        });


    }


    /**
     * 注册
     */
    public void register(){






    }

    public void checkSeeState1(){
        passwordSeeStateOnClickListener.passwordState(false);
    }


    public void checkSeeState2(){
        passwordSeeStateOnClickListener.passwordStateAgain(false);
    }


    /**
     * 提交
     */
    public void submit(){

        //提交注册
        if(isAgreen.get()){
            postRegisgerMethod();
        }else{

        }



    }

    private void postRegisgerMethod() {
        if(StringUtils.isEmpty(phone.get())){
            ToastUtil.Short("手机号码不能为空");
            return;
        }

        // 校验手机号
        String phoneString = StringUtils.getRightPhone(phone.get());
        if (phoneString == null) {
            ToastUtil.Short("请输入正确的手机号");
            return;
        }

        if(StringUtils.isEmpty(password.get())){
            ToastUtil.Short("密码不能为空");
            return;
        }

        if(StringUtils.isEmpty(passwordAgain.get())){
            ToastUtil.Short("密码不能为空");
            return;
        }

        if(!password.get().equals(passwordAgain.get())){
            ToastUtil.Short("两次密码不一致");
            return;
        }

        try {
            String conutryCode = countryNumber.get().substring(2);

        RegisterRequest request = new RegisterRequest();
        request.setPhone(phone.get());
        request.setPassword(OnionSecurityBase64Utils.encode(password.get()));
        request.setName(accountName.get());
        request.setVerifyCode(msgCode.get());
        request.setNationCode(conutryCode);
            request.getKeyMap().put("phone",request.getPhone());
            request.getKeyMap().put("password",request.getPassword());
            request.getKeyMap().put("name",request.getName());
            request.getKeyMap().put("nationCode",request.getNationCode());

        if(org.apache.commons.lang3.StringUtils.isNotEmpty(invitationCode.get())){
            //邀请码
            request.setInviteCode(invitationCode.get());
            request.getKeyMap().put("verifyCode",request.getVerifyCode());
        }
            request.setRequestSign(request.getKeyMap());

        RetrofitManager
                .create(SigninApi.class)
                .registerAccount(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<BaseResponse>() {
                    @Override
                    public void onSuccess(BaseResponse data) {
                        loading.set(false);
                        ToastUtil.Short(data.getMsg());


                    }

                    @Override
                    public void onError(String code, String msg) {
                        loading.set(false);
                        ToastUtil.Short(msg);
                        switch (code){
                            case NET_STATE_200:
                                EventBus.getDefault().post(MsgSendEvent.SIGNIN_SUCCESS);
                                break;
                            case NET_STATE_400:
                                EventBus.getDefault().post(MsgSendEvent.SIGNIN_ERROR);
                                break;
                            case NET_STATE_600:
                                EventBus.getDefault().post(MsgSendEvent.SIGNIN_SIX_HOUR);
                                break;
                        }

                    }
                });
        } catch (OnionException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取验证码
     */
    public void getVerifiCode(){

        //发送验证码
        // 校验手机号
        String phoneString = StringUtils.getRightPhone(phone.get());
        if (phoneString == null) {
            ToastUtil.Short("请输入正确的手机号");
            return;
        }



        sendMsg();
    }




    /**
     * 发送短信验证码
     */
    public void sendMsg(){

        loading.set(true);
        SmsRequest request = new SmsRequest();
        request.setSmsType(TypeUtils.toString(SmsSendType.MSG_REGISTER));
        request.setPhone(phone.get());
        String conutryCode = countryNumber.get().substring(2);
        request.setNationCode(conutryCode);
        request.getKeyMap().put("phone",request.getPhone());
        request.getKeyMap().put("smsType",request.getSmsType());
        request.getKeyMap().put("nationCode",request.getNationCode());
        request.setRequestSign(request.getKeyMap());

        RetrofitManager
                .create(SigninApi.class)
                .doSendSms(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<BaseResponse>() {
                    @Override
                    public void onSuccess(BaseResponse data) {
                        loading.set(false);
                        ToastUtil.Short(data.getMsg());
                        switch (data.getStatus()){
                            case NET_STATE_200:
                                EventBus.getDefault().post(MsgSendEvent.SIGNIN_SUCCESS);
                                break;
                            case NET_STATE_400:
                                EventBus.getDefault().post(MsgSendEvent.SIGNIN_ERROR);
                                break;
                            case NET_STATE_600:
                                EventBus.getDefault().post(MsgSendEvent.SIGNIN_SIX_HOUR);
                                break;
                        }

                    }

                    @Override
                    public void onError(String code, String msg) {
                        loading.set(false);
                        KLog.i("test","发送失败:~~~~~~~~~~~");
                        ToastUtil.Short(msg);
                    }
                });
    }


    public void chooseCountrt(){
        listener.showChooseCuntry();

    }

    /**
     * 用户协议
     */
    public void seeUserProtocol(){

    }


    /**
     * 切换效果
     */
    public void checkAgreen(){
        resigerViewOnClickListener.onCheckStateListener();
    }

    public ResetPasswordViewOnClickListener getListener() {
        return listener;
    }

    public void setListener(ResetPasswordViewOnClickListener listener) {
        this.listener = listener;
    }

    public PasswordSeeStateOnClickListener getPasswordSeeStateOnClickListener() {
        return passwordSeeStateOnClickListener;
    }

    public void setPasswordSeeStateOnClickListener(PasswordSeeStateOnClickListener passwordSeeStateOnClickListener) {
        this.passwordSeeStateOnClickListener = passwordSeeStateOnClickListener;
    }

    public ResigerViewOnClickListener getResigerViewOnClickListener() {
        return resigerViewOnClickListener;
    }

    public void setResigerViewOnClickListener(ResigerViewOnClickListener resigerViewOnClickListener) {
        this.resigerViewOnClickListener = resigerViewOnClickListener;
    }
}
