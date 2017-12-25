package com.example.zengbin.downloader.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.zengbin.downloader.R;
import com.example.zengbin.downloader.model.Data;

import java.util.ArrayList;

/**
 * Created by zengbin on 2017/12/24.
 */

public class HistoryListAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Data> mDatalist = new ArrayList<>();

    public HistoryListAdapter(Context context) {
        mContext = context;
    }

    public void setHistoryData(ArrayList<Data> datalist) {
        mDatalist = datalist;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mDatalist == null) {
            return 0;
        }
        return mDatalist.size();
    }

    @Override
    public Data getItem(int position) {
        return mDatalist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Data data = getItem(position);
        HistoryViewHolder viewHolder;
        if(convertView == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_history,null);
            viewHolder = new HistoryViewHolder();
            viewHolder.historyTv = (TextView) view.findViewById(R.id.history_tv);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (HistoryViewHolder) view.getTag();
        }
        viewHolder.historyTv.setText(data.getLabel());
        return view;
    }

    class HistoryViewHolder {
        TextView historyTv;
    }
}
