package cc.onion.cosyfans.module_trade.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.utils.TextMeoneryShowUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.module_trade.R;
import cc.onion.cosyfans.module_trade.entity.CartCreateEntity;
import cc.onion.cosyfans.module_trade.entity.CashCouponEntity;
import cc.onion.cosyfans.module_trade.listener.CashMoneryDialogOnClickListener;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.adapter
 * @ClassName: AddressListAdapter
 * @Description: 现金优惠券适配器
 * @Author: guobihai
 * @CreateDate: 2019-12-11 14:24
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-11 14:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CoshMoneryAdapter extends BaseQuickAdapter<CashCouponEntity.DataBean, BaseViewHolder> {

    String totalAmount;
    int curentPosition = 0;
    String cashCouponId ;
    CashMoneryDialogOnClickListener cashMoneryDialogOnClickListener;
    public CoshMoneryAdapter(Context mContext, @Nullable List<CashCouponEntity.DataBean> data, String amount,
                             String cashCouponId,CashMoneryDialogOnClickListener clickListener) {
        super(R.layout.trade_item_cosh_coupon,data);
        this.totalAmount =totalAmount;
        this.cashCouponId =cashCouponId;
        this.cashMoneryDialogOnClickListener = clickListener;
    }

    @Override
    protected void convert(BaseViewHolder helper,CashCouponEntity.DataBean item) {
        try {
            helper.setText(R.id.tv_show,item.getLabelName());
            if(StringUtils.isNotEmpty(item.getStartTime())){
                helper.setText(R.id.tv_date,"有限期："+item.getStartTime()+" "+item.getEndTime());
            }else{
                helper.getView(R.id.tv_date).setVisibility(View.GONE);
            }

//            if(Double.parseDouble(totalAmount.toString().trim()) >= Double.parseDouble(item.getThresholdAmount().toString().trim())){
//                helper.setVisible(R.id.tv_tips,true);
//                helper.getView(R.id.layout_select).setEnabled(true);
//                helper.setText(R.id.tv_tips,item.getCouponExplain());
//            }else{
//                helper.getView(R.id.layout_select).setEnabled(false);
//                helper.setVisible(R.id.tv_tips,false);
//            }

            ImageView  imageView = helper.getView(R.id.img_select);


            if(StringUtils.isNotEmpty(cashCouponId)){
                //首次

                //初始化选择
                if(item.isChoose()){
                    cashMoneryDialogOnClickListener.selectCurrentItem(item);
                    imageView.setImageResource(cc.onion.cosyfans.module_cart.R.mipmap.icon_check_agreen);
                }else{
                    cashMoneryDialogOnClickListener.selectCurrentItem(null);
                    imageView.setImageResource(cc.onion.cosyfans.module_cart.R.mipmap.icon_cart_cicle);
                }
                cashCouponId = "";
            }else{
                //后续业务
                if(helper.getPosition() ==curentPosition){
                    item.setChoose(true);
                    cashMoneryDialogOnClickListener.selectCurrentItem(item);
                    imageView.setImageResource(cc.onion.cosyfans.module_cart.R.mipmap.icon_check_agreen);
                }else{
                    item.setChoose(false);
                    cashMoneryDialogOnClickListener.selectCurrentItem(null);
                    imageView.setImageResource(cc.onion.cosyfans.module_cart.R.mipmap.icon_cart_cicle);
                }
//
            }





        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getCurentPosition() {
        return curentPosition;
    }

    public void setCurentPosition(int curentPosition) {
        this.curentPosition = curentPosition;
    }
}
