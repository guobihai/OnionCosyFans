package cc.onion.cosyfans.home.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.home.entity.response.AlumGroupEntity;
import cc.onion.cosyfans.home.entity.response.TableEntity;
import cc.onion.cosyfans.home.fragment.GroupDetailFragment;
import cc.onion.cosyfans.home.fragment.ItemDetailFragment;
import cc.onion.cosyfans.home.weight.ViewPagerForScrollView;

/**
 * 专辑适配器界面
 * @author guobihai
 * @email :guobihai@163.com
 *
 */
public class GroupItemViewPagerAdapter extends FragmentPagerAdapter {

    List<AlumGroupEntity.DataBean.TabListBean> testList = new ArrayList<>();
    ViewPagerForScrollView pagerForScrollView = null;

    public GroupItemViewPagerAdapter(FragmentManager fm, List<AlumGroupEntity.DataBean.TabListBean> testList, ViewPagerForScrollView viewPagerForScrollView) {
        super(fm);
        pagerForScrollView = viewPagerForScrollView;
        this.testList = testList;
    }

    @Override
    public Fragment getItem(int i) {
        //创建fragment对象并返回
        Bundle bundle = new Bundle();
        bundle.putString("flowTabId",  testList.get(i).getId()+"");
        //实例化Fragment
        GroupDetailFragment allFragment = new GroupDetailFragment(pagerForScrollView,i);
        allFragment.setArguments(bundle);
        return allFragment;
    }

    @Override
    public int getCount() {
        return testList.size();
    }

}
