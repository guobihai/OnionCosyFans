package cc.onion.cosyfans.my.viewdModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;

import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.my.api.MyApi;
import cc.onion.cosyfans.my.entity.AddressListEntity;
import cc.onion.cosyfans.my.entity.request.AddressRequest;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my
 * @ClassName: AddressListAndroidViewModel
 * @Description: 地址model
 * @Author: guobihai
 * @CreateDate: 2019-12-11 10:55
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-11 10:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AddressListAndroidViewModel extends AndroidViewModel {

    public final ObservableField<Boolean> isShow = new ObservableField<Boolean>(false);

    public AddressListAndroidViewModel(@NonNull Application application) {
        super(application);
        isShow.set(true);
    }


    public void addNewAddress(){

        ARouter.getInstance().build(RouterPath.MyCosy.ROUTE_MIME_ADDRESS_ADD)
                .greenChannel()
                .navigation();
    }

    /**
     * 获取地址列表
     * @param request
     * @param listener
     */
    public void getAddressList(AddressRequest request, ResponseListener<AddressListEntity> listener){
        RetrofitManager
                .createToken(MyApi.class)
                .getAddressList(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<AddressListEntity>() {
                    @Override
                    public void onSuccess(AddressListEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }

}
