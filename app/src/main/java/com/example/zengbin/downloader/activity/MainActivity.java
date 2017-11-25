package com.example.zengbin.downloader.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zengbin.downloader.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void opendl(View v){
        switch (v.getId()){
            case R.id.photo_bt:
                startActivity(new Intent(this,PhotoDLActivity.class));break;

        }
    }
}
