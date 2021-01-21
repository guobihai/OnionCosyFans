package cc.onion.cosyfans.my.activity.person;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;

import cc.onion.cosyfans.base.BaseToolBarActivity;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.module_my.databinding.MyUserHelperBinding;
import cc.onion.cosyfans.my.viewdModel.UserHelpCenterViewModel;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.activity.person
 * @ClassName: UserHelpCenterActivity
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2019-12-31 18:27
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-31 18:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = RouterPath.MyCosy.ROUTE_MIME_USER_HELP)
public class UserHelpCenterActivity extends BaseToolBarActivity<MyUserHelperBinding, UserHelpCenterViewModel> {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_user_helper);
        setToolbarTitle(R.string.my_user_center);
        mBinding.setModel(mViewModel);
        mViewModel.setmContext(this);

    }
}
