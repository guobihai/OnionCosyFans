package cc.onion.cosyfans.categorie.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.categorie.R;
import cc.onion.cosyfans.categorie.entity.responer.CategorieEntity;

/**
 * 右侧列表
 * @author guobihai
 * @email:guobihai@163.com
 * 部门标签适配器
 */
public class CategorieRightListAdapter extends BaseQuickAdapter<CategorieEntity.DataBean.ChildNodesBeanX, BaseViewHolder> {

    private Context mContext;
    private List<CategorieEntity.DataBean.ChildNodesBeanX> leftListArray = null;
    private int currentPosition = 0;


    public CategorieRightListAdapter(@Nullable List<CategorieEntity.DataBean.ChildNodesBeanX> data, Context activity) {
        super(R.layout.categorie_list_item_cate_right, data);
        this.mContext = activity;
        this.leftListArray = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, CategorieEntity.DataBean.ChildNodesBeanX item) {
        helper.setText(R.id.item_right_title,item.getCategoryName());
        RecyclerView recyclerViewItemProducts = helper.getView(R.id.rl_cate_item_products);

        if(item.getChildNodes() != null && item.getChildNodes().size() >0){
            CategorieRightGridAdapter adapter  = new CategorieRightGridAdapter(null,mContext);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3);
            recyclerViewItemProducts.setLayoutManager(gridLayoutManager);
            recyclerViewItemProducts.setAdapter(adapter);
            adapter.setNewData(item.getChildNodes());
            adapter.notifyDataSetChanged();
            adapter.setOnItemClickListener((adapter1, view, position) -> {
                CategorieEntity.DataBean.ChildNodesBeanX.ChildNodesBean childNodesBean = (CategorieEntity.DataBean.ChildNodesBeanX.ChildNodesBean) adapter1.getItem(position);

                //跳转事件
                ARouter.getInstance().build(RouterPath.Categorie.ROUTE_LIST_PRODUCTS)
                        .withString("id", TypeUtils.toString(childNodesBean.getId()))
                        .withString("titlename",childNodesBean.getCategoryName())
                        .navigation();

            });
        }



    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
