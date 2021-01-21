package cc.onion.cosyfans.base.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


import cc.onion.cosyfans.library_base.R;

/**
 * 底部弹出框
 * 功能：
 * 1. 底部弹出动画
 * 2. 设置内容布局
 * 3. 取消按钮
 * <p>
 * 使用例子：
* {@link }
 * com.ujuz.library.base.dialog.ListBottomSheetDialog
 * @Author zrh
 * @Created 3/20/19
 * @Editor zrh
 * @Edited 3/20/19
 * @Type
 * @Layout
 * @Api
 */
public abstract class BaseBottomSheetDialog extends Dialog implements DialogLifecycle {

    private FrameLayout layoutDialogContent;
    protected TextView btnCancel,betnOne,betnTwo;
    protected LinearLayout layoutBase;


    public BaseBottomSheetDialog(@NonNull Context context) {
        super(context, R.style.BaseBottomSheetDialog);
        setContentView(R.layout.base_dialog_bottom_sheet);
        initView();
    }

    private void initView() {
        btnCancel = findViewById(R.id.btn_dialog_cancel);
        betnOne = findViewById(R.id.betn_one);
        betnTwo = findViewById(R.id.betn_two);
        layoutBase = findViewById(R.id.layout_base);

        btnCancel.setOnClickListener(v -> dismiss());
        layoutDialogContent = findViewById(R.id.layout_dialog_content);
        layoutDialogContent.addView(createContentView(layoutDialogContent), FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void show() {
        super.show();
        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        window.setWindowAnimations(R.style.BaseBottomSheetDialog);  //添加动画

        onShow();
    }


    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    public void onShow() {

    }

    @Override
    public void onDismiss() {

    }

    /**
     * 创建内容布局
     *
     * @param viewGroup 内容布局依赖的父布局
     * @return 返回内容布局
     */
    protected abstract View createContentView(ViewGroup viewGroup);



}
