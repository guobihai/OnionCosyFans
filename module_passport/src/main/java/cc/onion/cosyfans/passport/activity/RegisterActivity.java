package cc.onion.cosyfans.passport.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cc.onion.cosyfans.base.dialog.LoadingDialog;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.SoftKeyBoardUtils;
import cc.onion.cosyfans.module_passport.R;
import cc.onion.cosyfans.module_passport.databinding.PassportRegisterBinding;
import cc.onion.cosyfans.passport.RegisterViewModel;
import cc.onion.cosyfans.passport.dialog.ChooseCountryDialog;
import cc.onion.cosyfans.passport.listener.PasswordSeeStateOnClickListener;
import cc.onion.cosyfans.passport.listener.ResetPasswordViewOnClickListener;
import cc.onion.cosyfans.passport.listener.ResigerViewOnClickListener;
import cc.onion.cosyfans.passport.utils.SoftKeyboard;
import cc.onion.cosyfans.passport.utils.StringUtils;

/**
 * @author guobihai
 * @date  2019-11-26
 */

@Route(path = RouterPath.Passport.ROUTE_PASSPORT_REGISISTER)
public class RegisterActivity extends EventBusActivity implements ResetPasswordViewOnClickListener , PasswordSeeStateOnClickListener, ResigerViewOnClickListener {

    RegisterViewModel model;
    PassportRegisterBinding binding;

    private LoadingDialog loadingDialog;
    /**
     * 选择国家对话框
     */
    ChooseCountryDialog countryDialog;


    /**
     * 显示密码控制1
     */
    private boolean isShowSee =false;

    /**
     * 显示密码控制2
     */
    private boolean isShowSeeAgain =false;
    /**
     *是否同意
     */
    boolean isAgreen = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化数据
        ARouter.getInstance().inject(this);
        model = ViewModelProviders.of(this).get(RegisterViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.passport_register);
        binding.setModel(model);
        model.setListener(this);
        model.setPasswordSeeStateOnClickListener(this);
        model.setResigerViewOnClickListener(this);
        binding.imgReturn.setOnClickListener(v -> onBackPressed());

        loadingDialog = new LoadingDialog(this);

        //界面数据初始化
        observerModel();
        initRootView();

    }

    private void initRootView() {
        binding.getRoot().setOnClickListener(v -> {
            SoftKeyBoardUtils.closeKeyBoard(this);
        });

        binding.editPhone.setOnFocusChangeListener((v, hasFocus) -> {
            if (!binding.editPhone.isFocused()){
                StringUtils.validatePhone(model.phone.get());
            }

        });

        binding.editPass.setOnFocusChangeListener((v, hasFocus) -> {
            if (!binding.editPass.isFocused()){
                checkPasswrodState(model.password, R.color.orange, R.color.bluce);
            }


        });

        binding.editPassAgain.setOnFocusChangeListener((v, hasFocus) -> {
            if (!binding.editPassAgain.isFocused()){
                checkPasswrodState(model.passwordAgain, R.color.orange, R.color.bluce);
            }


        });


        SoftKeyboard.of(this).listen(new SoftKeyboard.OnSoftKeyboardChangeListener() {
            @Override
            public void onHide() {
                if (binding.editPhone.isFocused()){
                    StringUtils.validatePhone(model.phone.get());
                }

                if (binding.editPass.isFocused()){
                    checkPasswrodState(model.password, R.color.orange, R.color.bluce);
                }

                if (binding.editPassAgain.isFocused()){
                    checkPasswrodState(model.passwordAgain, R.color.orange, R.color.bluce);
                }

                //隐藏布局
                binding.btnSign.setVisibility(View.VISIBLE);
                binding.layoutFlexbox.setVisibility(View.VISIBLE);
            }

            @Override
            public void onShow() {
                //隐藏布局
                binding.btnSign.setVisibility(View.GONE);
                binding.layoutFlexbox.setVisibility(View.GONE);

            }
        });
    }

    private void checkPasswrodState(ObservableField<String> password, int p, int p2) {
        if (!StringUtils.isPassword(password.get())) {
            binding.tvPasswordTips.setTextColor(getResources().getColor(p));
        } else {
            binding.tvPasswordTips.setTextColor(getResources().getColor(p2));
        }
    }


    private void observerModel() {


        //验证输入
        Observable.OnPropertyChangedCallback propertyChangedCallback = new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                boolean msgCode = !StringUtils.isEmpty(model.msgCode.get());
                boolean password = !StringUtils.isEmpty(model.password.get());
                boolean passwordAgain = !StringUtils.isEmpty(model.passwordAgain.get());


                //需要勾选才能进行提交
                    if (msgCode && password && passwordAgain && isAgreen) {
                        checkPasswrodState(model.passwordAgain, R.color.orange, R.color.bluce);
                        submitButtonState(true, "蓝色", R.color.bluce, R.color.bluce, R.color.bluce, R.color.white, R.color.white, R.color.white);
                    } else {
                        checkPasswrodState(model.passwordAgain, R.color.orange, R.color.bluce);
                        submitButtonState(false, "灰色", R.color.btn_default_color, R.color.btn_default_color, R.color.btn_default_color,
                                R.color.text_sub_dark, R.color.text_sub_dark, R.color.text_sub_dark);
                    }


            }
        };


        model.msgCode.addOnPropertyChangedCallback(propertyChangedCallback);

        model.password.addOnPropertyChangedCallback(propertyChangedCallback);

        model.passwordAgain.addOnPropertyChangedCallback(propertyChangedCallback);


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
                } else {
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
    }

    private void submitButtonState(boolean b, String 蓝色, int p, int p2, int p3, int p4, int p5, int p6) {
        binding.btnSign.setEnabled(b);
        KLog.i("test", "按钮颜色:" + 蓝色);
        binding.btnSign.setNormalBackgroundColor(getResources().getColor(p));
        binding.btnSign.setPressedBackgroundColor(getResources().getColor(p2));
        binding.btnSign.setUnableBackgroundColor(getResources().getColor(p3));

        binding.btnSign.setNormalTextColor(getResources().getColor(p4));
        binding.btnSign.setPressedTextColor(getResources().getColor(p5));
        binding.btnSign.setUnableTextColor(getResources().getColor(p6));
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handelEvent(String event) {

    }

    @Override
    public void showChooseCuntry() {

        countryDialog = new ChooseCountryDialog(RegisterActivity.this, v -> {
            model.countryNumber.set("0060");
            countryDialog.dismiss();

        }, v -> {
            model.countryNumber.set("0086");
            countryDialog.dismiss();
        });
        countryDialog.show();
    }


    @Override
    public void passwordState(boolean isShow) {
        // pwd state
        if(isShowSee){
            binding.imgSee1.setImageResource(R.mipmap.icon_see);
            binding.editPass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }else{
            binding.imgSee1.setImageResource(R.mipmap.icon_see_focus);
            binding.editPass.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        isShowSee =!isShowSee;
    }

    @Override
    public void passwordStateAgain(boolean isShow) {
        if(isShowSeeAgain){
            binding.imgSee2.setImageResource(R.mipmap.icon_see);
            binding.editPassAgain.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }else{
            binding.imgSee2.setImageResource(R.mipmap.icon_see_focus);
            binding.editPassAgain.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        isShowSeeAgain =!isShowSeeAgain;
    }

    @Override
    public void onCheckStateListener() {
        //切换状态
        KLog.i("test","状态变化:"+isAgreen);
        if(isAgreen){
            submitButtonState(false, "灰色", R.color.btn_default_color, R.color.btn_default_color, R.color.btn_default_color,
                    R.color.text_sub_dark, R.color.text_sub_dark, R.color.text_sub_dark);
            binding.tvCheckAgreen.setCompoundDrawablesWithIntrinsicBounds( getResources().getDrawable(R.mipmap.icon_cheack_state), null,null, null);
        }else{
            binding.tvCheckAgreen.setCompoundDrawablesWithIntrinsicBounds( getResources().getDrawable(R.mipmap.icon_check_agreen), null,null, null);
            submitButtonState(true, "蓝色", R.color.bluce, R.color.bluce, R.color.bluce, R.color.white, R.color.white, R.color.white);
        }
        model.isAgreen.set(isAgreen);

        isAgreen = !isAgreen;

    }
}
