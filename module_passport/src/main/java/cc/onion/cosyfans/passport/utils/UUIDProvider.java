package cc.onion.cosyfans.passport.utils;

import java.util.UUID;

/**
 * @Author anhuihuixi
 * @Created 5/24/19
 * @Editor zrh
 * @Edited 5/24/19
 * @Type
 * @Layout
 * @Api
 */
public class UUIDProvider {

    public static String DEFAULT = UUID.randomUUID().toString();

    public static String uuid() {
        return UUID.randomUUID().toString();
    }
}
