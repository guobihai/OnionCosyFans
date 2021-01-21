package cc.onion.cosyfans.item.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
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
import cc.onion.cosyfans.item.adapter.DisscountListAdapter;
import cc.onion.cosyfans.item.entity.response.ItemDetailEntity;
import cc.onion.cosyfans.module_item.R;

/**
 * 折扣
 * 根据用户等级进行显示
 * @author guobihai
 * @email:guobihai@163.com
 *
 */
public class DiscountDilalog extends BaseBottomSheetDialog implements DisscountListAdapter.CloseDialogListener {

    View contextView;
    protected Context mContext;
    DisscountListAdapter disscountListAdapter;
    List<ItemDetailEntity.DataBean.ItemDetailPromotionLevelDTOBean.CfPromotionLevelDTOSBean> cfPromotionLevelDTOS;

    public DiscountDilalog(@NonNull Context context, List<ItemDetailEntity.DataBean.ItemDetailPromotionLevelDTOBean.CfPromotionLevelDTOSBean> cfPromotionLevelDTOS) {
        super(context);
        this.mContext =context;
        this.cfPromotionLevelDTOS =cfPromotionLevelDTOS;
    }

    @Override
    protected View createContentView(ViewGroup viewGroup) {
        contextView = LayoutInflater.from(getContext()).inflate(R.layout.item_dialog_disscount, null);
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
        contextView.findViewById(R.id.img_cancle).setOnClickListener(v -> dismiss());
        RecyclerView lvConponRecyclerview = findViewById(R.id.lv_conpon_recyclerview);
        //add header recycleview
        disscountListAdapter  = new DisscountListAdapter((FragmentActivity) mContext,cfPromotionLevelDTOS,this);

        lvConponRecyclerview.setLayoutManager(new LinearLayoutManager(mContext,1,false));
        lvConponRecyclerview.setAdapter(disscountListAdapter);
        disscountListAdapter.setNewData(cfPromotionLevelDTOS);
        disscountListAdapter.notifyDataSetChanged();
        disscountListAdapter.setOnItemClickListener((adapter, view, position) -> {
                // on Click


        });


    }

    @Override
    public void onDismiss() {

    }


    @Override
    public void closeView() {
            dismiss();
    }
}
