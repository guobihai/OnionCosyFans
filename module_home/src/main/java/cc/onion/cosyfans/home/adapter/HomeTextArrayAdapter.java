package cc.onion.cosyfans.home.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.utils.TextMeoneryShowUtils;
import cc.onion.cosyfans.home.HomeUtils;
import cc.onion.cosyfans.home.entity.response.AdvertEntity;
import cc.onion.cosyfans.home.entity.response.DetailItemEntity;
import cc.onion.cosyfans.module_home.R;

/**
 * 文字专题
 * @author guobihai
 * @email:guobihai@163.com
 *
 */
public class HomeTextArrayAdapter extends BaseQuickAdapter<DetailItemEntity, BaseViewHolder> {

    private Context mContext;
    private int currentPosition = 0;
    AdvertEntity.DataBean dataBean;

    public HomeTextArrayAdapter(@Nullable AdvertEntity.DataBean mDataBean, Context activity) {
        super(R.layout.home_item_text);
        this.mContext = activity;
        this.dataBean = mDataBean;
    }

    @Override
    protected void convert(BaseViewHolder helper, DetailItemEntity item) {
        ImageView itemIconView = helper.getView(R.id.img_item_icon);
        BaseBindingAdapter.loadImageList(itemIconView,item.getImageSmall());
        TextMeoneryShowUtils.setShowBigMonery(helper.getView(R.id.tv_monery),item.getSellingPrice());
        TextMeoneryShowUtils.setShowLineMonery(helper.getView(R.id.tv_monery2),item.getMarketPrice());
        helper.getView(R.id.layout_show_item).setOnClickListener(v -> {
            //跳转到商品详情
            HomeUtils.toJumpAllAdvert(mContext,item);

        });


    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
