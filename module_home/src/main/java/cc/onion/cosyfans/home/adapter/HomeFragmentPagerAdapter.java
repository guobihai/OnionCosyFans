package cc.onion.cosyfans.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import cc.onion.cosyfans.base.entity.BaseListResponse;
import cc.onion.cosyfans.home.entity.response.TableEntity;

/**
 * 收藏滑块viewpager的适配器
 *
 * @author guobihai
 * @created 2019-06-20
 */
public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
    // fragment页面
    private List<Fragment> mFragments;
    // 标题数组
    String[] title;

    public HomeFragmentPagerAdapter(FragmentManager fm, String[] title, List<Fragment> fragmentList) {
        super(fm);
        this.mFragments = fragmentList;
        this.title = title;

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
        return title [position];
    }
}
