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

import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Title: OnionSecurityBase64Utils.java
 * @Package: xyz.onion.microservice.framework.common.utils
 * @Description: 安全Base64工具类
 * @Company: 广州市两棵树网络科技有限公司
 * @Author: HeroCao hero-cao@msyc.cc
 * @Date: 2017年2月16日 下午8:34:53
 * @Version: V2.0.0
 * @Modify-by: HeroCao hero-cao@msyc.cc
 * @Modify-date: 2017年2月16日 下午8:34:53
 * @Modify-version: V2.0.0
 * @Modify-description: 新增：实现相关方法
 */

/**
 * Base64是一种基于64个可打印字符来表示二进制数据的表示方法。通常是52个大小字母和10个数字，以及+，/两个字符，还有个=用于补缺。
 * <p>
 * BASE64是一种编码方式，通常用于把二进制数据编码为可写的字符形式的数据。
 * <p>
 * 这是一种可逆的编码方式。
 * <p>
 * 编码后的数据是一个字符串，其中包含的字符为：A-Z、a-z、0-9、+、/
 * 共64个字符：26 + 26 + 10 + 1 + 1 = 64。
 * 【注：其实是65个字符，“=”是填充字符】。
 * </p>
 *
 * @ClassName: OnionSecurityBase64Utils
 * @Description: 安全Base64工具类
 * @Company: 广州市两棵树网络科技有限公司
 * @Author: HeroCao hero-cao@msyc.cc
 * @Date: 2017年2月16日 下午8:34:53
 */
public final class OnionSecurityBase64Utils {

    // *(@bP&2)W@8NjF^KKw_(kZX7HO)ko*w1(kxD5pXRoqaeS_9*LggE95Nt2br_v2LyjmXFJ1JO6!OYtf$tkjjMJLUr
    // _#V!lcfKB6o2Im#Mxr(CJZhIZ()fS6Y6e&bj!%*#-4cRY(vCxZvnBgCA4q8g4xAiTpb-f)cfhwSCbg)Uab@PmJFy
    // W*O^Kgi&ElW%XTYY35_ebqZn-@9J#Xq2AbsBH_^dPilv7CeI0&qusp1j4vwk9eCwIn3tM5F@Jez@7AxZEmL2C1*y

    // cySuwyLHtr$_vQC!wY&b^xlAd3eVX8Q69NAgPg4b1NrV6h4Ov&2Q5D&6&(*DtrnEmqL@B7i6hi^9q^Bk*hPDhWum
    // 0sT13GrVIwtu#$zeOJC#@5!wagY#NC0v7yKxLc-JjdTpG*JL1!-v(8SnEkFm1dS9OFmN6Xo)3i^KElJ^3UHjbYF5
    // L35MyABoeG0kyYOM0ngc$wuLw6I6v%GN3^GpZH*bBvbOJCMhe6T_6^d@Sy%qn26eSf)%#MnzunY4Q7wlO^$lht8U
    // bQnEAuzo)LLVq-Xmr04mqU8r3-8A5PB0Lu#8@j8EFZ$pf!wBHAcFnx64fqrLwTDUsZtOtJjhE5FHwMzv$dYPQ*hh

    /**
     * 干扰1
     */
    private static final String INTERFERENCE_BASE64_1 = "cySuwyLHtr$_vQC!wY&b^xlAd3eVX8Q69NAgPg4b1NrV6h4Ov&2Q5D&6&(*DtrnEmqL@B7i6hi^9q^Bk*hPDhWumJE1so5hN2uGmjfY6LEvnczEgIbX8j7qGJ6S7djm0Smkkp8QmjiIEeDaYGgnM1wt0uxoLBu1fLblSiHDt8htm6QHn";

    /**
     * 干扰2
     */
    private static final String INTERFERENCE_BASE64_2 = "0sT13GrVIwtu#$zeOJC#@5!wagY#NC0v7yKxLc-JjdTpG*JL1!-v(8SnEkFm1dS9OFmN6Xo)3i^KElJ^3UHjbYF5NXnD0BJC3k4vU2rgVosQ4NxR5jAJkYeeI4btMUhL01toDCyAvlEQ1Q0eCOZB08d19sFnMQRtu38dVeCQTQsc3C6u";

    /**
     * 干扰3
     */
    private static final String INTERFERENCE_BASE64_3 = "uP41MYLzQ5f4pabhXtCGO8gpkiTcc1wul1ZBuV8Vo7rfxJ9vw3tyaj9E7a0aF4CAHcqntxYruGoF5Fs3bQ4HCIjTL35MyABoeG0kyYOM0ngc$wuLw6I6v%GN3^GpZH*bBvbOJCMhe6T_6^d@Sy%qn26eSf)%#MnzunY4Q7wlO^$lht8U";

    /**
     * 干扰4
     */
    private static final String INTERFERENCE_BASE64_4 = "Gi9J9i6EtpIttFdmRz8Ueye2DTDmZsrD5i1ohRq6k3hGccRvHfBFx81yAR9snKUirYRar8DyPUH0n2RY52KeQxCMbQnEAuzo)LLVq-Xmr04mqU8r3-8A5PB0Lu#8@j8EFZ$pf!wBHAcFnx64fqrLwTDUsZtOtJjhE5FHwMzv$dYPQ*hh";


//    /**
//     * 密钥 , #(@_#!@#*_@^!)@_!&         )&-&#-$#)_)*$-&^*_
//     */
//    private static final String KEY = ")@_)%(%&_*$(%@!!(&";

    /**
     * 干扰第一阶段长度
     */
    private static final int INTERFERENCE_BASE64_1_LENGTH = 8;

    /**
     * 干扰第二阶段长度
     */
    private static final int INTERFERENCE_BASE64_2_LENGTH = 88;


    private OnionSecurityBase64Utils() {
    }

    /**
     * LEGAL_CHARS
     */
    private static final char[] LEGAL_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    ////////////////////////////////////////   加强 Base64 ############### Begin  ////////////////////////////////////////////


    /**
     * 通过干扰加强复杂度的加密，BASE64
     *
     * @param plainText 普通文本
     * @return 返回加密数据
     * @throws OnionException 异常
     * @Title: encodeForStrengthen
     * @Description: 通过干扰加强复杂度的加密
     * @Author: HeroCao hero-cao@msyc.cc
     * @Date: 2017年11月29日 下午4:29:33
     */
    public static String encodeForStrengthen(String plainText) throws OnionException {
        try {
            // Base64 加密
            String encode = OnionSecurityBase64Utils.encode(plainText);

            // 插入干扰数据: 1
            if (StringUtils.isNotBlank(encode) && encode.length() > INTERFERENCE_BASE64_1_LENGTH) {
                String subStr1 = encode.substring(0, INTERFERENCE_BASE64_1_LENGTH);
                String subStr2 = encode.substring(INTERFERENCE_BASE64_1_LENGTH, encode.length());
                StringBuffer sb = new StringBuffer();
                sb.append(subStr1);
                sb.append(INTERFERENCE_BASE64_1);
                sb.append(subStr2);
                sb.append(INTERFERENCE_BASE64_2);
                encode = OnionSecurityBase64Utils.encode(sb.toString());
            }

            // 插入干扰数据: 2
            if (StringUtils.isNotBlank(encode) && encode.length() > INTERFERENCE_BASE64_2_LENGTH) {
                String subStr1 = encode.substring(0, INTERFERENCE_BASE64_2_LENGTH);
                String subStr2 = encode.substring(INTERFERENCE_BASE64_2_LENGTH, encode.length());
                StringBuffer sb = new StringBuffer();
                sb.append(subStr1);
                sb.append(INTERFERENCE_BASE64_3);
                sb.append(subStr2);
                sb.append(INTERFERENCE_BASE64_4);
                encode = OnionSecurityBase64Utils.encode(sb.toString());
            }
            return encode;
        } catch (Exception e) {
            throw new OnionException(e);
        }
    }

    /**
     * 通过干扰加强复杂度的解密,BASE64
     *
     * @param encryptText 加密文本
     * @return 返回解密之后数据
     * @throws OnionException 异常
     * @Title: decodeForStrengthen
     * @Description: 通过干扰加强复杂度的解密
     * @Author: HeroCao hero-cao@msyc.cc
     * @Date: 2017年11月29日 下午4:32:35
     */
    public static String decodeForStrengthen(String encryptText) throws OnionException {
        try {
            // BASE64 解密
            String decode = OnionSecurityBase64Utils.decode(encryptText);

            // 插入干扰数据: 2
            if (StringUtils.isNotBlank(decode) && decode.length() > INTERFERENCE_BASE64_2_LENGTH) {
                String subStr1 = decode.substring(0, INTERFERENCE_BASE64_2_LENGTH);
                String subStr2 = decode.substring(INTERFERENCE_BASE64_2_LENGTH + INTERFERENCE_BASE64_3.length(),
                        decode.length() - INTERFERENCE_BASE64_4.length());
                StringBuffer sb = new StringBuffer();
                sb.append(subStr1);
                sb.append(subStr2);
                decode = OnionSecurityBase64Utils.decode(sb.toString());
            }

            // 插入干扰数据: 1
            if (StringUtils.isNotBlank(decode) && decode.length() > INTERFERENCE_BASE64_1_LENGTH) {
                String subStr1 = decode.substring(0, INTERFERENCE_BASE64_1_LENGTH);
                String subStr2 = decode.substring(INTERFERENCE_BASE64_1_LENGTH + INTERFERENCE_BASE64_1.length(),
                        decode.length() - INTERFERENCE_BASE64_2.length());
                StringBuffer sb = new StringBuffer();
                sb.append(subStr1);
                sb.append(subStr2);
                decode = OnionSecurityBase64Utils.decode(sb.toString());
            }

            return decode;
        } catch (Exception ex) {
            throw new OnionException(ex);
        }
    }

    ////////////////////////////////////////   加强 Base64 ############### End  ////////////////////////////////////////////

    /**
     * Base64 加密
     *
     * @param data 需要Base64加密的数据
     * @return 返回Base64加密字符串
     * @throws OnionException 异常
     * @Title: encode
     * @Description: 加密
     * @author HeroCao hero-cao@msyc.cc
     * @Date: 2017年2月16日 下午1:22:33
     */
    public static String encode(String data) throws OnionException {
        if (StringUtils.isBlank(data)) {
            return data;
        }
        return encode(data.trim().getBytes());
    }

    /**
     * Base64 加密
     *
     * @param data 数据
     * @return 返回Base64加密字符串
     * @throws OnionException 异常
     * @Title: encode
     * @Description: 加密
     * @author HeroCao hero-cao@msyc.cc
     * @Date: 2017年2月16日 下午1:22:33
     */
    public static String encode(byte[] data) throws OnionException {
        try {
            int start = 0;
            int len = data.length;
            StringBuffer buf = new StringBuffer(data.length * 3 / 2);

            int end = len - 3;
            int i = start;
            int n = 0;

            while (i <= end) {
                int d = ((((int) data[i]) & 0x0ff) << 16) | ((((int) data[i + 1]) & 0x0ff) << 8) | (((int) data[i + 2]) & 0x0ff);

                buf.append(LEGAL_CHARS[(d >> 18) & 63]);
                buf.append(LEGAL_CHARS[(d >> 12) & 63]);
                buf.append(LEGAL_CHARS[(d >> 6) & 63]);
                buf.append(LEGAL_CHARS[d & 63]);

                i += 3;

                if (n++ >= 14) {
                    n = 0;
                    buf.append(" ");
                }
            }

            if (i == start + len - 2) {
                int d = ((((int) data[i]) & 0x0ff) << 16) | ((((int) data[i + 1]) & 255) << 8);

                buf.append(LEGAL_CHARS[(d >> 18) & 63]);
                buf.append(LEGAL_CHARS[(d >> 12) & 63]);
                buf.append(LEGAL_CHARS[(d >> 6) & 63]);
                buf.append("=");
            } else if (i == start + len - 1) {
                int d = (((int) data[i]) & 0x0ff) << 16;

                buf.append(LEGAL_CHARS[(d >> 18) & 63]);
                buf.append(LEGAL_CHARS[(d >> 12) & 63]);
                buf.append("==");
            }

            return buf.toString();
        } catch (Exception ex) {
            throw new OnionException(ex);
        }
    }

    /**
     * @param c
     * @return
     * @Title: decode
     * @Description: 解密
     * @author HeroCao hero-cao@msyc.cc
     * @Date: 2017年2月16日 下午1:22:48
     */
    private static int decode(char c) {
        if (c >= 'A' && c <= 'Z')
            return ((int) c) - 65;
        else if (c >= 'a' && c <= 'z')
            return ((int) c) - 97 + 26;
        else if (c >= '0' && c <= '9')
            return ((int) c) - 48 + 26 + 26;
        else
            switch (c) {
                case '+':
                    return 62;
                case '/':
                    return 63;
                case '=':
                    return 0;
                default:
                    throw new RuntimeException("unexpected code: " + c);
            }
    }

    /**
     * Base64解密
     *
     * @param data 已经使用Base64加密的字符串
     * @return 返回Base64解密之后字符串
     * @throws OnionException 异常
     * @Description: 解密
     * @author HeroCao hero-cao@msyc.cc
     * @Date: 2017年2月16日 下午1:23:14
     */
    public static String decode(String data) throws OnionException {
        byte[] bytes = decodeForBytes(data);
        if (null == bytes || bytes.length <= 0) {
            return null;
        }
        // 原先的，存在乱码问题
//        return new String(bytes);
        try {
            // 统一指定编码为：UTF-8
//            return new String(bytes, OnionConstants.CHARSET_UTF_8);
            return new String(bytes);
        } catch (Exception ex) {
            throw new OnionException(ex);
        }
    }

    /**
     * Base64解密
     *
     * @param data 已经使用Base64加密的字符串
     * @return 返回Base64解密之后字符串
     * @throws OnionException 异常
     * @Description: 解密
     * @author HeroCao hero-cao@msyc.cc
     * @Date: 2017年2月16日 下午1:23:14
     */
    public static byte[] decodeForBytes(String data) throws OnionException {
        if (StringUtils.isBlank(data)) {
            return null;
        }
        data = data.trim();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            decode(data, bos);
        } catch (IOException e) {
            throw new OnionException(e);
        }
        byte[] decodedBytes = bos.toByteArray();
        try {
            bos.close();
            bos = null;
        } catch (IOException ex) {
            throw new OnionException(ex);
        }
        return decodedBytes;
    }

    /**
     * 解密
     *
     * @param s  字符串
     * @param os 输出流
     * @throws IOException 异常
     */
    private static void decode(String s, OutputStream os) throws IOException {
        int i = 0;

        int len = s.length();

        while (true) {
            while (i < len && s.charAt(i) <= ' ')
                i++;

            if (i == len)
                break;

            int tri = (decode(s.charAt(i)) << 18) + (decode(s.charAt(i + 1)) << 12) + (decode(s.charAt(i + 2)) << 6) + (decode(s.charAt(i + 3)));

            os.write((tri >> 16) & 255);
            if (s.charAt(i + 2) == '=')
                break;
            os.write((tri >> 8) & 255);
            if (s.charAt(i + 3) == '=')
                break;
            os.write(tri & 255);

            i += 4;
        }
    }

}
