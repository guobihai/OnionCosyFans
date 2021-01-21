package cc.onion.cosyfans.passport.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.SoftKeyBoardUtils;
import cc.onion.cosyfans.module_passport.R;
import cc.onion.cosyfans.module_passport.databinding.PassportSiginWithLoginBinding;
import cc.onion.cosyfans.passport.Event.SigninPageEvent;
import cc.onion.cosyfans.passport.SigninWithLoginViewModel;

/**
 * 注册登陆模块入口界面
 * @author guobihai
 * @date 2019-11-26
 */
@Route(path = RouterPath.Passport.ROUTE_PASSPORT_SIGNIN_WITH_LOGIN)
public class SigninWithLoginActivity extends EventBusActivity {

    private SigninWithLoginViewModel model;
    private PassportSiginWithLoginBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化数据
        ARouter.getInstance().inject(this);
        model = ViewModelProviders.of(this).get(SigninWithLoginViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.passport_sigin_with_login);
        binding.setModel(model);
        binding.imgReturn.setOnClickListener(v -> onBackPressed());

        initData();
    }

    private void initData() {
        initPrivacyPolicyText();
    }


    private void initPrivacyPolicyText() {
        String privacyPolicy = getString(R.string.passport_password_user_agreement);
        SpannableString content = new SpannableString(privacyPolicy);
        int len = privacyPolicy.length();
        content.setSpan(new UnderlineSpan(), 1, len - 1, 0);
        content.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.theme)), 0, len, 0);
        binding.tvUserProtocol.setText(content);
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





}
