package com.dicoding.project.dicodingsubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListHeroAdapter ( val lisHero: ArrayList<Hero>): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_hero, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  lisHero.size
    }


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val (name,  detail, photo) = lisHero[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvDetail.text = detail

        val mContex = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContex, DetailHero::class.java)
            moveDetail.putExtra(DetailHero.EXTRA_NAME, name)
            moveDetail.putExtra(DetailHero.EXTRA_PHOTO, photo)
            moveDetail.putExtra(DetailHero.EXTRA_DETAIL, detail)
            mContex.startActivity(moveDetail)
        }
    }



    inner class ListViewHolder (itemView: View) : RecyclerView.ViewHolder (itemView){
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

    }


}