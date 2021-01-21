package cc.onion.cosyfans.base.utils;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.base.utils
 * @ClassName: KLogUtils
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2019-12-26 11:53
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-26 11:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public  class KLogUtils {

        private static  final String TAG = "test";


    /**
     * 打印调试日子
     * @param logStr
     */
    public static  void logTest(String logStr){
            KLog.i(TAG,logStr);
        }

}
