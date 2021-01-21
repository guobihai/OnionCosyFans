package cc.onion.cosyfans.home.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.base.BaseToolBarActivity;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.home.adapter.GroupItemViewPagerAdapter;
import cc.onion.cosyfans.home.adapter.HomeFragmentPagerAdapter;
import cc.onion.cosyfans.home.adapter.HousePricuterdAdapter;
import cc.onion.cosyfans.home.entity.response.AlbumRequest;
import cc.onion.cosyfans.home.entity.response.AlumGroupEntity;
import cc.onion.cosyfans.home.entity.response.GroupItemEntity;
import cc.onion.cosyfans.home.entity.response.GroupListRequest;
import cc.onion.cosyfans.home.viewmodel.HomeViewModel;
import cc.onion.cosyfans.home.viewmodel.ItemGroupViewModel;
import cc.onion.cosyfans.home.weight.ViewPagerForScrollView;
import cc.onion.cosyfans.module_home.R;
import cc.onion.cosyfans.module_home.databinding.HomeGroupItemBinding;
import io.reactivex.disposables.Disposable;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.home.activity
 * @ClassName: ItemGroupActivity
 * @Description: 商品专题
 * @Author: guobihai
 * @CreateDate: 2019-12-25 14:42
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-25 14:42
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = RouterPath.Home.ROUTE_HOME_GROUP)
public class ItemGroupActivity extends BaseToolBarActivity<HomeGroupItemBinding, ItemGroupViewModel> {

    @Autowired
    String itemId;
    @Autowired
    String albumId = "10213";

    private int pageNum = 1;
    private int pageSize = 10;

    private List<Fragment> fragments;
    private HomeFragmentPagerAdapter mPagerAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_group_item);
        mBinding.setItemModel(mViewModel);

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void initData() {
        super.initData();
        setScorTop();
        if(StringUtils.isNotEmpty(albumId)){
            loadAlbumData();
        }

    }

    private void loadAlbumData() {
        AlbumRequest request = new AlbumRequest();
        request.setAlbumId(albumId);
        request.getKeyMap().put("albumId",albumId);
        request.setRequestSign(request.getKeyMap());
        mViewModel.getAlbumData(request, new ResponseListener<AlumGroupEntity>() {
            @Override
            public void loadSuccess(AlumGroupEntity data) {
                if(data.getData() != null ){
                            //album
                            if(StringUtils.isNotEmpty(data.getData().getImageBig())){
                                BaseBindingAdapter.loadImageLarge(mBinding.imgAlbum,data.getData().getImageBig());
                            }

                            if(StringUtils.isNotEmpty(data.getData().getContent())){
                                mViewModel.context.set(data.getData().getContent());
                            }

                            if(StringUtils.isNotEmpty(data.getData().getTheme())){
                                setToolbarTitle(data.getData().getTheme());
                            }
                            if(data.getData().getTabList() != null && data.getData().getTabList().size() >0){
                                addTableLayout(data.getData().getTabList());
                            }

                }
            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                KLog.i("test","获取数据失败");
            }

            @Override
            public void addDisposable(Disposable disposable) {
                        addDisposable(disposable);
            }
        });
    }



    /**
     * 添加标签布局，动态化配置布局
     * @param tabList
     */
    private void addTableLayout(List<AlumGroupEntity.DataBean.TabListBean> tabList) {
        try {

                fragments = new ArrayList<>();

                mBinding.itemViewPageer.setAdapter(mPagerAdapter);


                for (int i = 0; i < tabList.size(); i++) {
                    mBinding.itemTabLayout.addTab(mBinding.itemTabLayout.newTab().setText(tabList.get(i).getName()));
                }


             mBinding.itemViewPageer.setAdapter(new GroupItemViewPagerAdapter(getSupportFragmentManager(),tabList,mBinding.itemViewPageer));
            mBinding.itemTabLayout.setupWithViewPager(mBinding.itemViewPageer);
                for (int i = 0; i < mBinding.itemTabLayout.getTabCount(); i++) {
                    TabLayout.Tab tab = mBinding.itemTabLayout.getTabAt(i);
                    tab.setText(tabList.get(i).getName());
                }

            mBinding.itemViewPageer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float v, int i1) {
                        KLog.i("test","viewPager切换的是"+position);
//                        viewPager.setCurrentItem(position);
                        mBinding.itemViewPageer.resetHeight(position);
                        mBinding.itemViewPageer.refreshView(position);
                    }

                    @Override
                    public void onPageSelected(int i) {

                    }

                    @Override
                    public void onPageScrollStateChanged(int i) {

                    }
                });


            mBinding.itemTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        int position = tab.getPosition();
                        KLog.i("test","table切换的是"+position);
//                        viewPager.setCurrentItem(position);
                        mBinding.itemViewPageer.resetHeight(position);
                        mBinding.itemViewPageer.refreshView(position);
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });

        }catch (Exception e){
            e.printStackTrace();
        }
    }




    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setScorTop() {
        mBinding.netScroview.setOnClickListener(v -> {
//            mBinding.netScroview.scrollTo(0,0);
            mBinding.netScroview.smoothScrollTo(0, 1);
        });
        mBinding.netScroview.setOnScrollChangeListener((View.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            try {

                if (scrollY > oldScrollY) {
//                    KLog.e("=====", "下滑");
                    if(scrollY >1000){
                        mBinding.imgTop.setVisibility(View.VISIBLE);
                    }


                }

                if (scrollY < oldScrollY) {
//                    KLog.e("=====", "上滑");
                    if(scrollY < 1000){
                        mBinding.imgTop.setVisibility(View.GONE);
                    }
                }




                if (scrollY == 0) {

                    KLog.e("=====", "滑倒顶部");
                    mBinding.imgTop.setVisibility(View.GONE);
                }



                if (scrollY == (mBinding.netScroview.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())) {
                    KLog.e("=====", "滑倒底部");
                    mBinding.imgTop.setVisibility(View.GONE);
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }



}
