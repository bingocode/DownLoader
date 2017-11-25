package com.example.zengbin.downloader.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.zengbin.downloader.R;
import com.example.zengbin.downloader.receiver.DownloadStateReceiver;
import com.example.zengbin.downloader.service.DownLoaderService;
import com.example.zengbin.downloader.util.Constants;

public class PhotoDLActivity extends AppCompatActivity {
    EditText url_et;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_dl);
        url_et = (EditText) findViewById(R.id.editText);
        initreceiver();
    }

    public void submit(View v){
        switch (v.getId()){
            case R.id.submit_bt:
                startphotodl();
                break;
        }
    }

    private void initreceiver(){
        IntentFilter statusIntentFilter = new IntentFilter(
                Constants.BROADCAST_ACTION);

//        // Adds a data filter for the HTTP scheme
//        statusIntentFilter.addDataScheme("http");
        // Instantiates a new DownloadStateReceiver
        DownloadStateReceiver mDownloadStateReceiver =
                new DownloadStateReceiver();
        // Registers the DownloadStateReceiver and its intent filters
        LocalBroadcastManager.getInstance(this).registerReceiver(
                mDownloadStateReceiver,
                statusIntentFilter);
    }

    private void startphotodl(){
        url = url_et.getText().toString();
        Intent mServiceIntent = new Intent(this, DownLoaderService.class);
        mServiceIntent.setData(Uri.parse(url));
        startService(mServiceIntent);
    }
}
