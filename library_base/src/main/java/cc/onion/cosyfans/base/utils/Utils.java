package cc.onion.cosyfans.base.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;

/**
 * @Author guobihai
 * @Created 2019/3/21
 * @Editor lyy
 * @Edited 2019/3/21
 * @Type
 * @Layout
 * @Api
 */
public class Utils {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static Float getDip2(Context ctx, float dip) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dip, ctx.getResources().getDisplayMetrics());
    }

    public static int dp2Px(Context context, int dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (scale * dp + 0.5);
    }

    /**
     * 跳转权限设置页面(例如某个功能页申请权限失败后，可以弹框用户点击去设置对应的权限)
     *
     * @param context
     */
    public static void toAndroidSetting(Context context) {
        try {
            // 跳转APP自己的设置
            Intent mIntent = new Intent();
            mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (Build.VERSION.SDK_INT >= 21) {
                mIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                mIntent.setData(Uri.fromParts("package", context.getPackageName(), null));
            } else {
                mIntent.setAction(Intent.ACTION_VIEW);
                mIntent.setClassName("com.android.settings", "com.android.setting.InstalledAppDetails");
                mIntent.putExtra("com.android.settings.ApplicationPkgName", context.getPackageName());
            }
            context.startActivity(mIntent);
        } catch (Exception e) {
            // 跳转系统的设置
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            context.startActivity(intent);
            e.printStackTrace();
        }
    }

    /**
     * 跳转到拨号盘
     *
     * @param ctx
     * @param phone
     */
    public static void call(Context ctx, String phone) {
        if (TextUtils.isEmpty(phone)) {
            return;
        }
        try {
            Intent it = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ctx.startActivity(it);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 直接拨号(调用前需要申请权限)
     *
     * @param ctx
     * @param phone
     */
    public static void callPhoneWithDirect(Context ctx, String phone) {
        try {
            Intent it = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
            ctx.startActivity(it);
        } catch (Exception e) {
            e.printStackTrace();
            Utils.call(ctx, phone);
        }
    }

    /**
     * 获取联系人
     *
     * @param act
     * @param data
     * @return
     */
    public static String[] getCustomer(Context act, Intent data) {
        String usernumber = "";
        String username = "";
        ContentResolver cr = act.getContentResolver();
        Uri contactData = data.getData();
        Cursor cursor = cr.query(contactData, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                username = cursor.getString(cursor
                        .getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                String contactId = cursor.getString(cursor
                        .getColumnIndex(ContactsContract.Contacts._ID));
                Cursor phone = cr.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = "
                                + contactId, null, null);
                while (phone.moveToNext()) {
                    usernumber = phone
                            .getString(phone
                                    .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    usernumber = usernumber.replace("-", "");
                    usernumber = usernumber.replace(" ", "");
                    usernumber = usernumber.replace("+", "");
                }
                phone.close();
            }
            cursor.close();
        }
        return new String[]{username, usernumber};
    }


    /**
     * 使用系统自带播放器播放视频
     *
     * @param type 1网络视频 2本地视频
     * @param url  视频地址或文件路径
     */
    public static void startPlayVideo(Context context, int type, String url) {
        // "http://oss-cn-shenzhen.aliyuncs.com/ujuzresources/65163FC0-C309-4437-989E-894254B48962.MOV"
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if (type == 1) {
            // 播放网络视频
            String extension = MimeTypeMap.getFileExtensionFromUrl(url);
            String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            Intent mediaIntent = new Intent(Intent.ACTION_VIEW);
            mediaIntent.setDataAndType(Uri.parse(url), mimeType);
            context.startActivity(mediaIntent);
        } else {
            // 播放本地视频
            File filePath = new File(url);
            Uri uri = null;
            if (SystemUtils.v24_N()) {
                // 7.0+
                uri = FileProvider.getUriForFile(context, "com.ujuz.module", filePath);
            } else {
                uri = Uri.parse("file://" + url);
            }
            Intent intent = new Intent(Intent.ACTION_VIEW);

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(uri, "video/*");
            try {
                context.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                ToastUtil.Short("无法播放该视频：" + e.getMessage());
            }
        }
    }

    /**
     * MD5加密
     */
    public static String MD5(String sourceStr) {
        byte[] source = sourceStr.getBytes();
        String s = null;
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            byte[] tmp = md.digest();
            char[] str = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            s = new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 序列化对象
     *
     * @param file
     * @param obj
     * @return
     */
    public static boolean writeObj(File file, Serializable obj) {
        boolean isWrite = false;
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file));
            stream.writeObject(obj);
            stream.close();
            isWrite = true;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return isWrite;
    }

    /**
     * 反序列化对象
     *
     * @param file
     * @param <T>
     * @return
     */
    public static <T> T readObj(File file) {

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            return null;
        }
        T obj = null;
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file));
            try {
                obj = (T) stream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return obj;
    }

    /**
     * 安装APK
     *
     * @param file 文件路径
     */
    private void installApk(Context context, File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            /* Android N 写法*/
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(context, "com.ujuz.module", file);
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
        } else {
            /* Android N之前的老版本写法*/
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    /**
     * 检测网络
     *
     * @param context
     * @return
     */
    public static boolean checkNetWork(Context context) {
        ConnectivityManager conn = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = conn.getActiveNetworkInfo();
        return (info != null && info.isConnected());

    }

    /**
     * 检查定位服务是否开启
     *
     * @param
     * @return true 表示开启
     */
    public static boolean checkLocationEnabled(Context context) {
        int locationMode = 0;
        String locationProviders;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            try {
                locationMode = Settings.Secure.getInt(context.getContentResolver(),
                        Settings.Secure.LOCATION_MODE);
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            return locationMode != Settings.Secure.LOCATION_MODE_OFF;
        } else {
            locationProviders = Settings.Secure.getString(context.getContentResolver(),
                    Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
            return !TextUtils.isEmpty(locationProviders);
        }
    }

    /**
     * 调用系统发送短信
     *
     * @param context
     * @param phone   目标手机号
     * @param msg     短信内容
     */
    public static void sendSMS(Context context, String phone, String msg) {
        //"smsto:xxx" xxx是可以指定联系人的
        Uri smsToUri = Uri.parse("smsto:" + phone);

        Intent intent = new Intent(Intent.ACTION_SENDTO, smsToUri);

        //"sms_body"必须一样，smsbody是发送短信内容content
        intent.putExtra("sms_body", msg);
        context.startActivity(intent);
    }

    /**
     * 隐藏软键盘
     */
    public static void hideSoftInput(Context context, View et) {
        try {
            ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(et.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 复制文本内容到粘贴板
     */
    public static void copyTextClipboard(Context context, String text) {
        //获取剪贴板管理器：
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        // 创建普通字符型ClipData
        ClipData mClipData = ClipData.newPlainText("Label", text);
        // 将ClipData内容放到系统剪贴板里。
        cm.setPrimaryClip(mClipData);
    }

}
