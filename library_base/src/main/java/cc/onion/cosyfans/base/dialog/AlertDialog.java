package cc.onion.cosyfans.base.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import cc.onion.cosyfans.base.utils.Utils;
import cc.onion.cosyfans.library_base.R;

/**
 * 消息提示对话框
 * <p>
 * 使用例子：
 * {@link com.ujuz.library.base.dialog.Examples#showAlertDialog}
 *
 * @Author guobihai
 * @Created 3/20/19
 * @Editor zrh
 * @Edited 3/20/19
 * @Type
 * @Layout
 * @Api
 */
public class AlertDialog extends BaseDialog {


    private TextView tvMessage;

    public AlertDialog(@NonNull Context context) {
        super(context);
    }

    /**
     * 定义自己的内容布局
     *
     * @param viewGroup 内容布局依赖的父布局
     * @return
     */
    @Override
    protected View createContentView(ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.base_dialog_alert, viewGroup, false);
        tvMessage = view.findViewById(R.id.tv_dialog_alert_message);
        return view;
    }

    @Override
    public void onShow() {

    }

    @Override
    public void onDismiss() {

    }

    /**
     * 设置消息内容
     *
     * @param msg
     */
    public void setMessage(CharSequence msg) {
        if (msg == null) return;
        tvMessage.setText(msg);
    }

    /**
     * 设置文字对齐
     *
     * @param gravity
     */
    public void setMessageGravity(int gravity) {
        tvMessage.setGravity(gravity);
    }

    /**
     * 设置上文字边距
     * @param
     * @param dp
     */
    public void setMessagePaddingTop(int dp) {
        tvMessage.setPadding(0, Utils.dp2Px(getContext(),dp),0,0);
    }

}
