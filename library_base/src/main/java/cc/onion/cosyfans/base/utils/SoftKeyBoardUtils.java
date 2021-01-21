package cc.onion.cosyfans.base.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * 操作软件盘
 *
 * @Author guobihai
 * @Created 3/15/19
 * @Editor zrh
 * @Edited 3/15/19
 * @Type
 * @Layout
 * @Api
 */
public class SoftKeyBoardUtils {

    /**
     * 关闭软键盘
     */
    public static void closeKeyBoard(Activity activity) {
        View view = activity.getWindow().getDecorView();
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void closeKeyBoard(View target) {
        InputMethodManager imm = (InputMethodManager) target.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(target.getWindowToken(), 0);
    }

    public static void showKeyBoard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

    }

    public static void showKeyBoard(View target) {
        InputMethodManager imm = (InputMethodManager) target.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
