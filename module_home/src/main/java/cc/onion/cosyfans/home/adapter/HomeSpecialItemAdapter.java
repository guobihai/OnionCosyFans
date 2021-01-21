package cc.onion.cosyfans.home.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.utils.TextMeoneryShowUtils;
import cc.onion.cosyfans.home.entity.response.DetailAlbumVosEntity;
import cc.onion.cosyfans.home.entity.response.DetailItemEntity;
import cc.onion.cosyfans.module_home.R;

/**
 * @author guobihai
 * @email:guobihai@163.com
 * 主页多宫格布局适配器
 */
public class HomeSpecialItemAdapter extends BaseQuickAdapter<DetailAlbumVosEntity, BaseViewHolder> {

    private Context mContext;
    private List<DetailAlbumVosEntity> leftListArray = null;
    private int currentPosition = 0;

    public HomeSpecialItemAdapter(@Nullable List<DetailAlbumVosEntity> data, Context activity) {
        super(R.layout.home_item_special, data);
        this.mContext = activity;
        this.leftListArray = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, DetailAlbumVosEntity item) {
        ImageView itemIconView = helper.getView(R.id.img_item_icon);
        BaseBindingAdapter.loadImageList(itemIconView,item.getImg());
        helper.setText(R.id.tv_monery,item.getTheme());

    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
