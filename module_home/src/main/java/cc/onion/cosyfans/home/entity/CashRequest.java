package cc.onion.cosyfans.home.entity;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.home.entity
 * @ClassName: CashRequest
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020-01-15 15:35
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-15 15:35
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CashRequest extends BaseRequestBean {

    String expiredTime;

    public String getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(String expiredTime) {
        this.expiredTime = expiredTime;
    }
}
