package cc.onion.cosyfans.item.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.onion.cosyfans.item.entity.response.ItemDetailEntity;
import cc.onion.cosyfans.module_item.R;


/**
 * 折扣适配器
 * @author guobihai
 * @email:guobihai@163.com
 *
 */
public class CommissionListAdapter extends BaseQuickAdapter<ItemDetailEntity.DataBean.ItemDetailPromotionLevelDTOBean.CfPromotionLevelDTOSBean, BaseViewHolder> {

    private Context mContext;
    private List<String> leftListArray = null;
    private int currentPosition = 0;

    public CommissionListAdapter(@Nullable Context activity) {
        super(R.layout.item_commission_list_item);
        this.mContext = activity;
    }

    @Override
    protected void convert(BaseViewHolder helper, ItemDetailEntity.DataBean.ItemDetailPromotionLevelDTOBean.CfPromotionLevelDTOSBean item) {
            helper.setText(R.id.tv_commission_left,item.getPromotionLabel());
            helper.setText(R.id.tv_commission_right,item.getPromotionLabel());

    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
