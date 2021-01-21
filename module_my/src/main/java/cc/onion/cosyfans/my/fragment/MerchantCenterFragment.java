package cc.onion.cosyfans.my.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.BaseFragment;
import cc.onion.cosyfans.base.event.Event;
import cc.onion.cosyfans.base.exception.ExceptionCode;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.utils.EventBusUtil;
import cc.onion.cosyfans.base.utils.JsonUtils;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.view.loadView.ULoadView;
import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.module_my.databinding.MyFragmentMerchantBinding;
import cc.onion.cosyfans.my.MerchantCenterViewModel;
import cc.onion.cosyfans.my.PerssonalCenterViewModel;
import cc.onion.cosyfans.my.entity.MerchantInfo;
import io.reactivex.disposables.Disposable;

/**
 * 商家中心模块
 * @author anhuifx
 * @date 2019 -12-02
 */
public class MerchantCenterFragment extends BaseFragment<MyFragmentMerchantBinding, MerchantCenterViewModel> {

    private ULoadView loadVew;
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.my_fragment_merchant;
    }

    @Override
    public int initVariableId() {
        return cc.onion.cosyfans.module_my.BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        loadVew = new ULoadView(mBinding.body);
        loadVew.showLoading();
        loadData();
    }

    private void loadData() {
        mViewModel.getMerchantCenterInfo(new ResponseListener<MerchantInfo.DataBean>() {
            @Override
            public void loadSuccess(MerchantInfo.DataBean data) {
                loadVew.hide();
                if(!TextUtils.isEmpty(data.getLogoUrl())){
                    BaseBindingAdapter.loadImage(mBinding.imgIcon,data.getLogoUrl());
                }
            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                KLog.i("errorCode:"+errorMsg);
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

    @Override
    public void initParam() {
        super.initParam();
        EventBusUtil.register(this);
    }

    @Subscribe(threadMode= ThreadMode.MAIN)
    public void onEvent(Event event) {
        int code = event.getCode();
        if (code=="my_shopName".hashCode()) {
            mViewModel.name.set(event.getData().toString());
        }
    }
    @Override
    protected void onUnbind() {
        super.onUnbind();
        EventBusUtil.unregister(this);
    }
}
