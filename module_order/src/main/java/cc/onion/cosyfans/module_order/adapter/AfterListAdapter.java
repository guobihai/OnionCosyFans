package cc.onion.cosyfans.module_order.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.utils.TextMeoneryShowUtils;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.module_order.R;
import cc.onion.cosyfans.module_order.entity.OrderAfterEntity;
import cc.onion.cosyfans.module_order.entity.OrderListEntity;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_order.adapter
 * @ClassName: OrderListChildenAdapter
 * @Description: 订单列表孩子适配器
 * @Author: guobihai
 * @CreateDate: 2019-12-16 16:35
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-16 16:35
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AfterListAdapter extends BaseQuickAdapter<OrderAfterEntity.DataBean.ItemsBean, BaseViewHolder> {

    private Context mContext;

    public AfterListAdapter(@Nullable List<OrderAfterEntity.DataBean.ItemsBean> data, Context context) {
        super(R.layout.order_item_products_childen, data);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderAfterEntity.DataBean.ItemsBean item) {
        try {

            ImageView imgProducts = helper.getView(cc.onion.cosyfans.module_trade.R.id.img_products);
            BaseBindingAdapter.loadImage(imgProducts,item.getItemImage());
            helper.setText(cc.onion.cosyfans.module_trade.R.id.tv_childen_title,item.getItemName());
            helper.setText(cc.onion.cosyfans.module_trade.R.id.tv_sku,item.getSpecification());

            TextView tv_childen_monery = helper.getView(cc.onion.cosyfans.module_trade.R.id.tv_childen_monery);
            TextMeoneryShowUtils.setShowBigMonery(tv_childen_monery, TypeUtils.toString(item.getRealFee()));

            helper.setText(cc.onion.cosyfans.module_trade.R.id.tv_size, "x"+TypeUtils.toString(item.getBuyNum()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
