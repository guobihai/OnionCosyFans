package cc.onion.cosyfans.my.viewdModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.my.api.MyApi;
import cc.onion.cosyfans.my.entity.TrackingDetailEntry;
import cc.onion.cosyfans.my.entity.TrackingInfoEntry;
import cc.onion.cosyfans.my.entity.request.OrderHistoryRequest;
import cc.onion.cosyfans.my.entity.request.OrderInComeRequest;

/**
 * 商家中心-查询订单物流
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.viewdModel
 * @ClassName: QueryTrackingViewModel
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/16 11:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/16 11:11
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class QueryTrackingViewModel extends AndroidViewModel {

    //订单号
   public ObservableField<String> orderNo = new ObservableField<>();

    public QueryTrackingViewModel(@NonNull Application application) {
        super(application);
    }


    /**
     * 查询物流订单列表
     *
     * @param listener
     */
    public void queryTrackingListInfo(ResponseListener<TrackingInfoEntry> listener) {
        OrderInComeRequest request = new OrderInComeRequest();
        request.setOrderNo(orderNo.get());
        request.putKeySign("orderNo", orderNo.get());
        request.sign();
        RetrofitManager.createToken(MyApi.class)
                .queryTrakingInfo(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<TrackingInfoEntry>() {
                    @Override
                    public void onSuccess(TrackingInfoEntry data) {
                        if (null != data && data.getStatus() == 200) {
                            if (null != listener) {

                                listener.loadSuccess(data);
                            }
                        } else {
                            if (null != listener) {

                                listener.loadFailed("-1", "data is null");
                            }
                        }
                    }

                    @Override
                    public void onError(String code, String msg) {
                        super.onError(code, msg);
                        if (null != listener) {

                            listener.loadFailed(code, msg);
                        }
                    }
                });
    }

    /**
     * 查询物流刻度信息
     *
     * @param listener
     */
    public void queryTrackingDetailInfo(String subOrderNo,ResponseListener<TrackingDetailEntry.DataBean> listener) {
        OrderInComeRequest request = new OrderInComeRequest();
        request.setOrderNo(subOrderNo);
        request.putKeySign("orderNo", subOrderNo);
        request.sign();
        RetrofitManager.createToken(MyApi.class)
                .queryTrakingDetailInfo(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<TrackingDetailEntry>() {
                    @Override
                    public void onSuccess(TrackingDetailEntry data) {
                        if (null != data && data.getStatus() == 200) {
                            if (null != listener) {

                                listener.loadSuccess(data.getData());
                            }
                        } else {
                            if (null != listener) {

                                listener.loadFailed("-1", "data is null");
                            }
                        }
                    }

                    @Override
                    public void onError(String code, String msg) {
                        super.onError(code, msg);
                        if (null != listener) {

                            listener.loadFailed(code, msg);
                        }
                    }
                });
    }

}
