package cc.onion.cosyfans.my.activity.address;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;

import cc.onion.cosyfans.base.BaseToolBarActivity;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.module_my.databinding.MyAddressAddBinding;
import cc.onion.cosyfans.module_my.databinding.MyAddressAddBindingImpl;
import cc.onion.cosyfans.module_my.databinding.MyAddressListBinding;
import cc.onion.cosyfans.my.viewdModel.AddAddressViewModel;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.activity.address
 * @ClassName: AddAddressActivity
 * @Description: 添加地址
 * @Author: guobihai
 * @CreateDate: 2019-12-11 10:53
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-11 10:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = RouterPath.MyCosy.ROUTE_MIME_ADDRESS_ADD)
public class AddAddressActivity extends BaseToolBarActivity<MyAddressAddBinding,AddAddressViewModel>{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_address_add);
        setToolbarTitle("新增收货地址");
        mBinding.setModel(mViewModel);
    }
}
