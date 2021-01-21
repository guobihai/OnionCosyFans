package cc.onion.cosyfans.cart.listener;

/**
 * @author guobihai
 * @version V1.0
 * @Title: AppCommonInfo
 * @Package cc.onion.cosyfans.base.common
 * @date 2019-12-03 14:53
 * @email: anhui-zhuang@msyc.cc
 * @Description: (购车车界面)
 */
public interface CartViewListener {



    /**
     * 选择全部item
     */
    public void selectAllItem();


    /**
     * 结算
     */
    public void checkItemCalculation();


    /**
     * 编辑
     */
    public void editItem();
}
