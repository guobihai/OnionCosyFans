package cc.onion.cosyfans.my.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;

import cc.onion.cosyfans.base.BaseActivity;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.module_my.BR;
import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.module_my.databinding.MySettingBinding;
import cc.onion.cosyfans.my.SettingAndroiViewModel;

/**
 * @author guobihai
 * @version V1.0
 * @Title: AppCommonInfo
 * @Package cc.onion.cosyfans.base.common
 * @date 2019-12-03 14:53
 * @email: anhui-zhuang@msyc.cc
 * @Description: (设置中心)
 */
@Route(path = RouterPath.MyCosy.ROUTE_MIME_SETTING)
public class SettingActivity extends BaseActivity<MySettingBinding, SettingAndroiViewModel> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.my_setting;
    }

    @Override
    public int initVariableId() {
        return cc.onion.cosyfans.module_my.BR.model;
    }
}
