package cc.onion.cosyfans.module_search;

import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.module_search.entity.HotRequest;
import cc.onion.cosyfans.module_search.entity.RecommendEntity;
import cc.onion.cosyfans.module_search.entity.SeachRequest;
import cc.onion.cosyfans.module_search.entity.SearchHotWordEntity;
import cc.onion.cosyfans.module_search.entity.SearchResultEntity;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_search
 * @ClassName: SearchApi
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020-01-06 10:44
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-06 10:44
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface SearchApi {


    /**
     * 获取是否有版本号
     */
    @POST("/search/item")
    Observable<SearchResultEntity> getSearchResultData(@Body SeachRequest requestBean);


    /**
     * 加载热词
     * @param requestBean
     * @return
     */
    @POST("/search/hotWord")
    Observable<SearchHotWordEntity> getSearchHot(@Body HotRequest requestBean);


    /**
     * 获取搜素推荐数据
     * @param requestBean
     * @return
     */
    @POST("/search/recommendItem")
    Observable<RecommendEntity> recommendItem(@Body BaseRequestBean requestBean);


}
