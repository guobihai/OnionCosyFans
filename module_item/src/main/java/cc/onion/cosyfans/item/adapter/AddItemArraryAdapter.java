package cc.onion.cosyfans.item.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import cc.onion.cosyfans.item.entity.response.ItemDetailEntity;
import cc.onion.cosyfans.module_item.R;


/**
 * 购物车对话框 颜色尺码展示
 * @author guobihai
 * @email:guobihai@163.com
 *
 */
public class AddItemArraryAdapter extends BaseQuickAdapter<ItemDetailEntity.DataBean.SkuInfoShowDTOBean.SkuOptionNameListBean.SpecOptionListBean, BaseViewHolder> {

    private Context mContext;
    private int currentPosition = 0;
    ChooseCurrentItem  chooseCurrentItem;


    public AddItemArraryAdapter(Context mContext,ChooseCurrentItem currentItem) {
        super(R.layout.item_item_add_cart_arrary);
        this.mContext = mContext;
        this.chooseCurrentItem = currentItem;
    }

    @Override
    protected void convert(BaseViewHolder helper, ItemDetailEntity.DataBean.SkuInfoShowDTOBean.SkuOptionNameListBean.SpecOptionListBean item) {
        helper.setText(R.id.item_array_name,item.getSpecOptName());
        TextView name  = helper.getView(R.id.item_array_name);


        if(helper.getPosition() == currentPosition){
                name.setTextColor(mContext.getResources().getColor(R.color.bluce));
                name.setBackgroundResource(R.drawable.item_cart_defalut_shape_focus);
            }else{
                name.setTextColor(mContext.getResources().getColor(R.color.text));
            name.setBackgroundResource(R.drawable.item_cart_defalut_shape);
            }


        if(currentPosition == 0){

            if(item.isSelect()){
                name.setTextColor(mContext.getResources().getColor(R.color.bluce));
                name.setBackgroundResource(R.drawable.item_cart_defalut_shape_focus);
                chooseCurrentItem.chooseCurrentItemOnClickListener(item);
            }else{
                name.setTextColor(mContext.getResources().getColor(R.color.text));
                name.setBackgroundResource(R.drawable.item_cart_defalut_shape);
            }

        }

        //点击回调
        name.setOnClickListener(v -> {
            setCurrentPosition(helper.getPosition());
            notifyDataSetChanged();
            chooseCurrentItem.chooseCurrentItemOnClickListener(item);
        });
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }


    /**
     * 选择SKU
     */
    public interface  ChooseCurrentItem{

       void   chooseCurrentItemOnClickListener(ItemDetailEntity.DataBean.SkuInfoShowDTOBean.SkuOptionNameListBean.SpecOptionListBean item);

    }
}
