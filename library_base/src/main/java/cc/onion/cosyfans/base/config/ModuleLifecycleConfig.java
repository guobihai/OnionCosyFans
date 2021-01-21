package cc.onion.cosyfans.base.config;

import android.app.Application;


import cc.onion.cosyfans.base.interfaces.ModuleInitImpl;
import io.reactivex.annotations.Nullable;

/**
 * 作为组件初始化的配置类，动态调用每个组件初始化逻辑
 *
 * @author author guobihai
 * @created 2019/3/13
 */
public class ModuleLifecycleConfig {

    private ModuleLifecycleConfig() {
    }

    // 内部类，在装载该内部类时才会去创建单例对象
    private static class SingletonHolder {
        public static ModuleLifecycleConfig instance = new ModuleLifecycleConfig();
    }

    public static ModuleLifecycleConfig getInstance() {
        return SingletonHolder.instance;
    }

    // 初始化组件-优先执行
    public void initModuleAhead(@Nullable Application application) {
        for (String moduleInitName : ModuleLifecycleReflexs.initModuleNames) {
            try {
                Class<?> clazz = Class.forName(moduleInitName);
                ModuleInitImpl init = (ModuleInitImpl) clazz.newInstance();
                //调用初始化方法
                init.onInitAhead(application);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    // 初始化组件-靠后执行
    public void initModuleLow(@Nullable Application application) {
        for (String moduleInitName : ModuleLifecycleReflexs.initModuleNames) {
            try {
                Class<?> clazz = Class.forName(moduleInitName);
                ModuleInitImpl init = (ModuleInitImpl) clazz.newInstance();
                //调用初始化方法
                init.onInitLow(application);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
