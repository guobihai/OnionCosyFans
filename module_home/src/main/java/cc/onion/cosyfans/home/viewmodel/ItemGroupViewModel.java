package cc.onion.cosyfans.home.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.home.api.HomeApiServer;
import cc.onion.cosyfans.home.entity.ContextModelRequest;
import cc.onion.cosyfans.home.entity.response.AlbumRequest;
import cc.onion.cosyfans.home.entity.response.AlumGroupEntity;
import cc.onion.cosyfans.home.entity.response.GroupItemEntity;
import cc.onion.cosyfans.home.entity.response.GroupListRequest;
import cc.onion.cosyfans.home.entity.response.GroupRequest;
import cc.onion.cosyfans.home.entity.response.TableEntity;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.home.viewmodel
 * @ClassName: ItemGroupViewModel
 * @Description: 专题分组模块
 * @Author: guobihai
 * @CreateDate: 2019-12-25 14:43
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-25 14:43
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ItemGroupViewModel extends AndroidViewModel {

    public final ObservableField<String> context = new ObservableField<>();

    public ItemGroupViewModel(@NonNull Application application) {
        super(application);
    }


    /**
     * 获取专辑列表数据
     * @param request
     * @param listener
     */
    public void getGroupItem(GroupListRequest request, ResponseListener<GroupItemEntity> listener){
        RetrofitManager
                .create(HomeApiServer.class)
                .getGroupItem(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<GroupItemEntity>() {
                    @Override
                    public void onSuccess(GroupItemEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }


    /**
     * 获取专辑热销数据
     * @param request
     * @param listener
     */
    public void getHotGroupItem(GroupRequest request, ResponseListener<GroupItemEntity> listener){
        RetrofitManager
                .create(HomeApiServer.class)
                .getGroupHotItem(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<GroupItemEntity>() {
                    @Override
                    public void onSuccess(GroupItemEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }


    /**
     * 获取专辑数据
     * @param request
     * @param listener
     */
    public void getAlbumData(AlbumRequest request, ResponseListener<AlumGroupEntity> listener){
        RetrofitManager
                .create(HomeApiServer.class)
                .getAlbumData(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<AlumGroupEntity>() {
                    @Override
                    public void onSuccess(AlumGroupEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }



}
