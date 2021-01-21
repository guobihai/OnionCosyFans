package cc.onion.cosyfans;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import org.litepal.LitePal;

import cc.onion.cosyfans.base.account.AccountManager;
import cc.onion.cosyfans.base.config.AppBaseConfig;
import cc.onion.cosyfans.base.config.ModuleLifecycleConfig;
import cc.onion.cosyfans.base.log.LoggerClent;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.permission.BPermissionsManager;
import cc.onion.cosyfans.base.utils.AppContext;
import cc.onion.cosyfans.base.utils.ScreenUtils;

/**
 *  ConsyFans Application
 * @author guobihai
 * @date 2019-11-04
 */
public class UApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // 执行各模块的初始化(优先的）
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);

        // 这里写其他逻辑
        // SmartRefreshLayout
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> {
            //指定为经典Header，默认是 贝塞尔雷达Header
            return new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate).setProgressResource(R.mipmap.ic_launcher_cosyfans);
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator((context, layout) -> {
            //指定为经典Footer，默认是 BallPulseFooter
            return new ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate).setTextSizeTitle(12);
        });

        // 执行各模块的初始化(靠后的）
        ModuleLifecycleConfig.getInstance().initModuleLow(this);


        // 写入项目配置信息
        AppBaseConfig.get().init(this, buildConfig());
        String baseUrl = AppBaseConfig.get().loadString("baseUrl");
        if (BuildConfig.DEBUG&&baseUrl!=null){

            RetrofitManager.getInstance().init(baseUrl);

        }else {

            //init retrofit网络框架
            RetrofitManager.getInstance().init(BuildConfig.BASE_HOST);
        }

        LoggerClent.getInstance().init();
        new AppContext(this);
        //init account data
        AccountManager.init(this);

        ScreenUtils.init(this);

        //初始化数据库
        LitePal.initialize(this);

        BPermissionsManager.init(this);

    }

    private AppBaseConfig.Config buildConfig() {
        AppBaseConfig.Config config = new AppBaseConfig.Config();
        config.setDebug(BuildConfig.DEBUG);
        config.setApplicationId(BuildConfig.APPLICATION_ID);
        config.setVersionCode(BuildConfig.VERSION_CODE);
        config.setVersionName(BuildConfig.VERSION_NAME);
        config.setBaseUrl(BuildConfig.BASE_HOST);
        config.setApiv(BuildConfig.Base_APIV);
        config.setAppId(BuildConfig.Base_APPID);
        config.setAppKey(BuildConfig.Base_APPKEY);
        config.setKey(BuildConfig.Base_KEY);
        config.setDevPlatformId(BuildConfig.Base_DEVPLATFORMID);
        return config;
    }


}
