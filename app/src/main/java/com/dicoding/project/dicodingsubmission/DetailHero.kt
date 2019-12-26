package com.dicoding.project.dicodingsubmission

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailHero : AppCompatActivity() {

    override fun onCreate(saveIntentState: Bundle?) {
        super.onCreate(saveIntentState)
        setContentView(R.layout.detail_hero)
        val actionBar =supportActionBar
        actionBar!!.title = "Detail Hero"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val tvName: TextView = findViewById(R.id.tv_item_name)
        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvDetail: TextView = findViewById(R.id.tv_item_detail)

        val tName = intent.getStringExtra(EXTRA_NAME)
        //val tImg = intent.getStringExtra(EXTRA_PHOTO)
        val tDetail = intent.getStringExtra(EXTRA_DETAIL)

        tvName.text = tName
        Glide.with(this)
            .load(getIntent().getIntExtra(EXTRA_PHOTO,0))
            .apply(RequestOptions())
            .into(imgPhoto)
        tvDetail.text = tDetail

    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}