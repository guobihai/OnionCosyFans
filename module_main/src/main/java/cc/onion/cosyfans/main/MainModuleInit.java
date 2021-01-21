package cc.onion.cosyfans.main;

import android.app.Application;

import cc.onion.cosyfans.base.interfaces.ModuleInitImpl;

/**
 *
 * 动态配置Application
 * 有需要初始化的模块组件实现该接口
 * 可以管理各自的初始化逻辑
 * 统一在主app的Application中初始化
 * @author guobihai
 * @created 2019/11/05
 */

public class MainModuleInit implements ModuleInitImpl {

    /**
     * 初始化优先执行的
     * @param application
     * @return
     */
    @Override
    public boolean onInitAhead(Application application) {
        return false;
    }

    /**
     * 初始化靠后执行的
     * @param application
     * @return
     */
    @Override
    public boolean onInitLow(Application application) {
        return false;
    }
}
