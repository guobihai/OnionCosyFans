package cc.onion.cosyfans.item.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;

import cc.onion.cosyfans.base.BaseFragment;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.item.activity.ProductsDetailActivity;
import cc.onion.cosyfans.item.viewModel.PostsAndroidViewModel;
import cc.onion.cosyfans.module_item.R;
import cc.onion.cosyfans.module_item.databinding.ItemFragmentProductsPostsBinding;


/**
 * 素材
 * @author  guobihai
 * @date 2019 - 11- 08
 */
@Route(path = RouterPath.Item.ROUTE_ITEM_POSTS)
public class PostsFraagment extends BaseFragment<ItemFragmentProductsPostsBinding, PostsAndroidViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.item_fragment_products_posts;
    }

    @Override
    public int initVariableId() {
        return cc.onion.cosyfans.module_item.BR.viewModel;
    }
}
