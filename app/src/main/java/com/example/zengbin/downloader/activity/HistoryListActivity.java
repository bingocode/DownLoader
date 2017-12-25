package com.example.zengbin.downloader.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.zengbin.downloader.R;
import com.example.zengbin.downloader.adapter.HistoryListAdapter;
import com.example.zengbin.downloader.listener.OnLoadMoreListener;
import com.example.zengbin.downloader.model.Data;
import com.example.zengbin.downloader.ui.LoadMoreListView;

import java.util.ArrayList;

public class HistoryListActivity extends AppCompatActivity {
    private LoadMoreListView listView;
    private ArrayList<Data> mDataList = new ArrayList<>();
    private HistoryListAdapter adapter;
    private ArrayAdapter<Data> t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);
        listView = (LoadMoreListView) findViewById(R.id.history_list);
        adapter = new HistoryListAdapter(this);
        listView.setAdapter(adapter);
        initData();
        listView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onloadMore() {
                loadMore();
            }
        });
    }

    private void loadMore(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i =0; i < 10; i++) {
                    mDataList.add(new Data("atate"+i));
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        listView.setLoadCompleted();
                    }
                });
            }
        }.start();
    }

    private void initData(){
        for (int i = 0; i<30; i++) {
            Data data = new Data(""+i);
            mDataList.add(data);
        }
        adapter.setHistoryData(mDataList);
    }
}
