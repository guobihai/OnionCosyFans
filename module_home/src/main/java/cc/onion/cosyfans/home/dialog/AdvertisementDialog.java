package cc.onion.cosyfans.home.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import org.apache.commons.lang3.StringUtils;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.dialog.DialogLifecycle;
import cc.onion.cosyfans.home.entity.response.HomeAllModel;
import cc.onion.cosyfans.module_home.R;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.home.dialog
 * @ClassName: AdvertisementDialog
 * @Description: 广告框
 * @Author: guobihai
 * @CreateDate: 2020-01-15 15:16
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-15 15:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AdvertisementDialog extends Dialog implements DialogLifecycle {

    HomeAllModel.ScreenAdModuleBean screenAdModule;

    public AdvertisementDialog(@NonNull Context context, HomeAllModel.ScreenAdModuleBean screenAdModule) {
        super(context, cc.onion.cosyfans.library_base.R.style.BaseDialog);
        setContentView(R.layout.home_advertisement);
        this.screenAdModule =screenAdModule;
        ImageView imgAdvertisemnt = findViewById(R.id.img_advertisement);
        if(StringUtils.isNotEmpty(screenAdModule.getImg())){
            BaseBindingAdapter.loadImageLarge(imgAdvertisemnt,screenAdModule.getImg());
        }
        findViewById(R.id.layout_delete).setOnClickListener(v -> dismiss());

    }

    @Override
    public void onShow() {

    }

    @Override
    public void onDismiss() {

    }
}
