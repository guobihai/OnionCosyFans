package cc.onion.cosyfans.item.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.dialog.BaseBottomSheetDialog;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.base.event.CartViewRereshEvent;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.base.utils.TextMeoneryShowUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.item.adapter.AddItemArraryAdapter;
import cc.onion.cosyfans.item.adapter.AddItemToCartAdapter;
import cc.onion.cosyfans.item.api.ItemApi;
import cc.onion.cosyfans.item.entity.AddCartRequest;
import cc.onion.cosyfans.item.entity.CartJsonEntity;
import cc.onion.cosyfans.item.entity.ItemDetailRequest;
import cc.onion.cosyfans.item.entity.SkuBaseEntity;
import cc.onion.cosyfans.item.entity.response.ItemDetailEntity;
import cc.onion.cosyfans.module_item.R;
import io.reactivex.disposables.Disposable;

/**
 *
 * 商品加入购物车对话框
 * 1、商品调用，2、购物车调用
 * @author guobihai
 * @email:guobihai@163.com
 *
 */
public class ProductAddCartDilalog extends BaseBottomSheetDialog implements AddItemArraryAdapter.ChooseCurrentItem {

    View contextView;
    protected Context mContext;
    AddItemToCartAdapter addItemToCartAdapter;
    /**
     * item 基础数据，包含所有
     */
    ItemDetailEntity.DataBean mItemDataModel;
    /**
     * 处理过的SKu数据
     */
    List<SkuBaseEntity> mSkBaseEntityList;
    /**
     * 加入购物车数量
     */
    TextView tvCount;

    /**
     * 当前SKU的数据模型
     */
    SkuBaseEntity currentSkuModel;


    /**
     * 当前SKU库存
     */
    int sKuStock = 0;


    /**
     * 当前库存
     */
    int currentCount = 1;
    FrameLayout layoutPlus;
    FrameLayout layoutLess;




    /**
     *接口请求参数
     */
    ItemDetailRequest request;


    TextView itemId;
    ImageView imageProducts;
    TextView productsMonery1;
    TextView prouctsMonery2;


    public ProductAddCartDilalog( ItemDetailRequest request, @NonNull Context context) {
        super(context);
        this.mContext = context;
        this.request = request;


    }

    /**
     * 初始化基本商品接口数据
     * @param request
     */
    private void initItemData(ItemDetailRequest request) {

        getItemDetail(request, new ResponseListener<ItemDetailEntity>() {
            @Override
            public void loadSuccess(ItemDetailEntity data) {
                //基础数据
                if(data.getData() != null){
                    mItemDataModel = data.getData();
                }


                //处理SKU数据
                if(data.getData().getSkuInfoShowDTO() != null && data.getData().getSkuInfoShowDTO().getSkuPriceMap() != null){

                    //获取SKU的Sting文件数据，进行动态解析
                    LinkedTreeMap<String, SkuBaseEntity> skuPriceMap = (LinkedTreeMap<String, SkuBaseEntity>) data.getData().getSkuInfoShowDTO().getSkuPriceMap();
                    Gson gson = new Gson();
                    String toJson = gson.toJson(skuPriceMap);
                    KLog.i("test","json数组:"+toJson);

                    List<String> skuKeyList = new ArrayList<>();
                    List<SkuBaseEntity> skuBaseEntityList = new ArrayList<>();
                    if(skuPriceMap != null && skuPriceMap.size() >0){

                        Iterator iter = skuPriceMap.entrySet().iterator();
                        while(iter.hasNext()) {
                            //循环添加SKu数据到集合对象，把key Name 也添加进集合当中处理

                            Map.Entry entry = (Map.Entry)iter.next();
                            // 获取key Name
                            skuKeyList.add((String)entry.getKey());
                            //获取Value
                            Object skuObject = skuPriceMap.get((String)entry.getKey());
                            String skuEntity = gson.toJson(skuObject);
                            SkuBaseEntity model  = gson.fromJson(skuEntity, SkuBaseEntity.class);
                            model.setSkuKeyName((String)entry.getKey());
                            skuBaseEntityList.add(model);

                        }
                    }

                    if(skuBaseEntityList != null && skuBaseEntityList.size() >0){
                        //数据初始化
                        mSkBaseEntityList = skuBaseEntityList;

                        if(mSkBaseEntityList != null && mSkBaseEntityList.size() >0){
                            currentSkuModel = mSkBaseEntityList.get(0);
                        }
                    }

                    /**
                     * 初始化基本数据
                     */
                    initDialogData(imageProducts, productsMonery1, prouctsMonery2, itemId);
                }

            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                KLog.i("test","获取数据失败:"+errorCode+errorMsg);
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addDisposable(disposable);
            }
        });

    }

    @Override
    protected View createContentView(ViewGroup viewGroup) {
        contextView = LayoutInflater.from(getContext()).inflate(R.layout.item_dialog_add_cart, null);
        return contextView;
    }

    @Override
    public void onShow() {
        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        //添加动画
        window.setWindowAnimations(cc.onion.cosyfans.library_base.R.style.BaseBottomSheetDialog);

        //业务操作
        btnCancel.setText(R.string.item_add_cart);
        btnCancel.setBackgroundColor(mContext.getResources().getColor(R.color.bluce));
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemSkutoCart();
            }
        });
        findViewById(R.id.img_cancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        RecyclerView lvConponRecyclerview = findViewById(R.id.lv_conpon_recyclerview);
        addItemToCartAdapter  = new AddItemToCartAdapter(mContext,this);
        lvConponRecyclerview.setLayoutManager(new LinearLayoutManager(mContext,1,false));
        lvConponRecyclerview.setAdapter(addItemToCartAdapter);
        addItemToCartAdapter.setOnItemClickListener((adapter, view, position) -> {
                // on Click


        });



        //数据操作
        imageProducts = findViewById(R.id.img_products);
        productsMonery1 = findViewById(R.id.tv_products_monery);
        prouctsMonery2 = findViewById(R.id.tv_products_monery_real);
        itemId = findViewById(R.id.tv_products_id);
        //计算
        layoutPlus = findViewById(R.id.layout_plus);
        layoutLess = findViewById(R.id.layout_less);
        tvCount = findViewById(R.id.tv_count);
        layoutPlus.setOnClickListener(v -> {
            //减操作
            lessCount();

        });
        layoutLess.setOnClickListener(v -> {
            //加操作
            plusCount();
        });

        //在界面初始化数据
        initItemData(request);


        //监听数量变化
        tvCount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {


                    if(StringUtils.isNotEmpty(s)){
                        KLog.i("test","数量变化："+s.toString());
                        /**
                         * 1、计算当前文本框输入的数量，如果大于当前的库存
                         * 就控制文本框的点击事件
                         * 反之就开启焦点事件的开启
                         * 2、并且把当前输入框的数量设置为当前库存的最大库存
                         */
                        if(Integer.parseInt(TypeUtils.toString(s)) >= sKuStock){
                            layoutLess.setEnabled(false);
//                            tvCount.setText(sKuStock);
                        }else{
                            /**
                             * 设置可点击事件，并且赋值正常
                             */
                            layoutLess.setEnabled(true);
//                            tvCount.setText(s);
                        }

//
//                        /**
//                         * 当前库存数量===1时，减操作不可以操作
//                         */
//                        if(Integer.parseInt(TypeUtils.toString(s)) == 1){
//                            layoutPlus.setEnabled(false);
//                        }else{
//                            layoutPlus.setEnabled(true);
//                        }


                    }

                }catch (Exception e){
                    KLog.i("test","监听输入框计算异常");
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });






    }

    /**
     * 初始化基本的数据显示
     * @param imageProducts
     * @param productsMonery1
     * @param prouctsMonery2
     * @param itemId
     */
    private void initDialogData(ImageView imageProducts, TextView productsMonery1, TextView prouctsMonery2, TextView itemId) {
        //基础数据显示
        if(mItemDataModel != null && mItemDataModel.getItemBaseInfoDTO() != null){
            if(mItemDataModel.getItemBaseInfoDTO().getSwiperList() != null && mItemDataModel.getItemBaseInfoDTO().getSwiperList().size() >0){
                String imageSmall = mItemDataModel.getItemBaseInfoDTO().getSwiperList().get(0).getImageSmall();
                BaseBindingAdapter.loadImage(imageProducts,imageSmall);
            }

            TextMeoneryShowUtils.setShowBigMonery(productsMonery1,mItemDataModel.getItemBaseInfoDTO().getSellingPriceRange());
            TextMeoneryShowUtils.setShowBigMonery(prouctsMonery2,mItemDataModel.getItemBaseInfoDTO().getMarketPriceRange());

            itemId.setText("商品ID: "+mItemDataModel.getItemBaseInfoDTO().getItemId());
        }


        //适配器数据操作
        if(mItemDataModel.getSkuInfoShowDTO() != null && mItemDataModel.getSkuInfoShowDTO().getSkuOptionNameList() != null
                && mItemDataModel.getSkuInfoShowDTO().getSkuOptionNameList().size() > 0){

            addItemToCartAdapter.setNewData(mItemDataModel.getSkuInfoShowDTO().getSkuOptionNameList());
            addItemToCartAdapter.notifyDataSetChanged();

        }
    }


    /**
     * 减数量操作
     */

    private void plusCount() {

        Calculation(true);
    }

    /**
     * 加操作
     */
    private void lessCount() {

        Calculation(false);
    }

    /**
     * 添加到购物车操作，涉及到接口
     */
    private void addItemSkutoCart() {
        addCart();

    }

    @Override
    public void onDismiss() {

    }


    /**
     * 选择商品SKU回调
     * @param item
     */
    @Override
    public void chooseCurrentItemOnClickListener(ItemDetailEntity.DataBean.SkuInfoShowDTOBean.SkuOptionNameListBean.SpecOptionListBean item) {
                if(mSkBaseEntityList != null && mSkBaseEntityList.size() >0){
                    for (SkuBaseEntity model:mSkBaseEntityList) {
                        if(model.getSkuKeyName().equals(TypeUtils.toString(item.getSpecOptId()))){
                            KLog.i("test","当前SKU名字:"+model.getSkuKeyName()+"数量"+model.getStock());
                            tvCount.setText("1");
                            currentSkuModel = model;
                        }

                    }

                }
    }


    /**
     * 1、加减库存处理
     * 2、库存最低或者最大加购数量
     * 3、库存不足处理，
     * 4、统一处理所有的计算业务
     */
    public void  Calculation(boolean isAdd){

        if(currentSkuModel != null){

            try {


                sKuStock = currentSkuModel.getStock();
                /**
         * 最小购买数量
         */
        int limitCount = currentSkuModel.getMinimumLimitCount();



                        // 0：无限购买； 非0：最低购买数
                        int minimumLimitCount = currentSkuModel.getLimitCount();
                        if(minimumLimitCount != 0){
//                            ：最低购买数
                            if(isAdd){
                                //添加
                                if(limitCount != 0) {
                                    //最低库存不为0的时候
                                    currentCount = currentCount + limitCount;
                                }else{
                                    currentCount = currentCount+1;
                                }
                            }else{
                                //减操作
                                if(limitCount != 0) {
                                    //最低库存不为0的时候
                                    currentCount =  currentCount  -limitCount;
                                }else{
                                    currentCount = currentCount-1;
                                }
                            }
                        }else{
                            // 0：无限购买；
                            if(isAdd){
                                currentCount = currentCount+1;
                            }else{
                                //库存为1时
                                if(currentCount ==1){
                                    layoutPlus.setEnabled(false);
                                }else{
                                    layoutPlus.setEnabled(true);
                                    currentCount = currentCount-1;
                                }

                            }
                        }


                    tvCount.setText(TypeUtils.toString(currentCount));
                        KLog.i("test","计算结果:"+currentCount+"计算类型："+isAdd +"产品库存："+sKuStock);


            }catch (Exception e){
                KLog.i("test","计算出错~~~~~");
                e.printStackTrace();
            }

        }

    }


    /**
     * 添加进购物车业务逻辑操作
     *
     */
    public void addCart(){
        if(currentSkuModel == null && mItemDataModel != null ) {
            return;
        }
        AddCartRequest cartRequest = new AddCartRequest();
        CartJsonEntity cartJson = new CartJsonEntity();
        cartJson.setSkuId(TypeUtils.toString(currentSkuModel.getSkuId()));
        cartJson.setAmount(TypeUtils.toString(currentCount));
        cartJson.setItemId(mItemDataModel.getItemBaseInfoDTO().getItemId());
        cartRequest.setCart(new Gson().toJson(cartJson));
        cartRequest.getKeyMap().put("cart",cartRequest.getCart());
        cartRequest.setRequestSign(cartRequest.getKeyMap());

        RetrofitManager
                .createToken(ItemApi.class)
                .addCart(cartRequest)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<BaseResponse>() {
                    @Override
                    public void onSuccess(BaseResponse data) {
                        if(data.getStatus().equals("200")){
                            //刷新操作
                            EventBus.getDefault().post(CartViewRereshEvent.VIEW_REFSH);
                            KLog.i("test","data show tost"+data.getStatus()+data.getMsg());
                        }else{
                            ARouter.getInstance().build(RouterPath.Passport.ROUTE_PASSPORT_SIGNIN_WITH_LOGIN)
                                    .greenChannel()
                                    .navigation();
                        }
                        dismiss();

                    }

                    @Override
                    public void onError(String code, String msg) {
                        ToastUtil.Short(msg);
                        dismiss();

                    }
                });
    }

    /**
     * 获取商品详情信息
     * @param request
     * @param listener
     */
    public void getItemDetail(ItemDetailRequest request, ResponseListener<ItemDetailEntity> listener) {
        RetrofitManager
                .create(ItemApi.class)
                .getItemDetail(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<ItemDetailEntity>() {
                    @Override
                    public void onSuccess(ItemDetailEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }


}
