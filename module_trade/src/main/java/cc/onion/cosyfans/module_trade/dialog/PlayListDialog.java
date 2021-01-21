package cc.onion.cosyfans.module_trade.dialog;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cc.onion.cosyfans.base.dialog.BaseBottomSheetDialog;
import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.base.utils.TimeTools;
import cc.onion.cosyfans.item.entity.SkuBaseEntity;
import cc.onion.cosyfans.module_trade.R;
import cc.onion.cosyfans.module_trade.adapter.PlayListAdapter;
import cc.onion.cosyfans.module_trade.api.TradeApi;
import cc.onion.cosyfans.module_trade.entity.CreateOrderEntity;
import cc.onion.cosyfans.module_trade.entity.PlayListEntity;
import cc.onion.cosyfans.module_trade.listener.PlayOnClickListener;
import io.reactivex.disposables.Disposable;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_trade.dialog
 * @ClassName: CashCouponDialog
 * @Description: 支付对话框
 * @Author: guobihai
 * @CreateDate: 2019-12-12 15:07
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-12 15:07
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class PlayListDialog extends BaseBottomSheetDialog implements PlayOnClickListener {

    private static final int WHAT = 101;

    View contextView;
    private Context mContext;
    private TextView tvTimer;
    private  RecyclerView rlPlayRecyclerview;


    private Timer mTimer;
    private TimerTask mTimerTask;
//
    private static final long MAX_TIME = 40*60*1000;
    private long curTime = 0;
    private boolean isPause = false;
    private String orderNumber;
    PlayOnClickListener listener;

    public PlayListDialog(@NonNull Context context, String orderNumber,PlayOnClickListener listener){
        super(context);
        this.mContext = context;
        this.orderNumber = orderNumber;
        this.listener = listener;
    }

    @Override
    protected View createContentView(ViewGroup viewGroup) {
        contextView = LayoutInflater.from(getContext()).inflate(R.layout.trade_dialog_play, null);
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
        window.setWindowAnimations(cc.onion.cosyfans.library_base.R.style.BaseBottomSheetDialog);  //添加动画


        //业务操作
        btnCancel.setVisibility(View.GONE);
        layoutBase.setVisibility(View.GONE);
        betnOne.setText(cc.onion.cosyfans.module_cart.R.string.cart_ok);
        layoutBase.setBackgroundColor(mContext.getResources().getColor(cc.onion.cosyfans.module_cart.R.color.bluce));
        layoutBase.setOnClickListener(v -> {
            dismiss();
        });
        findViewById(R.id.img_cancle).setOnClickListener(v -> dismiss());
        //业务操作
        findViewById(R.id.img_cancle).setOnClickListener(v -> dismiss());
        //时间
        tvTimer = findViewById(R.id.tv_timer);
        rlPlayRecyclerview = findViewById(R.id.rl_play_recyclerview);
        initTimer();
        mTimer.schedule(mTimerTask, 0, 1000);

        findViewById(R.id.tv_no_play).setVisibility(View.VISIBLE);
        rlPlayRecyclerview.setVisibility(View.GONE);

//
//        //lsit
//        RecyclerView popRecylerView = contextView.findViewById(R.id.lv_cosh_recyclerview);
//        CoshMoneryAdapter coshMoneryAdapter = new CoshMoneryAdapter(mContext,null,totalAmount,cashCouponId,this);
//
//        popRecylerView.setLayoutManager(new LinearLayoutManager(mContext,1,false));
//        popRecylerView.setAdapter(coshMoneryAdapter);

        
        loadPayMentList();

    }

    private void loadPayMentList() {
        BaseRequestBean requestBean = new BaseRequestBean();
        requestBean.setLanguage("en");
        requestBean.sign();
        getPaymentList(requestBean, new ResponseListener<PlayListEntity>() {
            @Override
            public void loadSuccess(PlayListEntity data) {
                KLog.i("test","获取支付列表成功");
                if(data.getData() != null && data.getData().size() >0){
                    rlPlayRecyclerview.setVisibility(View.VISIBLE);
                    findViewById(R.id.tv_no_play).setVisibility(View.GONE);
                    rlPlayRecyclerview.setLayoutManager(new LinearLayoutManager(mContext,1,false));
                    PlayListAdapter  playListAdapter =new PlayListAdapter(data.getData(),mContext,PlayListDialog.this::toPlayResule);
                    rlPlayRecyclerview.setAdapter(playListAdapter);

                }else{
                    rlPlayRecyclerview.setVisibility(View.GONE);
                    findViewById(R.id.tv_no_play).setVisibility(View.VISIBLE);
                }


            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                KLog.i("test","获取支付列表失败");
            }

            @Override
            public void addDisposable(Disposable disposable) {
                    addDisposable(disposable);
            }
        });
    }


    /**
     * 获取支付列表信息
     * @param requestBean
     * @param listener
     */
    public void getPaymentList(BaseRequestBean requestBean, ResponseListener<PlayListEntity> listener){
        RetrofitManager
                .createToken(TradeApi.class)
                .getPaymentList(requestBean)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<PlayListEntity>() {
                    @Override
                    public void onSuccess(PlayListEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }



    /**
     * 初始化Timer
     */
    public void initTimer() {
        mTimerTask = new TimerTask() {
            @Override
            public void run() {
                if (curTime == 0) {
                    curTime = MAX_TIME;
                } else {
                    curTime -= 1000;
                }
                Message message = new Message();
                message.what = WHAT;
                message.obj = curTime;
                mHandler.sendMessage(message);
            }
        };
        mTimer = new Timer();
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case WHAT:
                    long sRecLen = (long) msg.obj;
                    //毫秒换成00:00:00格式的方式，自己写的。
                    tvTimer.setText(TimeTools.getCountTimeByLong(sRecLen));
                    if (sRecLen <= 0) {
                        mTimer.cancel();
                        curTime = 0;
                        ARouter.getInstance().build(RouterPath.Order.ROUTE_ORDER_DETAIL)
                                .greenChannel()
                                .withString("orderNo",orderNumber)
                                .navigation();
                    }
                    break;
            }
        }
    };

    @Override
    public void onDismiss() {
        super.onDismiss();
        destroyTimer();
        if (mHandler != null) {
            mHandler.removeMessages(WHAT);
            mHandler = null;
        }

    }

    /**
     * destory上次使用的
     */
    public void destroyTimer() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
        if (mTimerTask != null) {
            mTimerTask.cancel();
            mTimerTask = null;
        }
    }


    /**
     * 唤起支付操作
     * @param item
     */
    @Override
    public void toPlayResule(PlayListEntity.DataBean item, String orderNo) {
        if(listener != null){
            listener.toPlayResule(item,orderNumber);
            dismiss();
        }
    }
}
