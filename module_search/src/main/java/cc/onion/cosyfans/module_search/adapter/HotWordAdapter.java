package cc.onion.cosyfans.module_search.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import cc.onion.cosyfans.module_search.R;
import cc.onion.cosyfans.module_search.entity.SearchHotWordEntity;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_search.adapter
 * @ClassName: HotWordAdapter
 * @Description: 热词适配器
 * @Author: guobihai
 * @CreateDate: 2020-01-06 14:20
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-06 14:20
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HotWordAdapter extends BaseQuickAdapter<SearchHotWordEntity.DataBean, BaseViewHolder> {

    public HotWordAdapter(@Nullable List<SearchHotWordEntity.DataBean> data) {
        super(R.layout.search_item_hot_word, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchHotWordEntity.DataBean item) {
        if(StringUtils.isNotEmpty(item.getHotWord())){
            helper.setText(R.id.tv_tag,item.getHotWord());
        }

    }
}
