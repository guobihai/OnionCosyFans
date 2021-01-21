package cc.onion.cosyfans.moment.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.onion.cosyfans.module_moment.R;
import cc.onion.cosyfans.moment.entry.PostCenterEntry;


/**
 * 发送素材信息的素材圈适配器
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.moment.adapter
 * @ClassName: PostMomentAdapter
 * @Description: java类作用描述
 * @Author: gbh
 * @CreateDate: 2020-02-08 11:08
 * @UpdateUser: gbh
 * @UpdateDate: 2020-02-08 11:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class PostMomentAdapter extends BaseQuickAdapter<PostCenterEntry, BaseViewHolder> {
    public PostMomentAdapter(@Nullable List<PostCenterEntry> data) {
        super(R.layout.moment_post_center_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PostCenterEntry item) {

    }
}
