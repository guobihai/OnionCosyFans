package cc.onion.cosyfans.my;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.Map;

import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.PreferencesUtils;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.my.api.MyApi;
import cc.onion.cosyfans.my.entity.MerchantInfo;

/**
 * 商家信息获取
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my
 * @ClassName: MerchantCenterViewModel
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/10 20:38
 * @UpdateUser: guobihai
 * @UpdateDate: 2020/1/10 20:38
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MerchantCenterViewModel extends AndroidViewModel {

    private static final String MY_HIDE_PRECD = "my_hide_preCD";//隐藏preCD
    private static final String MY_HIDE_ALL_INCOME = "my_allInCome_show";//
    private static final String MY_HIDE_ALL_SALE = "my_allSale_show";//

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> userLevel = new ObservableField<>();
    public ObservableField<String> logoUrl = new ObservableField<>();
    public ObservableField<String> allSale = new ObservableField<>();
    public ObservableField<String> allIncome = new ObservableField<>();
    public ObservableField<String> invitationCode = new ObservableField<>();

    public ObservableField<Drawable> imgAllSaleId = new ObservableField<>();
    public ObservableField<Drawable> imgAllInCome = new ObservableField<>();

    public ObservableBoolean isPreCD = new ObservableBoolean(false);

    private MerchantInfo.DataBean mDataBean;

    public MerchantCenterViewModel(@NonNull Application application) {
        super(application);
        imgAllSaleId.set(application.getResources().getDrawable(R.mipmap.my_tv_show_icon));
        imgAllInCome.set(application.getResources().getDrawable(R.mipmap.my_tv_show_icon));
    }

    /**
     * 获取商家信息
     *
     * @param responseListener
     */
    public void getMerchantCenterInfo(ResponseListener<MerchantInfo.DataBean> responseListener) {
        BaseRequestBean baseRequestBean = new BaseRequestBean();
        baseRequestBean.sign();
        RetrofitManager.createToken(MyApi.class)
                .getMerchantCenterInfo(baseRequestBean)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<MerchantInfo>() {
                    @Override
                    public void onSuccess(MerchantInfo data) {
                        if (null != data && data.getStatus() == 200) {
                            if (null != responseListener) {
                                mDataBean = data.getData();
                                if(null == mDataBean){
                                    responseListener.loadFailed(String.valueOf(data.getStatus()),"data is null");
                                    return;
                                }
                                name.set(mDataBean.getName());
                                userLevel.set(mDataBean.getUserLevel());
                                logoUrl.set(mDataBean.getLogoUrl());
                                allSale.set(mDataBean.getAllSale());
                                allIncome.set(mDataBean.getAllIncome());
                                invitationCode.set(mDataBean.getInvitationCode());
                                if (!PreferencesUtils.get(MY_HIDE_PRECD, false))
                                    isPreCD.set(!mDataBean.getIsPreCD().equals("0"));
                                initShowMoney();
                                responseListener.loadSuccess(mDataBean);
                            }
                        } else {
                            if (null != data && null != responseListener)
                                responseListener.loadFailed(String.valueOf(data.getStatus()), "network error");
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
     * 默认值
     */
    private void initShowMoney() {
        boolean bAllSale_show = PreferencesUtils.get(MY_HIDE_ALL_SALE, true);
        PreferencesUtils.set(MY_HIDE_ALL_SALE, !bAllSale_show);
        allSale.set(bAllSale_show ? mDataBean.getAllSale() : "****");
        imgAllSaleId.set(getApplication().getResources().getDrawable(bAllSale_show ? R.mipmap.my_tv_show_icon : R.mipmap.my_tv_hide_icon));
        boolean bAllInCome_show = PreferencesUtils.get(MY_HIDE_ALL_INCOME, true);
        PreferencesUtils.set(MY_HIDE_ALL_INCOME, !bAllInCome_show);
        allIncome.set(bAllInCome_show ? mDataBean.getAllIncome() : "****");
        imgAllInCome.set(getApplication().getResources().getDrawable(bAllInCome_show ? R.mipmap.my_tv_show_icon : R.mipmap.my_tv_hide_icon));
    }

    /**
     * 显示或者隐藏销售总额
     */
    public void hideOrShowAllSale() {
        if (null == mDataBean) return;
        boolean bAllSale_show = PreferencesUtils.get(MY_HIDE_ALL_SALE, true);
        PreferencesUtils.set(MY_HIDE_ALL_SALE, !bAllSale_show);
        allSale.set(bAllSale_show ? mDataBean.getAllSale() : "****");
        imgAllSaleId.set(getApplication().getResources().getDrawable(bAllSale_show ? R.mipmap.my_tv_show_icon : R.mipmap.my_tv_hide_icon));

    }

    /**
     * 显示或者隐藏累计收入
     */
    public void hideOrShowAllInCome() {
        if (null == mDataBean) return;
        boolean bAllInCome_show = PreferencesUtils.get(MY_HIDE_ALL_INCOME, true);
        PreferencesUtils.set(MY_HIDE_ALL_INCOME, !bAllInCome_show);
        allIncome.set(bAllInCome_show ? mDataBean.getAllIncome() : "****");
        imgAllInCome.set(getApplication().getResources().getDrawable(bAllInCome_show ? R.mipmap.my_tv_show_icon : R.mipmap.my_tv_hide_icon));
    }

    /**
     * 是否隐藏preCD
     */
    public void hideIsPreCDView() {
        isPreCD.set(false);
        PreferencesUtils.set(MY_HIDE_PRECD, true);
    }

    public void toEditMerchantInfo(){
        ARouter.getInstance().build(RouterPath.MyCosy.ROUTE_MIME_EDIT_MERCHANT).navigation();
    }

    //注册统计
    public void toJumpRegisterCount(){
        ARouter.getInstance().build(RouterPath.MyCosy.ROUTE_MIME_MERCHANT_REGISTE_COUNT).navigation();
    }



    //我的销售订单
    public void toJumpMyOrders(){
        ARouter.getInstance().build(RouterPath.MyCosy.ROUTE_MIME_MERCHANT_ORDERS).navigation();
    }
}
