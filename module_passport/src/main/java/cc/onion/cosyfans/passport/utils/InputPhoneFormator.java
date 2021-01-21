package cc.onion.cosyfans.passport.utils;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * 手机号显示格式3-4-4，例如：135 7878 7979
 *
 * @Author guobihai
 * @Created 5/21/19
 * @Editor zrh
 * @Edited 5/21/19
 * @Type
 * @Layout
 * @Api
 */
public class InputPhoneFormator implements TextWatcher {

    private EditText editText;
    private String preString;

    public InputPhoneFormator(@NonNull EditText editText) {
        this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        preString = s.toString().replace(" ", "");
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String text = s.toString().replace(" ", "");

        if (text.equals(preString)) {
            return;
        }

        int length = text.length();
        StringBuilder stringBuffer = new StringBuilder();

        if (length > 0 && length <= 3) {
            stringBuffer.append(text.substring(0, length));
        } else if (length > 3 && length <= 7) {
            stringBuffer.append(text.substring(0, 3));
            stringBuffer.append(" ");
            stringBuffer.append(text.substring(3, length));
        } else if (length > 7 && length <= 11) {
            stringBuffer.append(text.substring(0, 3));
            stringBuffer.append(" ");
            stringBuffer.append(text.substring(3, 7));
            stringBuffer.append(" ");
            stringBuffer.append(text.substring(7, length));
        } else if (length > 11) {
            stringBuffer.append(text.substring(0, 3));
            stringBuffer.append(" ");
            stringBuffer.append(text.substring(3, 7));
            stringBuffer.append(" ");
            stringBuffer.append(text.substring(7, 11));
        }


        editText.setText(stringBuffer.toString());
        editText.setSelection(stringBuffer.length());

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
