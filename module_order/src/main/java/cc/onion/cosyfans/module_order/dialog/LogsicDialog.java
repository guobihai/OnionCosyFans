package cc.onion.cosyfans.module_order.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import cc.onion.cosyfans.base.dialog.BaseBottomSheetDialog;
import cc.onion.cosyfans.module_order.R;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_order.dialog
 * @ClassName: LogsicDialog
 * @Description: 物流弹唱对话框
 * @Author: guobihai
 * @CreateDate: 2019-12-27 18:06
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-27 18:06
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LogsicDialog extends BaseBottomSheetDialog {

    View contextView;
    private Context mContext;

    public LogsicDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected View createContentView(ViewGroup viewGroup) {
        contextView = LayoutInflater.from(getContext()).inflate(R.layout.order_dialog_logsic, null);
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
    }

}
