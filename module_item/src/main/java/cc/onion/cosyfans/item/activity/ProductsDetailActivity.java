package cc.onion.cosyfans.item.activity;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.tmall.ultraviewpager.UltraViewPager;

import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.base.BaseActivity;
import cc.onion.cosyfans.base.BaseFragment;
import cc.onion.cosyfans.base.BaseToolBarActivity;
import cc.onion.cosyfans.base.dialog.LoadingDialog;
import cc.onion.cosyfans.base.event.PageEvent;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.SoftKeyBoardUtils;
import cc.onion.cosyfans.base.utils.StatusBarUtils;
import cc.onion.cosyfans.item.adapter.CoverPagerAdapter;
import cc.onion.cosyfans.item.entity.ItemDetailRequest;
import cc.onion.cosyfans.item.entity.PhotoModel;
import cc.onion.cosyfans.item.adapter.ProductsFragmentPagerAdapter;
import cc.onion.cosyfans.item.entity.response.ItemDetailEntity;
import cc.onion.cosyfans.item.fragment.DetailFragment;
import cc.onion.cosyfans.item.fragment.PostsFraagment;
import cc.onion.cosyfans.item.viewModel.ProductsViewModel;
import cc.onion.cosyfans.module_item.R;
import cc.onion.cosyfans.module_item.databinding.ItemProductsDetailBinding;
import io.reactivex.disposables.Disposable;

/**
 * Products detail
 * @author guobihai
 * @email:guobihai@163.com
 *  Products/Posts
 *
 */
@RequiresApi(api = Build.VERSION_CODES.M)
@Route(path = RouterPath.Item.ROUTE_ITEM_PRODUCTS_PATH)
public class ProductsDetailActivity extends BaseActivity<ItemProductsDetailBinding, ProductsViewModel> implements View.OnScrollChangeListener {

    // 标题栏按钮的颜色
    private int toolBarMenuColor = 0;
    // 轮播图
    private UltraViewPager coverViewPager;
    private LoadingDialog loadingDialog;
    //轮播图
    CoverPagerAdapter coverPagerAdapter;

    private static final String [] PAGE_TITLE = {"商品", "素材"};
    private List<Fragment> fragments;
    private ProductsFragmentPagerAdapter mPagerAdapter;


    @Autowired
    String itemId;


    @Override
    public void initParam() {
        // 获取ARouter注入
        ARouter.getInstance().inject(this);

    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.item_products_detail;
    }

    @Override
    public int initVariableId() {
        return cc.onion.cosyfans.module_item.BR.viewModel;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
//         itemId = getIntent().getStringExtra("itemId");
    }

    /**
     * 刷新界面Event
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshView(PageEvent event) {

        if(event.equals(PageEvent.HOME_PAGE_3)){
            KLog.i("test","刷新购物车");
            finish();
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Override
    public void initData() {
        super.initData();

//        initToolBar();
        mBinding.imgLeft1.setOnClickListener(v -> onBackPressed());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        loadingDialog = new LoadingDialog(this);
        initViewPage();
        KLog.i("test","itemId------ProductsDetailActivity"+"~~~"+itemId);
        mBinding.imgLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });





    }



    /**
     * 初始化列表fargment
     */
    private void initViewPage() {
        fragments = new ArrayList<>();
        fragments.add(new DetailFragment(itemId,this));
        fragments.add(new PostsFraagment());
        mPagerAdapter = new ProductsFragmentPagerAdapter(getSupportFragmentManager(), PAGE_TITLE, fragments);
        mBinding.viewpager.setAdapter(mPagerAdapter);

        mBinding.itemTabLayout.setupWithViewPager(mBinding.viewpager, false);
    }




    private void initToolBar() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            // 为了避免vivo 5.0系统使用全透明状态栏出现一片空白的问题，在这里做处理
            StatusBarUtils.setStatusBarTransparent(this); // 透明状态栏
        }

        StatusBarUtils.setStatusBarTextColorDark(this);
    }



    /**
     * 改变透明度
     *
     * @param color
     * @param fraction
     * @return
     */
    private int changeAlpha(int color, float fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = (int) (Color.alpha(color) * fraction);
        return Color.argb(alpha, red, green, blue);
    }


    @Override
    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

        try {
            if(scrollY >0 ){
                mBinding.layoutTitle.setVisibility(View.VISIBLE);
                mBinding.layoutPostos.setVisibility(View.GONE);
            }else{
                mBinding.layoutTitle.setVisibility(View.GONE);
                mBinding.layoutPostos.setVisibility(View.VISIBLE);
            }

            if (scrollY > oldScrollY) {
                KLog.e("=====", "下滑");
                if(scrollY >1000){
//                    mBinding.imgTop.setVisibility(View.VISIBLE);
                    //设置标题布局的透明度为0
//                    mBinding.layoutTitle.setAlpha(changeAlpha(R.color.white,scrollY));
                }


            }

            if (scrollY < oldScrollY) {
                KLog.e("=====", "上滑");
                if(scrollY < 1000){
//                    mBinding.imgTop.setVisibility(View.GONE);
//                    mBinding.layoutTitle.setAlpha(changeAlpha(R.color.white,scrollY));
                }
            }




            if (scrollY == 0) {

                KLog.e("=====", "滑倒顶部");
                mBinding.layoutTitle.setVisibility(View.GONE);
                mBinding.layoutPostos.setVisibility(View.VISIBLE);
            }


            if (scrollY == (v.getMeasuredHeight() - v.getMeasuredHeight())) {
                KLog.e("=====", "滑倒底部");
                mBinding.layoutPostos.setVisibility(View.GONE);
                mBinding.layoutTitle.setVisibility(View.VISIBLE);
            }

//            int mHeight = mBinding.layoutTitle.getHeight();//获取标题栏高度
//            if (scrollY <= 0) {//未滑动
//                mBinding.layoutTitle.setBackgroundColor(Color.argb((int) 0, 0, 0, 0));
//            } else if (scrollY > 0 && scrollY <= 500) { //滑动过程中 并且在mHeight之内
//                float scale = (float) scrollY / mHeight;
//                float alpha = (255 * scale);
////                mBinding.itemTabLayout.setTabTextColors(Color.argb((int) alpha, 255, 255, 255));
//                mBinding.itemTabLayout.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
//            } else {//超过mHeight
//                mBinding.itemTabLayout.setBackgroundColor(Color.argb((int) 255, 255, 255, 255));
//        }




        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
