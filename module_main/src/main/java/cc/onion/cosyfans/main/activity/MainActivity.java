package cc.onion.cosyfans.main.activity;


import android.Manifest;
import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.deadline.statebutton.StateButton;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.tbruyelle.rxpermissions2.RxPermissions;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.event.EventUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.base.BaseEventActivity;
import cc.onion.cosyfans.base.BaseFragment;
import cc.onion.cosyfans.base.account.AccountManager;
import cc.onion.cosyfans.base.appinfo.AppVersion;
import cc.onion.cosyfans.base.dialog.AlertDialog;
import cc.onion.cosyfans.base.dialog.AppVersionDialog;
import cc.onion.cosyfans.base.event.AppEvent;
import cc.onion.cosyfans.base.event.Event;
import cc.onion.cosyfans.base.event.ExitAppEvent;
import cc.onion.cosyfans.base.event.LoginSuccessEvent;
import cc.onion.cosyfans.base.event.PageEvent;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.EventBusUtil;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.KLogUtils;
import cc.onion.cosyfans.base.utils.StatusBarUtils;
import cc.onion.cosyfans.base.utils.SystemUtils;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.main.R;
import cc.onion.cosyfans.main.event.CartCount;
import cc.onion.cosyfans.main.viewmodel.MainViewModel;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

/**
 * ConsyFans--主界面入口
 * @author guobihai
 * @date 2019-11-5
 */
@Route(path = RouterPath.Main.ROUTE_MAIN_PATH)
public class MainActivity extends BaseEventActivity {


    private List<Fragment> mFragments;
    private BottomNavigationViewEx mNavigationView;

    private MainViewModel mViewModel;

    private int lastPosition;//上次fragment的位置
    private Fragment currentFragment;//要显示的Fragment
    private Fragment hideFragment;//要隐藏的Fragment



    int currentPage = 0;

    private Fragment homeFragment, msgFragment, workFragment, contactFragment, mineFragment;

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // 取消fragment的状态保存
        super.onSaveInstanceState(outState);
        outState.putInt("last_position",lastPosition);//activity重建时保存页面的位置
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lastPosition = savedInstanceState.getInt("last_position");//获取重建时的fragment的位置
        setSelectedFragment(lastPosition);//恢复销毁前显示的fragment
    }





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
//        currentPage = getIntent().getIntExtra("page",0);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        if(savedInstanceState == null){
            initFragment();
        }


        // 适配状态栏
        if (SystemUtils.v21()) {
            if (StatusBarUtils.setMiuiStatusBarDarkMode(this, true)
                    || StatusBarUtils.setMeizuStatusBarDarkIcon(this, true)) {
                getWindow().setStatusBarColor(Color.WHITE);

            }
        }
        if (SystemUtils.v21()) {
            //必须在代码里面设置状态栏颜色，否则在乐视手机上回出现状态栏变黑问题
            getWindow().setStatusBarColor(ContextCompat.getColor(this, cc.onion.cosyfans.library_base.R.color.colorPrimaryDark));
        }

        initBottomNavigation(savedInstanceState);

        // 检查版本更新
        mViewModel.checkUpdate();
        mViewModel.getCatRequest();
    }


    /**
     * 根据位置选择Fragment
     * @param position 要选中的fragment的位置
     */
    private void  setSelectedFragment(int position){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        currentFragment = fragmentManager.findFragmentByTag("fragment"+position);//要显示的fragment(解决了activity重建时新建实例的问题)
        hideFragment = fragmentManager.findFragmentByTag("fragment" + lastPosition);//要隐藏的fragment(解决了activity重建时新建实例的问题)
        if (position != lastPosition){//如果位置不同
            if (hideFragment != null){//如果要隐藏的fragment存在，则隐藏
                transaction.hide(hideFragment);
            }
            if (currentFragment == null){//如果要显示的fragment不存在，则新加并提交事务
                currentFragment = mFragments.get(position);
                transaction.add(R.id.frameLayout,currentFragment,"fragment"+position);
            }else {//如果要显示的存在则直接显示
                transaction.show(currentFragment);
            }
        }

        if (position == lastPosition){//如果位置相同
            if (currentFragment == null){//如果fragment不存在(第一次启动应用的时候)
                currentFragment = mFragments.get(position);
                transaction.add(R.id.frameLayout,currentFragment,"fragment"+position);
            }//如果位置相同，且fragment存在，则不作任何操作
        }
        transaction.commit();//提交事务
        lastPosition = position;//更新要隐藏的fragment的位置
    }



    private void initFragment() {

        // 首页
         homeFragment = (Fragment) ARouter.getInstance()
                .build(RouterPath.Home.ROUTE_HOME_PATH).navigation();
        // 分类
         msgFragment = (Fragment) ARouter.getInstance()
                .build(RouterPath.Categorie.ROUTE_CATEGORRIE_PATH).navigation();
        // 素材
         workFragment = (Fragment) ARouter.getInstance()
                .build(RouterPath.Posts.ROUTE_POSTS_PATH).navigation();
        // 购物车
         contactFragment = (Fragment) ARouter.getInstance()
                .build(RouterPath.Cart.ROUTE_CART_PATH).navigation();
        // 我的
         mineFragment = (Fragment) ARouter.getInstance()
                .build(RouterPath.MyCosy.ROUTE_MINE_PATH).navigation();

        mFragments = new ArrayList<>();
        mFragments.add(homeFragment);
        mFragments.add(msgFragment);
        mFragments.add(workFragment);
        mFragments.add(contactFragment);
        mFragments.add(mineFragment);


    }



    private void checkMainFragment() {
        KLog.i("test","切换的page"+currentPage);
        if(currentPage == 0){
            setSelectedFragment(0);
        }else if(currentPage ==1){
            setSelectedFragment(1);
        }else if(currentPage ==2){
            setSelectedFragment(2);
        }else if(currentPage ==3){
            setSelectedFragment(3);
        }else if(currentPage ==4){
            setSelectedFragment(4);
        }
    }

    private Badge mBadge;

    private void initBottomNavigation(Bundle savedInstanceState) {
        mNavigationView = findViewById(R.id.nav_view);
        // 关闭文字放大效果和图片移动效果
        mNavigationView.enableAnimation(false);
        mNavigationView.setLabelVisibilityMode(1);
        // 不显示系统的默认颜色
        mNavigationView.setItemIconTintList(null);
        // 设置图标大小
        mNavigationView.setIconSize(21, 21);
        // 给消息菜单添加小红点 , "99"
        mBadge = addBadgeAt(3);

        // 设置消息页面默认选中
        MenuItem itemMsg = mNavigationView.getMenu().findItem(R.id.nav_home);
        itemMsg.setIcon(R.mipmap.icon_home_refresh);
        if(currentPage >0){
            mNavigationView.setCurrentItem(currentPage);
        }else{
            mNavigationView.setCurrentItem(0);
        }

        if (savedInstanceState == null){
            //根据传入的Bundle对象判断是正常启动还是重建 true表示正常启动，false表示重建
            setSelectedFragment(0);
        }


        mNavigationView.setOnNavigationItemSelectedListener((MenuItem item) -> {
            int itemId = item.getItemId();
            resetToDefaultIcon();
            int fragemenPosition = 0;

            // 现在不能用Switch-case语句访问资源ID
            if (itemId == R.id.nav_home) {
                // 首页
                fragemenPosition  = 0;
                item.setIcon(R.mipmap.icon_home_main_focs);
            } else if (itemId == R.id.nav_categorie) {
                // 分类
                fragemenPosition  = 1;
                item.setIcon(R.mipmap.icon_home_categorie_focs);
            }else if (itemId == R.id.nav_posts) {
                // 素材
                fragemenPosition  = 2;
                item.setIcon(R.mipmap.icon_home_posts_focs);
            } else if (itemId == R.id.nav_carts) {
                AccountManager.setNeedLogin(true);
                if(StringUtils.isNotEmpty(AccountManager.getToken())){
                    //没有登陆
                    fragemenPosition  = 3;
                    item.setIcon(R.mipmap.icon_home_cart_fcos);
                    //刷新购物车数量
                    mViewModel.getCatRequest();
                }else{
                    ARouter.getInstance().build(RouterPath.Passport.ROUTE_PASSPORT_SIGNIN)
                            .greenChannel()
                            .navigation();
                }





            } else if (itemId == R.id.nav_mycosy) {
                // 我的
                fragemenPosition  = 4;
                    item.setIcon(R.mipmap.icon_home_mycosy_focs);
            }

            //切换Fragment
            setSelectedFragment(fragemenPosition);

            return true;
        });
    }



    /**
     * 重新设置菜单条图标为未选中状态
     */
    private void resetToDefaultIcon() {
        if (mNavigationView == null) {
            return;
        }

        //首页
        MenuItem itemHome = mNavigationView.getMenu().findItem(R.id.nav_home);
        itemHome.setIcon(R.mipmap.icon_home_main);


        // 分类
        MenuItem itemCategorie = mNavigationView.getMenu().findItem(R.id.nav_categorie);
        itemCategorie.setIcon(R.mipmap.icon_home_categorie);

        // 素材圈
        MenuItem itemPosts = mNavigationView.getMenu().findItem(R.id.nav_posts);
        itemPosts.setIcon(R.mipmap.icon_home_posts);

        // 购物车
        MenuItem itemCats = mNavigationView.getMenu().findItem(R.id.nav_carts);
        itemCats.setIcon(R.mipmap.icon_home_cart);

        // 我的
        MenuItem itemMycosy = mNavigationView.getMenu().findItem(R.id.nav_mycosy);
        itemMycosy.setIcon(R.mipmap.icon_home_mycosy);
    }


    /**
     * 给底部导航条添加红点标记
     *
     * @param position 要给哪一个菜单添加标记
     * @return
     */
    private Badge addBadgeAt(int position) {//, String badgeTxt
        // add badge
        return new QBadgeView(this)
//                .setBadgeText(badgeTxt)
                .setBadgeNumber(0)//红点标记数量
                .setBadgeTextSize(10, true)
                .setShowShadow(false) // 不显示阴影
                .stroke(0XFFFFFFFF, 1, true) // 描边
                .setBadgeGravity(Gravity.END|Gravity.TOP)
                .setBadgeBackgroundColor(ContextCompat.getColor(this, R.color.badge_color))
                .setGravityOffset(15, 0, true)
                .bindTarget(mNavigationView.getBottomNavigationItemView(position))
                .setOnDragStateChangedListener(
                        (dragState, badge, targetView) -> {
                            if (Badge.OnDragStateChangedListener.STATE_SUCCEED == dragState) {
                                // 清除红点后的回调

                            }
                        })
                ;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void closePage(ExitAppEvent event) {
        finish();
    }

    /**
     * 刷新界面Event
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshView(PageEvent event) {

        if(event.equals(PageEvent.HOME_PAGE_3)){
            KLog.i("test","刷新购物车");
        }

    }









    /**
     * 请求文件写入权限，并下载文件
     *
     * @param downUrl
     */
    @SuppressLint("CheckResult")
    private void requestPermissionsAndDownload(String downUrl) {
        new RxPermissions(this).request(Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe(aBoolean -> {
            if (aBoolean) {
                doDownload(downUrl);
            }
        });
    }

    /**
     * 下载安装包
     */
    private void doDownload(String downloadUrl) {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewModel.onDestroy();
    }



    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBusCome(Event event) {
        if (event != null) {
            switch (event.getCode()){
                case AppEvent.EventCode.carCount:
                    //刷新购物车数据
                    //设置数据显示
                    CartCount  cartCount  = (CartCount) event.getData();
                    KLog.i("test","刷新购物车数据"+cartCount.getCount());
                    mBadge.setBadgeNumber(cartCount.getCount());
                    //刷新购物车界面数据
                    EventBusUtil.sendEvent(new Event(AppEvent.EventCode.carRefresh));

                    break;
                case AppEvent.EventCode.refresh:
                        //根据购物车返回的刷新操作
                    KLogUtils.logTest("主架构刷新数据操作～～～～～");
                    mViewModel.getCatRequest();
                    mViewModel.checkUpdate();
                    break;
                case  AppEvent.EventCode.switchFragment1:
                    mNavigationView.setCurrentItem(0);
                    break;
                case  AppEvent.EventCode.switchFragment2:
                    mNavigationView.setCurrentItem(1);
                    break;
                case  AppEvent.EventCode.switchFragment3:
                    mNavigationView.setCurrentItem(2);
                    break;
                case  AppEvent.EventCode.switchFragment4:
                    mNavigationView.setCurrentItem(3);
                    break;
                case  AppEvent.EventCode.switchFragment5:
                    mNavigationView.setCurrentItem(4);
                    break;



            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEventBusCome(Event event) {
        if (event != null) {
            switch (event.getCode()){
                case AppEvent.EventCode.AppUpdate:
                    Event<AppVersion> appVersionEvent = (Event<AppVersion>) event.getData();
                    KLogUtils.logTest("App升级操作～～～～～");
                    AppVersion appVersion = appVersionEvent.getData();
//
                    if(appVersion == null){
//                        AlertDialog alertDialog = new AlertDialog(this);
//                        alertDialog.show();
                        AppVersionDialog versionDialog = new AppVersionDialog(this,appVersion);
                        StateButton stateButton = versionDialog.findViewById(R.id.btn_update);
                        stateButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                requestPermissionsAndDownload(appVersion.getUrl());
                                versionDialog.dismiss();
                            }
                        });
                        if(appVersion.getForceUpdate().equals("0")){
                            //不强制更新
                            //关闭写法
                            versionDialog.setCancelable(true);
                        }else{
                            //不关闭写法
                            versionDialog.setCancelable(false);
                        }
                        versionDialog.show();

                    }

                    break;
            }

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(mFragments.get(currentPage) != null){
            mFragments.get(currentPage).onActivityResult(requestCode, resultCode, data);
        }


    }
}
