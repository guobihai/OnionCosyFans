package cc.onion.cosyfans.module_search.entity;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_search.entity
 * @ClassName: HotRequest
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020-01-06 10:40
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-06 10:40
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HotRequest extends BaseRequestBean {
    /**
     * 应用到。1：首页搜索栏，2：发圈素材中心搜索栏
     */
    String applyTo;

    public String getApplyTo() {
        return applyTo;
    }


    public void setApplyTo(String applyTo) {
        this.applyTo = applyTo;
    }
}
