package com.example.zengbin.downloader.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.zengbin.downloader.util.Constants;


/**
 * Created by zengbin on 2017/11/23.
 */

public class DownloadStateReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        String status = intent.getStringExtra(Constants.EXTENDED_DATA_STATUS);
        Toast.makeText(context,status,Toast.LENGTH_SHORT).show();
        Log.e("Receive",status);
    }
}
