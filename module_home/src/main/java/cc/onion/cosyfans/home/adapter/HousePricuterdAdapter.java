package cc.onion.cosyfans.home.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;


import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.home.entity.response.TableEntity;
import cc.onion.cosyfans.home.fragment.ItemDetailFragment;
import cc.onion.cosyfans.home.weight.ViewPagerForScrollView;

/**
 * 户型信息,动态添加数据
 * @author guobihai
 * @email :guobihai@163.com
 *
 */
public class HousePricuterdAdapter extends FragmentPagerAdapter {

    List<TableEntity.DataBean.FlowTabListBean> testList = new ArrayList<>();
    ViewPager pagerForScrollView = null;

    public HousePricuterdAdapter(FragmentManager fm, List<TableEntity.DataBean.FlowTabListBean> testList, ViewPager viewPagerForScrollView) {
        super(fm);
        pagerForScrollView = viewPagerForScrollView;
        this.testList = testList;
    }

    @Override
    public Fragment getItem(int i) {
        //创建fragment对象并返回
        Bundle bundle = new Bundle();
        bundle.putString("flowTabId",  testList.get(i).getFlowTabId()+"");
        //实例化Fragment
        ItemDetailFragment allFragment = new ItemDetailFragment(pagerForScrollView,i);
        allFragment.setArguments(bundle);
        return allFragment;
    }

    @Override
    public int getCount() {
        return testList.size();
    }

}
