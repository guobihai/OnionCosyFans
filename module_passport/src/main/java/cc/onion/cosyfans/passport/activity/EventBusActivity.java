package cc.onion.cosyfans.passport.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @Author guobihai
 * @Created 4/20/19
 * @Editor zrh
 * @Edited 4/20/19
 * @Type
 * @Layout
 * @Api
 */
public class EventBusActivity extends AppCompatActivity {

    private CompositeDisposable mDisposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDisposable = new CompositeDisposable();

    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    protected void addDisposable(Disposable disposable) {
        mDisposable.add(disposable);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDisposable.clear();
        EventBus.getDefault().unregister(this);
    }
}
