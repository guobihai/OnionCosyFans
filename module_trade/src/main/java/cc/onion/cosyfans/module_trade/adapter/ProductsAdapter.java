package cc.onion.cosyfans.module_trade.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.utils.TextMeoneryShowUtils;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.module_trade.R;
import cc.onion.cosyfans.module_trade.entity.CartCreateEntity;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.adapter
 * @ClassName: AddressListAdapter
 * @Description: 产品适配器
 * @Author: guobihai
 * @CreateDate: 2019-12-11 14:24
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-11 14:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ProductsAdapter extends BaseQuickAdapter<CartCreateEntity.DataBean.ItemDetailsBean, BaseViewHolder> {

    public ProductsAdapter(Context mContext, @Nullable List<CartCreateEntity.DataBean.ItemDetailsBean> data) {
        super(R.layout.trade_item_poducts,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CartCreateEntity.DataBean.ItemDetailsBean item) {
        try {

        ImageView imgProducts = helper.getView(R.id.img_products);
        BaseBindingAdapter.loadImage(imgProducts,item.getItemLogoUrl());
        helper.setText(R.id.tv_childen_title,item.getItemName());
        helper.setText(R.id.tv_sku,item.getItemSpecification());

        TextView tv_childen_monery = helper.getView(R.id.tv_childen_monery);
        TextMeoneryShowUtils.setShowBigMonery(tv_childen_monery,TypeUtils.toString(item.getItemPrice()));

            helper.setText(R.id.tv_size, "x"+TypeUtils.toString(item.getAmount()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
