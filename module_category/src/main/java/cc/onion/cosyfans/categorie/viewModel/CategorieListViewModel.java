package cc.onion.cosyfans.categorie.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.categorie.api.CategorieApi;
import cc.onion.cosyfans.categorie.entity.CaterorieChildenRequest;
import cc.onion.cosyfans.categorie.entity.responer.CategorieListEntity;

/**
 * 分组合集界面
 * @author guobihai
 * @date 2019/11/06
 *
 */
public class CategorieListViewModel extends AndroidViewModel {



    public CategorieListViewModel(@NonNull Application application) {
        super(application);
    }


    /**
     * 获取分类数据接口
     * @param request
     * @param listener
     */
    public void getCatetorieData(CaterorieChildenRequest request, ResponseListener<CategorieListEntity> listener){
        RetrofitManager
                .create(CategorieApi.class)
                .getChildCategory(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<CategorieListEntity>() {
                    @Override
                    public void onSuccess(CategorieListEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }
}
