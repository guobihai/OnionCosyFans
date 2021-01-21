package cc.onion.cosyfans.passport;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

/**
 * 修改密码二次确认
 * @author guobihai
 * @date  2019 -11-27
 */
public class ModifyViewModel extends AndroidViewModel {

    //password
    public final ObservableField<String> password = new ObservableField<>();
    //password again
    public final ObservableField<String> passwordAgain = new ObservableField<>();
    public final ObservableBoolean showPasswordSee1 = new ObservableBoolean(false);
    public final ObservableBoolean showPasswordSee2 = new ObservableBoolean(false);


    public ModifyViewModel(@NonNull Application application) {
        super(application);
    }


    public void checkSeeState1(){

    }


    public void checkSeeState2(){

    }



    public void submit(){

    }

}
