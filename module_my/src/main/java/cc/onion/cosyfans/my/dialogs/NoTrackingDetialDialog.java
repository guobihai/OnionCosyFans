package cc.onion.cosyfans.my.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.my.adapter.TrackingDialogAdapt;
import cc.onion.cosyfans.my.entity.TrackingDetailEntry;

/**
 * 没有物流信息的对话框
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.dialogs
 * @ClassName: TrackingDetialDialog
 * @Description: java类作用描述
 * @Author: 唐朝
 * @CreateDate: 2020/1/16 16:25
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/16 16:25
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NoTrackingDetialDialog extends Dialog {

    public NoTrackingDetialDialog(@NonNull Context context) {
        super(context, cc.onion.cosyfans.library_base.R.style.BaseBottomSheetDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.my_tracking_nodata_dialog_layout);
        Window window = getWindow();
        assert window != null;
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        //添加动画
        window.setWindowAnimations(cc.onion.cosyfans.library_base.R.style.BaseBottomSheetDialog);
        findViewById(R.id.img_cancle).setOnClickListener(v -> {
            dismiss();
        });
    }
}
