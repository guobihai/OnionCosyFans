package cc.onion.cosyfans.item.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import cc.onion.cosyfans.item.entity.response.CouponListEntity;
import cc.onion.cosyfans.module_item.R;


/**
 * 优惠券
 * @author guobihai
 * @email:guobihai@163.com
 *
 */
public class ConponListAdapter extends BaseQuickAdapter<CouponListEntity.UnRecvListBean, BaseViewHolder> {

    private Context mContext;
    private List<CouponListEntity.UnRecvListBean> leftListArray = null;
    private int currentPosition = 0;

    public ConponListAdapter(@Nullable List<CouponListEntity.UnRecvListBean> data, Context activity) {
        super(R.layout.item_coupon_list_item, data);
        this.mContext = activity;
        this.leftListArray = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, CouponListEntity.UnRecvListBean item) {
        helper.setText(R.id.tv_copn_monery,item.getCouponAmount());
        helper.setText(R.id.tv_coupon_center,item.getCouponName());
        //时间
        if(StringUtils.isNotEmpty(item.getValidEndTime()) && StringUtils.isNotEmpty(item.getValidStartTime())){
            helper.setText(R.id.tv_use_time,item.getValidStartTime()+"-"+item.getValidEndTime());
        }
        TextView statebg = helper.getView(R.id.tv_coupon_state);
        if(item.getReceivedStatus() == 1){
//            是否领取 1:领取
            statebg.setBackgroundResource(R.drawable.item_coupon_button_use_shape);
            statebg.setText("立即领取");

        }else{
            statebg.setBackgroundResource(R.drawable.item_coupon_button_use_shape);
            statebg.setText("立即领取");
        }


    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
