package cc.onion.cosyfans.module_trade.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;

import java.util.Timer;
import java.util.TimerTask;

import javax.xml.transform.Result;

import cc.onion.cosyfans.base.BaseActivity;
import cc.onion.cosyfans.base.BaseToolBarActivity;
import cc.onion.cosyfans.base.event.CartViewRereshEvent;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.TimeTools;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.module_trade.BR;
import cc.onion.cosyfans.module_trade.PlayResultAndroidModel;
import cc.onion.cosyfans.module_trade.R;
import cc.onion.cosyfans.module_trade.TradeAndroidViewModel;
import cc.onion.cosyfans.module_trade.databinding.TradePlayBinding;
import cc.onion.cosyfans.module_trade.entity.AddressListEntity;
import cc.onion.cosyfans.module_trade.listener.PlayResultViewListener;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_trade.activity
 * @ClassName: PlayResultActivity
 * @Description: 支付结果界面
 * @Author: guobihai
 * @CreateDate: 2019-12-26 16:30
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-26 16:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

@Route(path = RouterPath.Trade.ROUTE_TRADE_PLAY_RESULE)
public class PlayResultActivity extends BaseActivity<TradePlayBinding, PlayResultAndroidModel> implements PlayResultViewListener {

    private static final int WHAT = 101;

    @Autowired
    int orderState;

    @Autowired
    String totalMonery;

    @Autowired
    String orderNumber;



    private Timer mTimer;
    private TimerTask mTimerTask;
    //
    private static final long MAX_TIME = 40*60*1000;
    private long curTime = 0;


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.trade_play;
    }

    @Override
    public int initVariableId() {
        return BR.playModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setPlayResultViewListener(this);

    }

    @Override
    public void initData() {
        super.initData();
        if(StringUtils.isNotEmpty(totalMonery)){
            mViewModel.totalMonery.set("RM"+totalMonery);
        }
        //处理订单是否成功逻辑
        if(orderState ==1){
            //true
            mBinding.imgOrderState.setImageResource(R.mipmap.play_success);
            mViewModel.orderShowState.set(getString(R.string.trade_order_success));
            mBinding.layoutTime.setVisibility(View.GONE);
        }else if(orderState ==2){
            mBinding.imgOrderState.setImageResource(R.mipmap.order_state_error);
            mViewModel.orderShowState.set(getString(R.string.trade_order_error));
            mBinding.layoutTime.setVisibility(View.GONE);
        }else{
            mBinding.layoutTime.setVisibility(View.VISIBLE);
            mBinding.imgOrderState.setImageResource(R.mipmap.order_state_error);
            mViewModel.orderShowState.set(getString(R.string.trade_order_error));
            initTimer();
            mTimer.schedule(mTimerTask, 0, 1000);
        }
    }

    @Override
    public void initParam() {
        // 获取ARouter注入
        ARouter.getInstance().inject(this);
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
                    mViewModel.totalMonery.set(TimeTools.getCountTimeByLong(sRecLen));
                    if (sRecLen <= 0) {
                        mTimer.cancel();
                        curTime = 0;
                        if(StringUtils.isNotEmpty(orderNumber)){
                            ARouter.getInstance().build(RouterPath.Order.ROUTE_ORDER_DETAIL)
                                    .greenChannel()
                                    .withString("orderNo",orderNumber)
                                    .navigation();
                        }

                    }
                    break;
            }
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
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


    @Override
    public void toOrderDetail() {
        if(StringUtils.isNotEmpty(orderNumber)){
            ARouter.getInstance().build(RouterPath.Order.ROUTE_ORDER_DETAIL)
                    .greenChannel()
                    .withString("orderNo",orderNumber)
                    .navigation(this,10001);
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 10001){
            //回到主页
            finish();
            EventBus.getDefault().post(CartViewRereshEvent.VIEW_REFSH);
        }
    }


    @Override
    public void toHome() {

        //关闭页面，回调到主页

        setResult(RESULT_OK);
        finish();
    }
}
