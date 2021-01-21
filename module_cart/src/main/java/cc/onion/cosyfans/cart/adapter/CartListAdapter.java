package cc.onion.cosyfans.cart.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.yanzhenjie.recyclerview.OnItemMenuClickListener;
import com.yanzhenjie.recyclerview.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.SwipeMenuItem;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.base.dialog.AlertDialog;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.base.event.AppEvent;
import cc.onion.cosyfans.base.event.CartViewRereshEvent;
import cc.onion.cosyfans.base.event.Event;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.EventBusUtil;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.cart.api.CartApi;
import cc.onion.cosyfans.cart.entity.CartDeleteRequest;
import cc.onion.cosyfans.cart.entity.response.CartListEntity;
import cc.onion.cosyfans.cart.listener.ItemCheckOnlickListener;
import cc.onion.cosyfans.cart.listener.ItemOnClickSelectListener;
import cc.onion.cosyfans.module_cart.R;

/**
 * @author guobihai
 * @version V1.0
 * @Title: AppCommonInfo
 * @Package cc.onion.cosyfans.base.common
 * @date 2019-12-03 14:53
 * @email: anhui-zhuang@msyc.cc
 * @Description: (购物车类)> cartDetailList) {
 *         cartListAdapter = new CartListAdap
 */
public class CartListAdapter extends BaseQuickAdapter<CartListEntity.DataBean.CartDetailListBean, BaseViewHolder>
        implements  ItemOnClickSelectListener {


    /**
     * 子view显示
     */
    CartChildenAdapter  cartChildenAdapter;
    boolean isFirst = false;

    /**
     * 当前购物车数据
     */
    List<CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean> cartItemDetailDTOList;

    private Context mContxt;
    /**
     * 子View
     */
    ItemOnClickSelectListener itemOnClickSelectListener;


    /**
     * 当前的item对象
     */
    CartListEntity.DataBean.CartDetailListBean cartDetailListBean;

    public CartListAdapter(@Nullable List<CartListEntity.DataBean.CartDetailListBean> data,Context mContxt,ItemOnClickSelectListener itemOnClickSelectListener) {
        super(R.layout.cart_item_cart, data);
        this.mContxt = mContxt;
        isFirst = true;
        this.itemOnClickSelectListener = itemOnClickSelectListener;
    }

    @Override
    protected void convert(BaseViewHolder helper, CartListEntity.DataBean.CartDetailListBean item) {
        try {
            if(cartChildenAdapter == null){
                this.cartDetailListBean  = item;
                cartChildenAdapter = new CartChildenAdapter(mContxt,null,item,this);
                SwipeRecyclerView lvChildenRecyclerView = helper.getView(R.id.lv_childen_revyclerview);

                // 创建菜单：
                SwipeMenuCreator mSwipeMenuCreator = (leftMenu, rightMenu, position) -> {
                    SwipeMenuItem deleteItem = new SwipeMenuItem(mContext); // 各种文字和图标属性设置。
                    deleteItem.setText("删除");
                    deleteItem.setBackgroundColor(mContxt.getResources().getColor(R.color.orange));
                    deleteItem.setTextColor(mContxt.getResources().getColor(R.color.white));
                    deleteItem.setWidth(200);
                    deleteItem.setHeight(150);
                    rightMenu.addMenuItem(deleteItem); // 在Item左侧添加一个菜单。
                };


                if(mSwipeMenuCreator !=null )
                    lvChildenRecyclerView.setSwipeMenuCreator(mSwipeMenuCreator);


                OnItemMenuClickListener mItemMenuClickListener = (menuBridge, position) -> {
                    // 任何操作必须先关闭菜单，否则可能出现Item菜单打开状态错乱。
                    menuBridge.closeMenu();
                    ToastUtil.Short("点击删除");
                    // 左侧还是右侧菜单：
                    int direction = menuBridge.getDirection();
                    // 菜单在Item中的Position：
                    int menuPosition = menuBridge.getPosition();

                    CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean model = cartItemDetailDTOList.get(position);
                    if(model != null ){
                        AlertDialog alertDialog = new AlertDialog(mContext);
                        alertDialog.setMessage("您确定要删除选中的商品吗？");
                        alertDialog.setLeftButton("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialog.dismiss();
                            }
                        });
                        alertDialog.setRightButton("确认", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                deleCart(model,position);
                                alertDialog.dismiss();
                            }
                        });
                        alertDialog.show();

                    }
                };

                // 菜单点击监听。
                lvChildenRecyclerView.setOnItemMenuClickListener(mItemMenuClickListener);
                // 侧滑删除，默认关闭。
                lvChildenRecyclerView.setItemViewSwipeEnabled(false);

                lvChildenRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,1,false));
                lvChildenRecyclerView.setAdapter(cartChildenAdapter);
            }

        //数据设置

            cartItemDetailDTOList = item.getCartItemDetailDTOList();
            if(item.getCartItemDetailDTOList() != null && item.getCartItemDetailDTOList().size() >0){
                cartChildenAdapter.setNewData(cartItemDetailDTOList);
                cartChildenAdapter.notifyDataSetChanged();
            }



            //点击事件
            helper.getView(R.id.tv_go_order).setOnClickListener(v ->
                    //活动列表
                    ARouter.getInstance()
                    .build(RouterPath.Cart.ROUTE_CART_PATH_ACTIVITY).navigation());





        }catch (Exception e){
            e.printStackTrace();
        }
    }




    /**
     * 刷新子View的状态
     */
    public void  checkChildenState(){
        KLog.i("test","刷新孩子的状态");
        cartChildenAdapter.notifyDataSetChanged();
    }


    /**
     * 删除购物车数据
     * @param model
     * @param position
     */
    private void deleCart(CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean model, int position) {
        EventBus.getDefault().post(CartViewRereshEvent.VIEW_LOGING_START);
        CartDeleteRequest cartRequest = new CartDeleteRequest();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(model.getCartId());
        String toJson = new Gson().toJson(integerList);
        cartRequest.setCartIds(integerList);
        KLog.i("test","json数组："+toJson);

        cartRequest.getKeyMap().put("cartIds",new Gson().toJson(integerList));
        cartRequest.setRequestSign(cartRequest.getKeyMap());

        RetrofitManager
                .createToken(CartApi.class)
                .deleteCart(cartRequest)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<BaseResponse>() {
                    @Override
                    public void onSuccess(BaseResponse data) {

                        if(data.getStatus().equals("200")){
                            KLog.i("test","data show tost"+data.getStatus()+data.getMsg());
                            //刷新操作,刷新主架构，刷新购物车界面
                            EventBusUtil.sendEvent(new Event(AppEvent.EventCode.carRefresh));
                            EventBusUtil.sendEvent(new Event(AppEvent.EventCode.refresh));
                        }


                    }

                    @Override
                    public void onError(String code, String msg) {
                        KLog.i("test","data show tost"+msg);
                        EventBus.getDefault().post(CartViewRereshEvent.VIEW_LOGIN_FINISH);
                    }
                });

    }


    @Override
    public void setSelectIitem(CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean item, CartListEntity.DataBean.CartDetailListBean cartDetailListBean) {
        if(item != null && this.cartDetailListBean != null){
            this.cartDetailListBean.setGroupCheck(true);
            itemOnClickSelectListener.setSelectIitem(item, this.cartDetailListBean);
        }

    }
}
