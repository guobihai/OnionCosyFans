package cc.onion.cosyfans.my.activity;

import android.annotation.SuppressLint;
import android.arch.lifecycle.AndroidViewModel;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import cc.onion.cosyfans.base.BaseToolBarActivity;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.module_my.databinding.MyActivityWebBinding;


/**
 * @Author zrh
 * @Created 7/16/19
 * @Editor zrh
 * @Edited 7/16/19
 * @Type
 * @Layout
 * @Api
 */
@Route(path = RouterPath.Features.ROUTE_WEB)
public class WebActivity extends BaseToolBarActivity<MyActivityWebBinding, AndroidViewModel> {

    @Autowired
    public String title;
    @Autowired
    public String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.my_activity_web);
        setToolbarTitle(title);

        initProgressBar();
        initWebView();
    }

    private void initProgressBar() {
        mBinding.loadingProgress.setMax(100);
        mBinding.loadingProgress.setProgress(0);
    }


    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {

        WebSettings webSettings = mBinding.webview.getSettings();
        // 支持JavaScript
        webSettings.setJavaScriptEnabled(true);

        // 设置缩放
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);

        // 使页面适应用户屏幕
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        mBinding.webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                mBinding.loadingProgress.setProgress(newProgress);
                if (newProgress == 100) {
                    mBinding.loadingProgress.setVisibility(View.GONE);
                }
            }
        });

        mBinding.webview.loadUrl(url);
    }


    @Override
    protected void onDestroy() {

        WebView mWebView = mBinding.webview;

        if (mWebView != null) {

            // 如果先调用destroy()方法，则会命中if (isDestroyed()) return;这一行代码，需要先onDetachedFromWindow()，再destory
            ViewParent parent = mWebView.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(mWebView);
            }

            mWebView.stopLoading();
            // 退出时调用此方法，移除绑定的服务，否则某些特定系统会报错
            mWebView.getSettings().setJavaScriptEnabled(false);
            mWebView.clearHistory();
            mWebView.clearView();
            mWebView.removeAllViews();
            mWebView.destroy();

        }
        super.onDestroy();
    }
}
