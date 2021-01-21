package cc.onion.cosyfans.base.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import cc.onion.cosyfans.library_base.R;


/**
 * 判断删除对话框
 * @author guobihai
 * @email: guobihai@163.com
 */
public class DeleteOrConfirmCheckDialog extends BaseDialog {

    private TextView tv_center;
    private TextView tv_title;
    private String showSome;
    private String mContext;
    public DeleteOrConfirmCheckDialog(@NonNull Context context, String showTitle,String strContext) {
        super(context);
        this.showSome = showTitle;
        this.mContext = strContext;

    }

    public void setDialogClickListener(AlertDialogClickListener alertDialogClickListener) {
        setLeftButton("取消", v -> alertDialogClickListener.onCancel());
        setRightButton("确认", v -> alertDialogClickListener.onOk());
    }


    @Override
    protected View createContentView(ViewGroup viewGroup) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.base_dialog_delete_data, viewGroup, false);
        tv_center = view.findViewById(R.id.tv_center);
        tv_title = view.findViewById(R.id.tv_title);
        return view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void setShowCenter(String title){
        tv_center.setText(title);
    }

    @Override
    public void onShow() {
        tvDialogTitle.setVisibility(View.GONE);
        tv_title.setText(mContext);
        tv_center.setText(showSome);
    }

    @Override
    public void onDismiss() {
        tv_center.setText(" ");
    }


   public interface AlertDialogClickListener {
        void onCancel();

        void onOk();
    }
}
