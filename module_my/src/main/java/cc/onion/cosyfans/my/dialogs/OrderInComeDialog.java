package cc.onion.cosyfans.my.dialogs;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Map;
import java.util.Objects;

import cc.onion.cosyfans.base.utils.ScreenUtils;
import cc.onion.cosyfans.base.view.recycleview.SimpleDividerItemDecoration;
import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.my.adapter.OrderInComeAdapt;
import cc.onion.cosyfans.my.entity.OrderInComeEntry;
import cc.onion.cosyfans.my.entity.request.OrderHistoryRequest;
import cc.onion.cosyfans.my.entity.request.OrderInComeRequest;

/**
 * 商家中心-我的订单-我的收益
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
public class OrderInComeDialog extends Dialog {

    private OrderInComeEntry.DataBean mDataBean;
    private int mOrderStatus;
    private Context mContext;

    public OrderInComeDialog(@NonNull Context context, OrderInComeEntry.DataBean dataBean,int orderStatus) {
        super(context);
        this.mDataBean = dataBean;
        this.mContext = context;
        this.mOrderStatus = orderStatus;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.my_order_income_diglog_layout);
        final WindowManager.LayoutParams params = Objects.requireNonNull(this.getWindow()).getAttributes();
        params.width = ScreenUtils.getScreenWidth() - ScreenUtils.getScreenWidth() / 6;
        this.getWindow().setAttributes(params);
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        RecyclerView recyclerView = findViewById(R.id.my_order_income_recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(mContext,LinearLayoutManager.VERTICAL,R.drawable.my_center_line,1));
        recyclerView.setAdapter(new OrderInComeAdapt(mDataBean.getOrderIncomeDTOList()));
        TextView tvIncomeOrderUsernameValue = findViewById(R.id.tv_income_order_username_value);
        TextView tvIncomePaymentTimeValue = findViewById(R.id.tv_income_payment_time_value);
        tvIncomeOrderUsernameValue.setText(mDataBean.getUserName());
        tvIncomePaymentTimeValue.setText(mDataBean.getOrderTime());
        LinearLayout linearLayout = findViewById(R.id.llLevelLayout);

        String isAdd = mOrderStatus == OrderHistoryRequest.ORDER_COMPLETE?"+":"-";
        if (null != mDataBean.getGradeIncomeMap()) {
            for (Map.Entry<String, String> entry : mDataBean.getGradeIncomeMap().entrySet()) {
                String mapKey = entry.getKey();
                String mapValue = entry.getValue();
                System.out.println(mapKey + ":" + mapValue);
                View view = LayoutInflater.from(mContext).inflate(R.layout.my_order_income_level_layout, linearLayout, false);
                TextView tvIncomeLevelname = view.findViewById(R.id.tv_income_levelname);
                TextView tv_income_level_realFee = view.findViewById(R.id.tv_income_level_realFee);
                tvIncomeLevelname.setText(mapKey);
                tv_income_level_realFee.setText(isAdd.concat(mContext.getResources().getString(R.string.my_monye_type).concat(mapValue)));
                linearLayout.addView(view);
            }
        }
        findViewById(R.id.btnCloseDialog).setOnClickListener(v -> {
            dismiss();
        });
    }


}
