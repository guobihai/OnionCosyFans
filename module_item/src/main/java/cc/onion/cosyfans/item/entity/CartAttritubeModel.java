package cc.onion.cosyfans.item.entity;

import java.util.List;

import cc.onion.cosyfans.item.entity.response.ItemDetailEntity;

/**
 * 购物车拼装数据
 * @author guobihai
 * @date 2019-12- 10
 */
public class CartAttritubeModel {

    private  String itemId;
    private String sellingPriceRange;
    private String marketPriceRange;

    private List<ItemDetailEntity.DataBean.ItemBaseInfoDTOBean.SwiperListBean> swiperList;

}
