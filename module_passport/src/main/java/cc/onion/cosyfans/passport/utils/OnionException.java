/**
 * 广州市两棵树网络科技有限公司版权所有
 * DT Group Technology & commerce Co., LtdAll rights reserved.
 * <p>
 * 广州市两棵树网络科技有限公司，创立于2009年。旗下运营品牌洋葱小姐。
 * 洋葱小姐（Ms.Onion） 下属三大业务模块 [洋葱海外仓] , [洋葱DSP] , [洋葱海外聚合供应链]
 * [洋葱海外仓]（DFS）系中国海关批准的跨境电商自营平台(Cross-border ecommerce platform)，
 * 合法持有海外直邮保税模式的跨境电商营运资格。是渠道拓展，平台营运，渠道营运管理，及客户服务等前端业务模块。
 * [洋葱DSP]（DSP）系拥有1.3亿消费者大数据分析模型。 是基于客户的消费行为，消费轨迹，及多维度云算法(MDPP)
 * 沉淀而成的精准消费者模型。洋葱DSP能同时为超过36种各行业店铺 及200万个销售端口
 * 进行多店铺高精度配货，并能预判消费者购物需求进行精准推送。同时为洋葱供应链提供更前瞻的商品采买需求模型 。
 * [洋葱海外聚合供应链]（Super Supply Chain）由中国最大的进口贸易集团共同
 * 合资成立，拥有20余年的海外供应链营运经验。并已入股多家海外贸易企业，与欧美澳等9家顶级全球供应商达成战略合作伙伴关系。
 * 目前拥有835个国际品牌直接采买权，12万个单品的商品供应库。并已建设6大海外直邮仓库，为国内客户提供海外商品采买集货供应，
 * 跨境 物流，保税清关三合一的一体化模型。目前是中国唯一多模式聚合的海外商品供应链 。
 * <p>
 * 洋葱商城：http://m.msyc.cc/wx/indexView?tmn=1
 * <p>
 * 洋桃商城：http://www.yunyangtao.com
 */

package cc.onion.cosyfans.passport.utils;



import java.util.List;

/**
 * @Title: OnionException.java
 * @Package: xyz.onion.microservice.framework.common.exception
 * @Description: Onion异常类
 * @Company: 广州市两棵树网络科技有限公司
 * @Author: HeroCao hero-cao@msyc.cc
 * @Date: 2017年2月14日 下午1:43:54
 * @Version: V2.0.0
 * @Modify-by: HeroCao hero-cao@msyc.cc
 * @Modify-date: 2017年2月14日 下午1:43:54
 * @Modify-version: V2.0.0
 * @Modify-description: 重写父类相关构造方法
 * @Modify-version: V2.3.32
 * @Modify-description: 新增 exceptions 字段，
 */

/**
 * @ClassName: OnionException
 * @Description: Onion异常类
 * @Company: 广州市两棵树网络科技有限公司
 * @Author: HeroCao hero-cao@msyc.cc
 * @Date: 2017年2月14日 下午1:43:54
 *
 */
public class OnionException extends OnionBaseException {

    /**
     * @Fields serialVersionUID : 自动生成serialVersionUID
     */
    private static final long serialVersionUID = 8417048002904219465L;

    /**
     * 异常，专门提供给批量操作，无法当时返回 Exception，最终通过批量返回Exception
     */
    private List<OnionException> exceptions;

    /**
     * @param message
     * @param exceptionStatus
     */
    public OnionException(String message, int exceptionStatus) {
        super(message, exceptionStatus);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     * @param exceptionStatus
     */
    public OnionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
                            int exceptionStatus) {
        super(message, cause, enableSuppression, writableStackTrace, exceptionStatus);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public OnionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param message
     * @param cause
     * @param exceptionStatus
     */
    public OnionException(String message, Throwable cause, int exceptionStatus) {
        super(message, cause, exceptionStatus);
    }

    /**
     * @param message
     * @param cause
     */
    public OnionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public OnionException(String message) {
        super(message);
    }

    /**
     * @param cause
     * @param exceptionStatus
     */
    public OnionException(Throwable cause, int exceptionStatus) {
        super(cause, exceptionStatus);
    }

    /**
     * @param cause
     */
    public OnionException(Throwable cause) {
        super(cause);
    }


    @Override
    public String toString() {

//        return "MsOnionException{" +
//                "exceptions=" + exceptions +
//                '}';

        // 解决 ： OnionException(exceptions=null)
        return super.getMessage();

    }

}
