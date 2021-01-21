package cc.onion.cosyfans.my.viewdModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;

import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.utils.JsonUtils;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.my.api.MyApi;
import cc.onion.cosyfans.my.entity.RegisterCosyTypeEntry;
import cc.onion.cosyfans.my.entity.RegisterUserDetailEntry;
import cc.onion.cosyfans.my.entity.UserStatisticsDetails;
import cc.onion.cosyfans.my.entity.request.RegisterUerDetailRequest;
import cc.onion.cosyfans.my.entity.request.RegisterUserRequest;
import cc.onion.cosyfans.my.entity.request.StatisticUerDetailRequest;

/**
 * 用户注册统计
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.viewdModel
 * @ClassName: RegisterCountViewModel
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/17 11:07
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/17 11:07
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class RegisterCountViewModel extends AndroidViewModel {

    //注册人数
    public ObservableField<String> registerUserCount = new ObservableField<>();
    public ObservableField<String> billingCount = new ObservableField<>();
    public ObservableField<String> orderCount = new ObservableField<>();
    public ObservableField<String> customerUnitPriceTitle = new ObservableField<>();
    public ObservableField<String> customerUnitPrice = new ObservableField<>();
    public ObservableField<String> retailCountTitle = new ObservableField<>();
    public ObservableField<String> retailCount = new ObservableField<>();
    public ObservableField<String> totalEarningsTitle = new ObservableField<>();
    public ObservableField<String> totalEarnings = new ObservableField<>();
    public ObservableField<String> refundCountTitle = new ObservableField<>();
    public ObservableField<String> refundCount = new ObservableField<>();
    public ObservableField<String> refundEarningsTitle = new ObservableField<>();
    public ObservableField<String> refundEarnings = new ObservableField<>();
    public ObservableField<String> directCd = new ObservableField<>();
    public ObservableField<String> indirectCd = new ObservableField<>();
    //10: Cosy Friend、15:Pre-Cosy Discoveries，20: Cosy Discoveries、30: Cosy Partner、40: Cosy Globalist
    public ObservableInt level = new ObservableInt(20);
    public ObservableField<String> levelName = new ObservableField<String>();


    //搜索
    //搜索输入内容
    public final ObservableField<String> searchText = new ObservableField<>();
    /**
     * 是否展示删除按钮
     */
    public final ObservableBoolean showDelete = new ObservableBoolean(false);


    public RegisterCountViewModel(@NonNull Application application) {
        super(application);
    }


    //解析角色
    private String praseRoleByLevel(int type) {
        switch (type) {
            case 10:
                return "Cosy Friend";
            case 15:
                return "Pre-Cosy";
            case 20:
                return "Cosy Discoveries";
            case 30:
                return "Cosy Partner";
            case 40:
                return "Cosy Globalist";
            default:
                return "Cosy Friend";
        }
    }

    /**
     * 查询注册用户统计信息
     *
     * @param listener
     */
    public void queryRegisterUserInfo(ResponseListener<RegisterCosyTypeEntry.DataBean> listener) {
        RetrofitManager.createToken(MyApi.class)
                .queryRegisterUserInfo(new RegisterUserRequest(4))
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<RegisterCosyTypeEntry>() {
                    @Override
                    public void onSuccess(RegisterCosyTypeEntry data) {
                        if (null == listener) return;
                        if (null != data) {
                            if (data.getStatus() == 200) {
                                RegisterCosyTypeEntry.DataBean dataBean = data.getData();
                                registerUserCount.set(String.valueOf(dataBean.getRegisterCount()));
                                billingCount.set(String.valueOf(dataBean.getBillingCount()));
                                orderCount.set(String.valueOf(dataBean.getOrderCount()));
                                customerUnitPrice.set(dataBean.getCustomerUnitPrice());
                                retailCount.set(dataBean.getRetailCount());
                                totalEarnings.set(dataBean.getTotalEarnings());
                                refundCount.set(dataBean.getRefundCount());
                                refundEarnings.set(dataBean.getRefundEarnings());
                                directCd.set(String.valueOf(dataBean.getDirectCd()));
                                indirectCd.set(String.valueOf(dataBean.getIndirectCd()));
                                level.set(dataBean.getLevel());
                                levelName.set(praseRoleByLevel(dataBean.getLevel()));
                                listener.loadSuccess(dataBean);
                            } else {
                                listener.loadFailed(String.valueOf(data.getStatus()), data.getMsg());
                            }
                        } else {
                            listener.loadFailed("-1", "data is null");
                        }
                    }

                    @Override
                    public void onError(String code, String msg) {
                        super.onError(code, msg);
                        if (null == listener) return;
                        listener.loadFailed(code, msg);
                    }
                });
    }


    /**
     * 用户详情列表
     */
    public void queryRegisterUserDetialInfo(ResponseListener<RegisterUserDetailEntry> listener) {
        RetrofitManager.createToken(MyApi.class)
                .queryRegisterUserDetailInfo(new RegisterUerDetailRequest(searchText.get(),1, 2))
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<RegisterUserDetailEntry>() {
                    @Override
                    public void onSuccess(RegisterUserDetailEntry data) {
                        if (null == listener) return;
                        if (null != data) {
                            if (data.getStatus() == 200) {
                                listener.loadSuccess(data);
                            } else {
                                listener.loadFailed(String.valueOf(data.getStatus()), data.getMsg());
                            }
                        } else {
                            listener.loadFailed("-1", "data is null");
                        }
                    }

                    @Override
                    public void onError(String code, String msg) {
                        super.onError(code, msg);
                        if (null == listener) return;
                        listener.loadFailed(code, msg);
                    }
                });
    }


    /**
     * 注册用户统计-用户订单详情
     *
     * @param listener
     */
    public void queryUserStatisticsDetails(int userIndexNo, ResponseListener<UserStatisticsDetails.DataBean> listener) {
        RetrofitManager.createToken(MyApi.class)
                .queryUserStatisticsDetails(new StatisticUerDetailRequest(userIndexNo))
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<UserStatisticsDetails>() {
                    @Override
                    public void onSuccess(UserStatisticsDetails data) {
                        if (null == listener) return;
                        if (null != data) {
                            if (data.getStatus() == 200) {
                                listener.loadSuccess(data.getData());
                            } else {
                                listener.loadFailed(String.valueOf(data.getStatus()), data.getMsg());
                            }
                        } else {
                            listener.loadFailed("-1", "data is null");
                        }
                    }

                    @Override
                    public void onError(String code, String msg) {
                        super.onError(code, msg);
                        if (null == listener) return;
                        listener.loadFailed(code, msg);
                    }
                });
    }


    //搜索
    public void toSearch(ResponseListener<RegisterUserDetailEntry> listener){
        queryRegisterUserDetialInfo(listener);
    }

    public void deleteSearchWord(){
        searchText.set("");
    }
}
