package cc.onion.cosyfans.home.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import cc.onion.cosyfans.home.entity.CashRollEntity;
import cc.onion.cosyfans.module_home.R;


/**
 * 优惠券
 * @author guobihai
 * @email:guobihai@163.com
 *
 */
public class HomeConponListAdapter extends BaseQuickAdapter<CashRollEntity.DataBean.CouponVOListBean, BaseViewHolder> {

    private Context mContext;
    private List<CashRollEntity.DataBean.CouponVOListBean> leftListArray = null;
    private int currentPosition = 0;

    public HomeConponListAdapter(@Nullable List<CashRollEntity.DataBean.CouponVOListBean> data, Context activity) {
        super(R.layout.home_coupon_list_item, data);
        this.mContext = activity;
        this.leftListArray = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, CashRollEntity.DataBean.CouponVOListBean item) {
        helper.setText(R.id.tv_copn_monery,item.getCouponAmount());
        helper.setText(R.id.tv_coupon_center,item.getCouponName());
        //时间
        if(StringUtils.isNotEmpty(item.getValidEndTime()) && StringUtils.isNotEmpty(item.getValidStartTime())){
            helper.setText(R.id.tv_use_time,item.getValidStartTime()+"-"+item.getValidEndTime());
        }

    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
