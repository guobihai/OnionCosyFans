package cc.onion.cosyfans.item.dialog;

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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.base.dialog.BaseBottomSheetDialog;
import cc.onion.cosyfans.base.utils.Utils;
import cc.onion.cosyfans.item.adapter.CommissionListAdapter;
import cc.onion.cosyfans.item.adapter.ConponListAdapter;
import cc.onion.cosyfans.item.entity.response.ItemDetailEntity;
import cc.onion.cosyfans.module_item.R;

/**
 * 佣金对话框
 * 根据用户等级进行显示
 * @author guobihai
 * @email:guobihai@163.com
 *
 */
public class CommissionDilalog extends BaseBottomSheetDialog {

    View contextView;
    protected Context mContext;
    CommissionListAdapter conponListAdapter;
    private List<ItemDetailEntity.DataBean.ItemDetailPromotionLevelDTOBean.CfPromotionLevelDTOSBean> mcfPromotionLevelDTOS;

    public CommissionDilalog(@NonNull Context context, List<ItemDetailEntity.DataBean.ItemDetailPromotionLevelDTOBean.CfPromotionLevelDTOSBean> cfPromotionLevelDTOS) {
        super(context);
        this.mContext =context;
        this.mcfPromotionLevelDTOS =cfPromotionLevelDTOS;
    }

    @Override
    protected View createContentView(ViewGroup viewGroup) {
        contextView = LayoutInflater.from(getContext()).inflate(R.layout.item_dialog_commission, null);
        return contextView;
    }

    @Override
    public void onShow() {
        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = Utils.dp2Px(mContext,375);
        window.setAttributes(lp);
        window.setWindowAnimations(cc.onion.cosyfans.library_base.R.style.BaseBottomSheetDialog);  //添加动画

        //业务操作
        contextView.findViewById(R.id.img_cancle).setOnClickListener(v -> dismiss());
        RecyclerView lvConponRecyclerview = findViewById(R.id.lv_conpon_recyclerview);
        TextView title = findViewById(R.id.tv_title);
        title.setText("佣金可得RM200");
        //add header recycleview
        conponListAdapter  = new CommissionListAdapter(mContext);

        lvConponRecyclerview.setLayoutManager(new LinearLayoutManager(mContext,1,false));
        lvConponRecyclerview.setAdapter(conponListAdapter);
        conponListAdapter.setNewData(mcfPromotionLevelDTOS);
        conponListAdapter.notifyDataSetChanged();
        conponListAdapter.setOnItemClickListener((adapter, view, position) -> {
                // on Click


        });

        findViewById(R.id.btn_commisson_copy).setOnClickListener(v -> {
            //复制
        });

        findViewById(R.id.btn_commisson_share).setOnClickListener(v -> {
            //分享
        });
    }

    @Override
    public void onDismiss() {

    }



}
