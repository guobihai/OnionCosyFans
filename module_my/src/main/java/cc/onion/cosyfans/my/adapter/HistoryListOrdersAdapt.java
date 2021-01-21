package cc.onion.cosyfans.my.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.my.entity.OrderListEntity;
import cc.onion.cosyfans.my.entity.request.OrderHistoryRequest;
import cc.onion.cosyfans.my.entity.request.OrderInComeRequest;
import cc.onion.cosyfans.my.interfaces.ItemOnClickInterface;

/**
 * 商品中心-我的订单 适配器
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.orders
 * @ClassName: HistoryListOrdersAdapt
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/14 14:20
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/14 14:20
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HistoryListOrdersAdapt extends BaseQuickAdapter<OrderListEntity.DataBean.OrderListBean, BaseViewHolder> {

    private static final int SHOW_PRODUCT_COUNT = 2;
    private ItemOnClickInterface<String> itemOnClickInterface;

    public void setItemOnClickInterface(ItemOnClickInterface<String> itemOnClickInterface) {
        this.itemOnClickInterface = itemOnClickInterface;
    }

    public HistoryListOrdersAdapt(@Nullable List<OrderListEntity.DataBean.OrderListBean> data) {
        super(R.layout.my_item_orders_layout, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, OrderListEntity.DataBean.OrderListBean item) {
        List<OrderListEntity.DataBean.OrderListBean.OrderItemListBean> orderItemList = item.getOrderItemList();
        TextView tvShowOrderNoValue = helper.getView(R.id.tvShowOrderNoValue);
        TextView tvShowOrderNoStatus = helper.getView(R.id.tvShowOrderNoStatus);
        TextView tvProductMoney = helper.getView(R.id.tvProductMoney);
        TextView tvProductCountValue = helper.getView(R.id.tvProductCountValue);
        TextView tvConsigne = helper.getView(R.id.tvConsigne);
        Button btnOrderIncome = helper.getView(R.id.btn_order_income);
        Button btnOrderTracking = helper.getView(R.id.btn_order_tracking);
        tvShowOrderNoValue.setText(item.getOrderNo());
        tvShowOrderNoStatus.setText(item.getOrderStatus());
        tvProductMoney.setText(item.getOrderTotalFee());
        tvConsigne.setText(item.getUserName());
        LinearLayout linearLayout = helper.getView(R.id.llOrderLayout);
        LinearLayout llcheckOrderIncome = helper.getView(R.id.llcheckOrderIncome);
        switch (item.getOrderStatusCode()){
            case OrderHistoryRequest.ORDER_COMPLETE:
                llcheckOrderIncome.setVisibility(item.getOrderStatusCode() == OrderHistoryRequest.ORDER_COMPLETE ? View.VISIBLE : View.GONE);
                btnOrderIncome.setText(mContext.getResources().getString(R.string.my_order_income));
                btnOrderTracking.setVisibility(View.VISIBLE);
                break;
                case OrderHistoryRequest.ORDER_RETURNING:
                    btnOrderTracking.setVisibility(View.GONE);
                    btnOrderIncome.setText(mContext.getResources().getString(R.string.my_order_outcome));
                    break;
                default:
                    break;
        }
        ImageView imgShowMoreProduct = helper.getView(R.id.img_show_more_product);
        if (null != orderItemList && orderItemList.size() > 0) {
            int size = orderItemList.size();
            imgShowMoreProduct.setVisibility(size > SHOW_PRODUCT_COUNT ? View.VISIBLE : View.GONE);
            tvProductCountValue.setText(String.valueOf(size));
            linearLayout.removeAllViews();
            if (size > SHOW_PRODUCT_COUNT) {
                int showSize = !item.isShowMore() ? SHOW_PRODUCT_COUNT : orderItemList.size();
                for (int i = 0; i < showSize; i++) {
                    OrderListEntity.DataBean.OrderListBean.OrderItemListBean orderItemListBean = orderItemList.get(i);
                    itemProduct(linearLayout, orderItemListBean);
                }
            } else {
                for (OrderListEntity.DataBean.OrderListBean.OrderItemListBean orderItemListBean : orderItemList) {
                    itemProduct(linearLayout, orderItemListBean);
                }
            }
            imgShowMoreProduct.setOnClickListener(v -> {
                item.setShowMore(!item.isShowMore());
                imgShowMoreProduct.setImageResource(!item.isShowMore() ? R.mipmap.icon_filter_arrow_uncheck :
                        R.mipmap.icon_filter_arrow_checked);
                notifyDataSetChanged();
            });
        }
        btnOrderIncome.setOnClickListener(v -> {
            if (null != itemOnClickInterface) {
                
                itemOnClickInterface.onClick(v, item.getOrderNo(), item.getOrderStatusCode());
            }
        });
        btnOrderTracking.setOnClickListener(v -> {
            if (null != itemOnClickInterface) {

                itemOnClickInterface.onClick(v, item.getOrderNo(), item.getOrderStatusCode());
            }
        });

    }


    private void itemProduct(LinearLayout linearLayout,
                             OrderListEntity.DataBean.OrderListBean.OrderItemListBean orderItemListBean) {
        View orderView = LayoutInflater.from(mContext).inflate(R.layout.my_item_product_layout, linearLayout, false);
        ImageView imgProduct = orderView.findViewById(R.id.img_products);
        TextView tvProductName = orderView.findViewById(R.id.tv_product_name);
        TextView tvProductDesc = orderView.findViewById(R.id.tv_product_desc);
        TextView tvProductPrice = orderView.findViewById(R.id.tv_product_price);
        TextView tvProductNum = orderView.findViewById(R.id.tv_product_num);
        tvProductName.setText(orderItemListBean.getItemName());
        tvProductDesc.setText(orderItemListBean.getSpecification());
        tvProductPrice.setText(orderItemListBean.getSaleFee());
        tvProductNum.setText("x".concat(String.valueOf(orderItemListBean.getBuyNum())));
        if (!TextUtils.isEmpty(orderItemListBean.getImage())) {
            BaseBindingAdapter.loadImage(imgProduct, orderItemListBean.getImage());
        }
        linearLayout.addView(orderView);
        orderView.setOnClickListener(v -> {
            String itemId = orderItemListBean.getItemId();
            KLog.i("========itemId=========" + itemId);
            ARouter.getInstance()
                    .build(RouterPath.Item.ROUTE_ITEM_PRODUCTS_PATH)
                    .withString("itemId", itemId).navigation(mContext);
        });
    }
}
