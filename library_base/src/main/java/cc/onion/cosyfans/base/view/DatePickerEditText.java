package cc.onion.cosyfans.base.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.view.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cc.onion.cosyfans.library_base.R;

/**
 * @Author guobihai
 * @Created 2019/4/1
 * @Editor lyy
 * @Edited 2019/4/1
 * @Type
 * @Layout
 * @Api
 */
public class DatePickerEditText extends AppCompatEditText {
    private Context mContext;
    private TimePickerView timePickerView;

    public DatePickerEditText(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public DatePickerEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public DatePickerEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    private void init() {
        this.setFocusable(false);
        this.setOnClickListener(new OnClickListenerImpl());
        //去除长按可以复制粘贴功能
        this.setOnLongClickListener(paramView -> true);
    }

    public void setDateText(String dateStr) {
        this.setText(dateStr);
    }

    private class OnClickListenerImpl implements OnClickListener {
        @Override
        public void onClick(View v) {
            Calendar selectedDate = Calendar.getInstance();// 系统当前时间
            Calendar startDate = Calendar.getInstance();
            startDate.set(1970, 1, 23);
            Calendar endDate = Calendar.getInstance();
            endDate.set(2027, 2, 28);
            timePickerView = new TimePickerBuilder(mContext, (date, v13) -> setDateText(getTime(date, "")))
                    .setDate(selectedDate)
                    .setRangDate(startDate, endDate)
                    .setLayoutRes(R.layout.base_picker_custom, v1 -> {
                        //TextView tvTitle = v.findViewById(R.id.tv_picker_title); // 标题文本
                        View vok = v1.findViewById(R.id.rl_picker_ok); // 确定
                        vok.setOnClickListener(v2 -> {
                            timePickerView.returnData();
                            timePickerView.dismiss();
                        });
                    })
                    // 设置滚轮文字大小
                    .setContentTextSize(16)
                    // 设置选中文字颜色
                    .setTextColorCenter(ContextCompat.getColor(mContext, R.color.theme))
                    // 设置未选中文字颜色
                    .setTextColorOut(ContextCompat.getColor(mContext, R.color.light_grey))
                    // 解决PickerView被虚拟按键遮挡的问题
                    .setDecorView(findViewById(android.R.id.content))
                    .build();

            timePickerView.show();
        }
    }

    public String getTime(Date date, String pattern) {//可根据需要自行截取数据显示
        String strPattern;
        if (TextUtils.isEmpty(pattern)) {
            strPattern = "yyyy-MM-dd";
        } else {
            strPattern = pattern;
        }
        SimpleDateFormat format = new SimpleDateFormat(strPattern);
        return format.format(date);
    }

}
