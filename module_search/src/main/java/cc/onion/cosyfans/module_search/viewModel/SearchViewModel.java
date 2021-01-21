package cc.onion.cosyfans.module_search.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;

import org.greenrobot.eventbus.EventBus;

import cc.onion.cosyfans.base.entity.SearchHouseData;
import cc.onion.cosyfans.base.event.Event;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.EventBusUtil;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.base.viewmodel.SearchBaseViewModel;
import cc.onion.cosyfans.module_search.Envent.HoristerEnvent;
import cc.onion.cosyfans.module_search.SearchApi;
import cc.onion.cosyfans.module_search.entity.HotRequest;
import cc.onion.cosyfans.module_search.entity.SearchHotWordEntity;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_search.viewModel
 * @ClassName: SearchViewModel
 * @Description: 搜素
 * @Author: guobihai
 * @CreateDate: 2020-01-01 15:55
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-01 15:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SearchViewModel  extends SearchBaseViewModel<SearchHouseData> implements ItemClickListener  {

    public final ObservableField<String> searchText = new ObservableField<>();

    /**
     * 是否展示删除按钮
     */
    public final ObservableBoolean showDelete = new ObservableBoolean(false);


    public SearchViewModel(@NonNull Application application) {
        super(application);
    }


    /**
     * 加载热词
     * @param request
     * @param listener
     */
    public  void getHotWord(HotRequest  request, ResponseListener<SearchHotWordEntity> listener){
        RetrofitManager
                .create(SearchApi.class)
                .getSearchHot(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<SearchHotWordEntity>() {
                    @Override
                    public void onSuccess(SearchHotWordEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });

    }


    /**
     * 搜索
     */
    public  void toSearch(){
        EventBusUtil.sendEvent(new Event(HoristerEnvent.SAVE_DATA));
        ARouter.getInstance().build(RouterPath.Search.ROUTE_SEARCH_HOME_RESULT)
                .withString("searchWord",searchText.get())
                .greenChannel()
                .navigation();

    }


    /**
     * 删除搜素词语
     */
    public void deleteSearchWord(){
        searchText.set("");

    }
}
