package cc.onion.cosyfans.my.viewdModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;

import java.util.Map;

import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.event.Event;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.utils.EventBusUtil;
import cc.onion.cosyfans.base.utils.JsonUtils;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.my.api.MyApi;
import cc.onion.cosyfans.my.entity.request.EdMerchantInfo;
import cc.onion.cosyfans.my.entity.ResMerchantInfo;

/**
 * 店铺信息编辑类
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.viewdModel
 * @ClassName: EditMerchantViewModel
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/11 15:16
 * @UpdateUser: guobihai
 * @UpdateDate: 2020/1/11 15:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class EditMerchantViewModel extends AndroidViewModel {

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> descIntrodution = new ObservableField<>();
    public ObservableInt shopId = new ObservableInt();

    public EditMerchantViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * 查询门店信息
     *
     * @param responseListener
     */
    public void queryShopInfo(ResponseListener<ResMerchantInfo.DataBean> responseListener) {
        BaseRequestBean baseRequestBean = new BaseRequestBean();
        baseRequestBean.sign();
        RetrofitManager.createToken(MyApi.class)
                .queryShopInfo(baseRequestBean)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<ResMerchantInfo>() {
                    @Override
                    public void onSuccess(ResMerchantInfo data) {
                        KLog.i("=info==" + JsonUtils.toJson(data));
                        if (null != data && data.getStatus() == 200) {
                            ResMerchantInfo.DataBean dataBean = data.getData();
                            if (null == dataBean) {
                                if (null != responseListener)
                                    responseListener.loadFailed(String.valueOf(data.getStatus()), "data is null");
                                return;
                            }
                            name.set(dataBean.getName());
                            descIntrodution.set(dataBean.getDiscription());
                            shopId.set(dataBean.getId());
                            if (null != responseListener)
                                responseListener.loadSuccess(dataBean);
                        } else {
                            if (null != responseListener && data != null)
                                responseListener.loadFailed(String.valueOf(data.getStatus()), data.getMsg());
                        }
                    }

                    @Override
                    public void onError(String code, String msg) {
                        super.onError(code, msg);
                        if (null != responseListener)
                            responseListener.loadFailed(code, msg);
                    }
                });
    }


    /**
     * 保存编辑信息
     * @param responseListener
     */
    public void saveData(ResponseListener<Boolean> responseListener) {
        String sname = name.get();
        String sdesc = descIntrodution.get();
        if (sname == null) return;
        if (sdesc == null) sdesc = "";
        EdMerchantInfo merchantInfo = new EdMerchantInfo(shopId.get(), sname, sdesc);
        merchantInfo.putKeySign("name", sname);
        merchantInfo.putKeySign("discription", sdesc);
        merchantInfo.putKeySign("id", shopId.get());
        merchantInfo.sign();
        RetrofitManager.createToken(MyApi.class)
                .updateShopInfo(merchantInfo)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<Map<String, Object>>() {
                    @Override
                    public void onSuccess(Map<String, Object> data) {
                        KLog.i("update shop info:" + JsonUtils.toJson(data));
                        if (null != data) {
                            String status = String.valueOf(data.get("status"));
                            if (status.contains("200")) {
                                if (null != responseListener)
                                    responseListener.loadSuccess(true);
                                EventBusUtil.sendEvent(new Event<String>("my_shopName".hashCode(), sname));
                            } else {
                                responseListener.loadFailed(String.valueOf(status), String.valueOf(data.get("msg")));
                            }
                        } else {
                            if (null != responseListener)
                                responseListener.loadFailed("-1", "data is null");
                        }

                    }

                    @Override
                    public void onError(String code, String msg) {
                        super.onError(code, msg);
                        if (null != responseListener)
                            responseListener.loadFailed(code, msg);
                    }
                });


    }


}
