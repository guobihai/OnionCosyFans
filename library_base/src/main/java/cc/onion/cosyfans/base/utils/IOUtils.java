package cc.onion.cosyfans.base.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author guobihai
 * @Created 7/17/19
 * @Editor zrh
 * @Edited 7/17/19
 * @Type
 * @Layout
 * @Api
 */
public class IOUtils {

    /**
     * 从raw文件读取文本
     *
     * @param context
     * @param resId
     * @return
     */
    public static String getStringFromRaw(Context context, int resId) throws IOException {
        InputStreamReader inputReader = new InputStreamReader(context.getResources().openRawResource(resId));
        BufferedReader bufReader = new BufferedReader(inputReader);
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = bufReader.readLine()) != null) {
            result.append(line);
        }
        return result.toString();

    }

    /**
     * 从assets文件读取文本
     *
     * @param fileName
     * @return
     */
    public static String getFromAssets(Context context, String fileName) throws IOException {
        InputStreamReader inputReader = new InputStreamReader(context.getResources().getAssets().open(fileName));
        BufferedReader bufReader = new BufferedReader(inputReader);
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = bufReader.readLine()) != null) {
            result.append(line);
        }
        return result.toString();

    }
}
