package cc.onion.cosyfans.passport.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.module_passport.R;
import cc.onion.cosyfans.module_passport.databinding.PassportLoginFacebookBinding;
import cc.onion.cosyfans.module_passport.databinding.PassportLoginGoogleBinding;
import cc.onion.cosyfans.passport.FacebookViewModel;
import cc.onion.cosyfans.passport.GoogleLoginViewModel;

/**
 * google login
 * @author guobihai
 * @date  2019-11-28
 *
 */
@Route(path = RouterPath.Passport.ROUTE_PASSPORT_GOOGLE)
public class GoogleLoginActivity extends EventBusActivity{


    private GoogleLoginViewModel model;
    private PassportLoginGoogleBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化数据
        ARouter.getInstance().inject(this);
        model = ViewModelProviders.of(this).get(GoogleLoginViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.passport_login_google);
        binding.setModel(model);
        binding.imgReturn.setOnClickListener(v -> onBackPressed());


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handelEvent(String event) {

    }
}
