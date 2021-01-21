package cc.onion.cosyfans.home;

import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;

import org.apache.commons.lang3.StringUtils;

import cc.onion.cosyfans.base.event.AppEvent;
import cc.onion.cosyfans.base.event.Event;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.EventBusUtil;
import cc.onion.cosyfans.base.utils.KLogUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.home.entity.response.AdvertEntity;
import cc.onion.cosyfans.home.entity.response.BannerEntity;
import cc.onion.cosyfans.home.entity.response.DetailAlbumVosEntity;
import cc.onion.cosyfans.home.entity.response.DetailIconVos;
import cc.onion.cosyfans.home.entity.response.DetailItemEntity;
import cc.onion.cosyfans.home.entity.response.HomeAllModel;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.home
 * @ClassName: HomeUtils
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020-01-16 18:06
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-16 18:06
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public  class HomeUtils {


    public static  void toJumpAllAdvert(Context mContext, AdvertEntity.DataBean advertDataBean){
        toJumpAllAdvert(mContext,advertDataBean,null,null,null,null,null);
    }

    public static  void toJumpAllAdvert(Context mContext, AdvertEntity.DataBean advertDataBean,DetailIconVos detailIconVos){
        toJumpAllAdvert(mContext,advertDataBean,detailIconVos,null,null,null,null);
    }

    public static  void toJumpAllAdvert(Context mContext,AdvertEntity.DataBean advertDataBean,DetailItemEntity detailItemEntity){
        toJumpAllAdvert(mContext,advertDataBean,null,detailItemEntity,null,null,null);
    }

    public static  void toJumpAllAdvert(Context mContext,DetailItemEntity detailItemEntity){
        toJumpAllAdvert(mContext,null,null,detailItemEntity,null,null,null);
    }

    public static  void toJumpAllAdvert(Context mContext,AdvertEntity.DataBean advertDataBean, DetailAlbumVosEntity detailAlbumVosEntity){
        toJumpAllAdvert(mContext,advertDataBean,null,null,detailAlbumVosEntity,null,null);
    }

    /**
     * 轮播图数据操作
     * @param mContext
     * @param bannerEntity
     */
    public  static  void toJumpAllAdvert(Context mContext,BannerEntity bannerEntity){
        toJumpAllAdvert(mContext,null,null,null,null,null,bannerEntity);
    }

    /**
     *
     * @param mContext
     * @param floatModel 浮动模块
     */
    public static  void toJumpAllAdvert(Context mContext, HomeAllModel.FloatModuleListBean.DetailListBean floatModel){
        toJumpAllAdvert(mContext,null,null,null,null,floatModel,null);
    }

    /**
     *
     * @param mContext
     * @param detailAlbumVosEntity 活动详情
     * @param floatModel 浮动模块
     */
    public static  void toJumpAllAdvert(Context mContext, DetailAlbumVosEntity detailAlbumVosEntity,HomeAllModel.FloatModuleListBean.DetailListBean floatModel){
        toJumpAllAdvert(mContext,null,null,null,detailAlbumVosEntity,floatModel,null);
    }




    /**
     * 链接类型  0 其他 1 列表 2商品详情 3 专辑 4: 分类  5 搜索结果 6 具体分类 7 h5
     * @param mContext
     * @param detailIconVos
     * @param detailItemEntity
     * @param detailAlbumVosEntity
     */
    public static  void toJumpAllAdvert(Context mContext, AdvertEntity.DataBean advertDataBean,
                                        DetailIconVos detailIconVos, DetailItemEntity detailItemEntity,
                                        DetailAlbumVosEntity detailAlbumVosEntity, HomeAllModel.FloatModuleListBean.DetailListBean floatModel,BannerEntity bannerEntity){
        try {

            /***
             *这个ID有可能是商品ID，有可能是专辑ID
             */
        String Id = null;
        String url = null;
        String androidUrl = null;
        int type = 0 ;

        if(floatModel != null ){
            if(type == 0){
                type = floatModel.getUrlType();
            }

            if(StringUtils.isNotEmpty(TypeUtils.toString(floatModel.getAndroidUrl()))){
                Id = floatModel.getAndroidUrl();
            }
            if(StringUtils.isNotEmpty(floatModel.getUrl())){
                url = floatModel.getUrl();
            }
        }

        if(advertDataBean != null){

            if(type == 0){
                type = advertDataBean.getUrlType();
            }

            if(StringUtils.isNotEmpty(TypeUtils.toString(advertDataBean.getAndroidUrl()))){
                Id = advertDataBean.getAndroidUrl();
            }

            if(StringUtils.isNotEmpty(TypeUtils.toString(advertDataBean.getUrl()))){
                url = advertDataBean.getUrl();
            }

        }


        if(detailIconVos != null){

            if(type == 0){
                type = detailIconVos.getUrlType();
            }

            if(StringUtils.isNotEmpty(TypeUtils.toString(detailIconVos.getId()))){
                Id =   TypeUtils.toString(detailIconVos.getId());
            }
            if(StringUtils.isNotEmpty(detailIconVos.getUrl())){
                url = detailIconVos.getUrl();
            }
        }
        if(detailItemEntity != null){

            if(type == 0){
                type = detailItemEntity.getUrlType();
            }

            if(StringUtils.isNotEmpty(TypeUtils.toString(detailItemEntity.getId()))){
                Id =   TypeUtils.toString(detailItemEntity.getItemId());
            }

            if(StringUtils.isNotEmpty(detailItemEntity.getUrl())){
                url = detailItemEntity.getUrl();
            }
        }

        if(detailAlbumVosEntity != null){


            if(type == 0){
                type = detailAlbumVosEntity.getUrlType();
            }

            if(StringUtils.isNotEmpty(detailAlbumVosEntity.getId())){
                Id =   TypeUtils.toString(detailAlbumVosEntity.getId());
            }

            if(StringUtils.isNotEmpty(detailAlbumVosEntity.getUrl())){
                url = detailAlbumVosEntity.getUrl();
            }

        }


            /**
             * 轮播图
             */
        if(bannerEntity != null){
            if(type == 0){
                type = bannerEntity.getUrlType();
            }

            if(StringUtils.isNotEmpty(bannerEntity.getAndroidUrl())){
                Id =   TypeUtils.toString(bannerEntity.getAndroidUrl());
            }

            if(StringUtils.isNotEmpty(bannerEntity.getUrl())){
                url = bannerEntity.getUrl();
            }
        }



        KLogUtils.logTest("跳转类型:"+type);
            KLogUtils.logTest("跳转URL---:"+url);
        switch (type){
            case 0:
                if(StringUtils.isNotEmpty(Id)){
                    toItemDetail(Id);
                }
                break;
            case 1:
                if(StringUtils.isNotEmpty(url)){
                    toWebURL(url);
                }
                break;
            case 2:
                //跳转到商品详情
                if(StringUtils.isNotEmpty(Id)){
                    toItemDetail(Id);
                }
                break;
            case 3:
               //前往专辑
                if(StringUtils.isNotEmpty(Id)){
                    toGroupItem(Id);
                }
                break;
            case 4:
                //跳转到分类
                EventBusUtil.sendStickyEvent(new Event(AppEvent.EventCode.switchFragment2));
                break;
            case 5:
//                5 搜索结果
                if(StringUtils.isNotEmpty(url)){
                    toWebURL(url);
                }
                break;
            case 6:
                if(StringUtils.isNotEmpty(url)){
                    toWebURL(url);
                }
                break;
            case 7:
                //跳转网页
//                         .withString("title", mContext.getString(R.string.my_transportation_policy))

                if(StringUtils.isNotEmpty(url)){
                    toWebURL(url);
                }
                break;

        }
        }catch (Exception e){
            KLogUtils.logTest("异常开始～～～～～～～～～");
            e.printStackTrace();
        }


    }



    /**
     * 跳转商品详情
     * @param itemId
     */
    public static void toItemDetail(String itemId){
                    ARouter.getInstance()
                    .build(RouterPath.Item.ROUTE_ITEM_PRODUCTS_PATH)
                    .withString("itemId", itemId)
                    .navigation();
    }


    /**
     *跳往分组
     * @param albumId
     */
    public static  void toGroupItem(String albumId){
        ARouter.getInstance()
                .build(RouterPath.Home.ROUTE_HOME_GROUP)
                .withString("itemId", albumId)
                .navigation();
    }


    public static  void toWebURL(String url){
        ARouter.getInstance().build(RouterPath.Features.ROUTE_WEB)
                .withString("url", url)
                .greenChannel()
                .navigation();
    }
}
