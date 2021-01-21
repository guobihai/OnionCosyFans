package cc.onion.cosyfans.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.adapter
 * @ClassName: AddressListAdapter
 * @Description: 底层EVENTBUS
 * @Author: guobihai
 * @CreateDate: 2019-12-11 14:24
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-11 14:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BindEventBus {
}
