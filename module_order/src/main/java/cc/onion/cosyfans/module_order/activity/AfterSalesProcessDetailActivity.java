package cc.onion.cosyfans.module_order.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;

import cc.onion.cosyfans.base.BaseToolBarActivity;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.module_order.R;
import cc.onion.cosyfans.module_order.databinding.OrderAfterProcessDetailBinding;
import cc.onion.cosyfans.module_order.viewModel.AfterSalesProcessDetailViewModel;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_order.activity
 * @ClassName: AfterSalesProcessDetailActivity
 * @Description: 售后流程界面
 * @Author: guobihai
 * @CreateDate: 2019-12-31 15:27
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-31 15:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = RouterPath.Order.ROUTE_ORDER_DETAIL_AFTER_SALSE_DETAIL)
public class AfterSalesProcessDetailActivity extends BaseToolBarActivity<OrderAfterProcessDetailBinding, AfterSalesProcessDetailViewModel> {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_after_process_detail);
        setTitle(R.string.order_after_Sale);
    }
}
