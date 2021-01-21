package cc.onion.cosyfans.module_search.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.event.Event;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.utils.EventBusUtil;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.module_search.Envent.HoristerEnvent;
import cc.onion.cosyfans.module_search.Envent.ResultViewEnvent;
import cc.onion.cosyfans.module_search.SearchApi;
import cc.onion.cosyfans.module_search.entity.HotRequest;
import cc.onion.cosyfans.module_search.entity.RecommendEntity;
import cc.onion.cosyfans.module_search.entity.SeachRequest;
import cc.onion.cosyfans.module_search.entity.SearchHotWordEntity;
import cc.onion.cosyfans.module_search.entity.SearchResultEntity;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_search.viewModel
 * @ClassName: SearchResultViewModel
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020-01-06 09:59
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-06 09:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SearchResultViewModel extends AndroidViewModel {


    /**
     * 搜索关键字
     */
    public final ObservableField<String> searchWord = new ObservableField<>();
    public final ObservableBoolean viewState = new ObservableBoolean(false);

    public SearchResultViewModel(@NonNull Application application) {
        super(application);
    }


    /**
     * 获取搜索结果展示
     * @param request
     * @param listener
     */
    public  void getSearchResultData(SeachRequest request, ResponseListener<SearchResultEntity> listener){
        RetrofitManager
                .create(SearchApi.class)
                .getSearchResultData(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<SearchResultEntity>() {
                    @Override
                    public void onSuccess(SearchResultEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });

    }


    /**
     * 获取推荐数据
     * @param request
     * @param listener
     */
    public  void getRecommendItem(BaseRequestBean request, ResponseListener<RecommendEntity> listener){
        RetrofitManager
                .create(SearchApi.class)
                .recommendItem(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<RecommendEntity>() {
                    @Override
                    public void onSuccess(RecommendEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });

    }




    public void menuOnClick(){
        if(viewState.get()){
            EventBusUtil.sendEvent(new Event(ResultViewEnvent.VIEW_TWO));
        }else{

            EventBusUtil.sendEvent(new Event(ResultViewEnvent.VIEW_ONE));
        }
        viewState.set(!viewState.get());

    }
}
