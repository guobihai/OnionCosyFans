package cc.onion.cosyfans.categorie.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.categorie.R;
import cc.onion.cosyfans.categorie.entity.responer.CategorieEntity;
import cc.onion.cosyfans.categorie.entity.responer.ChildNodesEntity;

/**
 * @author guobihai
 * @email:guobihai@163.com
 * 部门标签适配器
 */
public class CategorieRightGridAdapter extends BaseQuickAdapter<CategorieEntity.DataBean.ChildNodesBeanX.ChildNodesBean, BaseViewHolder> {

    private Context mContext;
    private List<CategorieEntity.DataBean.ChildNodesBeanX.ChildNodesBean> leftListArray = null;
    private int currentPosition = 0;

    public CategorieRightGridAdapter(@Nullable List<CategorieEntity.DataBean.ChildNodesBeanX.ChildNodesBean> data, Context activity) {
        super(R.layout.categorie_list_item_cate_right_products, data);
        this.mContext = activity;
        this.leftListArray = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, CategorieEntity.DataBean.ChildNodesBeanX.ChildNodesBean item) {
        helper.setText(R.id.item_cate_text,item.getCategoryName());
       ImageView itemProducts = helper.getView(R.id.img_products);
        BaseBindingAdapter.loadImage(itemProducts,item.getImageSamll());

    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
