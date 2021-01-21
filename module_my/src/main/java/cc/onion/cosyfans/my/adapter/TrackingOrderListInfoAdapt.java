package cc.onion.cosyfans.my.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.my.entity.TrackingInfoEntry;
import cc.onion.cosyfans.my.entity.request.OrderHistoryRequest;
import cc.onion.cosyfans.my.interfaces.ItemOnClickInterface;

/**
 * 商家中心-查看物流-订单列表
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.adapter
 * @ClassName: TrackingOrderListInfoAdapt
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/16 14:09
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/16 14:09
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TrackingOrderListInfoAdapt extends BaseQuickAdapter<TrackingInfoEntry.DataBean, BaseViewHolder> {
    private ItemOnClickInterface<String> onClickInterface;

    public void setOnClickInterface(ItemOnClickInterface<String> onClickInterface) {
        this.onClickInterface = onClickInterface;
    }

    public TrackingOrderListInfoAdapt(@Nullable List<TrackingInfoEntry.DataBean> data) {
        super(R.layout.my_query_tracking_item_layout, data);
    }

    private String getOrderStatuValue(int orderStatus) {
        switch (orderStatus) {
            case OrderHistoryRequest.ORDER_COMPLETE:
                return mContext.getResources().getString(R.string.my_order_complete);
            case OrderHistoryRequest.ORDER_DELIVERING:
                return mContext.getResources().getString(R.string.my_order_delivering);
            default:
                break;
        }
        return mContext.getResources().getString(R.string.my_order_complete);
    }

    @Override
    protected void convert(BaseViewHolder helper, TrackingInfoEntry.DataBean item) {
        helper.setText(R.id.tv_order_no, item.getSubOrderNo());
        helper.setText(R.id.tv_order_status, getOrderStatuValue(item.getOrderStatus()));
        RecyclerView recyclerView = helper.getView(R.id.rv_image_recycleView);
        if (item.getSubOrderItemImageList() != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setAdapter(new ImgProductAdapt(item.getSubOrderItemImageList()));
        }
        helper.getView(R.id.btn_order_tracking).setOnClickListener(v -> {
            if (null != onClickInterface) {

                onClickInterface.onClick(v, item.getSubOrderNo(), item.getOrderStatus());
            }
        });
    }

    class ImgProductAdapt extends BaseQuickAdapter<TrackingInfoEntry.DataBean.SubOrderItemImageListBean, BaseViewHolder> {

        ImgProductAdapt(@Nullable List<TrackingInfoEntry.DataBean.SubOrderItemImageListBean> data) {
            super(R.layout.my_query_tracking_item_img_layout, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, TrackingInfoEntry.DataBean.SubOrderItemImageListBean item) {
            ImageView icon = helper.getView(R.id.img_products_icon);
            if (!TextUtils.isEmpty(item.getItemImage())) {
                BaseBindingAdapter.loadImage(icon, item.getItemImage());
            }
        }
    }
}
