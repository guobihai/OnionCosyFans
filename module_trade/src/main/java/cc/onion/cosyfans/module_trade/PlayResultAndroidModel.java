package cc.onion.cosyfans.module_trade;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import cc.onion.cosyfans.module_trade.listener.PlayResultViewListener;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_trade
 * @ClassName: PlayResultAndroidModel
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2019-12-26 16:31
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-26 16:31
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class PlayResultAndroidModel extends AndroidViewModel {

    public final ObservableField<String> totalMonery = new ObservableField<>();


    public final ObservableField<String> times = new ObservableField<>();

    public final ObservableBoolean orderState = new ObservableBoolean();
    public final ObservableField<String> orderShowState = new ObservableField<>();

    PlayResultViewListener playResultViewListener;
    public PlayResultAndroidModel(@NonNull Application application) {
        super(application);
    }


    public void orderDetail(){
        if(playResultViewListener != null){
            playResultViewListener.toOrderDetail();
        }


    }

    public void goHome(){
        if(playResultViewListener != null){
            playResultViewListener.toHome();
        }
    }


    public PlayResultViewListener getPlayResultViewListener() {
        return playResultViewListener;
    }

    public void setPlayResultViewListener(PlayResultViewListener playResultViewListener) {
        this.playResultViewListener = playResultViewListener;
    }
}
