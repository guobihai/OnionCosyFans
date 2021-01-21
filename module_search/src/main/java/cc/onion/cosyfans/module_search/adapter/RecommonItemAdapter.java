package cc.onion.cosyfans.module_search.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.TextMeoneryShowUtils;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.module_search.R;
import cc.onion.cosyfans.module_search.entity.RecommendEntity;
import cc.onion.cosyfans.module_search.entity.SearchResultEntity;


/**
 * @author guobihai
 * @email:guobihai@163.com
 */
public class RecommonItemAdapter extends BaseQuickAdapter<RecommendEntity.DataBean, BaseViewHolder> {

    public boolean isShoHotStock = false;
    public RecommonItemAdapter(@Nullable List<RecommendEntity.DataBean> data, Context activity) {
        super(R.layout.search_item_recommon, data);
        this.mContext = activity;
    }

    @Override
    protected void convert(BaseViewHolder helper, RecommendEntity.DataBean item) {
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

        if(!isShoHotStock){
            if(item.getHasStock() ==1){
                helper.getView(R.id.img_item_logon).setVisibility(View.VISIBLE);
                ImageView imageStock = helper.getView(R.id.img_item_logon);
                BaseBindingAdapter.setBackgroud(imageStock,R.mipmap.item_detail_no_sku);
            }else{
                helper.getView(R.id.img_item_logon).setVisibility(View.GONE);
            }

        }

        helper.getView(R.id.layout_show_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //商品详情
                ARouter.getInstance()
                        .build(RouterPath.Item.ROUTE_ITEM_PRODUCTS_PATH)
                        .withString("itemId", TypeUtils.toString(item.getItemId()))
                        .navigation();
            }
        });


    }


    public boolean isShoHotStock() {
        return isShoHotStock;
    }

    public void setShoHotStock(boolean shoHotStock) {
        isShoHotStock = shoHotStock;
    }
}
