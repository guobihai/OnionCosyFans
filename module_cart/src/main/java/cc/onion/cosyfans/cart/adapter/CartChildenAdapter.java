package cc.onion.cosyfans.cart.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;

import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.base.event.CartViewRereshEvent;
import cc.onion.cosyfans.base.event.LoginSuccessEvent;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.base.utils.TextMeoneryShowUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.base.view.loadView.ILoadVew;
import cc.onion.cosyfans.base.view.loadView.ULoadView;
import cc.onion.cosyfans.cart.api.CartApi;
import cc.onion.cosyfans.cart.dialog.CartAddCartDilalog;
import cc.onion.cosyfans.cart.dialog.PromotionListDialog;
import cc.onion.cosyfans.cart.entity.AddCartRequest;
import cc.onion.cosyfans.cart.entity.CartJsonEntity;
import cc.onion.cosyfans.cart.entity.response.CartListEntity;
import cc.onion.cosyfans.cart.listener.ItemCheckOnlickListener;
import cc.onion.cosyfans.cart.listener.ItemOnClickSelectListener;
import cc.onion.cosyfans.cart.listener.PromotionCheckItemListener;
import cc.onion.cosyfans.item.dialog.CouponDilalog;
import cc.onion.cosyfans.item.dialog.ProductAddCartDilalog;
import cc.onion.cosyfans.item.entity.ItemDetailRequest;
import cc.onion.cosyfans.module_cart.R;

/**
 * @author guobihai
 * @version V1.0
 * @Title: AppCommonInfo
 * @Package cc.onion.cosyfans.base.common
 * @date 2019-12-03 14:53
 * @email: anhui-zhuang@msyc.cc
 * @Description: (购物车item 子view)
 */
public class CartChildenAdapter extends BaseQuickAdapter<CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean,
        BaseViewHolder> implements PromotionCheckItemListener {


    /**
     * 集合列表
     */
    List<CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean> currentChildenList = new ArrayList<>();

    /**
     * 选中回调
     */

    CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean.SwitchActivityLabelDTOListBean currentItem;

    //顶层数据
    CartListEntity.DataBean.CartDetailListBean mCartDetailItem;

    CouponDilalog couponDilalog;
    PromotionListDialog promotionListDialog;

    /**
     * 当前活动
     */
    CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean.SwitchActivityLabelDTOListBean currentActivityModel;

    /**
     * 子View
     */
    ItemOnClickSelectListener itemOnClickSelectListener;

    public CartChildenAdapter(Context mContxt, @Nullable List<CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean> data,
                             CartListEntity.DataBean.CartDetailListBean item,ItemOnClickSelectListener listener) {
        super(R.layout.cart_item_childen, data);
        this.mCartDetailItem = item;
        this.itemOnClickSelectListener = listener;
    }

    @Override
    protected void convert(BaseViewHolder helper, CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean item) {

        if(helper.getPosition() == 0){
            helper.getView(R.id.view_line).setVisibility(View.GONE);
        }else{
            helper.getView(R.id.view_line).setVisibility(View.VISIBLE);
        }
        //设置图片显示
        JumpItemDetail(helper, item);
        //设置最低购买数量
        setLimitTextViewShow(helper, item);

        //设置SKU显示,并且点击事件显示
        if(StringUtils.isNotEmpty(item.getItemSpecification())){
            helper.setText(R.id.tv_sku_text,item.getItemSpecification());
        }

        helper.getView(R.id.tv_sku_text).setOnClickListener(v -> {
            //初始化加入购物车对话框
            ItemDetailRequest request = new ItemDetailRequest();
            request.setItemId(TypeUtils.toString(item.getItemId()));
            request.getKeyMap().put("itemId",TypeUtils.toString(item.getItemId()));
            request.setRequestSign(request.getKeyMap());

            CartAddCartDilalog cartAddCartDilalog = new CartAddCartDilalog(request,mContext,item);
            cartAddCartDilalog.show();
        });

        //设置标题
        if(StringUtils.isNotEmpty(item.getItemName())){
            helper.setText(R.id.tv_childen_title,item.getItemName());
        }


        //设置价格
        if(StringUtils.isNotEmpty(item.getSkuPrice())){
            TextMeoneryShowUtils.setShowBigMonery(helper.getView(R.id.tv_childen_monery),item.getSkuPrice());
        }


        //是否海外
//        品类型，10：海外商品，20：普通商品
        if(item.getItemType() == 10){
            helper.setText(R.id.tv_childen_tag,"HK");
        }else{
            helper.setText(R.id.tv_childen_tag,"CN");
        }

        //进行判断显示
        checkPopOrCopShow(mCartDetailItem,item,helper);

        //设置数量显示
        if(StringUtils.isNotEmpty(item.getAmount())){
            helper.setText(R.id.tv_amount,TypeUtils.toString(item.getAmount()));
        }


        //加减显示控制
        helper.getView(R.id.tv_reduce).setOnClickListener(v -> {
            Calculation(item,false,helper);
        });
        //加控制
        helper.getView(R.id.tv_add).setOnClickListener(v -> {
            Calculation(item,true, helper);
        });


        //优惠券点击事件
        helper.getView(R.id.tv_vorchers).setOnClickListener(v -> {
            couponDilalog.show();


        });

        //促销
        helper.getView(R.id.layout_pop).setOnClickListener(v -> {

            //进行判断显示
            promotionListDialog.show();

        });

        //显示
        ImageView imageView = helper.getView(R.id.img_select);

        /**
         * 设置状态显示
         */
//        if(item.isChildenOnCLick()){
//            if(item.isCHeck()){
//                imageView.setImageResource(R.mipmap.icon_cart_cicle);
//            }else{
//                //判断是否为选中
//                imageView.setImageResource(R.mipmap.icon_check_agreen);
//
//            }
//
//        }else{
//
//        }
        KLog.i("test","孩子展示的类型:"+item.isCHeck());
        if(!item.isCHeck()){
            imageView.setImageResource(R.mipmap.icon_cart_cicle);
        }else{
            //判断是否为选中
            imageView.setImageResource(R.mipmap.icon_check_agreen);

        }

        /**
         * 勾选
         */
        helper.getView(R.id.layout_select).setOnClickListener(v -> {


            childenCheckState(item, imageView);

        });
    }


    /**
     * 控制子view的状态显示,根据判断返回
     * @param item
     * @param imageView
     */
    private void childenCheckState(CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean item, ImageView imageView) {
        if(item.isCHeck()){
            item.setCHeck(false);
            itemOnClickSelectListener.setSelectIitem(item,null);
            imageView.setImageResource(R.mipmap.icon_cart_cicle);
        }else{

        imageView.setImageResource(R.mipmap.icon_check_agreen);
        //判断是否为选中
        if(itemOnClickSelectListener != null){
            item.setCHeck(true);
            itemOnClickSelectListener.setSelectIitem(item,null);
        }
        KLog.i("test","最底层的孩子选择中的类型:"+item.isCHeck());
        }
    }

    //设置最低购买数量
    private void setLimitTextViewShow(BaseViewHolder helper, CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean item) {
        if(item.getLimitCount() >0){
            helper.getView(R.id.layout_mitCount).setVisibility(View.VISIBLE);
            helper.setText(R.id.tv_limit,"每人限购"+item.getLimitCount()+"件");
        }else{
            helper.getView(R.id.layout_mitCount).setVisibility(View.GONE);
        }
    }

    /**
     * 设置商品ITem，跳转事件
     * @param helper
     * @param item
     */
    private void JumpItemDetail(BaseViewHolder helper, CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean item) {
        if(StringUtils.isNotEmpty(item.getItemLogoUrl())){
            ImageView imgItem = helper.getView(R.id.img_item);
            BaseBindingAdapter.loadImage(imgItem,item.getItemLogoUrl());
            imgItem.setOnClickListener(v -> {
                if(item != null){
                    if(StringUtils.isNotEmpty(TypeUtils.toString(item.getItemId()))){
                        //商品详情
                        ARouter.getInstance()
                                .build(RouterPath.Item.ROUTE_ITEM_PRODUCTS_PATH)
                                .withString("itemId",TypeUtils.toString(item.getItemId()))
                                .navigation(mContext);
                    }
                }

            });
        }
    }



    /**
     * 选中回调事项,
     * 进行了2次回调
     * @param item
     */
    @Override
    public void checkItem(CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean.SwitchActivityLabelDTOListBean item) {

        if(item != null){
            this.currentItem  = item;
            KLog.i("test","选择折扣回调成功");
        }
    }

    @Override
    public void notifyDataSetChangedView() {
        notifyDataSetChanged();
    }

    /**
     * 删除item的数据
     */
    @Override
    public void deleteChildenIitem() {

    }


    /**
     * 判断是否显示优惠券还是折扣
     * @param item
     * @param helper
     */
    public void checkPopOrCopShow(CartListEntity.DataBean.CartDetailListBean mCartDetailItem,
                                  CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean item,
                                  BaseViewHolder helper){

        try{

        if(item != null && !StringUtils.isNotEmpty(mCartDetailItem.getActivityChoice())){
            KLog.i("test","不显示");
            helper.getView(R.id.tv_vorchers).setVisibility(View.GONE);
            helper.getView(R.id.layout_pop).setVisibility(View.GONE);
            helper.setVisible(R.id.view_wihite,false);
        }else{
            KLog.i("test","显示");
            helper.getView(R.id.tv_vorchers).setVisibility(View.VISIBLE);
            helper.getView(R.id.layout_pop).setVisibility(View.VISIBLE);
            helper.setVisible(R.id.view_wihite,true);

            //活动拆分 1、折扣，2、优惠券
            String[] actiivtyArray = mCartDetailItem.getActivityChoice().split(":");
            if(StringUtils.isNotEmpty(actiivtyArray[1])){
                //判断哪个是当前要显示的数据
                if(item != null && item.getSwitchActivityLabelDTOList() != null && item.getSwitchActivityLabelDTOList().size() >0){
                    for (CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean.SwitchActivityLabelDTOListBean model: item.getSwitchActivityLabelDTOList()) {
                        if(actiivtyArray[1].equals(TypeUtils.toString(model.getActivityId()))){
                            helper.setText(R.id.tv_pop_show,model.getSwitchLabel());
                            currentActivityModel = model;
                        }

                    }
                }
//

            }

            /**
             * 折扣对话框，进行了2次回调
             */
            promotionListDialog = new PromotionListDialog(mContext,item,this,actiivtyArray[1]);


            //优惠券
            if(StringUtils.isNotEmpty(TypeUtils.toString(item.getItemId()))){

                couponDilalog = new CouponDilalog(mContext,TypeUtils.toString(item.getItemId()));
            }




        }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    /**
     * 计算加减操作以及调用接口请求
     * @param item
     * @param isAdd TRUE  add false press
     * @param helper
     */
    private void Calculation(CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean item, boolean isAdd, BaseViewHolder helper) {
        String itemAmount = item.getAmount();
        //当前的数量
        int currentAmount = Integer.parseInt(itemAmount);

        if(isAdd){
            //加
            KLog.i("test","执行加操作"+"当前的数量"+currentAmount);
            currentAmount = currentAmount +1;

            addCart(item,currentAmount);
        }else{
            KLog.i("test","执行减操作"+"当前的数量"+currentAmount);
            currentAmount = currentAmount -1;
//            减
            addCart(item,currentAmount);

        }

        //设置数量
        helper.setText(R.id.tv_amount,TypeUtils.toString(itemAmount));

    }




    /**
     * 添加进购物车业务逻辑操作
     *
     * @param item
     * @param currentAmount
     */
    public void addCart(CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean item, int currentAmount){
        if(item == null  ) {
            return;
        }
        EventBus.getDefault().post(CartViewRereshEvent.VIEW_LOGING_START);
        AddCartRequest cartRequest = new AddCartRequest();
        CartJsonEntity cartJson = new CartJsonEntity();

        cartJson.setSkuId(item.getSkuId());
        cartJson.setAmount(currentAmount);
        cartJson.setCartId(item.getCartId());
       if(currentActivityModel != null){
           cartJson.setActivityId(currentActivityModel.getActivityId());
           cartJson.setActivityType(currentActivityModel.getActivityType());
       }


        cartRequest.setCart(new Gson().toJson(cartJson));
        cartRequest.getKeyMap().put("cart",cartRequest.getCart());
        cartRequest.setRequestSign(cartRequest.getKeyMap());

        RetrofitManager
                .createToken(CartApi.class)
                .updateCart(cartRequest)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<BaseResponse>() {
                    @Override
                    public void onSuccess(BaseResponse data) {

                        if(data.getStatus().equals("200")){
                            KLog.i("test","data show tost"+data.getStatus()+data.getMsg());
                            //刷新操作
                            EventBus.getDefault().post(CartViewRereshEvent.VIEW_REFSH);
                        }

                        EventBus.getDefault().post(CartViewRereshEvent.VIEW_LOGIN_FINISH);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        KLog.i("test","data show tost"+msg);
                        EventBus.getDefault().post(CartViewRereshEvent.VIEW_LOGIN_FINISH);
                    }
                });
    }

}
