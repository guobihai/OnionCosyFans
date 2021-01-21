package cc.onion.cosyfans.base;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import cc.onion.cosyfans.base.config.AppBaseConfig;
import cc.onion.cosyfans.library_base.R;

/**
 * DataBinding中一些通用的绑定方法都写到这里实现
 *
 * @author guobihai
 * @created 2019/4/23
 */
public class BaseBindingAdapter {

    /**
     * // 大图样式
     * large = "centerlogo375x304"
     * // 小图样式
     * small = "centerlogo86x60"
     * // 列表样式
     * listSmall = "centerlogo105x85"
     * // 头像样式
     * avatar = "centerlogo48x48"
     * // 原图带水印
     * ORIGINAL centerlogo
     *
     */

    public enum OssImageStyle {

        LARGE("centerlogo750x608"),
        SMALL("centerlogo172x120"),
        LIST_SMALL("centerlogo375x304"),
        AVATAR("centerlogo96x96"),
        ORIGINAL("centerlogo"), // 有水印原图
        BLANK("blank"); // 无水印
        String style;

        OssImageStyle(String style) {
            this.style = style;
        }}


    /**
     * 根据API返回的图片链接拼接对应的样式
     *
     * @param apiUrl API返回的图片地址
     * @param imageStyle 需要拼接的样式，可选类型参考上面的OssImageStyle枚举
     * @return 返回能显示的图片地址
     */
    public static String getImageUrl(String apiUrl, String imageStyle) {
        String ossUrl = "";
        if (TextUtils.isEmpty(apiUrl)){
            return ossUrl;
        }
        if (apiUrl.contains("?x-oss-process")) {
            // 如果含有拼接参数的话，就直接用API返回的
            ossUrl = apiUrl;
        } else {
            // 没有包含样式，APP自己拼接
            if (apiUrl.contains(AppBaseConfig.get().getConfig().getBaseUrl())
                    || apiUrl.contains("static-beta.yjyz.com")
                    || apiUrl.contains("static-stag.yjyz.com")
                    || apiUrl.contains("static.yjyz.com")) {
                // 是我们自己的域名才拼接，外链直接显示
                ossUrl = apiUrl + "?x-oss-process=style/" + imageStyle;
            } else {
                ossUrl = apiUrl;
            }
        }
        return ossUrl;
    }

    /**
     * 加载图片(带水印原图)
     *
     * @param imageView 要显示图片的ImageView
     * @param url       图片URL
     */
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.home_item_detail)
                .error(R.mipmap.home_item_detail)
                .centerCrop(); // 不加这句会导致未使用圆形的图片也会变圆
        if (TextUtils.isEmpty(url)) {
            // 没有图片
            Glide.with(imageView.getContext())
                    .applyDefaultRequestOptions(options)
                    .load(R.mipmap.home_item_detail)
                    .into(imageView);
        } else {
            Glide.with(imageView.getContext())
                    .applyDefaultRequestOptions(options)
                    .load(getImageUrl(url, OssImageStyle.ORIGINAL.style))
                    .into(imageView);
        }

    }

    /**
     * 加载视频封面
     */
    @BindingAdapter(("videoUrl"))
    public static void loadVideoCover(ImageView imageView, String url){
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.icon_placeholder_youju)
                .error(R.mipmap.icon_placeholder_youju)
                .centerCrop(); // 不加这句会导致未使用圆形的图片也会变圆
        Glide.with(imageView.getContext())
                .applyDefaultRequestOptions(options)
                .load(url)
                .into(imageView);
    }


    /**
     * 加载带有OSS样式的大图
     *
     * @param imageView
     * @param url
     */
    @BindingAdapter({"imageUrlLarge"})
    public static void loadImageLarge(ImageView imageView, String url) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.home_advert_one)
                .error(R.mipmap.home_advert_one)
                .centerCrop(); // 不加这句会导致未使用圆形的图片也会变圆
        if (TextUtils.isEmpty(url)) {
            // 没有图片
            Glide.with(imageView.getContext())
                    .applyDefaultRequestOptions(options)
                    .load(R.mipmap.home_advert_one)
                    .into(imageView);
        } else {
            Glide.with(imageView.getContext())
                    .applyDefaultRequestOptions(options)
                    .load(getImageUrl(url, OssImageStyle.LARGE.style))
                    .into(imageView);
        }
    }

    /**
     * fitCneter
     * @param imageView
     * @param url
     */
    @BindingAdapter({"imageUrlLarge"})
    public static void loadImageFitCenterType(ImageView imageView, String url) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.home_item_detail)
                .error(R.mipmap.home_item_detail)
                .fitCenter(); // 不加这句会导致未使用圆形的图片也会变圆
        if (TextUtils.isEmpty(url)) {
            // 没有图片
            Glide.with(imageView.getContext())
                    .applyDefaultRequestOptions(options)
                    .load(R.mipmap.home_item_detail)
                    .into(imageView);
        } else {
            Glide.with(imageView.getContext())
                    .applyDefaultRequestOptions(options)
                    .load(getImageUrl(url, OssImageStyle.LARGE.style))
                    .into(imageView);
        }
    }





    /**
     * 加载大图，要设置背景资源，主页大图背景专用
     * @param imageView
     * @param url
     * @param placeholderImage
     */
    public static void loadImageLarge(ImageView imageView, String url,int placeholderImage) {
        RequestOptions options = new RequestOptions()
                .placeholder(placeholderImage)
                .error(placeholderImage)
                .centerCrop(); // 不加这句会导致未使用圆形的图片也会变圆
        if (TextUtils.isEmpty(url)) {
            // 没有图片
            Glide.with(imageView.getContext())
                    .applyDefaultRequestOptions(options)
                    .load(placeholderImage)
                    .into(imageView);
        } else {
            Glide.with(imageView.getContext())
                    .applyDefaultRequestOptions(options)
                    .load(getImageUrl(url, OssImageStyle.LARGE.style))
                    .into(imageView);
        }
    }




    /**
     * 加载带有OSS样式的小图
     *
     * @param imageView
     * @param url
     */
    @BindingAdapter({"imageUrlSmall"})
    public static void loadImageSmall(ImageView imageView, String url) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.icon_placeholder_youju)
                .error(R.mipmap.icon_placeholder_youju)
                .centerCrop(); // 不加这句会导致未使用圆形的图片也会变圆
        if (TextUtils.isEmpty(url)) {
            // 没有图片
            Glide.with(imageView.getContext())
                    .applyDefaultRequestOptions(options)
                    .load(R.mipmap.icon_placeholder_empty)
                    .into(imageView);
        } else {

            Glide.with(imageView.getContext())
                    .applyDefaultRequestOptions(options)
                    .load(getImageUrl(url, OssImageStyle.SMALL.style))
                    .into(imageView);
        }
    }

    /**
     * 加载带有OSS样式的列表图片
     */
    @BindingAdapter({"imageUrlList"})
    public static void loadImageList(ImageView imageView, String url) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.icon_placeholder_youju)
                .error(R.mipmap.icon_placeholder_youju)
                .centerCrop(); // 不加这句会导致未使用圆形的图片也会变圆
        if (TextUtils.isEmpty(url)) {
            // 没有图片
            Glide.with(imageView.getContext())
                    .applyDefaultRequestOptions(options)
                    .load(R.mipmap.icon_placeholder_empty)
                    .into(imageView);
        } else {
            Glide.with(imageView.getContext())
                    .applyDefaultRequestOptions(options)
                    .load(getImageUrl(url, OssImageStyle.LIST_SMALL.style))
                    .into(imageView);
        }
    }

    /**
     * 加载带有OSS样式的圆形头像
     */
    @BindingAdapter({"userAvatarUrlOss"})
    public static void loadAvatarIconOss(ImageView imageView, String url) {
        RequestOptions requestOptions = RequestOptions.circleCropTransform()
                .placeholder(R.mipmap.icon_portrait)
                .error(R.mipmap.icon_portrait);

        Glide.with(imageView.getContext())
                .applyDefaultRequestOptions(requestOptions)
                .load(getImageUrl(url, OssImageStyle.BLANK.style))
                .into(imageView);

    }

    /**
     * 加载圆形头像(注意：ImageView不能设置centerInside)
     *
     * @param imageView
     * @param url
     */
    @BindingAdapter({"userAvatarUrl"})
    public static void loadAvatarIcon(ImageView imageView, String url) {
        RequestOptions requestOptions = RequestOptions.circleCropTransform()
                .placeholder(R.mipmap.icon_portrait)
                .error(R.mipmap.icon_portrait);

        Glide.with(imageView.getContext())
                .applyDefaultRequestOptions(requestOptions)
                .load(getImageUrl(url, OssImageStyle.BLANK.style))
                .into(imageView);

    }

    /**
     * 加载圆形图片
     *
     * @param imageView
     * @param url
     */
    @BindingAdapter({"roundImage"})
    public static void loadCircleIcon(ImageView imageView, String url) {
        RequestOptions requestOptions = RequestOptions.circleCropTransform()
                .placeholder(R.mipmap.icon_round_logo)
                .error(R.mipmap.icon_round_logo);

        Glide.with(imageView.getContext())
                .applyDefaultRequestOptions(requestOptions)
                .load(getImageUrl(url, OssImageStyle.BLANK.style))
                .into(imageView);

    }


    /**
     *设置布局文件背景显示
     * @param viewGroup
     * @param url
     */
    @BindingAdapter({"layoutBg"})
    public static void setLayoutBgShow(Context mContext,ViewGroup viewGroup, String url){

        RequestOptions requestOptions = RequestOptions.circleCropTransform()
                .placeholder(R.mipmap.icon_portrait)
                .error(R.mipmap.icon_portrait);


        Glide.with(viewGroup.getContext())
                .applyDefaultRequestOptions(requestOptions)
                .asBitmap()
                .load(url)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        Drawable drawable = new BitmapDrawable(resource);
                        viewGroup.setBackground(drawable);
                    }
                });

    }


    /**
     * 设置view的选中状态
     *
     * @param view
     * @param selected
     */
    @BindingAdapter({"selected"})
    public static void setSelected(View view, boolean selected) {
        view.setSelected(selected);
    }

    /**
     * 设置经纪人性别图标
     *
     * @param imageView
     * @param sex       传字符串或者数字 男 女(或者 1男 2女)
     */
    @BindingAdapter("sexIcon")
    public static void setSexIcon(ImageView imageView, String sex) {
        if (!TextUtils.isEmpty(sex)) {
            if ("男".equals(sex) || "1".equals(sex)) {
                imageView.setBackgroundResource(R.mipmap.icon_sex_boy);
            } else if ("女".equals(sex) || "2".equals(sex)) {
                imageView.setBackgroundResource(R.mipmap.icon_sex_girl);
            }
        }
    }


    /**
     * 设置本地资源
     */
    @BindingAdapter({"background"})
    public static void setBackgroud(ImageView imageView, int icon) {
        imageView.setImageResource(icon);
    }

    @BindingAdapter({"text_color"})
    public static void setTextColor(TextView textView, String color) {
        textView.setTextColor(Color.parseColor(color));
    }

    @BindingAdapter({"itemDecoration"})
    public static void setItemDecoration(RecyclerView recyclerView, RecyclerView.ItemDecoration decoration) {
        recyclerView.addItemDecoration(decoration);
    }

}
