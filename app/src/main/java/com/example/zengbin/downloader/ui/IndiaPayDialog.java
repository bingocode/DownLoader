package com.example.zengbin.downloader.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.example.zengbin.downloader.R;
import com.example.zengbin.downloader.activity.PhotoDLActivity;

/**
 * Created by zengbin on 2017/12/20.
 */

public class IndiaPayDialog extends Dialog{
    Button bt;
    Context context;

    public IndiaPayDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_pay);
        bt = (Button) findViewById(R.id.buttondl);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, PhotoDLActivity.class));
            }
        });
    }
    @Override
    public void dismiss() {
        super.dismiss();

    }

    @Override
    public void show() {
        super.show();
    }
}
