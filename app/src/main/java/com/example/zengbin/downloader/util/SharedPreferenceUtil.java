package com.example.zengbin.downloader.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zengbin on 2017/11/23.
 */

public class SharedPreferenceUtil {
    private static SharedPreferences sharedPreferences;
    /**
     * 保存在手机里面的名字
     */
    public static final String FILE_NAME = "shared_data";
    private static SharedPreferences.Editor editor;
    private SharedPreferenceUtil(Context context,String filename){
        sharedPreferences = context.getSharedPreferences(filename,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    }


