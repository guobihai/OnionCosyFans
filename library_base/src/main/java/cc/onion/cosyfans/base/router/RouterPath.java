package cc.onion.cosyfans.base.router;

/**
 * 路由路径统一在此类声明
 * (注意：路由路径一定要斜杠 '/' 开头，否则DataBinding会无法生成)
 *
 * @author lsy
 * @created 2019/3/12
 */
public class RouterPath {

    public static final String BASE_URL = "router://erp.yjyz.com";

    public static class Features {
        // 图片预览
        public static final String ROUTE_PREVIEW_IMAGES = "/image/preview";
        // 扫一扫
        public static final String ROUTE_QRCODE_SCAN = "/qrcode/scan";
        // web网页
        public static final String ROUTE_WEB = "/web/index";
    }

    /**
     * 主业务组件
     */
    public static class Main {
        private static final String MAIN = "/main";

        // 入口
        public static final String ROUTE_MAIN_PATH = MAIN + "/mainAct";
    }

    /**
     * 首页组件
     */
    public static class Home {
        private static final String HOME = "/home";

        // 首页Fragment
        public static final String ROUTE_HOME_PATH = HOME + "/homeFrgm";
        //分组
        public static final String ROUTE_HOME_GROUP = HOME + "/group";

    }

    /**
     * 分类
     */
    public static class Categorie {
        private static final String CATEGORIE = "/categorie";

        // 分类
        public static final String ROUTE_CATEGORRIE_PATH = CATEGORIE + "/categorieFrgm";
        //分类列表
        public static final String ROUTE_LIST_PRODUCTS = CATEGORIE + "/list/products";

    }

    /**
     * 购物车
     */
    public static class Cart {
        private static final String CART = "/cart";

        // 购物车
        public static final String ROUTE_CART_PATH = CART + "/cartFrgm";

        public static final String ROUTE_CART_PATH_ACTIVITY = CART + "/cartFrgm/activity";


    }

    /**
     * 结算
     */
    public static class Trade {
        private static final String Trade = "/trade";

        // 结算界面
        public static final String ROUTE_TRADE_ORDER= Trade + "/order";

        public static final String ROUTE_TRADE_PLAY_RESULE= Trade + "/play/result";


    }



    /**
     * 素材
     */
    public static class Posts {
        private static final String Posts = "/posts";

        // POSTS
        public static final String ROUTE_POSTS_PATH = Posts + "/postsFrgm";

        //素材个人中心
        public static final String ROUTE_CENTER_PATH = Posts + "/centerinfo";
        //搜索
        public static final String ROUTE_SEARCH_PATH = Posts + "/center/search";
        //发布
        public static final String ROUTE_POST_COMMENT_PATH = Posts + "/post/moment";

    }

    /**
     * 个人中心组件(我的)
     */
    public static class MyCosy {
        private static final String MINE = "/mycosy";

        // 我的
        public static final String ROUTE_MINE_PATH = MINE + "/mycosyFrgm";

        public static final String ROUTE_MIME_AGENT_VERIFY = MINE + "/agentVerify";

        public static final String ROUTE_MIME_SETTING = MINE + "/Setting";


        //地址

        public static final String ROUTE_MIME_ADDRESS_LIST = MINE + "/address/list";
        //添加地址列表
        public static final String ROUTE_MIME_ADDRESS_ADD = MINE + "/address/add";

        //用户帮助中心
        public static final String ROUTE_MIME_USER_HELP = MINE + "/user/helper";

        //商家中心编辑店铺
        public static  final String ROUTE_MIME_EDIT_MERCHANT = MINE+"/edit/merchant";
        //商家中心-销售订单
        public static  final String ROUTE_MIME_MERCHANT_ORDERS = MINE+"/merchant/orders";
        //商家中心-查看物流
        public static  final String ROUTE_MIME_MERCHANT_TRACKING= MINE+"/merchant/tracking";

        //商家中心-用户注册统计
        public static  final String ROUTE_MIME_MERCHANT_REGISTE_COUNT= MINE+"/merchant/register/count";
    }

    /**
     * 订单
     */
    public static class Order {
        private static final String Order = "/order";

        // Order main
        public static final String ROUTE_ORDER_MAIN  = Order + "/order/main";

        //订单
        public static final String ROUTE_ORDER_DETAIL = Order + "/order/detail";
        //fragment
        public static final String ROUTE_ORDER_DETAIL_Fragment = Order + "/order/detail/fragment";

        //售后
        public static final String ROUTE_ORDER_DETAIL_AFTER_SALSE = Order + "/order/detail/afterSale";

        //售后流程
        public static final String ROUTE_ORDER_DETAIL_AFTER_SALSE_PROCESS = Order + "/order/detail/afterSale/process";

        //售后流程步骤
        public static final String ROUTE_ORDER_DETAIL_AFTER_SALSE_DETAIL = Order + "/order/detail/afterSale/detail";

        //售后物流回填界面
        public static final String ROUTE_ORDER_DETAIL_AFTER_SALSE_DETAIL_COMMIT = Order + "/order/detail/afterSale/detail/commit";


    }




    //Item管理，商品
    public static class Item {
        private static final String MINE = "/item";

        // 商品详情
        public static final String ROUTE_ITEM_PRODUCTS_PATH = MINE + "/productsDetail";

        // 商品Detail
        public static final String ROUTE_ITEM_DETAIL = MINE + "/detail";
        // POsts
        public static final String ROUTE_ITEM_POSTS = MINE + "/posts";

    }



    /**
     * 登录注册
     */
    public static class Passport {

        public static final String PASSPORT = "/passport";
        public static final String ROUTE_PASSPORT_SIGNIN_WITH_LOGIN = PASSPORT + "/siginwithLogin";
        public static final String ROUTE_PASSPORT_SIGNIN = PASSPORT + "/signin";
        public static final String ROUTE_PASSPORT_REGISISTER = PASSPORT + "/signin/register";
        public static final String ROUTE_PASSPORT_RESET_PASSWORD = PASSPORT + "/password/reset";
        public static final String ROUTE_PASSPORT_MODIFY = PASSPORT + "/password/modify";
        //login aucc
        public static final String ROUTE_PASSPORT_GOOGLE = PASSPORT + "/login/google";
        public static final String ROUTE_PASSPORT_FACEBOOK= PASSPORT + "/login/facebook";
    }


    /**
     * 搜索界面
     */
    public static  class Search{

        public static final String SEARCH = "/search";
//        主页搜索
        public static final String ROUTE_SEARCH_HOME = "/search/home";

        public static final String ROUTE_SEARCH_HOME_RESULT = "/search/home/result";

    }






}
