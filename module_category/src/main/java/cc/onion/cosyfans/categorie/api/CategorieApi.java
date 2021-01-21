package cc.onion.cosyfans.categorie.api;

import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.categorie.entity.responer.CategorieEntity;
import cc.onion.cosyfans.categorie.entity.CaterorieChildenRequest;
import cc.onion.cosyfans.categorie.entity.responer.CategorieListEntity;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author  guobihai
 * @date:2019-11-18
 */
public interface CategorieApi {


    /**
     * 获取是否有版本号
     */
    @POST("/item/category/multiLevelCategory")
    Observable<CategorieEntity> getItemDetail(@Body BaseRequestBean requestBean);


    /**
     * 获取分类子类目信息
     * @param requestBean
     * @return
     */
    @POST("/search/item")
    Observable<CategorieListEntity> getChildCategory(@Body CaterorieChildenRequest requestBean);


}
