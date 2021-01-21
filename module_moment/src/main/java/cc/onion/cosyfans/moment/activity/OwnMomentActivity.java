package cc.onion.cosyfans.moment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.base.BaseActivity;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.module_moment.BR;
import cc.onion.cosyfans.module_moment.R;
import cc.onion.cosyfans.module_moment.databinding.MomentActivityLayoutBinding;
import cc.onion.cosyfans.moment.adapter.MomentCenterAdapter;
import cc.onion.cosyfans.moment.entry.CenterInfoEntry;
import cc.onion.cosyfans.viewmodel.OwnMomentViewModel;


/**
 * 个人素材中心
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.moment.activity
 * @ClassName: OwnMomentActivity
 * @Description: java类作用描述
 * @Author: gbh
 * @CreateDate: 2020-02-05 16:05
 * @UpdateUser: gbh
 * @UpdateDate: 2020-02-05 16:05
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = RouterPath.Posts.ROUTE_CENTER_PATH)
public class OwnMomentActivity extends BaseActivity<MomentActivityLayoutBinding, OwnMomentViewModel> {


    private MomentCenterAdapter MmomentCenterAdapter;
    private List<CenterInfoEntry> centerInfoEntryList;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.moment_activity_layout;
    }

    @Override
    public int initVariableId() {
        return cc.onion.cosyfans.module_moment.BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        mBinding.setViewModel(mViewModel);

        centerInfoEntryList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            centerInfoEntryList.add(new CenterInfoEntry());
        }

        initView();


    }

    private void initView() {
        mBinding.toolbar.setNavigationOnClickListener(v -> {
            onBackPressed();
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        MmomentCenterAdapter = new MomentCenterAdapter(centerInfoEntryList);
        MmomentCenterAdapter.setEmptyView(R.layout.moment_center_nodata_layout, mBinding.smartRefreshLayout);
        mBinding.rvRecycleView.setLayoutManager(layoutManager);
        mBinding.rvRecycleView.setAdapter(MmomentCenterAdapter);
    }
}
