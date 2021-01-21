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

import cc.onion.cosyfans.base.utils.ScreenUtils;
import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.my.adapter.TrackingDialogAdapt;
import cc.onion.cosyfans.my.entity.TrackingDetailEntry;

/**
 * 物流详情跟踪对话框
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.dialogs
 * @ClassName: TrackingDetialDialog
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/16 16:25
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/16 16:25
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TrackingDetialDialog extends Dialog {
    private TrackingDetailEntry.DataBean mData;
    private Context mContext;

    public TrackingDetialDialog(@NonNull Context context, TrackingDetailEntry.DataBean dataBean) {
        super(context, cc.onion.cosyfans.library_base.R.style.BaseBottomSheetDialog);
        this.mContext = context;
        this.mData = dataBean;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.my_tracking_detial_dialog_layout);
        Window window = getWindow();
        assert window != null;
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        //添加动画
        window.setWindowAnimations(cc.onion.cosyfans.library_base.R.style.BaseBottomSheetDialog);
//        if (null == mData) dismiss();
        findViewById(R.id.img_cancle).setOnClickListener(v -> {
            dismiss();
        });
        TextView tvCompanyNameValue = findViewById(R.id.tv_company_name_value);
        TextView tvTrackingNameValue = findViewById(R.id.tv_tracking_name_value);
        tvCompanyNameValue.setText(mData.getLogisticsCompany());
        tvTrackingNameValue.setText(mData.getLogisticsNo());

        RecyclerView recyclerView = findViewById(R.id.rv_tracking_recylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        List<TrackingDetailEntry.DataBean.TrackDetailListBean> listBeans = new ArrayList<>();
        TrackingDialogAdapt adapt = new TrackingDialogAdapt(listBeans);
        adapt.setEmptyView(R.layout.my_nodata_layout,recyclerView);
        recyclerView.setAdapter(adapt);
        if (null != mData.getTrackDetailList()) {
            adapt.setNewData(mData.getTrackDetailList());
        }

    }
}
