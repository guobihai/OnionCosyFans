package cc.onion.cosyfans.my.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.BaseFragment;
import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.exception.ExceptionCode;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.base.view.loadView.ULoadView;
import cc.onion.cosyfans.item.entity.SkuBaseEntity;
import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.module_my.databinding.MyFragmentPersonBindingImpl;
import cc.onion.cosyfans.my.PerssonalCenterViewModel;
import cc.onion.cosyfans.my.entity.MineEntity;
import io.reactivex.disposables.Disposable;

/**
 * 个人模块
 * @author anhuifx
 * @date 2019 -12-02
 */
public class PerssonalCenterFragment extends BaseFragment<MyFragmentPersonBindingImpl, PerssonalCenterViewModel> {

    private ULoadView loadVew;

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.my_fragment_person;
    }

    @Override
    public int initVariableId() {
        return cc.onion.cosyfans.module_my.BR.model;
    }


    @Override
    public void initData() {
        super.initData();
        loadVew = new ULoadView(mBinding.body);
        loadVew.showLoading();


        loadData();
    }

    private void loadData() {
        BaseRequestBean request  = new BaseRequestBean();
        request.sign();
        mViewModel.getUserCenter(request, new ResponseListener<MineEntity>() {
            @Override
            public void loadSuccess(MineEntity data) {
                loadVew.hide();
                KLog.i("test","加载我的数据成功");
                if(data.getData() != null){
                    if(StringUtils.isNotEmpty(data.getData().getInviteImage())){
                        BaseBindingAdapter.loadImage(mBinding.imgLogon,data.getData().getInviteImage());
                    }

                    //attritube
                    if(StringUtils.isNotEmpty(data.getData().getName())){
                        mViewModel.userName.set(data.getData().getName());
                    }

                    mViewModel.couponCount.set(data.getData().getCouponCount()+"可用优惠券");
                    mViewModel.unpaid.set(TypeUtils.toString(data.getData().getUnpaid()));
                    mViewModel.delivering.set(TypeUtils.toString(data.getData().getDelivering()));
                    mViewModel.afterSale.set(TypeUtils.toString(data.getData().getAfterSale()));
                }


            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                loadVew.hide();
                if (ExceptionCode.NO_NERWORK_ERROR.equals(errorCode)) {
                    loadVew.showNetworkError(v -> {
                        // 无网络
                        loadVew.showLoading();
                        loadData();
                    });
                } else {
                    loadVew.showError("数据加载失败：" + errorMsg, v -> {
                        loadVew.showLoading();
                        loadData();
                    });
                }
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }
}
