package cc.onion.cosyfans.home.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.TextMeoneryShowUtils;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.home.HomeUtils;
import cc.onion.cosyfans.home.entity.response.AdvertEntity;
import cc.onion.cosyfans.home.entity.response.DetailAlbumVosEntity;
import cc.onion.cosyfans.home.entity.response.DetailItemEntity;
import cc.onion.cosyfans.home.entity.response.DetailItemVosEntity;
import cc.onion.cosyfans.module_home.R;

/**
 * 图文专题，显示价格模块
 * @author guobihai
 * @email:guobihai@163.com
 *
 */
public class HomeSpecialTextAdapter extends BaseQuickAdapter<DetailItemEntity, BaseViewHolder> {

    private Context mContext;
    private int currentPosition = 0;
    AdvertEntity.DataBean dataBean;

    public HomeSpecialTextAdapter(@Nullable AdvertEntity.DataBean mDataBean, Context activity) {
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
        helper.getView(R.id.layout_show_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到商品详情
//                HomeUtils.
                HomeUtils.toJumpAllAdvert(mContext,dataBean,item);

            }
        });


    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
