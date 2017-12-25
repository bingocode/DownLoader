package com.example.zengbin.downloader.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zengbin.downloader.R;
import com.example.zengbin.downloader.ui.IndiaPayDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void opendl(View v){
        switch (v.getId()){
            case R.id.photo_bt:
                showdialog();break;
            case R.id.list_bt:
                startActivity(new Intent(MainActivity.this,HistoryListActivity.class));break;
        }
    }

    private void showdialog(){
        IndiaPayDialog indiaPayDialog = new IndiaPayDialog(this);
        indiaPayDialog.show();
    }
}
