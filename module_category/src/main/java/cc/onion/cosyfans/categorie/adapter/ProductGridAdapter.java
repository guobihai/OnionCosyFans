package cc.onion.cosyfans.categorie.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.utils.TextMeoneryShowUtils;
import cc.onion.cosyfans.categorie.R;
import cc.onion.cosyfans.categorie.entity.responer.CategorieListEntity;

/**
 * 分类商品列表
 * @author guobihai
 * @email:guobihai@163.com
 * 部门标签适配器
 */
public class ProductGridAdapter extends BaseQuickAdapter<CategorieListEntity.DataBean, BaseViewHolder> {

    private Context mContext;
    private List<CategorieListEntity.DataBean> leftListArray = null;
    private int currentPosition = 0;

    public ProductGridAdapter(@Nullable List<CategorieListEntity.DataBean> data, Context activity) {
        super(R.layout.categorie_list_item_products_grid, data);
        this.mContext = activity;
        this.leftListArray = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, CategorieListEntity.DataBean item) {

        try {


        helper.getView(R.id.layout_buttom).setVisibility(View.VISIBLE);
        ImageView imageView = helper.getView(R.id.img_item_icon);
        BaseBindingAdapter.loadImage(imageView,item.getImageMedium());
        helper.setText(R.id.tv_title,item.getItemName());


        if(StringUtils.isNotEmpty(item.getPromotionLabel()) && StringUtils.isNotEmpty(item.getCouponLabel())){
            //都显示
            helper.getView(R.id.layout_disc).setVisibility(View.VISIBLE);
            helper.setText(R.id.tv_discc_monery1,item.getPromotionLabel());
            helper.setText(R.id.tv_discc_monery2,item.getCouponLabel());

        }else if(StringUtils.isNotEmpty(item.getPromotionLabel())){
            //单个显示
            helper.getView(R.id.layout_disc).setVisibility(View.VISIBLE);
            helper.getView(R.id.tv_discc_monery2).setVisibility(View.GONE);
            helper.setText(R.id.tv_discc_monery1,item.getPromotionLabel());

        }else if(StringUtils.isNotEmpty(item.getCouponLabel())){
            //单个显示
            helper.getView(R.id.layout_disc).setVisibility(View.VISIBLE);
            helper.getView(R.id.tv_discc_monery1).setVisibility(View.GONE);
            helper.setText(R.id.tv_discc_monery2,item.getCouponLabel());

        }else if(StringUtils.isNotEmpty(item.getDiscountedPrice())){
            //折扣后价格显示
                helper.getView(R.id.layou_price_show).setVisibility(View.VISIBLE);
                helper.setText(R.id.tv_price,item.getDiscountedPrice());

        }
        else{
            helper.setVisible(R.id.layout_disc,false);
        }



        //price
        TextMeoneryShowUtils.setRMShowBigMonery(helper.getView(R.id.tv_monery),item.getSellingPrice());
        TextMeoneryShowUtils.setRMShowLineMonery(helper.getView(R.id.tv_monery2),item.getMarketPrice());


        if(item.getHasStock() !=1){
            helper.getView(R.id.img_item_logon).setVisibility(View.VISIBLE);
            ImageView imageStock = helper.getView(R.id.img_item_logon);
            BaseBindingAdapter.setBackgroud(imageStock,R.mipmap.item_detail_no_sku);
        }else{
            helper.getView(R.id.img_item_logon).setVisibility(View.GONE);
        }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
