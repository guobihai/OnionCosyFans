package cc.onion.cosyfans.home.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.onion.cosyfans.module_home.R;

/**
 * @author guobihai
 * @email:guobihai@163.com
 * 主页多宫格布局适配器
 */
public class HomeTopGridAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    private Context mContext;
    private List<String> leftListArray = null;
    private int currentPosition = 0;

    public HomeTopGridAdapter(@Nullable List<String> data, Context activity) {
        super(R.layout.home_item_grid_top, data);
        this.mContext = activity;
        this.leftListArray = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.item_cate_text,item);


    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
