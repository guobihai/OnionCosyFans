package cc.onion.cosyfans.passport;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;

import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.ToastUtil;

/**
 * 注册登陆
 * @author guobihai
 * @date 2019 -11-26
 */
public class SigninWithLoginViewModel extends AndroidViewModel {



    public SigninWithLoginViewModel(@NonNull Application application) {
        super(application);
    }


    public void submit(){
        //登录
        ARouter.getInstance().build(RouterPath.Passport.ROUTE_PASSPORT_SIGNIN)
                .greenChannel()
                .navigation();
    }

    public void register(){
            //注册
        ARouter.getInstance().build(RouterPath.Passport.ROUTE_PASSPORT_REGISISTER)
                .greenChannel()
                .navigation();
    }


    public void fackbookLogin(){
        // facebook init
        ARouter.getInstance().build(RouterPath.Passport.ROUTE_PASSPORT_FACEBOOK)
                .greenChannel()
                .navigation();
    }


    public void googleLogin(){
        //google  init
        ARouter.getInstance().build(RouterPath.Passport.ROUTE_PASSPORT_GOOGLE)
                .greenChannel()
                .navigation();

    }

}
