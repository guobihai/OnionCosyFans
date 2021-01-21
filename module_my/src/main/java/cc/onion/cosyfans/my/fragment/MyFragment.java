package cc.onion.cosyfans.my.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.my.adapter.MyFragmentPagerAdapter;

/**
 * 我的
 *
 * @author anhuifxi
 * @created 2019/11/06
 */
@Route(path = RouterPath.MyCosy.ROUTE_MINE_PATH)
public class MyFragment extends Fragment {

    public static MyFragment newInstance() {
        Bundle args = new Bundle();

        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }





    View rootView;
    private List<Fragment> fragments;
    private MyFragmentPagerAdapter mPagerAdapter;
    private static final String[] PAGE_TITLE = {"商家", "个人"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.my_frgm_home, container, false);
        return rootView;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViewPager();
    }

    private void initViewPager() {
        RadioGroup centerRadioGroup = rootView.findViewById(R.id.my_item_radioGroup);
        ViewPager viewPager = rootView.findViewById(R.id.my_center_viewpager);
        fragments = new ArrayList<>();
        fragments.add(new MerchantCenterFragment());
        fragments.add(new PerssonalCenterFragment());
        mPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), PAGE_TITLE, fragments);
        viewPager.setAdapter(mPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        centerRadioGroup.check(R.id.my_radiobtn_merchant_center);
                        break;
                    case 1:
                        centerRadioGroup.check(R.id.my_radiobtn_person_center);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        centerRadioGroup.setOnCheckedChangeListener(((group, checkedId) -> {
            int checkId = group.getCheckedRadioButtonId();
            if (checkId == R.id.my_radiobtn_merchant_center) {
                viewPager.setCurrentItem(0);
            } else if (checkId == R.id.my_radiobtn_person_center) {
                viewPager.setCurrentItem(1);
            }
        }));

    }

}
