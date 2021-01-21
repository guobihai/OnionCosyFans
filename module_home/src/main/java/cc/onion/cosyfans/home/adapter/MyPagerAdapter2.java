package cc.onion.cosyfans.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import java.util.List;

public class MyPagerAdapter2 extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private String[] title ;


    public MyPagerAdapter2(FragmentManager fm,List<Fragment> fragmentList,String[] title) {
        super(fm);
        this.fragmentList =fragmentList;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList != null ? fragmentList.get(position) : null;
    }

    @Override
    public int getCount() {
        return fragmentList != null ? fragmentList.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
//            return super.isViewFromObject(view, object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
