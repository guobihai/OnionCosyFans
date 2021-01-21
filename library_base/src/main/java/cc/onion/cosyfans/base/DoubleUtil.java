package cc.onion.cosyfans.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.base
 * @ClassName: DoubleUtil
 * @Description:
 * double的计算不精确，会有类似0.0000000000000002的误差，正确的方法是使用BigDecimal或者用整型
 *  9  * 整型地方法适合于货币精度已知的情况，比如12.11+1.10转成1211+110计算，最后再/100即可
 * 10  * 以下是摘抄的BigDecimal方法:
 * @Author: guobihai
 * @CreateDate: 2019-12-13 15:58
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-13 15:58
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DoubleUtil implements Serializable {


    private static final long serialVersionUID = -4302265186934812512L;


    /**
          * 提供指定数值的（精确）小数位四舍五入处理。
          *
          * @param value 需要四舍五入的数字
          * @param scale 小数点后保留几位
          * @return 四舍五入后的结果
           */
    public static double round(double value,int scale){
                if(scale<0){
                        throw new IllegalArgumentException("The scale must be a positive integer or zero");
                    }
                 BigDecimal b = new BigDecimal(Double.toString(value));
                 BigDecimal one = new BigDecimal("1");
                 return b.divide(one,scale, RoundingMode.HALF_UP).doubleValue();
           }



    /**
           * 提供精确的乘法运算。
           *
           * @param value1 被乘数
           * @param value2 乘数
           * @return 两个参数的积
           */
     public static Double mul(Double value1, Double value2) {
                 BigDecimal b1 = new BigDecimal(Double.toString(value1));
                 BigDecimal b2 = new BigDecimal(Double.toString(value2));
                 return b1.multiply(b2).doubleValue();
             }

}
