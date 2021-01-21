package cc.onion.cosyfans.passport.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import cc.onion.cosyfans.base.dialog.BaseBottomSheetDialog;
import cc.onion.cosyfans.module_passport.R;

/**
 * 选择国家电话
 * @author guobihai
 * @date  2019-11-27
 */
public class ChooseCountryDialog extends BaseBottomSheetDialog {

    private  View contextView;
    private  Context mContext;
    View.OnClickListener mListener1;
    View.OnClickListener mListener2;
    public ChooseCountryDialog(@NonNull Context context, View.OnClickListener listener1,View.OnClickListener listener2) {
        super(context);
        this.mContext = context;
        this.mListener1 =listener1;
        this.mListener2 =listener2;
    }

    @Override
    protected View createContentView(ViewGroup viewGroup) {
       return contextView = LayoutInflater.from(getContext()).inflate(R.layout.passport_dialog_choose_country, null);
    }


    @Override
    public void onShow() {
        super.onShow();

        //init view
        RelativeLayout layout1 = contextView.findViewById(R.id.layout_country_1);
        RelativeLayout layout2 = contextView.findViewById(R.id.layout_country_2);
        layout1.setOnClickListener(mListener1);
        layout2.setOnClickListener(mListener2);
        contextView.findViewById(R.id.img_cancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
