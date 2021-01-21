package cc.onion.cosyfans.module_order.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cc.onion.cosyfans.base.BaseToolBarActivity;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.module_order.OrderMainViewModel;
import cc.onion.cosyfans.module_order.R;
import cc.onion.cosyfans.module_order.adapter.OrderPagerAdapter;
import cc.onion.cosyfans.module_order.databinding.OrdreMainBinding;
import cc.onion.cosyfans.module_order.fragment.OrderListFragment;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_order
 * @ClassName: OrderMainActivity
 * @Description: 订单模块主界面
 * @Author: guobihai
 * @CreateDate: 2019-12-16 13:49
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-16 13:49
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = RouterPath.Order.ROUTE_ORDER_MAIN)
public class OrderMainActivity extends BaseToolBarActivity<OrdreMainBinding, OrderMainViewModel> implements ViewPager.OnPageChangeListener {



    private String[] titles = new String[]{"全部订单", "待支付", "待收货","售后"};
    private ViewPager viewPager;
    private List<Fragment> tabs;

    @Autowired
    int orderType;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordre_main);
        setToolbarTitle(R.string.order_titile);

        // 避免过度绘制
        getWindow().setBackgroundDrawable(null);

        initWithUI();



    }

    @Override
    public void initParam() {
        ARouter.getInstance().inject(this);
    }




    private void initWithUI() {
        TabLayout tabLayout = findViewById(R.id.tab_title);
        tabs = new ArrayList<>();

        /**
         * 全部
         */
        OrderListFragment orderAll = (OrderListFragment) ARouter
                .getInstance()
                .build(RouterPath.Order.ROUTE_ORDER_DETAIL_Fragment)
                .withString("statusType", "0")
                .navigation();
//
        /**
         * 带支付
         */
        OrderListFragment orderWithPayMent = (OrderListFragment) ARouter
                .getInstance()
                .build(RouterPath.Order.ROUTE_ORDER_DETAIL_Fragment)
                .withString("statusType", "1")
                .navigation();
        /**
         * 待收货
         */
        OrderListFragment orderReceipt = (OrderListFragment) ARouter
                .getInstance()
                .build(RouterPath.Order.ROUTE_ORDER_DETAIL_Fragment)
                .withString("statusType", "2")
                .navigation();

        /**
         * 售后
         */
        OrderListFragment orderAfterSale = (OrderListFragment) ARouter
                .getInstance()
                .build(RouterPath.Order.ROUTE_ORDER_DETAIL_Fragment)
                .withString("statusType", "3")
                .navigation();



        tabs.add(orderAll);
        tabs.add(orderWithPayMent);
        tabs.add(orderReceipt);
        tabs.add(orderAfterSale);


        viewPager = findViewById(R.id.view_page);
        viewPager.setOffscreenPageLimit(2);
        viewPager.addOnPageChangeListener(this);
        tabLayout.setupWithViewPager(viewPager);

        OrderPagerAdapter pagerAdapter = new OrderPagerAdapter(getSupportFragmentManager(), tabs, Arrays.asList(titles));
        viewPager.setAdapter(pagerAdapter);
//        /**
//         * 跳往指定界面
//         */
//        if(orderType != 0){
//            tabLayout.setSelectedTabIndicator(orderType);
//        }
    }


    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        ((OrderListFragment) (tabs.get(viewPager.getCurrentItem()))).filterData(i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
