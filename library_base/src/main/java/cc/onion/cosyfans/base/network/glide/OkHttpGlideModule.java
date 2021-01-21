package cc.onion.cosyfans.base.network.glide;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;

import java.io.InputStream;

import cc.onion.cosyfans.base.network.RetrofitManager;

/**
 * @Author guobihai
 * @Created 5/13/19
 * @Editor zrh
 * @Edited 5/13/19
 * @Type
 * @Layout
 * @Api
 */
@GlideModule
public class OkHttpGlideModule extends AppGlideModule {

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        OkHttpUrlLoader.Factory factory = new OkHttpUrlLoader.Factory(RetrofitManager.getOkhttpClient());
        registry.replace(GlideUrl.class, InputStream.class, factory);
    }
}
