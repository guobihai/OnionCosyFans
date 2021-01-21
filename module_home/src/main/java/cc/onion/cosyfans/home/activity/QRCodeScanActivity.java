package cc.onion.cosyfans.home.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.tbruyelle.rxpermissions2.RxPermissions;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import cc.onion.cosyfans.base.dialog.AlertDialog;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.KLogUtils;
import cc.onion.cosyfans.base.utils.SystemUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.module_home.R;
import cn.bingoogolapple.qrcode.core.BarcodeType;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

/**
 * 二维码
 * @author guobihai
 * @email: guobihai@163.com
 */
@Route(path = RouterPath.Features.ROUTE_QRCODE_SCAN)
public class QRCodeScanActivity extends AppCompatActivity implements QRCodeView.Delegate{


    // 设置hard模式增加扫描精度
    public static final Map<DecodeHintType, Object> HINTS = new EnumMap<>(DecodeHintType.class);

    static {
        List<BarcodeFormat> allFormats = new ArrayList<>();
        allFormats.add(BarcodeFormat.QR_CODE);
        HINTS.put(DecodeHintType.TRY_HARDER, BarcodeFormat.QR_CODE);
        HINTS.put(DecodeHintType.POSSIBLE_FORMATS, allFormats);
        HINTS.put(DecodeHintType.CHARACTER_SET, "utf-8");
    }

    private ZXingView mZXingView;
    private View layoutNotFound;
    public static final int REQUEST_CODE_FOR_PHOTO = 1;

    @Autowired
    public boolean handle;

    @Autowired
    public boolean isRouter; // 是否直接跳转路由(和上面的参数二选一)


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ARouter.getInstance().inject(this);

        setContentView(R.layout.home_qrcode_scan);

        initToolbar();

        initZxingView();

        initNotFoundLayout();

    }
    private void initNotFoundLayout() {
        layoutNotFound = findViewById(R.id.layout_not_found);
        layoutNotFound.setOnClickListener(v -> {
            layoutNotFound.setVisibility(View.GONE);
            mZXingView.startSpot();
        });
    }



    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());
//        toolbar.inflateMenu(R.menu.contract_qrcode_scan);
//        toolbar.setOnMenuItemClickListener(menuItem -> {
//            if (menuItem.getItemId() == R.id.menu_item_select_pivture) {
//                openAlbum();
//            }
//            return true;
//        });

        View statusBarCompat = findViewById(R.id.status_bar_compat);
        if (SystemUtils.v21()) {
            statusBarCompat.setVisibility(View.VISIBLE);
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }

    }

    private void setupScanBoxCenter() {
        final View body = findViewById(R.id.body);
        body.post(() -> {
            int height = (body.getMeasuredHeight() - mZXingView.getScanBoxView().getRectHeight()) / 2;
            mZXingView.getScanBoxView().setTopOffset((height));
        });
    }



    private void initZxingView() {
        mZXingView = findViewById(R.id.zxingview);
        mZXingView.setVisibility(View.GONE);
        mZXingView.setDelegate(this);
        mZXingView.setType(BarcodeType.ONLY_QR_CODE, HINTS);
//        mZXingView.getScanBoxView().setOnlyDecodeScanBoxArea(true);
//        mZXingView.getScanBoxView().setShowLocationPoint(true);
        setupScanBoxCenter();
    }



    @SuppressLint("CheckResult")
    @Override
    protected void onStart() {
        super.onStart();
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.CAMERA)
                .subscribe(granted -> {
                    if (granted) {
                        mZXingView.setVisibility(View.VISIBLE);
                        mZXingView.startCamera();
                        mZXingView.startSpotAndShowRect();
                    } else {
                        finish();
                    }
                });
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        vibrate();
        if (result == null || result.equals("null")) {
            mZXingView.stopSpot();
            layoutNotFound.setVisibility(View.VISIBLE);
            return;
        }

        if (handle || isRouter) {
            handelRoute(result);
        } else {
            returnQrcode(result);
        }


    }

    private void handelRoute(String route) {
        // 如果为合法路由则直接跳转，否则返回扫描的二维码
        Uri uri = Uri.parse(route);

        if (uri.getScheme() != null && uri.getHost() != null) {

            String path = uri.getPath();
            if (path == null || !path.startsWith("/")) {
                showError(route);
            } else {
                navigation(uri);
            }
        } else {
            showError(route);
        }
    }

    /**
     * 返回二维码
     *
     * @param result
     */
    private void returnQrcode(String result) {
        Intent intent = new Intent();
        intent.putExtra("qrcode", result);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    /**
     * 跳转路由
     *
     * @param uri
     */
    private void navigation(Uri uri) {
        ARouter.getInstance().build(uri)
                .navigation(this, new NavCallback() {
                    @Override
                    public void onArrival(Postcard postcard) {
                        finish();
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        showError(uri.toString());
                    }
                });
    }


    /**
     * 展示错误
     *
     * @param msg
     */
    private void showError(String msg) {

        try {
            //不包括店铺ID
            if(!msg.contains("shopId")){
                ARouter.getInstance().build(RouterPath.Features.ROUTE_WEB)
                        .withString("url", msg)
                        .greenChannel()
                        .navigation();
            }


        KLogUtils.logTest("二维码检测到文本:"+msg);
        //https://cosyfans-m.factorychain2social.cn?shopId=39306&from=qrcode
        if(StringUtils.isNotEmpty(msg)){
            String[] shopIdArr = msg.split("shopId=");
            List list = Arrays.asList(shopIdArr);
            if(list != null && list.size() >0){
                String listArray = (String) list.get(1);
                //截取SHopId
                KLogUtils.logTest(listArray);
                String[] lastArray = listArray.split("&");
                List lastStr = Arrays.asList(lastArray);
                if(lastStr != null && lastStr.size() >0){
                    if(lastStr.get(0) != null){


                        /**
                         * 处理返回操作处理，根据扫描到二维码值进行操作
                         *
                         */
                        if(StringUtils.isNotEmpty(lastStr.get(0).toString())){
                            KLogUtils.logTest("最终结果:"+lastStr.get(0));
                            Intent intent = new Intent();
                            intent.putExtra("shopId",lastStr.get(0).toString());
                            setResult(100002,intent);
                            finish();
                        }


                    }
                }

            }

        }

        }catch (Exception e){
            e.printStackTrace();
        }

//        AlertDialog alertDialog = new AlertDialog(this);
//        alertDialog.setTitle("检测到如下文本：");
//        alertDialog.setMessageGravity(Gravity.START);
//        alertDialog.setMessage(msg);
//        alertDialog.setLeftButton("取消", v -> {
//            alertDialog.dismiss();
//            finish();
//        });
//        alertDialog.setRightButton("复制", v -> {
//            copyResult(msg);
//            alertDialog.dismiss();
//            finish();
//        });
//        alertDialog.show();
    }

    /**
     * 赋值到粘贴板
     *
     * @param msg
     */
    private void copyResult(String msg) {
        try {
            ClipboardManager mClipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData mClipData = ClipData.newPlainText("text", msg);
            mClipboardManager.setPrimaryClip(mClipData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCameraAmbientBrightnessChanged(boolean isDark) {

    }

    @Override
    public void onScanQRCodeOpenCameraError() {

    }

    @Override
    protected void onStop() {
        mZXingView.stopCamera(); // 关闭摄像头预览，并且隐藏扫描框
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mZXingView.onDestroy(); // 销毁二维码扫描控件
        super.onDestroy();
    }

    /**
     * 解析图片二维码
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_FOR_PHOTO && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            String imagePath = c.getString(columnIndex);
            mZXingView.decodeQRCode(imagePath);
            c.close();
        }
    }

    /**
     * 震动
     */
    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
