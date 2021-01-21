package cc.onion.cosyfans.base.entity;

import io.reactivex.disposables.Disposable;

/**
 * @Author zrh
 * @Created 4/20/19
 * @Editor zrh
 * @Edited 4/20/19
 * @Type
 * @Layout
 * @Api
 */
public class BaseDisposable {

    private Disposable disposable;

    public BaseDisposable(Disposable disposable) {
        this.disposable = disposable;
    }

    public Disposable get() {
        return disposable;
    }
}
