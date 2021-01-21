package cc.onion.cosyfans.my.dialogs;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Objects;

import cc.onion.cosyfans.base.utils.ScreenUtils;
import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.my.entity.UserStatisticsDetails;

/**
 * 商家中心-注册统计-用户详情收益
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.dialogs
 * @ClassName: OrderInComeDialog
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/15 17:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/15 17:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UserDetailIncomeDialog extends Dialog {

    private UserStatisticsDetails.DataBean mDataBean;
    private Context mContext;

    public UserDetailIncomeDialog(@NonNull Context context, UserStatisticsDetails.DataBean dataBean) {
        super(context);
        this.mContext = context;
        this.mDataBean = dataBean;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.my_user_statistics_details_dialog_layout);
        final WindowManager.LayoutParams params = Objects.requireNonNull(this.getWindow()).getAttributes();
        params.width = ScreenUtils.getScreenWidth() - ScreenUtils.getScreenWidth() / 6;
        this.getWindow().setAttributes(params);
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        if (null == mDataBean) {
            dismiss();
            return;
        }
        TextView tvTvOrderQuantityValue = findViewById(R.id.tv_tv_order_quantity_value);
        TextView tvTotalValue = findViewById(R.id.tv_total_value);
        TextView tvTotalRefundedValue = findViewById(R.id.tv_total_refunded_value);
        TextView tvContributionIncomeValue = findViewById(R.id.tv_contribution_income_value);
        TextView tvPerCustomerTransacValue = findViewById(R.id.tv_per_customer_transac_value);
        tvTvOrderQuantityValue.setText(String.valueOf(mDataBean.getOrderCount()));
        tvTotalValue.setText(mContext.getResources().getString(R.string.my_monye_type).concat(String.valueOf(mDataBean.getRetailCount())));
        tvTotalRefundedValue.setText(mContext.getResources().getString(R.string.my_monye_type).concat(String.valueOf(mDataBean.getRefundCount())));
        tvContributionIncomeValue.setText(mContext.getResources().getString(R.string.my_monye_type).concat(String.valueOf(mDataBean.getTotalEarnings())));
        tvPerCustomerTransacValue.setText(mContext.getResources().getString(R.string.my_monye_type).concat(String.valueOf(mDataBean.getCustomerUnitPrice())));


        findViewById(R.id.btnCloseDialog).setOnClickListener(v -> {
            dismiss();
        });
    }


}
