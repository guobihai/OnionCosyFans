package cc.onion.cosyfans.base.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

/**
 * 当页面没有viewModel的情况，可以用这个
 * @author lsy
 * @created 2019/3/14
 */
public class NoViewModel extends AndroidViewModel {

    public NoViewModel(@NonNull Application application) {
        super(application);
    }
}
