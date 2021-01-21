package cc.onion.cosyfans.base.utils;

/**
 * @author  guobihai
 * @date 2019/3/20
 */


public class BaseConfig {

    public static void set(String key, String value){
        if(value != null){
            PreferencesUtils.set(key, value);
        }
    }


    public static String get(String key){
        return PreferencesUtils.get(key,null);
    }

    public static void set(String key, long value){
        PreferencesUtils.set(key, value);
    }

    public static long get(String key, long value){
        return PreferencesUtils.get(key, value);
    }
}
