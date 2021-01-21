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
import cc.onion.cosyfans.module_passport.databinding.PassportModlfyPasswordBinding;
import cc.onion.cosyfans.module_passport.databinding.PassportSiginWithLoginBinding;
import cc.onion.cosyfans.passport.ModifyViewModel;
import cc.onion.cosyfans.passport.SigninWithLoginViewModel;
import cc.onion.cosyfans.passport.activity.EventBusActivity;

/**
 * 重置密码2层
 * @author guobihai
 * @email:guobihai@163.com
 */
@Route(path = RouterPath.Passport.ROUTE_PASSPORT_MODIFY)
public class ModifyPasswordActivity extends EventBusActivity {

    private ModifyViewModel model;
    private PassportModlfyPasswordBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化数据
        ARouter.getInstance().inject(this);
        model = ViewModelProviders.of(this).get(ModifyViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.passport_modlfy_password);
        binding.setModel(model);
        binding.imgReturn.setOnClickListener(v -> onBackPressed());

    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handelEvent(String event) {

    }



}
