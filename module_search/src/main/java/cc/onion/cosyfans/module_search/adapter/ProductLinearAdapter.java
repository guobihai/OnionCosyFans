package cc.onion.cosyfans.module_search.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

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
import cc.onion.cosyfans.module_search.entity.SearchResultEntity;

/**
 * 分类商品列表 List
 * @author guobihai
 * @email:guobihai@163.com
 * 部门标签适配器
 */
public class ProductLinearAdapter extends BaseQuickAdapter<SearchResultEntity.DataBean, BaseViewHolder> {

    private Context mContext;
    private List<SearchResultEntity.DataBean> leftListArray = null;
    private int currentPosition = 0;

    public ProductLinearAdapter(@Nullable List<SearchResultEntity.DataBean> data, Context activity) {
        super(R.layout.search_item_products, data);
        this.mContext = activity;
        this.leftListArray = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchResultEntity.DataBean item) {

        helper.getView(R.id.item_products_name).setVisibility(View.VISIBLE);
        ImageView imageView = helper.getView(R.id.img_products);
        BaseBindingAdapter.loadImage(imageView,item.getImageMedium());
        helper.setText(R.id.item_products_name,item.getItemName());

        //price
        TextMeoneryShowUtils.setShowBigMonery(helper.getView(R.id.item_products_price),item.getSellingPrice());
        TextMeoneryShowUtils.setShowLineMonery(helper.getView(R.id.item_products_price_real),item.getMarketPrice());

        if(item.getHasStock() !=1){
            helper.getView(R.id.img_item_logon).setVisibility(View.VISIBLE);
            ImageView imageStock = helper.getView(R.id.img_item_logon);
            BaseBindingAdapter.setBackgroud(imageStock,R.mipmap.item_detail_no_sku);
        }else{
            helper.getView(R.id.img_item_logon).setVisibility(View.GONE);
        }

        helper.getView(R.id.layou_body).setOnClickListener(v -> {
            //商品详情
            ARouter.getInstance()
                    .build(RouterPath.Item.ROUTE_ITEM_PRODUCTS_PATH)
                    .withString("itemId", TypeUtils.toString(item.getItemId()))
                    .navigation();
        });

    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
