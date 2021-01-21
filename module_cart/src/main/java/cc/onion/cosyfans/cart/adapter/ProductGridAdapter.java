package cc.onion.cosyfans.cart.adapter;

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
import cc.onion.cosyfans.cart.entity.response.ItemEntity;
import cc.onion.cosyfans.module_cart.R;


/**
 * 购物车推荐数据
 * @author guobihaix
 * @email:guobihai@163.com
 *x
 */
public class ProductGridAdapter extends BaseQuickAdapter<ItemEntity.DataBean, BaseViewHolder> {

    private Context mContext;
    private List<ItemEntity.DataBean> leftListArray = null;
    private int currentPosition = 0;

    public ProductGridAdapter(@Nullable List<ItemEntity.DataBean> data, Context activity) {
        super(R.layout.cart_list_item_products_grid, data);
        this.mContext = activity;
        this.leftListArray = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, ItemEntity.DataBean item) {
        ImageView imageView = helper.getView(R.id.img_products);
        BaseBindingAdapter.loadImage(imageView,item.getImageMedium());
        if(StringUtils.isNotEmpty(item.getItemName())) {
            helper.setText(R.id.item_products_name,item.getItemName());
        }
        if(StringUtils.isNotEmpty(item.getSellingPrice())) {
            //J金额显示
            TextMeoneryShowUtils.setShowBigMonery(helper.getView(R.id.item_products_price),item.getSellingPrice());
        }
        if(StringUtils.isNotEmpty(item.getMarketPrice())) {
            TextMeoneryShowUtils.setShowLineMonery((TextView) helper.getView(R.id.item_products_price_real),item.getMarketPrice());
        }

        if(item.getHasStock() ==1){
            helper.getView(R.id.img_item_logon).setVisibility(View.VISIBLE);
            ImageView imageStock = helper.getView(R.id.img_item_logon);
            BaseBindingAdapter.setBackgroud(imageStock,R.mipmap.item_detail_no_sku);
        }else{
            helper.getView(R.id.img_item_logon).setVisibility(View.GONE);
        }



    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
