package cc.onion.cosyfans.module_trade.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.event.LoginSuccessEvent;
import cc.onion.cosyfans.module_trade.R;
import cc.onion.cosyfans.module_trade.entity.PlayListEntity;
import cc.onion.cosyfans.module_trade.event.PlayTypeEvent;
import cc.onion.cosyfans.module_trade.listener.PlayOnClickListener;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_trade.entity
 * @ClassName: CreateOrderEntity
 * @Description: (支付列表Adapter)
 * @Author: guobihai
 * @CreateDate: 2019-12-13 14:01
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-13 14:01
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class PlayListAdapter extends BaseQuickAdapter<PlayListEntity.DataBean, BaseViewHolder> {

    private Context mContext;
    private PlayOnClickListener mListener;
    public PlayListAdapter(@Nullable List<PlayListEntity.DataBean> data, Context cotext, PlayOnClickListener listener) {
        super(R.layout.trade_item_play, data);
        this.mContext =cotext;
        this.mListener = listener;
    }

    @Override
    protected void convert(BaseViewHolder helper, PlayListEntity.DataBean item) {

        ImageView imgIcon = helper.getView(R.id.img_icon);
        BaseBindingAdapter.loadImage(imgIcon,item.getLogo());
        helper.setText(R.id.tv_play_name,item.getName());
        helper.getView(R.id.layout_item).setOnClickListener(v -> {
            mListener.toPlayResule(item,null);
        });
    }
}
