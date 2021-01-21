package cc.onion.cosyfans.base.interfaces;

import android.view.View;

import java.util.Date;

/**
 *  @author guobihai
 * on 2019-08-16
 */
public interface OnTimeSelectCallback {

    void onTimeSelect(Date date, View v);

    void clickConfirmButton();
}
