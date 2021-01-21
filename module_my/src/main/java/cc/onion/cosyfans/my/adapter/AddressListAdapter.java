package cc.onion.cosyfans.my.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.my.entity.AddressListEntity;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.adapter
 * @ClassName: AddressListAdapter
 * @Description: 地址类适配器
 * @Author: guobihai
 * @CreateDate: 2019-12-11 14:24
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-11 14:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AddressListAdapter extends BaseQuickAdapter<AddressListEntity.DataBean, BaseViewHolder> {

    public AddressListAdapter(Context mContext, @Nullable List<AddressListEntity.DataBean> data) {
        super(R.layout.my_item_address,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AddressListEntity.DataBean item) {
        helper.setText(R.id.tv_name,item.getConsignee());
        helper.setText(R.id.tv_number,item.getMobile());
        String address = " ";
        if(StringUtils.isNotEmpty(item.getAddress2())){
            address += item.getAddress2()+",";
        }
        if(StringUtils.isNotEmpty(item.getAddress1())){
            address += item.getAddress1()+",";
        }
        if(StringUtils.isNotEmpty(item.getCity())){
            address += item.getCity()+",";
        }
        if(StringUtils.isNotEmpty(item.getPostalCode())){
            address += item.getPostalCode()+",";
        }

        if(StringUtils.isNotEmpty(item.getState())){
            address += item.getState()+",";
        }

        if(StringUtils.isNotEmpty(item.getCountry())){
            address += item.getCountry();
        }

        helper.setText(R.id.tv_address,address);

    }
}
