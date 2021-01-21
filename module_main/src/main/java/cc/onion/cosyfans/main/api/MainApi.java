package cc.onion.cosyfans.main.api;

import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.main.entity.AppVersionInfo;
import cc.onion.cosyfans.main.entity.ItemAmonutEntity;
import cc.onion.cosyfans.main.entity.request.AppVersionRequest;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.main.api
 * @ClassName: MainApi
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020-01-11 10:13
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-11 10:13
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface MainApi {

    /**
     * 获取购物车数量
     * @param requestBean
     * @return
     */
    @POST("/cart/showItemAmount")
    Observable<ItemAmonutEntity> getCatAmount(@Body BaseRequestBean requestBean);


    /**
     * 获取App版本
     * @param requestBean
     * @return
     */
    @POST("/content/version/getLatestVersion")
    Observable<AppVersionInfo> getAppVersion(@Body AppVersionRequest requestBean);

}
