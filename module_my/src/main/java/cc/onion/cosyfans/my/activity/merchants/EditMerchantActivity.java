package cc.onion.cosyfans.my.activity.merchants;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

import cc.onion.cosyfans.base.BaseToolBarActivity;
import cc.onion.cosyfans.base.dialog.LoadingDialog;
import cc.onion.cosyfans.base.exception.ExceptionCode;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.view.loadView.ULoadView;
import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.module_my.databinding.MyEditMerchantActivityBinding;
import cc.onion.cosyfans.my.entity.ResMerchantInfo;
import cc.onion.cosyfans.my.viewdModel.EditMerchantViewModel;
import io.reactivex.disposables.Disposable;

/**
 * 编辑商家店铺
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.activity
 * @ClassName: EditMerchantActivity
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/11 14:17
 * @UpdateUser: guobihai
 * @UpdateDate: 2020/1/11 14:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = RouterPath.MyCosy.ROUTE_MIME_EDIT_MERCHANT)
public class EditMerchantActivity extends BaseToolBarActivity<MyEditMerchantActivityBinding, EditMerchantViewModel> {

    private ULoadView uLoadView;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_edit_merchant_activity);
        setToolbarTitle(getString(R.string.my_show_merchant_title));
        mBinding.setEdViewModel(mViewModel);
        mBinding.myEdSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    @Override
    public void initData() {
        super.initData();
        uLoadView = new ULoadView(mBinding.body);
        uLoadView.showLoading();
        loadingDialog = new LoadingDialog(this);
        loadData();
    }

    /**
     * 加载门店信息
     */
    private void loadData() {
        mViewModel.queryShopInfo(new ResponseListener<ResMerchantInfo.DataBean>() {
            @Override
            public void loadSuccess(ResMerchantInfo.DataBean data) {
                uLoadView.hide();
            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                uLoadView.hide();
                if (ExceptionCode.NO_NERWORK_ERROR.equals(errorCode)) {
                    uLoadView.showNetworkError(v -> {
                        // 无网络
                        uLoadView.showLoading();
                        loadData();
                    });
                } else {
                    uLoadView.showError(getString(R.string.my_load_error_data) + errorMsg, v -> {
                        uLoadView.showLoading();
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


    private void saveData() {
        String name = mViewModel.name.get();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, getText(R.string.my_toast_input_name), Toast.LENGTH_SHORT).show();
            return;
        }
        loadingDialog.show();
        mViewModel.saveData(new ResponseListener<Boolean>() {
            @Override
            public void loadSuccess(Boolean data) {
                loadingDialog.dismiss();
                finish();
            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                loadingDialog.dismiss();
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });


    }

}
