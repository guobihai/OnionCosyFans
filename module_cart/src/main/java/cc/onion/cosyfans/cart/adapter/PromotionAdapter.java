package cc.onion.cosyfans.cart.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.cart.entity.response.CartListEntity;
import cc.onion.cosyfans.cart.listener.PromotionCheckItemListener;
import cc.onion.cosyfans.module_cart.R;

/**
 * @author guobihai
 * @version V1.0
 * @Title: AppCommonInfo
 * @Package cc.onion.cosyfans.base.common
 * @date 2019-12-03 14:53
 * @email: anhui-zhuang@msyc.cc
 * @Description: (折扣对话框)
 */
public class PromotionAdapter extends BaseQuickAdapter<CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean.SwitchActivityLabelDTOListBean, BaseViewHolder> {

    PromotionCheckItemListener checkItemListener;
    String currentActivityCode;
    public PromotionAdapter(@Nullable List<CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean.SwitchActivityLabelDTOListBean> data, PromotionCheckItemListener listener, String currentActivityCode) {
        super(R.layout.cart_item_promation, data);
        this.checkItemListener =listener;
        this.currentActivityCode = currentActivityCode;
    }

    @Override
    protected void convert(BaseViewHolder helper, CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean.SwitchActivityLabelDTOListBean item) {
        helper.setText(R.id.tv_show,item.getSwitchLabel());
        ImageView imageView = helper.getView(R.id.img_select);
        /**
         * 勾选
         */
        helper.getView(R.id.layout_select).setOnClickListener(v -> {


            if(item.isCHeck()){
                checkItemListener.checkItem(null);
                //判断是否为选中
                imageView.setImageResource(R.mipmap.icon_cart_cicle);
            }else{
                imageView.setImageResource(R.mipmap.icon_check_agreen);
                checkItemListener.checkItem(item);
            }
            item.setCHeck(!item.isCHeck);
        });

        /**
         * 设置当前选中的ID
         */
        if(TypeUtils.toString(item.getActivityId()).equals(currentActivityCode)){
            imageView.setImageResource(R.mipmap.icon_check_agreen);
            checkItemListener.checkItem(item);
        }

    }


}
