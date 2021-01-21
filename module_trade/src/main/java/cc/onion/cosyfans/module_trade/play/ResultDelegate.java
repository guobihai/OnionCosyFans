package cc.onion.cosyfans.module_trade.play;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ipay.IPayIHResultDelegate;

import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;

import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.KLogUtils;
import cc.onion.cosyfans.module_trade.TradeAcivity;
import cc.onion.cosyfans.module_trade.entity.CartCreateEntity;
import cc.onion.cosyfans.module_trade.entity.CreateOrderEntity;
import cc.onion.cosyfans.passport.Event.PlayResultEvent;
import cc.onion.cosyfans.passport.Event.SigninPageEvent;


/**
 * Created by pnduy on 3/9/2016.
 */
public class ResultDelegate implements IPayIHResultDelegate, Serializable {
    private static final long serialVersionUID = 10001L;
    private static final String TAG = ResultDelegate.class.getSimpleName();



    @Override
    public void onPaymentSucceeded(String TransId, String RefNo, String Amount,
                                   String Remark, String AuthCode, String CCName,
                                   String CCNo, String S_bankname, String S_country) {

        String extra = "";
        extra = extra + "TransId\t= " + TransId + "\n";
        extra = extra + "RefNo\t\t= " + RefNo + "\n";
        extra = extra + "Amount\t= " + Amount + "\n";
        extra = extra + "Remark\t= " + Remark + "\n";
        extra = extra + "AuthCode\t= " + AuthCode + "\n";
//        extra = extra + "CCName\t= " + CCName + "\n";
//        extra = extra + "CCNo\t= " + CCNo + "\n";
//        extra = extra + "S_bankname\t= " + S_bankname + "\n";
//        extra = extra + "S_country\t= " + S_country;
       KLogUtils.logTest( Remark);
        EventBus.getDefault().post(PlayResultEvent.SUCCESS);
    }

    @Override
    public void onPaymentFailed(String TransId, String RefNo, String Amount,
                                String Remark, String ErrDesc, String CCName,
                                String CCNo, String S_bankname, String S_country) {

        String extra = "";
        extra = extra + "TransId\t= " + TransId + "\n";
        extra = extra + "RefNo\t\t= " + RefNo + "\n";
        extra = extra + "Amount\t= " + Amount + "\n";
        extra = extra + "Remark\t= " + Remark + "\n";
        extra = extra + "ErrDesc\t= " + ErrDesc + "\n";
//        extra = extra + "CCName\t= " + CCName + "\n";
//        extra = extra + "CCNo\t= " + CCNo + "\n";
//        extra = extra + "S_bankname\t= " + S_bankname + "\n";
//        extra = extra + "S_country\t= " + S_country;
        KLogUtils.logTest( ErrDesc);
        KLogUtils.logTest( Remark);
        EventBus.getDefault().post(PlayResultEvent.ERROR);
    }

    @Override
    public void onPaymentCanceled(String TransId, String RefNo, String Amount,
                                  String Remark, String ErrDesc, String CCName,
                                  String CCNo, String S_bankname, String S_country) {


        String extra = "";
        extra = extra + "TransId\t= " + TransId + "\n";
        extra = extra + "RefNo\t\t= " + RefNo + "\n";
        extra = extra + "Amount\t= " + Amount + "\n";
        extra = extra + "Remark\t= " + Remark + "\n";
        extra = extra + "ErrDesc\t= " + ErrDesc + "\n";
//        extra = extra + "CCName\t= " + CCName + "\n";
//        extra = extra + "CCNo\t= " + CCNo + "\n";
//        extra = extra + "S_bankname\t= " + S_bankname + "\n";
//        extra = extra + "S_country\t= " + S_country;
        KLogUtils.logTest( Remark);
        KLogUtils.logTest( ErrDesc);
        EventBus.getDefault().post(PlayResultEvent.SUCCESS);

    }

    @Override
    public void onRequeryResult(String MerchantCode, String RefNo,
                                String Amount, String Result) {
        String extra = "";
        extra = extra + "MerchantCode\t= " + MerchantCode + "\n";
        extra = extra + "RefNo\t\t= " + RefNo + "\n";
        extra = extra + "Amount\t= " + Amount + "\n";
        extra = extra + "Result\t= " + Result;
        KLogUtils.logTest( extra);


    }

    @Override
    public void onConnectionError(String merchantCode, String merchantKey,
                                  String RefNo, String Amount, String Remark, String lang, String country) {

        String extra = "";
        extra = extra + "Merchant Code\t= " + merchantCode + "\n";
        extra = extra + "RefNo\t\t= " + RefNo + "\n";
        extra = extra + "Amount\t= " + Amount + "\n";
        extra = extra + "Remark\t= " + Remark + "\n";
        extra = extra + "Language\t= " + lang + "\n";
        extra = extra + "Country\t= " + country + "\n";
//        extra = extra + "ErrDesc\t= " + "Had connection error while connecting to IPay server";
        KLogUtils.logTest(extra);
        EventBus.getDefault().post(PlayResultEvent.ERROR);
    }


}
