package cc.onion.cosyfans.base.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;


import cc.onion.cosyfans.library_base.R;

/**
 * 基础对话框
 * 功能：
 * 1. 设置标题
 * 2. 设置内容布局
 * 3. 设置左右按钮
 * <p>
 * 使用例子:
 * {@link AlertDialog}
 *
 * @Author guobihai
 * @Created 3/20/19
 * @Editor zrh
 * @Edited 3/20/19
 * @Type
 * @Layout
 * @Api
 */
public abstract class BaseDialog extends Dialog implements DialogLifecycle {

    public  TextView tvDialogTitle;
    private FrameLayout layoutDialogContent;
    public Button btnDialogLeft, btnDialogRight;

    public BaseDialog(@NonNull Context context) {
        super(context, R.style.BaseDialog);
        setContentView(R.layout.base_dialog);
        initView();
    }

    private void initView() {
        tvDialogTitle = findViewById(R.id.tv_dialog_title);
        layoutDialogContent = findViewById(R.id.layout_dialog_content);
        btnDialogLeft = findViewById(R.id.btn_dialog_left);
        btnDialogRight = findViewById(R.id.btn_dialog_right);

        layoutDialogContent.addView(createContentView(layoutDialogContent), FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        tvDialogTitle.setText(title);
    }

    /**
     * 设置标题的不同颜色
     * @param color
     * @param titleAndColor
     */
    public void setTitleAndColor(int color,String titleAndColor) {
        tvDialogTitle.setTextColor(color);
        tvDialogTitle.setText(Html.fromHtml(titleAndColor));
    }

    /**
     * 设置标题位置
     *
     * @param gravity
     */
    public void setTitleGravity(int gravity) {
        tvDialogTitle.setGravity(gravity);
    }

    /**
     * 设置左边按钮，不设置则不显示
     *
     * @param text
     * @param listener
     */
    public void setLeftButton(String text, View.OnClickListener listener) {
        btnDialogLeft.setVisibility(View.VISIBLE);
        btnDialogLeft.setText(text);
        btnDialogLeft.setOnClickListener(listener);
    }

    /**
     * 设置右边按钮，不设置则不显示
     *
     * @param text
     * @param listener
     */
    public void setRightButton(String text, View.OnClickListener listener) {
        btnDialogRight.setVisibility(View.VISIBLE);
        btnDialogRight.setText(text);
        btnDialogRight.setOnClickListener(listener);
    }

    /**
     * 创建内容布局
     *
     * @param viewGroup 内容布局依赖的父布局
     * @return 返回内容布局
     */
    protected abstract View createContentView(ViewGroup viewGroup);


    /**
     * 显示对话框
     */
    @Override
    public void show() {
        super.show();
        onShow();
    }

    /**
     * 隐藏对话框
     */
    @Override
    public void dismiss() {
        onDismiss();
        super.dismiss();
    }

    protected void hideTitle() {
        tvDialogTitle.setVisibility(View.GONE);
    }
}
