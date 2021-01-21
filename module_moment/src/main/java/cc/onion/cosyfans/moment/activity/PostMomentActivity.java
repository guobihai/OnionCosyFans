package cc.onion.cosyfans.moment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import cc.onion.cosyfans.base.BaseActivity;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.module_moment.BR;
import cc.onion.cosyfans.module_moment.R;
import cc.onion.cosyfans.module_moment.databinding.MomentPostActivityBinding;
import cc.onion.cosyfans.viewmodel.PostMomentViewModel;


/**
 * 发布素材圈
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.moment.activity
 * @ClassName: PostMomentActivity
 * @Description: java类作用描述
 * @Author: gbh
 * @CreateDate: 2020-02-05 18:00
 * @UpdateUser: gbh
 * @UpdateDate: 2020-02-05 18:00
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

@Route(path = RouterPath.Posts.ROUTE_POST_COMMENT_PATH)
public class PostMomentActivity extends BaseActivity<MomentPostActivityBinding, PostMomentViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.moment_post_activity;
    }

    @Override
    public int initVariableId() {
        return cc.onion.cosyfans.module_moment.BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
    }


}
