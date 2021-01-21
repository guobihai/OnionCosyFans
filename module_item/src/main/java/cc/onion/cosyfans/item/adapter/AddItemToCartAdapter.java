package cc.onion.cosyfans.item.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.onion.cosyfans.item.entity.SkuBaseEntity;
import cc.onion.cosyfans.item.entity.response.ItemDetailEntity;
import cc.onion.cosyfans.module_item.R;


/**
 *
 * 购物车颜色，尺码组item显示
 * @author guobihai
 * @email:guobihai@163.com
 *
 */
public class AddItemToCartAdapter extends BaseQuickAdapter<ItemDetailEntity.DataBean.SkuInfoShowDTOBean.SkuOptionNameListBean, BaseViewHolder> implements AddItemArraryAdapter.ChooseCurrentItem {

    private Context mContext;
    private int currentPosition = 0;
    private AddItemArraryAdapter.ChooseCurrentItem   chooseCurrentItem;

    public AddItemToCartAdapter(Context mContext, AddItemArraryAdapter.ChooseCurrentItem item) {
        super(R.layout.item_item_add_cart);
        this.mContext = mContext;
        this.chooseCurrentItem = item;
    }

    @Override
    protected void convert(BaseViewHolder helper, ItemDetailEntity.DataBean.SkuInfoShowDTOBean.SkuOptionNameListBean item) {
        helper.setText(R.id.item_name,item.getSpecName());
        RecyclerView rlAddCartItem = helper.getView(R.id.rl_add_cart);
        rlAddCartItem.setLayoutManager((new LinearLayoutManager(mContext,0,false)));
        AddItemArraryAdapter arraryAdapter = new AddItemArraryAdapter(mContext,this);
        rlAddCartItem.setAdapter(arraryAdapter);
        arraryAdapter.setNewData(item.getSpecOptionList());
        arraryAdapter.notifyDataSetChanged();
        arraryAdapter.setOnItemClickListener((adapter, view, position) -> {
            // on Click


        });


    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    /**
     *选择SKU回调
     * @param item
     */
    @Override
    public void chooseCurrentItemOnClickListener(ItemDetailEntity.DataBean.SkuInfoShowDTOBean.SkuOptionNameListBean.SpecOptionListBean item) {
        chooseCurrentItem.chooseCurrentItemOnClickListener(item);
    }
}
