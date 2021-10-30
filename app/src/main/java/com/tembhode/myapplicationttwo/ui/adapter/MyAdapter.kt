package com.tembhode.myapplicationttwo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tembhode.myapplicationttwo.R
import com.tembhode.myapplicationttwo.data.Plant

/**
 * Created by Pankaj Gadge on 10/30/2021.
 */
class MyAdapter(val data: List<Plant>) : RecyclerView.Adapter<MyAdapter.PlantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return PlantViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class PlantViewHolder(val v: View) : RecyclerView.ViewHolder(v) {

        fun bind(Plant: Plant) {
            val title = v.findViewById<TextView>(R.id.tvTitle)
            val imageView = v.findViewById<ImageView>(R.id.imageView)
            val description = v.findViewById<TextView>(R.id.tvDescription)

            title.text = Plant.title
            description.text = Plant.description

            Glide.with(v.context).load(Plant.image).centerCrop().into(imageView)
        }
    }
}