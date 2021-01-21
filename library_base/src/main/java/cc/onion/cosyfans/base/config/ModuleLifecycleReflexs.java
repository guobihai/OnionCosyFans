package cc.onion.cosyfans.base.config;

/**
 * 组件生命周期反射类名管理
 * 在这里注册需要初始化的组件
 * 通过反射动态调用各个组件的初始化方法
 * PS: 以下模块中初始化的Module类不能被混淆，必须填入对应完整包名 + 类名
 *
 * @author author guobihai
 * @created 2019/3/13
 */
public class ModuleLifecycleReflexs {
    // 目前原型图的有：首页、

    // 基础模块
    private static final String BaseInit = "cc.onion.cosyfans.base.BaseModuleInit";
    // 主业务模块
    private static final String MainInit = "cc.onion.cosyfans.main.MainModuleInit";
    //首页
    private static final String HomeInit = "cc.onion.cosyfans.home.HomeModuleInit";
    //分类
    private static final String CategorieInit = "cc.onion.cosyfans.categorie.CategorieModuleInit";
    //素材
    private static final String MomentModuleInit = "cc.onion.cosyfans.moment.MomentModuleInit";
    //购物车
    private static final String CartModuleInit = "cc.onion.cosyfans.cart.CartModuleInit";
    //我的
    private static final String MyModuleInit = "cc.onion.cosyfans.my.MyModuleInit";
    //商品Item
    private static final String ItemModuleInit = "cc.onion.cosyfans.item.ItemModuleInit";



    // 放入这里来确定执行顺序
    public static String[] initModuleNames = {
            BaseInit,
            MainInit,
            HomeInit,
            CategorieInit,
            MomentModuleInit,
            CartModuleInit,
            MyModuleInit,
            ItemModuleInit

    };

}
