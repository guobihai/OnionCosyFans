package cc.onion.cosyfans.cart.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.TextMeoneryShowUtils;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.cart.dialog.CartAddCartDilalog;
import cc.onion.cosyfans.cart.dialog.PromotionAddCartDilalog;
import cc.onion.cosyfans.cart.entity.response.PomptionListEntity;
import cc.onion.cosyfans.cart.listener.AddCartStateListener;
import cc.onion.cosyfans.item.entity.ItemDetailRequest;
import cc.onion.cosyfans.module_cart.R;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.cart.adapter
 * @ClassName: PopListProductAdapter
 * @Description: 折扣列表商品适配器
 * @Author: guobihai
 * @CreateDate: 2019-12-24 11:39
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-24 11:39
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class PopListProductAdapter extends BaseQuickAdapter<PomptionListEntity.DataBean.ItemsBean, BaseViewHolder>implements AddCartStateListener {

    Context mContext;
    AddCartStateListener listener;
    public PopListProductAdapter(Context mContext, @Nullable List<PomptionListEntity.DataBean.ItemsBean> data,AddCartStateListener addCartStateListener) {
        super(R.layout.cart_item_pop, data);
        this.mContext = mContext;
        this.listener = addCartStateListener;
    }

    @Override
    protected void convert(BaseViewHolder helper, PomptionListEntity.DataBean.ItemsBean item) {
        try {
            helper.setText(R.id.tv_title,item.getItemName());
            TextView monery = helper.getView(R.id.tv_monery);
            TextView monery2 = helper.getView(R.id.tv_monery2);
            TextMeoneryShowUtils.setShowBigMonery(monery,item.getSellingPrice());
            TextMeoneryShowUtils.setShowLineMonery(monery2,item.getMarketPrice());

            //image
            ImageView imgItem = helper.getView(R.id.img_item);
            BaseBindingAdapter.loadImage(imgItem,item.getImageMedium());
            //设置有无库存显示
            if(item.getHasStock() == 1){
                helper.getView(R.id.layout_add_cart).setVisibility(View.VISIBLE);
                helper.getView(R.id.img_no_sku).setVisibility(View.GONE);
            }else{
                helper.getView(R.id.layout_add_cart).setVisibility(View.GONE);
                helper.getView(R.id.img_no_sku).setVisibility(View.VISIBLE);
            }

            helper.getView(R.id.layout_add_cart).setOnClickListener(v -> {
                //点击弹出购物车对话框
                //初始化加入购物车对话框
                ItemDetailRequest request = new ItemDetailRequest();
                request.setItemId(TypeUtils.toString(item.getItemId()));
                request.getKeyMap().put("itemId",TypeUtils.toString(item.getItemId()));
                request.setRequestSign(request.getKeyMap());
                //调用下单对话框
                PromotionAddCartDilalog dilalog = new PromotionAddCartDilalog(request,mContext,this);
                if(!dilalog.isShowing()){
                    dilalog.show();
                }

            });

            //优惠券
            if(StringUtils.isNotEmpty(item.getPromotionLabel())){
                helper.setText(R.id.tv_pop,item.getPromotionLabel());
            }else{
                helper.setVisible(R.id.tv_pop,false);
            }

            if(StringUtils.isNotEmpty(item.getCouponLabel())){
                helper.setText(R.id.tv_cup,item.getCouponLabel());
            }else{
                helper.setVisible(R.id.tv_cup,false);
            }

            //点击事件
            helper.getView(R.id.layout_item).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //商品详情
                    ARouter.getInstance()
                            .build(RouterPath.Item.ROUTE_ITEM_PRODUCTS_PATH)
                            .withString("itemId", TypeUtils.toString(item.getItemId()))
                            .navigation(mContext);
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Override
    public void onSuccess() {
        listener.onSuccess();
    }

    @Override
    public void onError() {
        listener.onError();
    }
}
