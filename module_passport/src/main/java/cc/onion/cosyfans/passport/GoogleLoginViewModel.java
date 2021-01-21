package cc.onion.cosyfans.passport;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

/**
 * google login
 * @author guobihai
 * @date  2019-11-28
 */
public class GoogleLoginViewModel extends AndroidViewModel {

    /**
     * 邀请码
     */
    public final ObservableField<String> invitationCode = new ObservableField<>();


    public GoogleLoginViewModel(@NonNull Application application) {
        super(application);
    }


    /**
     * 确认授权
     */
    public void authorizationYes(){

    }


    /**
     * 暂不授权
     */
    public void authorizationNo(){

    }


    /**
     * 用户协议
     */
    public void seeUserProtocol(){

    }


    public void checkAgreen(){

    }
}
