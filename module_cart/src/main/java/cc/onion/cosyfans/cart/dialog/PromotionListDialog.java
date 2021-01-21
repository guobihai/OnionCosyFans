package cc.onion.cosyfans.cart.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.dialog.BaseBottomSheetDialog;
import cc.onion.cosyfans.base.utils.TextMeoneryShowUtils;
import cc.onion.cosyfans.cart.adapter.CartChildenAdapter;
import cc.onion.cosyfans.cart.adapter.PromotionAdapter;
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
 * @Description: (促销活动对话框)
 */
public class PromotionListDialog extends BaseBottomSheetDialog implements PromotionCheckItemListener {

    View contextView;
    private Context mContext;
    private CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean itemDetailDTOListBean;
    private List<CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean.SwitchActivityLabelDTOListBean> currentList;


    PromotionCheckItemListener mCheckItemListener;
    /**
     * 当前活动ID
     */
    private String currentActivityCode;

    public PromotionListDialog(@NonNull Context context, CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean item, PromotionCheckItemListener listener, String activityCode) {
        super(context);
        this.mContext = context;
        this.itemDetailDTOListBean = item;
        this.mCheckItemListener =listener;
        this.currentActivityCode = activityCode;
    }


    @Override
    protected View createContentView(ViewGroup viewGroup) {
        contextView = LayoutInflater.from(getContext()).inflate(R.layout.cart_dialog_promotion, null);
        return contextView;
    }


    @Override
    public void onShow() {
        super.onShow();
        //业务操作
        btnCancel.setText(R.string.cart_ok);
        btnCancel.setBackgroundColor(mContext.getResources().getColor(R.color.bluce));
        btnCancel.setOnClickListener(v -> {

         dismiss();
        });
        findViewById(R.id.img_cancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        currentList  = new ArrayList<>();
        currentList.add(new CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean.SwitchActivityLabelDTOListBean(11111,0,"不参与促销活动"));
        //优惠券信息
        if(itemDetailDTOListBean.getSwitchActivityLabelDTOList() != null && itemDetailDTOListBean.getSwitchActivityLabelDTOList().size() >0){
            currentList.addAll(itemDetailDTOListBean.getSwitchActivityLabelDTOList());
        }

        //lsit
        RecyclerView popRecylerView = contextView.findViewById(R.id.lv_pop_recyclerview);
        PromotionAdapter promotionAdapter = new PromotionAdapter(null,this,currentActivityCode);

        popRecylerView.setLayoutManager(new LinearLayoutManager(mContext,1,false));
        popRecylerView.setAdapter(promotionAdapter);
        promotionAdapter.setNewData(currentList);
        promotionAdapter.notifyDataSetChanged();

        //数据操作
        ImageView imageProducts = findViewById(R.id.img_products);
        TextView productsMonery1 = findViewById(R.id.tv_products_monery);
        TextView itemId  = findViewById(R.id.tv_products_id);

        //基础数据显示
        if(itemDetailDTOListBean != null ){
            if(StringUtils.isNotEmpty(itemDetailDTOListBean.getItemLogoUrl())){
                BaseBindingAdapter.loadImage(imageProducts,itemDetailDTOListBean.getItemLogoUrl());
            }



            TextMeoneryShowUtils.setShowBigMonery(productsMonery1,itemDetailDTOListBean.getSkuPrice());
            itemId.setText("商品ID: "+itemDetailDTOListBean.getItemId());
        }


    }

    @Override
    public void checkItem(CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean.SwitchActivityLabelDTOListBean item) {
        if(mCheckItemListener != null){
            mCheckItemListener.checkItem(item);
        }

    }

    @Override
    public void notifyDataSetChangedView() {

    }

    @Override
    public void deleteChildenIitem() {

    }
}
