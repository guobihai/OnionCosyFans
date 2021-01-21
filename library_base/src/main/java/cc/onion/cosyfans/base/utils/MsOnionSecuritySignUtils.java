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
package cc.onion.cosyfans.base.utils;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: MsOnionSecuritySignUtils
 * @Description: 签名工具类
 * @Company: 广州市两棵树网络科技有限公司
 * @Author: Jack jack-liang@msyc.cc
 * @Date: 2018/7/23 16:17
 */
public class MsOnionSecuritySignUtils {


    /**
     * 签名
     *
     * @param signMap 参与签名的参数
     * @param appSecret     App密钥
     * @return
     *
     */
    public static String sign(Map<String, Object> signMap, String appSecret) {


        String result = "";

        if (signMap == null || signMap.isEmpty()) {
            return result;
        }

        List<String> paramList = new ArrayList<String>(signMap.keySet());
        //参数排序
        Collections.sort(paramList);

//        第一步：对参数按照key=value的格式
        StringBuffer stringSignTemp = new StringBuffer();
        for (int i = 0; i < paramList.size(); i++) {

            if (null == signMap.get(paramList.get(i)) || StringUtils.isBlank(signMap.get(paramList.get(i)).toString()
            )) {
//                参数值为空不参与签名
                continue;
            }

            stringSignTemp.append(paramList.get(i)).append("=")
                          .append(JSONObject.toJSON(signMap.get(paramList.get(i))));

            if (i < paramList.size() - 1) {
                stringSignTemp.append("&");
            }

        }
//        第二步：拼接API密钥：
        stringSignTemp.append("&").append("key=").append(appSecret);

        System.out.println("拼接URL:" + stringSignTemp.toString() + ":End");
//        第三步：MD5加密转大写
        result = md5(stringSignTemp.toString(), "UTF-8").toUpperCase();

        return result;
    }


    /**
     * 字符串MD5
     *
     * @param data    需要MD5的数据
     * @param charset 需要MD5的数据
     * @return 返回MD5之后数据
     * @Title: md5
     * @Description: 字符串MD5
     * @Author: HeroCao hero-cao@msyc.cc
     * @date 2016年8月17日 上午11:11:58
     */
    public static String md5(String data, String charset) {
        try {
            byte[] array = MessageDigest.getInstance("MD5").digest(data.getBytes(charset));
            StringBuffer sb = new StringBuffer();
            for (byte anArray : array) {
                sb.append(Integer.toHexString((anArray & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception ex) {
            return  "";
        }
    }

    public static void main(String[] args) {

        // Map<String,String> map = new HashMap<String,String>();
        // map.put("appKey","YTlVgQLXppeh");
        // map.put("platformId","10000100");
        // map.put("occupyNum","1");
        // map.put("sku","test");
        // map.put("occupyId","");
        //
        // try {
        //    System.out.println(JSON.toJSONString(JSON.toJSONString(map)));
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

    }
    }

