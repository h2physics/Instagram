package com.h2physics.instagram.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.h2physics.instagram.R;
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
        return R.layout.fragment_home;
    }

    @Override
    public BaseViewHolder<Photo> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_home,parent,false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<Photo> holder, int position) {
        Photo photo = mList.get(position);
        holder.bind(photo, position);

    }

    public class PhotoViewHolder extends BaseViewHolder<Photo>{
        ImageView imgAvatar, imgBackground, imgLike, imgShare, imgRepeat;
        TextView txtName, txtNumLike;
        public PhotoViewHolder(View itemView) {
            super(itemView);
            imgAvatar       = itemView.findViewById(R.id.imgAvatar);
            imgBackground   = itemView.findViewById(R.id.imgBackground);
            imgLike         = itemView.findViewById(R.id.imgLike);
            imgShare        = itemView.findViewById(R.id.imgShare);
            imgRepeat       = itemView.findViewById(R.id.imgRepeat);
            txtName         = itemView.findViewById(R.id.txtName);
            txtNumLike      = itemView.findViewById(R.id.txtNumLike);
        }

        @Override
        public void bind(Photo photo, int position) {
            Glide.with(mContext)
                    .load(photo.getUser().getmProfileImage().getMedium())
                    .into(imgAvatar);
            Glide.with(mContext)
                    .load(photo.getUrl().getFull())
                    .into(imgBackground);
            txtName.setText(photo.getUser().getName());
            txtNumLike.setText(photo.getLikes() + "");
            imgLike.setImageResource(R.drawable.ic_favorite_black_24dp);
            imgRepeat.setImageResource(R.drawable.ic_repeat_black_24dp);
            imgShare.setImageResource(R.drawable.ic_share_black_24dp);

        }
    }
}
