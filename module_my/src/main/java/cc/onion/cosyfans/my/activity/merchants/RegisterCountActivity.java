package cc.onion.cosyfans.my.activity.merchants;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.base.BaseActivity;
import cc.onion.cosyfans.base.BaseToolBarActivity;
import cc.onion.cosyfans.base.dialog.LoadingDialog;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.JsonUtils;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.view.loadView.ULoadView;
import cc.onion.cosyfans.module_my.BR;
import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.module_my.databinding.MyRegisterCountActivityBinding;
import cc.onion.cosyfans.my.adapter.RegisterUserCountAdapt;
import cc.onion.cosyfans.my.dialogs.NoTrackingDetialDialog;
import cc.onion.cosyfans.my.dialogs.UserDetailIncomeDialog;
import cc.onion.cosyfans.my.entity.RegisterCosyTypeEntry;
import cc.onion.cosyfans.my.entity.RegisterUserDetailEntry;
import cc.onion.cosyfans.my.entity.UserStatisticsDetails;
import cc.onion.cosyfans.my.viewdModel.RegisterCountViewModel;
import io.reactivex.disposables.Disposable;

/**
 * 用户注册统计
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.activity.merchants
 * @ClassName: RegisterCountActivity
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/17 10:36
 * @UpdateUser: guobihai
 * @UpdateDate: 2020/1/17 10:36
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = RouterPath.MyCosy.ROUTE_MIME_MERCHANT_REGISTE_COUNT)
public class RegisterCountActivity extends BaseActivity<MyRegisterCountActivityBinding, RegisterCountViewModel> {

    private RegisterUserCountAdapt mRegisterUserCountAdapt;
    private List<RegisterUserDetailEntry.DataBean> mList;

    private ULoadView uLoadView;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding.setViewModel(mViewModel);
        initLayout();
    }


    private void initLayout() {
        mBinding.toolbar.setNavigationOnClickListener(v -> {
            onBackPressed();
        });
        uLoadView = new ULoadView(mBinding.nelNestedScrollView);
        uLoadView.showLoading();
        loadingDialog = new LoadingDialog(this);
        mList = new ArrayList<>();
        mRegisterUserCountAdapt = new RegisterUserCountAdapt(mList);
        mBinding.rvRegiestRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvRegiestRecycleView.setAdapter(mRegisterUserCountAdapt);
        mRegisterUserCountAdapt.setEmptyView(R.layout.my_nodata_layout, mBinding.rvRegiestRecycleView);

        mRegisterUserCountAdapt.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                RegisterUserDetailEntry.DataBean dataBean = mRegisterUserCountAdapt.getData().get(position);
                queryUserStatisticsDetails(dataBean.getUserIdxCode());
            }
        });
        mBinding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String value = s.toString();
                mViewModel.showDelete.set(value.length() > 0);
            }
        });
        mBinding.tvSearch.setOnClickListener(v -> {
            loadingDialog.show();
            queryRegisterUserDetialInfo();
        });
        String[] gradeList = this.getResources().getStringArray(R.array.my_spinner_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.my_spinner_checked_text, gradeList) {
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.my_spinner_item_layout, parent, false);
                TextView label = (TextView) view.findViewById(R.id.spinner_item_label);
                ImageView check = (ImageView) view.findViewById(R.id.spinner_item_checked_image);
                label.setText(gradeList[position]);
                return view;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mBinding.selectSpinner.setAdapter(adapter);
    }

    @Override
    public void initData() {
        super.initData();
        loadRegisterUserInfo();
        queryRegisterUserDetialInfo();
        mViewModel.customerUnitPriceTitle.set(getString(R.string.my_item_per_cus).concat(String.format("(%s)", getString(R.string.my_monye_type))));
        mViewModel.retailCountTitle.set(getString(R.string.my_item_total_sales).concat(String.format("(%s)", getString(R.string.my_monye_type))));
        mViewModel.totalEarningsTitle.set(getString(R.string.my_item_total_incomes).concat(String.format("(%s)", getString(R.string.my_monye_type))));
        mViewModel.refundCountTitle.set(getString(R.string.my_item_total_refund).concat(String.format("(%s)", getString(R.string.my_monye_type))));
        mViewModel.refundEarningsTitle.set(getString(R.string.my_item_refund_incomes).concat(String.format("(%s)", getString(R.string.my_monye_type))));
    }


    /**
     * 用户注册统计主信息
     */
    private void loadRegisterUserInfo() {
        mViewModel.queryRegisterUserInfo(new ResponseListener<RegisterCosyTypeEntry.DataBean>() {
            @Override
            public void loadSuccess(RegisterCosyTypeEntry.DataBean data) {
                uLoadView.hide();

            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                uLoadView.hide();
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }


    /**
     * 用户列表
     */
    private void queryRegisterUserDetialInfo() {
        mViewModel.queryRegisterUserDetialInfo(new ResponseListener<RegisterUserDetailEntry>() {
            @Override
            public void loadSuccess(RegisterUserDetailEntry data) {
                loadingDialog.dismiss();
                if (null != data.getData())
                    mRegisterUserCountAdapt.setNewData(data.getData());
            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                loadingDialog.dismiss();
                ToastUtil.Short(errorMsg);
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }


    /**
     * 当个用户的收益信息
     *
     * @param userIndexNo
     */
    private void queryUserStatisticsDetails(int userIndexNo) {
        loadingDialog.show();
        mViewModel.queryUserStatisticsDetails(userIndexNo, new ResponseListener<UserStatisticsDetails.DataBean>() {
            @Override
            public void loadSuccess(UserStatisticsDetails.DataBean data) {
                loadingDialog.dismiss();
                if (null != data) {
                    new UserDetailIncomeDialog(RegisterCountActivity.this, data).show();
                } else {
                    new NoTrackingDetialDialog(RegisterCountActivity.this).show();
                }
            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                ToastUtil.Short(errorMsg);
                loadingDialog.dismiss();
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.my_register_count_activity;
    }

    @Override
    public int initVariableId() {
        return cc.onion.cosyfans.module_my.BR.viewModel;
    }


}
