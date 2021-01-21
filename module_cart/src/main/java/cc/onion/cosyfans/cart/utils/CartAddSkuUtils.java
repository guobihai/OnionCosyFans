package cc.onion.cosyfans.cart.utils;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.item.api.ItemApi;
import cc.onion.cosyfans.item.entity.ItemDetailRequest;
import cc.onion.cosyfans.item.entity.SkuBaseEntity;
import cc.onion.cosyfans.item.entity.response.ItemDetailEntity;
import io.reactivex.disposables.Disposable;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.cart.utils
 * @ClassName: CartAddSkuUtils
 * @Description: 获取数据接口请求类
 * @Author: guobihai
 * @CreateDate: 2019-12-24 15:33
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-24 15:33
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CartAddSkuUtils {


    /**
     * 初始化基本商品接口数据
     *
     * @param request
     */
    private List<SkuBaseEntity> getItemAttritube(ItemDetailRequest request, Disposable mDisposadble) {
        List<SkuBaseEntity> skuList = new ArrayList<>();
        getItemDetail(request, new ResponseListener<ItemDetailEntity>() {
            @Override
            public void loadSuccess(ItemDetailEntity data) {

                try {


                    //处理SKU数据
                    if (data.getData().getSkuInfoShowDTO() != null && data.getData().getSkuInfoShowDTO().getSkuPriceMap() != null) {

                        //获取SKU的Sting文件数据，进行动态解析
                        LinkedTreeMap<String, SkuBaseEntity> skuPriceMap = (LinkedTreeMap<String, SkuBaseEntity>) data.getData().getSkuInfoShowDTO().getSkuPriceMap();
                        Gson gson = new Gson();
                        String toJson = gson.toJson(skuPriceMap);
                        KLog.i("test", "json数组:" + toJson);

                        List<String> skuKeyList = new ArrayList<>();
                        List<SkuBaseEntity> skuBaseEntityList = new ArrayList<>();
                        if (skuPriceMap != null && skuPriceMap.size() > 0) {

                            Iterator iter = skuPriceMap.entrySet().iterator();
                            while (iter.hasNext()) {
                                //循环添加SKu数据到集合对象，把key Name 也添加进集合当中处理

                                Map.Entry entry = (Map.Entry) iter.next();
                                // 获取key Name
                                skuKeyList.add((String) entry.getKey());
                                //获取Value
                                Object skuObject = skuPriceMap.get((String) entry.getKey());
                                String skuEntity = gson.toJson(skuObject);
                                SkuBaseEntity model = gson.fromJson(skuEntity, SkuBaseEntity.class);
                                model.setSkuKeyName((String) entry.getKey());
                                skuBaseEntityList.add(model);
                                skuList.addAll(skuBaseEntityList);

                            }
                        }

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                KLog.i("test", "获取数据失败:" + errorCode + errorMsg);
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addDisposable(disposable);
            }
        });

        if(skuList != null && skuList.size() >0){
            return skuList;
        }
        return null;

    }

    /**
     * 获取商品详情信息
     * @param request
     * @param listener
     */
    public void getItemDetail(ItemDetailRequest request, ResponseListener<ItemDetailEntity> listener) {
        RetrofitManager
                .create(ItemApi.class)
                .getItemDetail(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<ItemDetailEntity>() {
                    @Override
                    public void onSuccess(ItemDetailEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }
}
