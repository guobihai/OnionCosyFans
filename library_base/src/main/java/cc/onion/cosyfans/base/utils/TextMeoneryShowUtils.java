package cc.onion.cosyfans.base.utils;

import android.content.Context;
import android.graphics.Paint;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;

/**
 * @author guobihai
 * @version V1.0
 * @Title: TextMeoneryShowUtils
 * @Package cc.onion.cosyfans.base.utils
 * @date 2019-12-03 14:15
 * @email: anhui-zhuang@msyc.cc
 * @Description: (Confans 使用到金额类显示)
 */
public  class TextMeoneryShowUtils {

    private static String TAG_MONERY =  "￥";
    private static String TAG_MONERY_RM =  "RM";

    /**
     *设置中间横线金额显示
     * @param textView
     * @param monery
     */
    public static  void setShowLineMonery(TextView textView,String monery){
        if(StringUtils.isNotEmpty(monery)){
            textView.setText(TAG_MONERY+monery);
            textView.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        }
    }


    /**
     * rm
     * @param textView
     * @param monery
     */
    public static  void setRMShowLineMonery(TextView textView,String monery){
        if(StringUtils.isNotEmpty(monery)){
            textView.setText(TAG_MONERY_RM+monery);
            textView.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        }
    }



    /**
     * 设置中间横线金额显示
     * @param textView
     * @param monery
     * @param color 颜色
     */
    public static void setShowLineMonery(TextView textView, String monery,int color){
        if(StringUtils.isNotEmpty(monery)){
            textView.setText(TAG_MONERY+monery);
            textView.setTextColor(color);
            textView.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        }
    }


    /**
     * 设置金额显示
     * @param textView
     * @param monery
     */
    public static  void  setShowBigMonery(TextView textView, String monery){
        if(StringUtils.isNotEmpty(monery)){
            textView.setText(TAG_MONERY+monery);
        }
    }

    /**
     * rm
     * @param textView
     * @param monery
     */
    public static  void  setRMShowBigMonery(TextView textView, String monery){
        if(StringUtils.isNotEmpty(monery)){
            textView.setText(TAG_MONERY_RM+monery);
        }
    }



    /**
     * 设置金额显示，可以设置颜色
     * @param textView
     * @param monery
     * @param color
     */
    public  static void  setShowBigMonery(TextView textView, String monery,int color){
        if(StringUtils.isNotEmpty(monery)){
            textView.setText(TAG_MONERY+monery);
            textView.setTextColor(color);
        }
    }



}
