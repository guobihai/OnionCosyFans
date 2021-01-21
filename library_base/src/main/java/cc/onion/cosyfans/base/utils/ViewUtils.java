package cc.onion.cosyfans.base.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

/**
 * @author guobihai
 * on 2019-07-27
 */
public class ViewUtils {


    /**
     * 给textView 右侧显示图片
     * @param context
     * @param tartView
     * @param resId
     * @param textValue
     */
    public static void setTextViewRightImage(Context context,TextView tartView, int resId, String textValue) {
        tartView.setText(textValue);
        Drawable drawable = context.getResources().getDrawable(resId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tartView.setCompoundDrawables(null,null,drawable,null);
    }
}
