package cc.onion.cosyfans.passport.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cc.onion.cosyfans.base.dialog.LoadingDialog;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.utils.Utils;
import cc.onion.cosyfans.module_passport.R;
import cc.onion.cosyfans.module_passport.databinding.PassportPasswordResetBinding;
import cc.onion.cosyfans.passport.Event.MsgSendEvent;
import cc.onion.cosyfans.passport.Event.PassportEvent;
import cc.onion.cosyfans.passport.Event.SigninPageEvent;
import cc.onion.cosyfans.passport.ResetPasswordViewModel;
import cc.onion.cosyfans.passport.dialog.ChooseCountryDialog;
import cc.onion.cosyfans.passport.listener.ResetPasswordViewOnClickListener;
import cc.onion.cosyfans.passport.listener.SendMsgCountDownOnClickListener;
import cc.onion.cosyfans.passport.utils.StringUtils;

/**
 * 重置密码
 * @author guobihai
 * @date 2019-11-27
 */
@Route(path = RouterPath.Passport.ROUTE_PASSPORT_RESET_PASSWORD)
public class ResetPasswordActivity extends EventBusActivity implements ResetPasswordViewOnClickListener, SendMsgCountDownOnClickListener {

    private ResetPasswordViewModel model;
    private PassportPasswordResetBinding binding;
    /**
     * 选择国家对话框
     */
    ChooseCountryDialog  countryDialog;

    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化数据
        ARouter.getInstance().inject(this);
        model = ViewModelProviders.of(this).get(ResetPasswordViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.passport_password_reset);
        binding.setModel(model);
        model.setListener(this);
        model.setSendMsgCountDownOnClickListener(this);
        binding.imgReturn.setOnClickListener(v -> onBackPressed());

        loadingDialog = new LoadingDialog(this);
        //验证码

        observerModel();
    }

    private void observerModel() {
        Observable.OnPropertyChangedCallback propertyChangedCallback = new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                boolean phoneValidate = StringUtils.isPhone(model.phone.get());
                boolean codeValidate = !StringUtils.isEmpty(model.code.get());


                if (phoneValidate && codeValidate ) {
                    binding.btnSign.setEnabled(true);
                } else {
                    binding.btnSign.setEnabled(false);
                }
            }
        };




        model.loading.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (model.loading.get()) {
                    loadingDialog.show();
                } else {
                    loadingDialog.dismiss();
                }
            }
        });
        //email
        model.email.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {

                //背景颜色
                if (!StringUtils.isEmpty(model.email.get())) {
                    binding.btnVerifyCode.setEnabled(true);
                    binding.btnVerifyCode.setNormalBackgroundColor(getResources().getColor(R.color.bluce));
                    binding.btnVerifyCode.setPressedBackgroundColor(getResources().getColor(R.color.bluce));
                    binding.btnVerifyCode.setUnableBackgroundColor(getResources().getColor(R.color.bluce));
                    binding.btnVerifyCode.setNormalTextColor(getResources().getColor(R.color.white));
                    binding.btnVerifyCode.setPressedTextColor(getResources().getColor(R.color.white));
                    binding.btnVerifyCode.setUnableTextColor(getResources().getColor(R.color.white));
                }else{
                    binding.btnVerifyCode.setEnabled(false);
                    binding.btnVerifyCode.setNormalBackgroundColor(getResources().getColor(R.color.btn_default_color));
                    binding.btnVerifyCode.setPressedBackgroundColor(getResources().getColor(R.color.btn_default_color));
                    binding.btnVerifyCode.setUnableBackgroundColor(getResources().getColor(R.color.btn_default_color));
                    binding.btnVerifyCode.setNormalTextColor(getResources().getColor(R.color.text_sub_dark));
                    binding.btnVerifyCode.setPressedTextColor(getResources().getColor(R.color.text_sub_dark));
                    binding.btnVerifyCode.setUnableTextColor(getResources().getColor(R.color.text_sub_dark));
                }
            }
        });




        //电话
        model.phone.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {

                if (!StringUtils.isEmpty(model.phone.get())) {
                    binding.tvConuntNumber.setTextColor(getResources().getColor(R.color.text));
                } else {
                    binding.tvConuntNumber.setTextColor(getResources().getColor(R.color.text_sub_dark));
                }

                //背景颜色
                if (!StringUtils.isEmpty(model.phone.get()) && model.phone.get().length() >= 11) {
                    binding.btnVerifyCodeMobile.setEnabled(true);
                    binding.btnVerifyCodeMobile.setNormalBackgroundColor(getResources().getColor(R.color.bluce));
                    binding.btnVerifyCodeMobile.setPressedBackgroundColor(getResources().getColor(R.color.bluce));
                    binding.btnVerifyCodeMobile.setUnableBackgroundColor(getResources().getColor(R.color.bluce));
                    binding.btnVerifyCodeMobile.setNormalTextColor(getResources().getColor(R.color.white));
                    binding.btnVerifyCodeMobile.setPressedTextColor(getResources().getColor(R.color.white));
                    binding.btnVerifyCodeMobile.setUnableTextColor(getResources().getColor(R.color.white));
                }else{
                    binding.btnVerifyCodeMobile.setEnabled(false);
                    binding.btnVerifyCodeMobile.setNormalBackgroundColor(getResources().getColor(R.color.btn_default_color));
                    binding.btnVerifyCodeMobile.setPressedBackgroundColor(getResources().getColor(R.color.btn_default_color));
                    binding.btnVerifyCodeMobile.setUnableBackgroundColor(getResources().getColor(R.color.btn_default_color));
                    binding.btnVerifyCodeMobile.setNormalTextColor(getResources().getColor(R.color.text_sub_dark));
                    binding.btnVerifyCodeMobile.setPressedTextColor(getResources().getColor(R.color.text_sub_dark));
                    binding.btnVerifyCodeMobile.setUnableTextColor(getResources().getColor(R.color.text_sub_dark));
                }
            }
        });

        //验证码

        model.code.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {

                if (!StringUtils.isEmpty(model.code.get()) && model.code.get().length() >= 4) {
                     binding.btnSign.setNormalBackgroundColor(getResources().getColor(R.color.bluce));
                    binding.btnSign.setPressedBackgroundColor(getResources().getColor(R.color.bluce));
                    binding.btnSign.setUnableBackgroundColor(getResources().getColor(R.color.bluce));
                    binding.btnSign.setNormalTextColor(getResources().getColor(R.color.white));
                    binding.btnSign.setPressedTextColor(getResources().getColor(R.color.white));
                    binding.btnSign.setUnableTextColor(getResources().getColor(R.color.white));
                } else {
                    binding.btnSign.setNormalBackgroundColor(getResources().getColor(R.color.btn_default_color));
                    binding.btnSign.setPressedBackgroundColor(getResources().getColor(R.color.btn_default_color));
                    binding.btnSign.setUnableBackgroundColor(getResources().getColor(R.color.btn_default_color));
                    binding.btnSign.setNormalTextColor(getResources().getColor(R.color.text_sub_dark));
                    binding.btnSign.setPressedTextColor(getResources().getColor(R.color.text_sub_dark));
                    binding.btnSign.setUnableTextColor(getResources().getColor(R.color.text_sub_dark));
                }
            }
        });

        model.code.addOnPropertyChangedCallback(propertyChangedCallback);

        model.phone.addOnPropertyChangedCallback(propertyChangedCallback);


    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handelEvent(String event) {
        switch (event) {
            case MsgSendEvent.SIGNIN_SUCCESS:
                binding.btnVerifyCode.startCountDown();
                break;

            case MsgSendEvent.SIGNIN_ERROR:
                binding.btnVerifyCode.cancelCountDown();
                break;
            case MsgSendEvent.SIGNIN_SIX_HOUR:
                ToastUtil.Short("请8小时后重试！");
                break;
            case PassportEvent
                        .PAGE_COLOSE:
                // close this view .go next view
                ARouter.getInstance().build(RouterPath.Passport.ROUTE_PASSPORT_MODIFY)
                        .greenChannel()
                        .navigation();
                finish();
                break;
        }

    }

    @Override
    public void showChooseCuntry() {


        countryDialog = new ChooseCountryDialog(ResetPasswordActivity.this, v -> {
            model.countryNumber.set("0060");
            countryDialog.dismiss();

        }, v -> {
            model.countryNumber.set("0086");
            countryDialog.dismiss();
        });
        countryDialog.show();
    }

    @Override
    public void toStartTime() {
        //倒计时开始
        KLog.i("test","倒计时开始～～～");
        binding.btnVerifyCodeMobile.startCountDown();
    }
}
