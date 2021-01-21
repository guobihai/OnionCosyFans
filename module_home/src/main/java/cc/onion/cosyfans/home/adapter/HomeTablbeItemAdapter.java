package cc.onion.cosyfans.home.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.entity.BaseListResponse;
import cc.onion.cosyfans.base.utils.TextMeoneryShowUtils;
import cc.onion.cosyfans.home.entity.response.TableDetailEntity;
import cc.onion.cosyfans.module_home.R;

/**
 * @author guobihai
 * @email:guobihai@163.com
 *
 */
public class HomeTablbeItemAdapter extends BaseQuickAdapter<TableDetailEntity.DataBean, BaseViewHolder> {

    private Context mContext;
    private int currentPosition = 0;

    public HomeTablbeItemAdapter(@Nullable  Context activity) {
        super(R.layout.home_item_table_detail);
        this.mContext = activity;
    }

    @Override
    protected void convert(BaseViewHolder helper, TableDetailEntity.DataBean item) {

        if(item.getDetailType() ==1){
            helper.getView(R.id.layout_buttom).setVisibility(View.GONE);
            ImageView imageView = helper.getView(R.id.img_item_icon);
            BaseBindingAdapter.loadImage(imageView,item.getSpecificImage());
        }else{
            helper.getView(R.id.layout_buttom).setVisibility(View.VISIBLE);
            ImageView imageView = helper.getView(R.id.img_item_icon);
            BaseBindingAdapter.loadImage(imageView,item.getImageSmall());
            helper.setText(R.id.tv_title,item.getItemName());
            //price
            TextMeoneryShowUtils.setShowBigMonery(helper.getView(R.id.tv_monery),item.getSellingPrice());
            TextMeoneryShowUtils.setShowBigMonery(helper.getView(R.id.tv_monery2),item.getMarketPrice());
            //不是分组商品
            if(item.getHasStock() == 0){
                helper.getView(R.id.img_item_logon).setVisibility(View.VISIBLE);
                ImageView imageStock = helper.getView(R.id.img_item_logon);
                BaseBindingAdapter.setBackgroud(imageStock,R.mipmap.item_detail_no_sku);
            }else{
                helper.getView(R.id.img_item_logon).setVisibility(View.GONE);
            }

        }


        if(StringUtils.isNotEmpty(item.getPromotionLabel()) || StringUtils.isNotEmpty(item.getCouponLabel())){
            helper.getView(R.id.layout_disc).setVisibility(View.VISIBLE);
            if(StringUtils.isNotEmpty(item.getPromotionLabel())){
                helper.getView(R.id.tv_discc_monery1).setVisibility(View.VISIBLE);
                helper.setText(R.id.tv_discc_monery1,item.getPromotionLabel()+"OFF");
            }else{
                helper.getView(R.id.tv_discc_monery1).setVisibility(View.GONE);
            }

            if(StringUtils.isNotEmpty(item.getCouponLabel())){
                helper.getView(R.id.tv_discc_monery2).setVisibility(View.VISIBLE);
                helper.setText(R.id.tv_discc_monery2,item.getCouponLabel()+"OFF");
            }else{
                helper.getView(R.id.tv_discc_monery2).setVisibility(View.GONE);
            }
        }






    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
