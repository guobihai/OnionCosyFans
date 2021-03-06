package cc.onion.cosyfans.item.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import cc.onion.cosyfans.base.utils.TypeUtils;

/**
 * 收藏滑块viewpager的适配器
 *
 * @author guobihai
 * @created 2019-06-20
 */
public class ProductsFragmentPagerAdapter extends FragmentPagerAdapter {
    // fragment页面
    private List<Fragment> mFragments;
    // 标题数组
    private String mTitles[];

    public ProductsFragmentPagerAdapter(FragmentManager fm, String titles[], List<Fragment> fragmentList) {
        super(fm);
        this.mFragments = fragmentList;
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
