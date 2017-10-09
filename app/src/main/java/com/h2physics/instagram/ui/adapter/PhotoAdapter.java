package com.h2physics.instagram.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.h2physics.instagram.data.model.Photo;
import com.h2physics.instagram.ui.base.BaseAdapter;
import com.h2physics.instagram.ui.base.BaseViewHolder;

/**
 * Created by YukiNoHara on 10/7/2017.
 */

public class PhotoAdapter extends BaseAdapter<Photo> {

    public PhotoAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public int getContentView() {
        return 0;
    }

    @Override
    public BaseViewHolder<Photo> onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<Photo> holder, int position) {

    }

    public class PhotoViewHolder extends BaseViewHolder<Photo>{
        public PhotoViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Photo photo, int position) {

        }
    }
}
