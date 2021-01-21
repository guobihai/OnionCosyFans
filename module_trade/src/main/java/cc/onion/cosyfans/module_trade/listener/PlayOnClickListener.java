package cc.onion.cosyfans.module_trade.listener;

import cc.onion.cosyfans.module_trade.entity.PlayListEntity;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.trade
 * @ClassName: AddressListAdapter
 * @Description: 支付监听
 * @Author: guobihai
 * @CreateDate: 2019-12-11 14:24
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-11 14:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface PlayOnClickListener {

    void toPlayResule(PlayListEntity.DataBean item,String orderNo);
}
