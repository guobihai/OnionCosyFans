package cc.onion.cosyfans.module_order.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author guobihai
 *
 */
public class OrderPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> listFragment; //fragment列表
    private List<String> listTitle; // tab名称列表

    public OrderPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        this.listFragment = fragments;
        this.listTitle = titles;
    }

    @Override
    public Fragment getItem(int i) {
        return listFragment.get(i);
    }

    @Override
    public int getCount() {
        return listTitle.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listTitle.get(position % listTitle.size());
    }

    // 覆盖destroyItem方法阻止销毁Fragment，避免滑动卡顿、牺牲了内存
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return view == object;
//    }
}
