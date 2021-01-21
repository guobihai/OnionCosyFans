package cc.onion.cosyfans.passport.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cc.onion.cosyfans.base.BaseActivity;
import cc.onion.cosyfans.base.dialog.LoadingDialog;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.SoftKeyBoardUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.module_passport.R;
import cc.onion.cosyfans.module_passport.databinding.PassportSinginBinding;
import cc.onion.cosyfans.passport.Event.SigninPageEvent;
import cc.onion.cosyfans.passport.SigninViewModel;
import cc.onion.cosyfans.passport.SigninWithLoginViewModel;
import cc.onion.cosyfans.passport.listener.PasswordSeeStateOnClickListener;
import cc.onion.cosyfans.passport.utils.InputPhoneFormator;
import cc.onion.cosyfans.passport.utils.SoftKeyboard;
import cc.onion.cosyfans.passport.utils.StringUtils;

/**
 * 密码登录
 * @author guobihai
 * @date 2019-11-26
 */
@Route(path = RouterPath.Passport.ROUTE_PASSPORT_SIGNIN)
public class SigninActivity extends EventBusActivity implements PasswordSeeStateOnClickListener {

    private SigninViewModel model;
    private PassportSinginBinding binding;

    private LoadingDialog loadingDialog;

    private boolean isShowSee =false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化数据
        ARouter.getInstance().inject(this);
        model = ViewModelProviders.of(this).get(SigninViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.passport_singin);
        binding.setModel(model);
        model.setPasswordSeeStateOnClickListener(this);

        loadingDialog = new LoadingDialog(this);
        observerModel();
        initRootView();
        findViewById(R.id.img_back).setOnClickListener(v -> onBackPressed());
    }

    private void observerModel() {
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
    }

    private void initRootView() {
        binding.getRoot().setOnClickListener(v -> {
            SoftKeyBoardUtils.closeKeyBoard(this);
        });

        binding.editPhone.setOnFocusChangeListener((v, hasFocus) -> {
            if (!binding.editPhone.isFocused())
                StringUtils.validatePhone(model.account.get());
        });

        SoftKeyboard.of(this).listen(new SoftKeyboard.OnSoftKeyboardChangeListener() {
            @Override
            public void onHide() {
                if (binding.editPhone.isFocused())
                    StringUtils.validatePhone(model.account.get());
            }

            @Override
            public void onShow() {

            }
        });
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handelEvent(String event) {
        SoftKeyBoardUtils.closeKeyBoard(this);

        switch (event) {
            case SigninPageEvent.SIGNIN_SUCCESS:
                //登录
                ARouter.getInstance().build(RouterPath.Main.ROUTE_MAIN_PATH)
                        .greenChannel()
                        .navigation(this, new NavCallback() {
                            @Override
                            public void onArrival(Postcard postcard) {
                                finish();
                            }
                        });

                break;

            case SigninPageEvent.SIGNIN_ERROR:

                break;
        }

    }


    @Override
    public void passwordState(boolean isShow) {
        // pwd state
        if(isShowSee){
            binding.imgSee.setImageResource(R.mipmap.icon_see);
            binding.editPass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }else{
            binding.imgSee.setImageResource(R.mipmap.icon_see_focus);
            binding.editPass.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        isShowSee =!isShowSee;
    }

    @Override
    public void passwordStateAgain(boolean isShow) {

    }
}
