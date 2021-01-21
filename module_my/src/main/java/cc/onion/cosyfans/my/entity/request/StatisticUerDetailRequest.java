package cc.onion.cosyfans.my.entity.request;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * 注册统计-用户详情
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.entity.request
 * @ClassName: RegisterUerDetailRequest
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/17 17:30
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/17 17:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class StatisticUerDetailRequest extends BaseRequestBean {
    private int userIdxCode;//用户信息


    //查询详情的时候使用
    public StatisticUerDetailRequest(int userIdxCode) {
        this.userIdxCode = userIdxCode;
        this.putKeySign("userIdxCode", this.userIdxCode);
        this.sign();
    }

    public int getUserIdxCode() {
        return userIdxCode;
    }

    public void setUserIdxCode(int userIdxCode) {
        this.userIdxCode = userIdxCode;
    }
}
