package com.h2physics.instagram.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by YukiNoHara on 10/7/2017.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(T t, int position);
}