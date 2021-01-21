package cc.onion.cosyfans.base.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;

import cc.onion.cosyfans.base.appinfo.AppVersion;
import cc.onion.cosyfans.base.event.Event;
import cc.onion.cosyfans.base.utils.Utils;
import cc.onion.cosyfans.library_base.R;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.base.dialog
 * @ClassName: AppVersionDialog
 * @Description: App版本升级对话框
 * @Author: guobihai
 * @CreateDate: 2020-01-11 15:38
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-11 15:38
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AppVersionDialog extends BaseDialog{


    private Context mContext;

    AppVersion appVersion;

    TextView tvContext,tvVersion;
    ImageView img_1,img_2,img_3,img_4,img_5;

    View view;
    public AppVersionDialog(@NonNull Context context, AppVersion appVersionEvent) {
        super(context);
        this.mContext = context;
        this.appVersion = appVersionEvent;
    }

    @Override
    protected View createContentView(ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.base_dialog_app_update, viewGroup, false);
        tvContext = view.findViewById(R.id.tv_context);
        tvVersion  =view.findViewById(R.id.tv_version);
        img_1  = findViewById(R.id.img_1);
        img_2 = findViewById(R.id.img_2);
        img_3 = findViewById(R.id.img_3);
        img_4  = findViewById(R.id.img_4);
        img_5 = findViewById(R.id.img_5);
        return view;
    }

    @Override
    public void onShow() {
        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.CENTER;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = Utils.dp2Px(mContext,350);
        window.setAttributes(lp);


        tvDialogTitle.setVisibility(View.GONE);
        btnDialogLeft.setVisibility(View.GONE);
        btnDialogRight.setVisibility(View.GONE);

        if(appVersion != null){
            tvContext.setText(appVersion.getUpdateContent());
            tvVersion.setText(appVersion.getVersionNo());

            switch (Integer.parseInt(appVersion.getUpdateIndex())){
                case  1:
                    img_1.setImageResource(R.mipmap.icon_stary);
                    img_2.setImageResource(R.mipmap.icon_stary_bg);
                    img_3.setImageResource(R.mipmap.icon_stary_bg);
                    img_4.setImageResource(R.mipmap.icon_stary_bg);
                    img_5.setImageResource(R.mipmap.icon_stary_bg);
                    break;
                case 2:
                    img_1.setImageResource(R.mipmap.icon_stary);
                    img_2.setImageResource(R.mipmap.icon_stary);
                    img_3.setImageResource(R.mipmap.icon_stary_bg);
                    img_4.setImageResource(R.mipmap.icon_stary_bg);
                    img_5.setImageResource(R.mipmap.icon_stary_bg);
                    break;
                case 3:
                    img_1.setImageResource(R.mipmap.icon_stary);
                    img_2.setImageResource(R.mipmap.icon_stary);
                    img_3.setImageResource(R.mipmap.icon_stary);
                    img_4.setImageResource(R.mipmap.icon_stary_bg);
                    img_5.setImageResource(R.mipmap.icon_stary_bg);
                    break;
                case 4:
                    img_1.setImageResource(R.mipmap.icon_stary);
                    img_2.setImageResource(R.mipmap.icon_stary);
                    img_3.setImageResource(R.mipmap.icon_stary);
                    img_4.setImageResource(R.mipmap.icon_stary);
                    img_5.setImageResource(R.mipmap.icon_stary_bg);
                    break;
                case 5:
                    img_1.setImageResource(R.mipmap.icon_stary);
                    img_2.setImageResource(R.mipmap.icon_stary);
                    img_3.setImageResource(R.mipmap.icon_stary);
                    img_4.setImageResource(R.mipmap.icon_stary);
                    img_5.setImageResource(R.mipmap.icon_stary);
                    break;

            }
        }

    }

    @Override
    public void onDismiss() {

    }
}
