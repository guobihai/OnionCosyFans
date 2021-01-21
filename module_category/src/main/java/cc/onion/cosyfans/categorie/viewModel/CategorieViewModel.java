package cc.onion.cosyfans.categorie.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;

import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.categorie.api.CategorieApi;
import cc.onion.cosyfans.categorie.entity.responer.CategorieEntity;

/**
 * @author guobihai
 * @date 2019/11/06
 */
public class CategorieViewModel extends AndroidViewModel {


    public final ObservableField<String> searchText = new ObservableField<>();

    public CategorieViewModel(@NonNull Application application) {
        super(application);
    }


    /**
     * 获取分类数据接口
     * @param request
     * @param listener
     */
    public void getCatetorieData(BaseRequestBean request, ResponseListener<CategorieEntity> listener){
        RetrofitManager
                .create(CategorieApi.class)
                .getItemDetail(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<CategorieEntity>() {
                    @Override
                    public void onSuccess(CategorieEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }


    public void toSearch(){
        //前往搜索模块界面
        ARouter.getInstance().build(RouterPath.Search.ROUTE_SEARCH_HOME)
                .greenChannel()
                .navigation();
    }

}
