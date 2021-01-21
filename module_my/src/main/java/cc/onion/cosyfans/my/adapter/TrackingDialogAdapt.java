package cc.onion.cosyfans.my.adapter;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.Collection;
import java.util.List;

import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.my.entity.TrackingDetailEntry;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.adapter
 * @ClassName: TrackingDialogAdapt
 * @Description: java类作用描述
 * @Author: 唐朝
 * @CreateDate: 2020/1/16 16:55
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/16 16:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TrackingDialogAdapt extends BaseQuickAdapter<TrackingDetailEntry.DataBean.TrackDetailListBean, BaseViewHolder> {
    public TrackingDialogAdapt(@Nullable List<TrackingDetailEntry.DataBean.TrackDetailListBean> data) {
        super(R.layout.my_tracking_dialog_item_layout, data);
    }

    @Override
    public void setNewData(@Nullable List<TrackingDetailEntry.DataBean.TrackDetailListBean> data) {
        if (null == data) {

            return;
        }
        for (int i = 0; i < data.size(); i++) {
            if (i == 0) {
                data.get(i).setFirst(true);
            } else {

                data.get(i).setFirst(false);
            }
        }
        super.setNewData(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TrackingDetailEntry.DataBean.TrackDetailListBean item) {
        TextView textTitle = helper.getView(R.id.tv_tracking_address_value);
        textTitle.setText(item.getStationName().concat(item.getEvent()));
        helper.setText(R.id.tv_tracking_time_value, item.getDate());
        textTitle.setTextColor(item.isFirst()?mContext.getResources().getColor(R.color.bluce):mContext.getResources().getColor(R.color.text));
        ImageView imageView = helper.getView(R.id.img_time_icon);
        imageView.setImageResource(item.isFirst() ? R.mipmap.icon_check_agreen
                : R.drawable.my_tracking_time_point);


    }


}
