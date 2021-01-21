package cc.onion.cosyfans.base.utils;

import android.view.Gravity;
import android.widget.Toast;

/**
 * @author guobihai
 * @date 2019/3/20
 */
public class ToastUtil {


    /**
     * 长时间提示信息显示
     */
    public static void Long(String text) {
        Toast.makeText(AppContext.getAppContext(), text, Toast.LENGTH_LONG).show();
    }

    /**
     * 长时间提示信息显示
     */
    public static void Long(int srcId) {
        Toast.makeText(AppContext.getAppContext(), srcId, Toast.LENGTH_LONG).show();
    }

    /**
     * 短时间提示信息显示
     */
    public static void Short(String text) {
        Toast.makeText(AppContext.getAppContext(), text, Toast.LENGTH_SHORT).show();
    }

    /**
     * 短时间提示信息显示
     */
    public static void Short(int srcId) {
        Toast.makeText(AppContext.getAppContext(), srcId, Toast.LENGTH_SHORT).show();
    }

    /**
     * 弹出列表总数
     * */
    public static void total(String massage) {
        Toast toast = Toast.makeText(AppContext.getAppContext(), massage, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
