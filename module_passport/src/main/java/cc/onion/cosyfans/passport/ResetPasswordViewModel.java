package cc.onion.cosyfans.passport;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.Observable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;


import com.alibaba.android.arouter.launcher.ARouter;

import org.greenrobot.eventbus.EventBus;

import cc.onion.cosyfans.base.account.AccountManager;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.passport.Event.MsgSendEvent;
import cc.onion.cosyfans.passport.Event.SigninPageEvent;
import cc.onion.cosyfans.passport.api.SigninApi;
import cc.onion.cosyfans.passport.dialog.ChooseCountryDialog;
import cc.onion.cosyfans.passport.entity.LoginRequest;
import cc.onion.cosyfans.passport.entity.LoginResponEntity;
import cc.onion.cosyfans.passport.entity.NextVerificationPasswordRequest;
import cc.onion.cosyfans.passport.entity.SendEmailRequest;
import cc.onion.cosyfans.passport.entity.SmsRequest;
import cc.onion.cosyfans.passport.listener.ResetPasswordViewOnClickListener;
import cc.onion.cosyfans.passport.listener.SendMsgCountDownOnClickListener;
import cc.onion.cosyfans.passport.utils.StringUtils;

import static cc.onion.cosyfans.passport.NetStateType.NET_STATE_200;
import static cc.onion.cosyfans.passport.NetStateType.NET_STATE_400;
import static cc.onion.cosyfans.passport.NetStateType.NET_STATE_500;
import static cc.onion.cosyfans.passport.NetStateType.NET_STATE_600;

/**
 * @Author guobihai
 * @Created 4/20/19
 * @Editor zrh
 * @Edited 4/20/19
 * @Type
 * @Layout
 * @Api
 */
public class ResetPasswordViewModel extends AndroidViewModel {

    public final ObservableField<String> countryNumber = new ObservableField<>();
    public final ObservableField<String> countryNumberHiht = new ObservableField<>();
    public final ObservableField<String> phone = new ObservableField<>();
    public final ObservableField<String> code = new ObservableField<>();
    public final ObservableField<String> password = new ObservableField<>();
    public final ObservableField<String> email = new ObservableField<>();

    public final ObservableBoolean showPhoneDelete = new ObservableBoolean(false);
    public final ObservableBoolean showPassDelete = new ObservableBoolean(false);
    public final ObservableBoolean showEmail = new ObservableBoolean(false);
    public final ObservableBoolean showMobile = new ObservableBoolean(true);

    public final ObservableBoolean loading = new ObservableBoolean(false);

    boolean isCheckEmailOrMobile = true;

    /**
     * 倒计时
     */
    SendMsgCountDownOnClickListener sendMsgCountDownOnClickListener;

    ResetPasswordViewOnClickListener listener;
    public ResetPasswordViewModel(@NonNull Application application) {
        super(application);
        countryNumber.set("0060");


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

    public void deletePhone() {
        phone.set(null);
    }

    public void deletePass() {
        password.set(null);
    }

    public void getVerifiCode() {
        // 校验手机号
        String phoneString = StringUtils.getRightPhone(phone.get());
        if (phoneString == null) {
            ToastUtil.Short("请输入正确的手机号");
            return;
        }


        //获取短信
        sendMsg();


    }


    /**
     * 获取邮箱验证码
     */
    public void getEmailVerifiCode(){
        //发送邮件
        sendEmail();


    }
    /**
     * 切换邮箱或者手机
     */
    public void checkEmailOrMobile(){
        if(isCheckEmailOrMobile){
            showEmail.set(true);
            showMobile.set(false);
        }else{
            showMobile.set(true);
            showEmail.set(false);
        }
        isCheckEmailOrMobile = !isCheckEmailOrMobile;
    }


    /**
     * 选择国家爱
     */
    public void chooseCountrt(){
            listener.showChooseCuntry();
    }


    /**
     * 发送短信验证码
     */
    public void sendMsg(){

        loading.set(true);
        SmsRequest request = new SmsRequest();
        request.setSmsType(TypeUtils.toString(SmsSendType.MSG_FORGET));
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
                        ToastUtil.Short("短信发送失败！");
                    }
                });
    }



    public void sendEmail(){
        loading.set(true);
        SendEmailRequest request = new SendEmailRequest();
        request.setEmail(email.get());
        request.getKeyMap().put("email",request.getEmail());
        request.getKeyMap().put("emailType",1);
        request.setRequestSign(request.getKeyMap());

        RetrofitManager
                .create(SigninApi.class)
                .doSendEmail(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<BaseResponse>() {
                    @Override
                    public void onSuccess(BaseResponse data) {
                        loading.set(false);
                        ToastUtil.Short(data.getMsg());
                        //邮件发送

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


    /**
     * 下一步重置密码
     */
    public void next(){

//        ARouter.getInstance().build(RouterPath.Passport.ROUTE_PASSPORT_MODIFY)
//                .greenChannel()
//                .navigation();
    }


    /**
     * 提交才一步
     */
    public void submit() {

        // 校验手机号
        String phoneString = StringUtils.getRightPhone(phone.get());
        if (phoneString == null) {
            ToastUtil.Short("请输入正确的手机号");
            return;
        }



        loading.set(true);
        NextVerificationPasswordRequest request = new NextVerificationPasswordRequest();
        if(org.apache.commons.lang3.StringUtils.isNotEmpty(request.getEmail())){
            //email
            request.setEmail(email.get());
            request.setAccountType("email");
            request.setVerifyCode(code.get());
            request.getKeyMap().put("verifyCode",request.getVerifyCode());
            request.getKeyMap().put("email",request.getEmail());
            request.getKeyMap().put("accountType","email");
        }else{
            //phone
            request.setPhone(phone.get());
            request.setAccountType("phone");
            request.setVerifyCode(code.get());
            request.getKeyMap().put("verifyCode",request.getVerifyCode());
            request.getKeyMap().put("phone",request.getPhone());
            request.getKeyMap().put("accountType","phone");
        }

        request.setRequestSign(request.getKeyMap());

        RetrofitManager
                .create(SigninApi.class)
                .retrievePassword(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<BaseResponse>() {
                    @Override
                    public void onSuccess(BaseResponse data) {
                        loading.set(false);
                        ToastUtil.Short(data.getMsg());
                        //成功
                        EventBus.getDefault().post(MsgSendEvent.SIGNIN_SUCCESS);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        loading.set(false);
                        KLog.i("test","发送失败:~~~~~~~~~~~");
                        ToastUtil.Short(msg);
                    }
                });



    }

    public ResetPasswordViewOnClickListener getListener() {
        return listener;
    }

    public void setListener(ResetPasswordViewOnClickListener listener) {
        this.listener = listener;
    }


    public SendMsgCountDownOnClickListener getSendMsgCountDownOnClickListener() {
        return sendMsgCountDownOnClickListener;
    }

    public void setSendMsgCountDownOnClickListener(SendMsgCountDownOnClickListener sendMsgCountDownOnClickListener) {
        this.sendMsgCountDownOnClickListener = sendMsgCountDownOnClickListener;
    }
}
