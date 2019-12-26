package com.dicoding.project.dicodingsubmission

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class About : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about)
        val actionBar = supportActionBar
        actionBar!!.title = "About"

        val imgabout: ImageView = findViewById(R.id.img_about)
        val tImg = R.drawable.photo_me
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgabout)


    }
}