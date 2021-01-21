package cc.onion.cosyfans.passport.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;

import com.deadline.statebutton.StateButton;

import java.util.concurrent.TimeUnit;

import cc.onion.cosyfans.base.utils.Utils;
import cc.onion.cosyfans.module_passport.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * 倒计时按钮
 *
 * @Author anhuifi
 * @Created 4/20/19
 * @Editor zrh
 * @Edited 4/20/19
 * @Type
 * @Layout
 * @Api
 */
public class CountDownButton extends StateButton {

    private int count = 60;
    public static final String SECOND = "秒";
    private boolean countDown = true;

    private String originText;

    private Disposable disposable;

    public CountDownButton(Context context) {
        super(context);
        init(context, null, 0);
    }

    public CountDownButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public CountDownButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CountDownButton, defStyleAttr, 0);
            countDown = a.getBoolean(R.styleable.CountDownButton_countDown, false);
            a.recycle();
        }

        setRadius(Utils.dp2Px(context, 300));
        setNormalTextColor(getResources().getColor(R.color.text_sub_dark));
        setPressedTextColor(getResources().getColor(R.color.text_sub_dark));
        setUnableTextColor(getResources().getColor(R.color.text_sub_dark));
        setTextSize(13);
        setPadding(15,5,15,5);
        setNormalBackgroundColor(Color.parseColor("#F1F2F4"));
        setPressedBackgroundColor(Color.parseColor("#F1F2F4"));
        setUnableBackgroundColor(Color.parseColor("#F1F2F4"));
        setGravity(Gravity.CENTER);
    }

    /**
     * 设置倒计时时间
     *
     * @param count
     */
    public void setCountTimes(int count) {
        this.count = count;
    }

    /**
     * 是否允许倒计时
     *
     * @param enable
     */
    public void enableCountDown(boolean enable) {
        this.countDown = enable;
    }

    /**
     * 开始倒计时
     */
    public void startCountDown() {
        if (originText == null) {
            originText = getText().toString();
        }

        if (countDown) {
            Observable.interval(0, 1, TimeUnit.SECONDS)//设置0延迟，每隔一秒发送一条数据
                    .take(count + 1)
                    .map(aLong -> count - aLong)
                    .observeOn(AndroidSchedulers.mainThread())//操作UI主要在UI线程
                    .subscribe(new Observer<Long>() {

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onComplete() {
                            setText(originText);
                            setEnabled(true);
                        }

                        @Override
                        public void onSubscribe(Disposable d) {
                            disposable = d;
                            setEnabled(false);
                        }

                        @Override
                        public void onNext(Long aLong) {
                            setText(aLong + SECOND);
                        }
                    });
        }
    }

    /**
     * 取消倒计时
     */
    public void cancelCountDown() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
            setText(originText);
            setEnabled(true);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
