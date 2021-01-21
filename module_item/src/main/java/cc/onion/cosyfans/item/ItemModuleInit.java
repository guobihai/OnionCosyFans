package cc.onion.cosyfans.item;

import android.app.Application;

import cc.onion.cosyfans.base.interfaces.ModuleInitImpl;

/**
 * 商品模块
 * @author guobihai
 * @created 2019/11/05
 */

public class ItemModuleInit implements ModuleInitImpl {

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
