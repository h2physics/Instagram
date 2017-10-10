package com.h2physics.instagram.ui.author

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide

import com.h2physics.instagram.R
import com.h2physics.instagram.data.model.User
import com.h2physics.instagram.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_author.*
import java.io.Serializable

class AuthorActivity : BaseActivity() {
    override fun getContentView(): Int {
        return R.layout.activity_author
    }

    override fun initView() {


    }

    override fun initData() {
        val intent : Intent? = intent;
        var user : User? = intent?.getSerializableExtra("author") as User?
        Glide.with(AuthorActivity@this)
                .load(user?.getmProfileImage()?.medium)
                .into(imv_avatar)
        tv_name.text = user?.name
        tv_total_likes.text = user?.totalLikes as String?
        tv_total_photos.text = user?.totalPhotos as String?
        tv_biography.text = user?.biology
        tv_location.text = user?.location
    }
}
