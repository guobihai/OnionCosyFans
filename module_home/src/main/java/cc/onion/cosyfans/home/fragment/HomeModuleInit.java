package cc.onion.cosyfans.home.fragment;

import android.app.Application;


import cc.onion.cosyfans.base.interfaces.ModuleInitImpl;
import cc.onion.cosyfans.base.utils.KLog;

/**
 * 用于首页模块的组件初始化
 * @author guobihai
 * @created 2019/11/6
 */
public class HomeModuleInit implements ModuleInitImpl {

    @Override
    public boolean onInitAhead(Application application) {
        KLog.e("首页模块初始化 -- onInitAhead");
        return false;
    }

    @Override
    public boolean onInitLow(Application application) {
        return false;
    }
}
