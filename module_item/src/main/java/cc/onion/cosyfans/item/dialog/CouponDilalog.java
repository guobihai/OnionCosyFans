package cc.onion.cosyfans.item.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import cc.onion.cosyfans.base.dialog.BaseBottomSheetDialog;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.item.adapter.ConponListAdapter;
import cc.onion.cosyfans.item.api.ItemApi;
import cc.onion.cosyfans.item.entity.CouponRequest;
import cc.onion.cosyfans.item.entity.SkuBaseEntity;
import cc.onion.cosyfans.item.entity.response.CouponListEntity;
import cc.onion.cosyfans.module_item.R;
import io.reactivex.disposables.Disposable;

/**
 * @author guobihai
 * @version V1.0
 * @Title: AppCommonInfo
 * @Package cc.onion.cosyfans.base.common
 * @date 2019-12-03 14:53
 * @email: anhui-zhuang@msyc.cc
 * @Description: 优惠券对话框，item跟cart公用一个)
 */
public class CouponDilalog extends BaseBottomSheetDialog {

    View contextView;
    ConponListAdapter conponListAdapter;
    protected Context mContext;
    RecyclerView lvConponRecyclerview,lv_unUse_recyclerview;
    ConponListAdapter conponListAdapter1;
    /**
     * 优惠券
     * @param context
     * @param cfCouponDTO
     */
    private String itemId;

    public CouponDilalog(@NonNull Context context, String id) {
        super(context);
        this.mContext =context;
        this.itemId = id;
    }

    @Override
    protected View createContentView(ViewGroup viewGroup) {
        contextView = LayoutInflater.from(getContext()).inflate(R.layout.item_dialog_coupon, null);
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
        contextView.findViewById(R.id.img_cancle).setOnClickListener(v -> dismiss());

        lvConponRecyclerview = findViewById(R.id.lv_conpon_recyclerview);
        lv_unUse_recyclerview = findViewById(R.id.lv_unUse_recyclerview);

        initLayout();
        if(StringUtils.isNotEmpty("29197")){
                CouponRequest request = new CouponRequest();
                request.getKeyMap().put("itemIdStr","29197");
                request.setItemIdStr("29197");
                request.setRequestSign(request.getKeyMap());
                loadData(request);
            }

    }

    private void initLayout() {


        conponListAdapter1 = new ConponListAdapter(null,mContext);
        lv_unUse_recyclerview.setAdapter(conponListAdapter1);
        lv_unUse_recyclerview.setLayoutManager(new LinearLayoutManager(mContext,1,false));
        conponListAdapter1.setOnItemClickListener((adapter, view, position) -> {
            // on Click


        });

        conponListAdapter = new ConponListAdapter(null,mContext);
        lvConponRecyclerview.setLayoutManager(new LinearLayoutManager(mContext,1,false));
        lvConponRecyclerview.setAdapter(conponListAdapter);
        conponListAdapter.setOnItemClickListener((adapter, view, position) -> {
            // on Click


        });
    }

    @Override
    public void onDismiss() {

    }

    public void loadData(CouponRequest couponRequest){
        getCouponList(couponRequest, new ResponseListener<BaseResponse<CouponListEntity>>() {
            @Override
            public void loadSuccess(BaseResponse<CouponListEntity> data) {
                KLog.i("test","加载数据成功"+data.toString());
                if(data.getData().getUnRecvList().size() == 0 &&  data.getData().getRecvList().size() ==0 ){
                    findViewById(R.id.layout_no_data).setVisibility(View.VISIBLE);
                    findViewById(R.id.layout_context).setVisibility(View.GONE);
                }else{

                }


//                if(data.getData().getUnRecvList() != null && data.getData().getUnRecvList().size() >0){
//
//                    conponListAdapter.setNewData(data.getData().getUnRecvList());
//                    conponListAdapter.notifyDataSetChanged();
//                }else{
//                    //add header recycleview
//                    View headerVew = LayoutInflater.from(mContext).inflate(R.layout.item_coupon_no_data, null, true);
//                    conponListAdapter.addHeaderView(headerVew);
//                }

                if(data.getData().getRecvList() != null && data.getData().getRecvList().size() >0){
                    lvConponRecyclerview.setVisibility(View.VISIBLE);
                    conponListAdapter.setNewData(data.getData().getRecvList());
                    conponListAdapter.notifyDataSetChanged();
                }else{
                    lvConponRecyclerview.setVisibility(View.GONE);
                }


                if(data.getData().getUnRecvList() != null && data.getData().getUnRecvList().size() >0){
                    lv_unUse_recyclerview.setVisibility(View.VISIBLE);
                    conponListAdapter1.setNewData(data.getData().getRecvList());
                    conponListAdapter1.notifyDataSetChanged();
                }else{
                    lv_unUse_recyclerview.setVisibility(View.GONE);
                }

            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {

            }

            @Override
            public void addDisposable(Disposable disposable) {
                addDisposable(disposable);
            }
        });
    }

    /**
     * 加载优惠券
     * @param request
     * @param listener
     */
    public void getCouponList(CouponRequest request, ResponseListener<BaseResponse<CouponListEntity>> listener){
        RetrofitManager
                .createToken(ItemApi.class)
                .getCouponListForItem(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<BaseResponse<CouponListEntity>>() {
                    @Override
                    public void onSuccess(BaseResponse<CouponListEntity> data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }


}
