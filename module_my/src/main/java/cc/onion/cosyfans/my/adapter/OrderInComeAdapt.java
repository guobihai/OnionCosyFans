package cc.onion.cosyfans.my.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.my.entity.OrderInComeEntry;

/**
 * 商家中心-我的订单-我的收益-适配器
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.adapter
 * @ClassName: OrderInComeAdapt
 * @Description: java类作用描述
 * @Author: 唐朝
 * @CreateDate: 2020/1/15 17:24
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/15 17:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderInComeAdapt extends BaseQuickAdapter<OrderInComeEntry.DataBean.OrderIncomeDTOListBean, BaseViewHolder> {
    public OrderInComeAdapt(@Nullable List<OrderInComeEntry.DataBean.OrderIncomeDTOListBean> data) {
        super(R.layout.my_order_income_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderInComeEntry.DataBean.OrderIncomeDTOListBean item) {
        helper.setText(R.id.tv_income_item_name,item.getItemName());
        helper.setText(R.id.tv_income_realFee,mContext.getResources().getString(R.string.my_monye_type).concat(item.getRealFee()));
        helper.setText(R.id.tv_income_realFee2,"(".concat(mContext.getResources().getString(R.string.my_monye_type).concat(item.getRealFee())).concat(")"));
        helper.setText(R.id.tv_income_item_count,"x".concat(String.valueOf(item.getItemNum())));
    }
}
