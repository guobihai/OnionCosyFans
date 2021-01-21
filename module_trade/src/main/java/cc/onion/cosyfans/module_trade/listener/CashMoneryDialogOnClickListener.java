package cc.onion.cosyfans.module_trade.listener;

import cc.onion.cosyfans.module_trade.entity.CashCouponEntity;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_trade.listener
 * @ClassName: CashMoneryDialogOnClickListener
 * @Description: 接口，抽取选中的数据
 * @Author: guobihai
 * @CreateDate: 2019-12-13 11:34
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-13 11:34
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface CashMoneryDialogOnClickListener {

    void selectCurrentItem(CashCouponEntity.DataBean item);
}
