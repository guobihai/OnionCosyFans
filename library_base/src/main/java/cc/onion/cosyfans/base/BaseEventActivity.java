package cc.onion.cosyfans.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import cc.onion.cosyfans.base.annotation.BindEventBus;
import cc.onion.cosyfans.base.utils.EventBusUtil;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.adapter
 * @ClassName: AddressListAdapter
 * @Description: 产品适配器
 * @Author: guobihai
 * @CreateDate: 2019-12-11 14:24
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-11 14:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class BaseEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isRegisterEventBus()) {
            EventBusUtil.register(this);
        }
    }


    /**
     * 是否注册事件分发
     *
     * @return true绑定EventBus事件分发，默认不绑定，子类需要绑定的话复写此方法返回true.
     */
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isRegisterEventBus()) {
            EventBusUtil.unregister(this);
        }
    }

}
