package cc.onion.cosyfans.home.dialog;

import android.app.Dialog;
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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.List;

import cc.onion.cosyfans.base.dialog.BaseDialog;
import cc.onion.cosyfans.base.dialog.DialogLifecycle;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.home.adapter.HomeConponListAdapter;
import cc.onion.cosyfans.home.entity.CashRollEntity;
import cc.onion.cosyfans.module_home.R;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.home.dialog
 * @ClassName: CashRollDialog
 * @Description: 现金劵对话框
 * @Author: guobihai
 * @CreateDate: 2020-01-15 15:15
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-15 15:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CashRollDialog extends Dialog implements DialogLifecycle {

    HomeConponListAdapter homeConponListAdapter;
    Context context ;
    RecyclerView lvRecyclerview;
    List<CashRollEntity.DataBean.CouponVOListBean>  couponVOListBeans;
    public CashRollDialog(@NonNull Context context, List<CashRollEntity.DataBean.CouponVOListBean> couponVOList) {
        super(context, cc.onion.cosyfans.library_base.R.style.BaseDialog);
        setContentView(R.layout.home_cash_roll);
        lvRecyclerview  = findViewById(R.id.lv_unUse_recyclerview);
        this.couponVOListBeans = couponVOList;
        this.context = context;
        initView();

    }

    private void initView() {
        if(couponVOListBeans != null && couponVOListBeans.size() >0){
            //处理操作
            homeConponListAdapter = new HomeConponListAdapter(null,context);
            lvRecyclerview.setAdapter(homeConponListAdapter);
            lvRecyclerview.setLayoutManager(new LinearLayoutManager(context,1,false));
            homeConponListAdapter.setNewData(couponVOListBeans);
            homeConponListAdapter.notifyDataSetChanged();
            homeConponListAdapter.setOnItemClickListener((adapter, view, position) -> {
                // on Click

                ARouter.getInstance().build(RouterPath.Passport.ROUTE_PASSPORT_SIGNIN)
                        .greenChannel()
                        .navigation();
            });
            findViewById(R.id.img_cancle).setOnClickListener(v -> dismiss());
            findViewById(R.id.layout_delete).setOnClickListener(v -> dismiss());
            findViewById(R.id.btn_watch).setOnClickListener(v ->
                    ARouter.getInstance().build(RouterPath.Passport.ROUTE_PASSPORT_SIGNIN)
                    .greenChannel()
                    .navigation());

        }

    }



    @Override
    public void onShow() {



    }

    @Override
    public void onDismiss() {

    }
}
