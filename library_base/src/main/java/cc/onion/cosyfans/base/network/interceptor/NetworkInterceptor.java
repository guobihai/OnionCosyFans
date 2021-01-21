package cc.onion.cosyfans.base.network.interceptor;


import java.io.IOException;

import cc.onion.cosyfans.base.exception.NoNetworkException;
import cc.onion.cosyfans.base.utils.AppContext;
import cc.onion.cosyfans.base.utils.NetworkMonitor;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @Author guobihai
 * @Created 4/22/19
 * @Editor zrh
 * @Edited 4/22/19
 * @Type
 * @Layout
 * @Api
 */
public class NetworkInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        boolean connected = NetworkMonitor.isContected(AppContext.getAppContext());
        if (connected) {
            return chain.proceed(chain.request());
        } else {
            //TODO  页面刷新多次数据无网络会闪退 2019/7/6
            throw new NoNetworkException();
        }
    }
}
