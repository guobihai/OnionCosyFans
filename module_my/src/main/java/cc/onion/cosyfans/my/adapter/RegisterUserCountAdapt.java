package cc.onion.cosyfans.my.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.my.entity.RegisterUserDetailEntry;

/**
 * 注册统计-个人信息适配器
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.adapter
 * @ClassName: RegisterUserCountAdapt
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/17 14:30
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/17 14:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class RegisterUserCountAdapt extends BaseQuickAdapter<RegisterUserDetailEntry.DataBean, BaseViewHolder> {
    public RegisterUserCountAdapt(@Nullable List<RegisterUserDetailEntry.DataBean> data) {
        super(R.layout.my_register_user_detail_item_layout,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RegisterUserDetailEntry.DataBean item) {
        helper.setText(R.id.tv_userName_value,item.getUserName());
        helper.setText(R.id.tv_TelNo_value,item.getCellPhone());
        helper.setText(R.id.tv_register_date_value,item.getCreateTime());
        helper.setText(R.id.tv_register_addr_value,item.getRegisterJoint());
        helper.setText(R.id.tv_register_type_value,item.getLevel());
    }
}
