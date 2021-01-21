package cc.onion.cosyfans.my.entity.request;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * 注册统计 请求体
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.entity.request
 * @ClassName: RegisterUserRequest
 * @Description: java类作用描述
 * @Author: 唐朝
 * @CreateDate: 2020/1/17 17:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/17 17:34
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class RegisterUserRequest extends BaseRequestBean {
    private int statisticsType;

    public RegisterUserRequest(int statisticsType) {
        this.statisticsType = statisticsType;
        this.putKeySign("statisticsType", this.statisticsType);
        this.sign();
    }

    public int getStatisticsType() {
        return statisticsType;
    }

    public void setStatisticsType(int statisticsType) {
        this.statisticsType = statisticsType;
    }
}
