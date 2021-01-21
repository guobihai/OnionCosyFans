package cc.onion.cosyfans.base;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import cc.onion.cosyfans.base.event.Event;
import cc.onion.cosyfans.base.interfaces.BaseActFragmImpl;
import cc.onion.cosyfans.base.utils.ClassUtil;
import cc.onion.cosyfans.base.utils.SoftKeyBoardUtils;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 基础Activity
 *
 * @author guobihai
 * @created 2019/3/14
 */
public abstract class BaseActivity<VB extends ViewDataBinding, VM extends AndroidViewModel>
        extends BaseEventActivity implements BaseActFragmImpl {

    // ViewModel
    protected VM mViewModel;
    // ViewModel关联的ID
    private int viewModelId;
    // 布局DataBinding
    protected VB mBinding;

    private CompositeDisposable mDisposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParam();
        initViewDataBinding(savedInstanceState);
        initData();
        initViewObservable();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.mDisposable != null && !mDisposable.isDisposed()) {
            // clear 和 dispose的区别是：disposed = true;
            this.mDisposable.clear(); // 解除所有订阅
        }

        if (mBinding != null) {
            mBinding.unbind();
        }
    }

    /**
     * 初始化ViewModel
     */
    private void initViewModel() {
        Class<VM> viewModelClass = ClassUtil.getViewModel(this);
        if (viewModelClass != null) {
            this.mViewModel = ViewModelProviders.of(this).get(viewModelClass);
        }
    }

    /**
     * 初始化ViewDataBinding
     */
    private void initViewDataBinding(Bundle savedInstanceState) {
        mBinding = DataBindingUtil.setContentView(this, initContentView(savedInstanceState));
        viewModelId = initVariableId();
        initViewModel();
        // 关联ViewModel(设置变量的BR的id值，对应layout中variable的name)
        mBinding.setVariable(viewModelId, mViewModel);
    }


    /**
     * 在这个方法里面注入路由，拿到传参
     * 要在初始化布局之前执行
     */
    @Override
    public void initParam() {

    }

    /**
     * 初始化根布局
     *
     * @return 布局layout的id
     */
    public abstract int initContentView(Bundle savedInstanceState);

    /**
     * 初始化ViewModel的id
     *
     * @return BR的id
     */
    public abstract int initVariableId();

    /**
     * 页面初始化数据
     */
    @Override
    public void initData() {

    }

    /**
     * 页面事件监听的方法，一般用于ViewModel层转到View层的事件注册
     */
    @Override
    public void initViewObservable() {

    }

    /**
     * 刷新布局
     */
    public void refreshLayout() {
        if (mViewModel != null) {
            mBinding.setVariable(viewModelId, mViewModel);
        }
    }

    /**
     * 添加订阅
     *
     * @param disposable
     */
    public void addSubscription(Disposable disposable) {
        if (this.mDisposable == null) {
            this.mDisposable = new CompositeDisposable();
        }
        this.mDisposable.add(disposable);
    }

    /**
     * 解除订阅
     */
    public void removeDisposable() {
        if (this.mDisposable != null && !mDisposable.isDisposed()) {
            this.mDisposable.dispose(); // 主动解除订阅
        }
    }

    /**
     * 页面挂起时关闭页面的软键盘
     */
    @Override
    protected void onStop() {
        super.onStop();
        SoftKeyBoardUtils.closeKeyBoard(this);
    }


    /**
     * 空白区隐藏输入法
     * @param ev
     * @return
     */

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideKeyboard(v, ev)) {
                SoftKeyBoardUtils.closeKeyBoard(this);
            }
        }

        return super.dispatchTouchEvent(ev);

    }


    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时则不能隐藏
     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0],
                    top = l[1],
                    bottom = top + v.getHeight(),
                    right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击EditText的事件，忽略它。
                return false;
            } else {
                return true;
            }
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditText上，和用户用轨迹球选择其他的焦点
        return false;
    }



    /**
     * 通过这个方法可以避免重复实例化Fragment
     *
     * @param <T>
     * @param clazz
     * @param tag
     * @return
     */
    public <T extends BaseFragment> T getFragment(Class<?> clazz, String tag) {

        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        BaseFragment fragment = null;
        if (fragments != null && fragments.size() > 0) {
            for (Fragment fragment1 : fragments) {

                if (fragment1 != null && fragment1 instanceof BaseFragment) {
                    BaseFragment baseFragment = (BaseFragment) fragment1;
                    if (baseFragment.getClass().getName().equals(clazz.getName())) {
                        if (!TextUtils.isEmpty(tag)) {
                            if (baseFragment.tag.equals(tag)) {
                                fragment = baseFragment;
                            }
                        } else {
                            fragment = baseFragment;
                        }
                    }

                }
            }
        }


        if (fragment == null) {
            try {
                fragment = (BaseFragment) clazz.newInstance();

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (tag != null) {
            fragment.tag = tag;
        }

        return (T) fragment;
    }




    /**
     * 是否注册事件分发
     *
     * @return true绑定EventBus事件分发，默认不绑定，子类需要绑定的话复写此方法返回true.
     */
    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBusCome(Event event) {
        if (event != null) {
            receiveEvent(event);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEventBusCome(Event event) {
        if (event != null) {
            receiveStickyEvent(event);
        }
    }

    /**
     * 接收到分发到事件
     *
     * @param event 事件
     */
    protected void receiveEvent(Event event) {

    }

    /**
     * 接受到分发的粘性事件
     *
     * @param event 粘性事件
     */
    protected void receiveStickyEvent(Event event) {

    }







}
