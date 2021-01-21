package cc.onion.cosyfans.main.entity.request;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.main.entity.request
 * @ClassName: AppVersionRequest
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020-01-11 15:14
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-11 15:14
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AppVersionRequest extends BaseRequestBean {

    /**
     * 用户端 1、m端 2、ios端 3、Android端
     */
    int userClient;

    public int getUserClient() {
        return userClient;
    }

    public void setUserClient(int userClient) {
        this.userClient = userClient;
    }
}
