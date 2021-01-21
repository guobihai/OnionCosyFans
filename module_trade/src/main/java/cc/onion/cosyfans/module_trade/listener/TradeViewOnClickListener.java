package cc.onion.cosyfans.module_trade.listener;

import cc.onion.cosyfans.module_trade.entity.CreateOrderEntity;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.adapter
 * @ClassName: AddressListAdapter
 * @Description: 产品适配器
 * @Author: guobihai
 * @CreateDate: 2019-12-11 14:24
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-11 14:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface TradeViewOnClickListener {


    void toShowPlayDialog(CreateOrderEntity data);
}
