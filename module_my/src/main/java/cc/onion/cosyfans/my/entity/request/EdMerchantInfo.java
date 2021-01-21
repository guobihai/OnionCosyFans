package cc.onion.cosyfans.my.entity.request;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * 修改商家信息类
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.entity
 * @ClassName: EdMerchantInfo
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/11 16:42
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/11 16:42
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class EdMerchantInfo extends BaseRequestBean {
    private String name;
    private String discription;
    private int id;


    public EdMerchantInfo(int id,String name, String discription) {
        this.id =id;
        this.name = name;
        this.discription = discription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
