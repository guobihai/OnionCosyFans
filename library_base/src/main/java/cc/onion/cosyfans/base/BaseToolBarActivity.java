package cc.onion.cosyfans.base;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


import org.greenrobot.eventbus.EventBus;

import java.util.List;

import cc.onion.cosyfans.base.interfaces.BaseActFragmImpl;
import cc.onion.cosyfans.base.utils.ClassUtil;
import cc.onion.cosyfans.base.utils.SoftKeyBoardUtils;
import cc.onion.cosyfans.base.utils.StatusBarUtils;
import cc.onion.cosyfans.base.utils.SystemUtils;
import cc.onion.cosyfans.library_base.R;
import cc.onion.cosyfans.library_base.databinding.ActBaseToolbarBinding;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 带有标题栏的基类Activity
 *
 * @author guobihai
 * @created 2019/3/15
 */
public abstract class BaseToolBarActivity<VB extends ViewDataBinding, VM extends AndroidViewModel>
        extends BaseEventActivity implements BaseActFragmImpl {

    protected Context mContext;
    // ViewModel
    protected VM mViewModel;
    // ViewModel关联的ID
    private int viewModelId;
    // 布局DataBinding
    protected VB mBinding;
    private CompositeDisposable mDisposable;

    // 标题栏相关
    public Toolbar mToolBar;
    public TextView mToolbarTitle; // ToolBar上面的标题栏文本(暂时停用)
    public AppBarLayout mAppBarLayout;
    private ActBaseToolbarBinding mBaseToolBarBinding;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = BaseToolBarActivity.this;
        initParam();
    }

    @Override
    public void setContentView(int layoutResID) {
        mBaseToolBarBinding = DataBindingUtil.inflate(LayoutInflater.from(this),
                R.layout.act_base_toolbar, null, false);
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), layoutResID, null, false);

        mToolBar = mBaseToolBarBinding.toolbar;
        mToolbarTitle = mBaseToolBarBinding.toolbarTitle;
        mAppBarLayout = mBaseToolBarBinding.appBarLayout;

        // content
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        mBinding.getRoot().setLayoutParams(params);
        RelativeLayout mContainer = (RelativeLayout) mBaseToolBarBinding.getRoot().findViewById(R.id.ui_layout);
        mContainer.addView(mBinding.getRoot());
        getWindow().setContentView(mBaseToolBarBinding.getRoot());

        // 适配状态栏
        if (SystemUtils.v21()) {
            if (StatusBarUtils.setMiuiStatusBarDarkMode(this, true)
                    || StatusBarUtils.setMeizuStatusBarDarkIcon(this, true)) {
                getWindow().setStatusBarColor(Color.WHITE);

            }
        }
        if (SystemUtils.v21()) {
            //必须在代码里面设置状态栏颜色，否则在乐视手机上回出现状态栏变黑问题
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }

        refreshToolbar();
        showBackBtn(false);
        initViewModel();
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

        if (mBaseToolBarBinding != null) {
            mBaseToolBarBinding.unbind();
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


    @Override
    public void initParam() {

    }


    @Override
    public void initViewObservable() {

    }

    @Override
    public void initData() {

    }

    /**
     * 刷新ToolBar
     */
    public void refreshToolbar() {
        if (mBaseToolBarBinding != null && mBaseToolBarBinding.toolbar != null) {
            setSupportActionBar(mBaseToolBarBinding.toolbar);
            mToolBar.setNavigationIcon(R.mipmap.icon_left);
            mBaseToolBarBinding.toolbar.setNavigationOnClickListener(view -> onBackClick());
        }
    }

    /**
     * 是否显示ToolBar的返回按钮
     *
     * @param isShow
     */
    public void showBackBtn(boolean isShow) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(isShow);
    }

    public void onBackClick() {
        onBackPressed();
    }

    /**
     * 设置ToolBar标题文本
     *
     * @param title
     */
    public void setToolbarTitle(String title) {
        if (mBaseToolBarBinding != null && mBaseToolBarBinding.toolbar != null) {
            mBaseToolBarBinding.toolbar.setTitle(title);
            mBaseToolBarBinding.toolbarTitle.setText(title);
            if (TextUtils.isEmpty(title)) {
                mBaseToolBarBinding.toolbarTitle.setVisibility(View.GONE);
            } else {
                mBaseToolBarBinding.toolbarTitle.setVisibility(View.VISIBLE);
            }
            refreshToolbar();
        }
    }

    public void setToolbarTitle(int strId) {
        setToolbarTitle(getString(strId));
        refreshToolbar();
    }


    /**
     * 改变返回按钮的宽度
     * @param width
     */
    protected void setImageButtonWidth(int width) {
        if (mBaseToolBarBinding.toolbar == null) {
            return;
        }
        mBaseToolBarBinding.toolbar.post(() -> {
            final int len = mBaseToolBarBinding.toolbar.getChildCount();
            for (int i = 0; i < len; i++) {
                View view = mBaseToolBarBinding.toolbar.getChildAt(i);
                if (view instanceof AppCompatImageButton) {
                    ViewGroup.LayoutParams params =  view.getLayoutParams();
                    params.width = width;
                    view.setLayoutParams(params);
                }
            }
        });
    }


    /**
     * 隐藏菜单按钮
     */
    protected void hideActionMenuView() {
        if (mBaseToolBarBinding.toolbar == null) {
            return;
        }
        mBaseToolBarBinding.toolbar.post(() -> {
            final int len = mBaseToolBarBinding.toolbar.getChildCount();
            for (int i = 0; i < len; i++) {
                View view = mBaseToolBarBinding.toolbar.getChildAt(i);
                if (view instanceof ActionMenuView) {
                    view.setVisibility(View.GONE);
                }
            }
        });

    }

    /**
     * 显示菜单按钮
     */
    protected void showActionMenuView() {
        if (mBaseToolBarBinding.toolbar == null) {
            return;
        }
        mBaseToolBarBinding.toolbar.post(() -> {
            final int len = mBaseToolBarBinding.toolbar.getChildCount();
            for (int i = 0; i < len; i++) {
                View view = mBaseToolBarBinding.toolbar.getChildAt(i);
                if (view instanceof ActionMenuView) {
                    view.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    /**
     * 设置ToolBar兼容透明状态栏，避免显示到状态栏上面，高度异常的问题
     */
    public void setToolBarCompatStatusBar() {
        // 判断版本大于V19就需要增加标题栏的高度为状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && mBaseToolBarBinding.toolbar != null) {
            int statusBarHeight = StatusBarUtils.getStatusBarHeight(this);
            mBaseToolBarBinding.toolbar.setPadding(0, statusBarHeight, 0, 0); // 左、上、右、下
        }
    }

    /**
     * 设置ToolBar返回按钮颜色
     *
     * @param color
     */
    protected void setToolbarBackMenuColor(int color) {
        if (mBaseToolBarBinding.toolbar == null) {
            return;
        }
        Drawable upArrow = mBaseToolBarBinding.toolbar.getNavigationIcon();
        if (upArrow != null) {
            upArrow.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(upArrow);
        }
    }

    /**
     * 设置AppBarLayout阴影
     *
     * @param elevation
     */
    protected void setAppBarLayoutElevation(float elevation) {
        if (mBaseToolBarBinding.appBarLayout == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(mBaseToolBarBinding.appBarLayout, "elevation", elevation));
            mBaseToolBarBinding.appBarLayout.setStateListAnimator(stateListAnimator);
        }
    }



    /**
     * 添加订阅
     * 需要在Activity退出时解除订阅的添加
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

}
