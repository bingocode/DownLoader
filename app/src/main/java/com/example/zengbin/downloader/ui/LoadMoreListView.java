package com.example.zengbin.downloader.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.zengbin.downloader.R;
import com.example.zengbin.downloader.listener.OnLoadMoreListener;

/**
 * Created by zengbin on 2017/12/25.
 */

public class LoadMoreListView extends ListView implements AbsListView.OnScrollListener {
    private View mFootView;
    private int mTotalItemCount;
    private OnLoadMoreListener mLoadMoreListener;
    private boolean mIsLoading = false;
    public LoadMoreListView(Context context) {
        super(context);
        init(context);
    }

    public LoadMoreListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public LoadMoreListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    @Override
    public void onScrollStateChanged(AbsListView listView, int scrollState) {
        // 滑到底部后，判断listview已经停止滚动并且最后可视的条目等于adapter的条目
        int lastVisibleIndex=listView.getLastVisiblePosition();
        if (!mIsLoading&&scrollState == OnScrollListener.SCROLL_STATE_IDLE//停止滚动
                && lastVisibleIndex ==mTotalItemCount-1) {//滑动到最后一项
            mIsLoading=true;
            addFooterView(mFootView);
            if (mLoadMoreListener!=null) {
                mLoadMoreListener.onloadMore();
            }
        }
    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        mTotalItemCount=totalItemCount;
    }

    private void init (Context context) {
        mFootView = LayoutInflater.from(context).inflate(R.layout.footer_view,null);
        setOnScrollListener(this);
    }

    public void setLoadCompleted(){
        mIsLoading=false;
        removeFooterView(mFootView);
    }

    public void setOnLoadMoreListener(OnLoadMoreListener listener){
        mLoadMoreListener=listener;
    }
}
