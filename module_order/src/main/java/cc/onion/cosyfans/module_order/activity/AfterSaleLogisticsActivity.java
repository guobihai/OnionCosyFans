package cc.onion.cosyfans.module_order.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;

import cc.onion.cosyfans.base.BaseToolBarActivity;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.module_order.R;
import cc.onion.cosyfans.module_order.databinding.OrderAfterLogsicBinding;
import cc.onion.cosyfans.module_order.viewModel.AfterSaleLogisticsViewModel;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_order.activity
 * @ClassName: AfterSaleLogisticsActivity
 * @Description: 售后物流回填界面
 * @Author: guobihai
 * @CreateDate: 2019-12-31 15:54
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-31 15:54
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = RouterPath.Order.ROUTE_ORDER_DETAIL_AFTER_SALSE_DETAIL_COMMIT)
public class AfterSaleLogisticsActivity extends BaseToolBarActivity<OrderAfterLogsicBinding, AfterSaleLogisticsViewModel> {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_layout_logistics);
        setToolbarTitle(R.string.order_logistics);

    }
}
