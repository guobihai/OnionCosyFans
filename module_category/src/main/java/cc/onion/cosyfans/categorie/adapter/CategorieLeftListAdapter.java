package cc.onion.cosyfans.categorie.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;


import java.util.List;

import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.categorie.R;
import cc.onion.cosyfans.categorie.entity.responer.CategorieEntity;

/**
 * @author guobihai
 * @email:guobihai@163.com
 * 部门标签适配器
 */
public class CategorieLeftListAdapter extends BaseQuickAdapter<CategorieEntity.DataBean, BaseViewHolder> {

    private Context mContext;
    private List<CategorieEntity.DataBean> leftListArray = null;
    private int currentPosition = 0;

    public CategorieLeftListAdapter(@Nullable List<CategorieEntity.DataBean> data, Context activity) {
        super(R.layout.categorie_list_item_cate_left, data);
        this.mContext = activity;
        this.leftListArray = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, CategorieEntity.DataBean item) {
        helper.setText(R.id.item_cate_left_text,item.getCategoryName());
        TextView itemView = helper.getView(R.id.item_cate_left_text);
        View line  = helper.getView(R.id.line_left);
        KLog.i("test","Aapter刷新的数据："+currentPosition);
        if(helper.getPosition()  == currentPosition){
            itemView.setBackgroundColor(mContext.getResources().getColor(R.color.categorie_item_bg));
            line.setBackgroundColor(mContext.getResources().getColor(R.color.theme));
            itemView.setTextColor(mContext.getResources().getColor(R.color.categorie_text_focus));
        }else{
            itemView.setBackgroundColor(mContext.getResources().getColor(R.color.white));
            line.setBackgroundColor(mContext.getResources().getColor(R.color.white));
            itemView.setTextColor(mContext.getResources().getColor(R.color.text));
        }

    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
