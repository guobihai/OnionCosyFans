package cc.onion.cosyfans.moment.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.module_moment.R;
import cc.onion.cosyfans.moment.adapter.MyFragmentPagerAdapter;




/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.moment.fragment
 * @ClassName: MomentFragment
 * @Description: java类作用描述
 * @Author: gbh
 * @CreateDate: 2020-02-03 19:04
 * @UpdateUser: gbh
 * @UpdateDate: 2020-02-03 19:04
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

@Route(path = RouterPath.Posts.ROUTE_POSTS_PATH)
public class MomentFragment extends Fragment implements ViewPager.OnPageChangeListener {

    public static MomentFragment newInstance() {
        Bundle args = new Bundle();

        MomentFragment fragment = new MomentFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private TabLayout mTabLayout;
    private ViewPager mViewPager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.moment_frgm_home, container, false);
        initView(rootView);
        initData();
        return rootView;
    }

    private void initView(View rootView) {
        mTabLayout = rootView.findViewById(R.id.moment_center_tablayout);
        mViewPager = rootView.findViewById(R.id.moment_ViewPager);
        Button btnPost = rootView.findViewById(R.id.btnPost);
        btnPost.setOnClickListener(v ->{
            ARouter.getInstance().build(RouterPath.Posts.ROUTE_POST_COMMENT_PATH).greenChannel().navigation();
        });

    }

    private void initData() {
        String[] titles = getResources().getStringArray(R.array.moment_tab_array);

        mTabLayout.setupWithViewPager(mViewPager);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(ListMomentsFragment.newInstance("", ""));
        fragmentList.add(ListMomentsFragment.newInstance("", ""));
        fragmentList.add(ListMomentsFragment.newInstance("", ""));

        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(Objects.requireNonNull(getActivity()).getSupportFragmentManager(), titles,
                fragmentList);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.addOnPageChangeListener(this);
        mViewPager.setOffscreenPageLimit(3);

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
