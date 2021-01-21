package cc.onion.cosyfans.module_trade.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.base.dialog.BaseBottomSheetDialog;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.TextMeoneryShowUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.base.utils.Utils;
import cc.onion.cosyfans.module_trade.R;
import cc.onion.cosyfans.module_trade.adapter.CoshMoneryAdapter;
import cc.onion.cosyfans.module_trade.entity.CashCouponEntity;
import cc.onion.cosyfans.module_trade.listener.CashMoneryDialogOnClickListener;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_trade.dialog
 * @ClassName: CashCouponDialog
 * @Description: 现金对话框
 * @Author: guobihai
 * @CreateDate: 2019-12-12 15:07
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-12 15:07
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CashCouponDialog extends BaseBottomSheetDialog implements CashMoneryDialogOnClickListener {

    View contextView;
    private Context mContext;
    private  List<CashCouponEntity.DataBean> mList;
    private  String totalAmount;
    private String cashCouponId;

    public CashCouponDialog(@NonNull Context context, List<CashCouponEntity.DataBean> dataBeanList, String amount, String cashCouponId) {
        super(context);
        this.mContext = context;
        this.mList = dataBeanList;
        this.totalAmount = totalAmount;
        this.cashCouponId = cashCouponId;
    }

    @Override
    protected View createContentView(ViewGroup viewGroup) {
        contextView = LayoutInflater.from(getContext()).inflate(R.layout.trade_dialog_cashcoupon, null);
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
        layoutBase.setVisibility(View.VISIBLE);
        betnOne.setText(cc.onion.cosyfans.module_cart.R.string.cart_ok);
        layoutBase.setBackgroundColor(mContext.getResources().getColor(cc.onion.cosyfans.module_cart.R.color.bluce));
        layoutBase.setOnClickListener(v -> {
            dismiss();
        });
        findViewById(R.id.img_cancle).setOnClickListener(v -> dismiss());


        //lsit
        RecyclerView popRecylerView = contextView.findViewById(R.id.lv_cosh_recyclerview);
        CoshMoneryAdapter coshMoneryAdapter = new CoshMoneryAdapter(mContext,null,totalAmount,cashCouponId,this);

        popRecylerView.setLayoutManager(new LinearLayoutManager(mContext,1,false));
        popRecylerView.setAdapter(coshMoneryAdapter);

        //添加基础数据
        List<CashCouponEntity.DataBean> newData = new ArrayList<>();
        newData.add(new CashCouponEntity.DataBean("不使用"));
        for (CashCouponEntity.DataBean model: mList ) {
            if(TypeUtils.toString(model.getUserCouponId()).equals(cashCouponId)){
                model.setChoose(true);
            }
            newData.add(model);
        }

        coshMoneryAdapter.setNewData(newData);
        coshMoneryAdapter.notifyDataSetChanged();
        coshMoneryAdapter.setOnItemClickListener((adapter, view, position) -> {
            coshMoneryAdapter.setCurentPosition(position);
            coshMoneryAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public void selectCurrentItem(CashCouponEntity.DataBean item) {
        KLog.i("test","选中当前的数据:"+item.getLabelName());
        betnTwo.setText("(共省\"￥\""+item.getCouponAmount()+")");
    }
}
