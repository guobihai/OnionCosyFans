package cc.onion.cosyfans.item.Utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import java.util.List;

import cc.onion.cosyfans.base.BaseFragment;

public class FragmentGetViewUtils {
    /**
     * 通过这个方法可以避免重复实例化Fragment
     *
     * @param <T>
     * @param clazz
     * @param tag
     * @return
     */
    public static  <T extends BaseFragment> T getFragment(AppCompatActivity context, Class<?> clazz, String tag) {

        List<Fragment> fragments = context.getSupportFragmentManager().getFragments();
        BaseFragment fragment = null;
        if (fragments != null && fragments.size() > 0) {
            for (Fragment fragment1 : fragments) {

                if (fragment1 != null && fragment1 instanceof BaseFragment) {
                    BaseFragment baseFragment = (BaseFragment) fragment1;
                    if (baseFragment.getClass().getName().equals(clazz.getName())) {
                        if (!TextUtils.isEmpty(tag)) {
                            if (baseFragment.tag.equals(tag)) {
                                fragment = baseFragment;
                            }
                        } else {
                            fragment = baseFragment;
                        }
                    }

                }
            }
        }


        if (fragment == null) {
            try {
                fragment = (BaseFragment) clazz.newInstance();

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (tag != null) {
            fragment.tag = tag;
        }

        return (T) fragment;
    }

}
