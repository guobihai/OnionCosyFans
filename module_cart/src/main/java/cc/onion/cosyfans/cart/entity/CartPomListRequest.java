package cc.onion.cosyfans.cart.entity;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.cart.entity
 * @ClassName: CartPomListRequest
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2019-12-23 17:14
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-23 17:14
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CartPomListRequest extends BaseRequestBean {
//    appId: 45758921074
//    appKey: "YTvxPoiCjqKo"
//    apiv: "1.0.0"
//    timestamp: "20191223171121"
//    language: "cn"
//    pageNum: 1
//    pageSize: 10
//    q: ""
//    promotionId: "24045"
//    sign: "AC945B0CAD8F2A7AA84CD759A3428622"

    private int pageNum;
    private int pageSize;
    private String  q;
    private String promotionId;


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }
}
