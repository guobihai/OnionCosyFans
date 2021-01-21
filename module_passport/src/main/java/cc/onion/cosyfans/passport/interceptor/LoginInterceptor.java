package cc.onion.cosyfans.passport.interceptor;

import android.content.Context;
import android.provider.SyncStateContract;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;

import cc.onion.cosyfans.base.account.AccountManager;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.KLogUtils;
import cc.onion.cosyfans.passport.utils.StringUtils;

/**
 * 登录拦截器，未登录时需要跳转到登录界面
 *
 * @Author guobihai
 * @Created 5/8/19
 * @Editor guobihai
 * @Edited 5/8/19
 * @Type
 * @Layout
 * @Api
 */
@Interceptor(name = "login", priority = 8)
public class LoginInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        /**
         * 设置需要开启登陆拦截
         * 再判断是否登陆，并且进行拦截操作
         */
        if(AccountManager.isNeedLogin()){
            if (StringUtils.isEmpty(AccountManager.getToken())) {
                KLogUtils.logTest(AccountManager.getToken());
                callback.onInterrupt(null);
                ARouter.getInstance().build(RouterPath.Passport.ROUTE_PASSPORT_SIGNIN)
                        .with(postcard.getExtras())
                        .greenChannel()
                        .navigation();
            } else {
                callback.onContinue(postcard);
            }
        }else{
            callback.onContinue(postcard);
        }


    }

    @Override
    public void init(Context context) {

    }
}
