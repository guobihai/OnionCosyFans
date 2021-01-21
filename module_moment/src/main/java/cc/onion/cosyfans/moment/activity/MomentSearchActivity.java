package cc.onion.cosyfans.moment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.module_moment.R;

/**
 * 素材中心搜索
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.moment.activity
 * @ClassName: MomentSearchActivity
 * @Description: java类作用描述
 * @Author: gbh
 * @CreateDate: 2020-02-05 15:56
 * @UpdateUser: gbh
 * @UpdateDate: 2020-02-05 15:56
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

@Route(path = RouterPath.Posts.ROUTE_SEARCH_PATH)
public class MomentSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moment_search_activity_layout);
    }
}
