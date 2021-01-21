package cc.onion.cosyfans.my.viewdModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;

import cc.onion.cosyfans.base.config.AppBaseConfig;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLogUtils;
import cc.onion.cosyfans.module_my.R;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.viewdModel
 * @ClassName: UserHelpCenterViewModel
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2019-12-31 18:28
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-31 18:28
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UserHelpCenterViewModel extends AndroidViewModel {

    private Context mContext;
    String baseUrl = "https://api.cosyfans.com";

    String url1 = baseUrl+"/en/refund-policy.html?shopId=1";
    String url2 = baseUrl+"/en/distribution-policy.html?shopId=1";

    public UserHelpCenterViewModel(@NonNull Application application) {
        super(application);
    }


   public void  toTransportation(){
       KLogUtils.logTest(url2);
       ARouter.getInstance().build(RouterPath.Features.ROUTE_WEB)
               .withString("title", mContext.getString(R.string.my_transportation_policy))
               .withString("url", url2)
               .greenChannel()
               .navigation();
    }


    public void  refund(){
        KLogUtils.logTest(url1);
        ARouter.getInstance().build(RouterPath.Features.ROUTE_WEB)
                .withString("title", mContext.getString(R.string.my_refund_policy))
                .withString("url", url1)
                .greenChannel()
                .navigation();
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }
}
