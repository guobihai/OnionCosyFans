package cc.onion.cosyfans.moment.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.onion.cosyfans.module_moment.R;
import cc.onion.cosyfans.moment.entry.CenterInfoEntry;

/**
 * 素材中心适配器
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.moment.adapter
 * @ClassName: MomentCenterAdapter
 * @Description: java类作用描述
 * @Author: gbh
 * @CreateDate: 2020-02-04 18:13
 * @UpdateUser: gbh
 * @UpdateDate: 2020-02-04 18:13
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MomentCenterAdapter extends BaseQuickAdapter<CenterInfoEntry, BaseViewHolder> {
    public MomentCenterAdapter(@Nullable List<CenterInfoEntry> data) {
        super(R.layout.moment_center_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CenterInfoEntry item) {

    }
}
