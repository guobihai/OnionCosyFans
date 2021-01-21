package cc.onion.cosyfans.base.event;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.base.event
 * @ClassName: AppEvent
 * @Description: App全局使用消息传递Code
 * @Author: guobihai
 * @CreateDate: 2020-01-10 14:10
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-10 14:10
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AppEvent {

    // EventBus Code
    public static final class EventCode {
        public static final int loginSuccess = 0x111111;
        public static final int refresh = 0x222222;
        /**
         * 主页购物车数量刷新
         */
        public static final int carCount = 0x333333;
        //购物车界面数据刷新
        public static final int carRefresh = 0x444444;
        //App 升级操作
        public static final int AppUpdate = 0x555555;

        //fragment切换
        public static final int switchFragment1 = 0x666666;
        public static final int switchFragment2 = 0x777777;
        public static final int switchFragment3 = 0x888888;
        public static final int switchFragment4 = 0x999999;
        public static final int switchFragment5 = 0x1000000;




    }

}
