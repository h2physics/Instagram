package com.h2physics.instagram.ui.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by YukiNoHara on 10/7/2017.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>> {
    public List<T> mList;
    public Context mContext;

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public abstract int getContentView();

    public void add(T t){
        mList.add(t);
    }

    public void addAll(List<T> list){
        mList.addAll(list);
    }

    public void clear(){
        mList.clear();
    }

    public void resetAll(List<T> list){
        if (mList == null) return;
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public List<T> getData(){
        return mList;
    }


}
