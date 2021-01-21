package cc.onion.cosyfans;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.Timer;
import java.util.TimerTask;

import cc.onion.cosyfans.base.account.AccountManager;
import cc.onion.cosyfans.base.router.RouterPath;

/**
 * 欢迎页
 * @Author guobihai
 * @Created 5/8/19
 * @Editor guobihai
 * @Edited 6/26/19
 * @Type
 * @Layout
 * @Api
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_splach);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                ARouter.getInstance().build(RouterPath.Main.ROUTE_MAIN_PATH).navigation();
                finish();
            }
        }, 2000);

    }
}
