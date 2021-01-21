package cc.onion.cosyfans.base.utils;


import org.greenrobot.eventbus.EventBus;

import cc.onion.cosyfans.base.event.Event;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.adapter
 * @ClassName: AddressListAdapter
 * @Description: EventBusUtil
 * @Author: guobihai
 * @CreateDate: 2019-12-11 14:24
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-11 14:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class EventBusUtil {
    public static void register(Object subscriber) {
        KLogUtils.logTest("判断是否注册了eventBus"+EventBus.getDefault().isRegistered(subscriber));
        EventBus.getDefault().register(subscriber);

    }

    public static void unregister(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }

    public static void sendEvent(Event event) {
        EventBus.getDefault().post(event);
    }

    public static void sendStickyEvent(Event event) {
        EventBus.getDefault().postSticky(event);
    }




}
