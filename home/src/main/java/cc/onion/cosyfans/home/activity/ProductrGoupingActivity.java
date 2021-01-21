package cc.onion.cosyfans.home.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;

import cc.onion.cosyfans.base.BaseToolBarActivity;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.home.viewmodel.ProductrGoupingViewModel;
import cc.onion.cosyfans.module_home.R;
import cc.onion.cosyfans.module_home.databinding.HomeProductGroupBinding;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.home.activity
 * @ClassName: ProductrGoupingActivity
 * @Description: 产品分组界面
 * @Author: guobihai
 * @CreateDate: 2019-12-19 19:57
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-19 19:57
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = RouterPath.Features.ROUTE_QRCODE_SCAN)
public class ProductrGoupingActivity extends BaseToolBarActivity<HomeProductGroupBinding, ProductrGoupingViewModel> {

    @Autowired
    private String titleName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_product_group);
        setToolbarTitle(titleName);
    }
}
