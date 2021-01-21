package cc.onion.cosyfans.item.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.onion.cosyfans.item.entity.response.DetailItemEntity;
import cc.onion.cosyfans.module_item.R;

/**
 * @author guobihai
 * @date 2019 - 12-9
 */
public class DetailItemAdapter extends BaseQuickAdapter<DetailItemEntity, BaseViewHolder> {


    public DetailItemAdapter( @Nullable List<DetailItemEntity> data) {
        super(R.layout.item_detail_show, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DetailItemEntity item) {
            helper.setText(R.id.tv_key,item.getKey()+":");
            helper.setText(R.id.tv_value,item.getValue());
    }
}
