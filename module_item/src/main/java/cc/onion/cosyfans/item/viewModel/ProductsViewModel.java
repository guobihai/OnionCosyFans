package cc.onion.cosyfans.item.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.item.api.ItemApi;
import cc.onion.cosyfans.item.entity.ItemDetailRequest;
import cc.onion.cosyfans.item.entity.response.ItemDetailEntity;

/**
 * Products detail
 * @author guobihai
 * @email:guobihai@163.com
 *
 *
 */
public class ProductsViewModel extends AndroidViewModel {


    public ProductsViewModel(@NonNull Application application) {
        super(application);
    }






}
