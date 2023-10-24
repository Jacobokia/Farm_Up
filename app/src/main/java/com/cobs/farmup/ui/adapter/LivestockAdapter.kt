package com.cobs.farmup.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cobs.farmup.R
import com.cobs.farmup.data.model.Livestock
import com.squareup.picasso.Picasso

class LivestockAdapter(val context: Context, val livestock:List<Livestock>):RecyclerView.Adapter<LivestockAdapter.LivestockViewHolder>() {

    class LivestockViewHolder(view: View):RecyclerView.ViewHolder(view){
        val imageView = view.findViewById<ImageView>(R.id.livestock_image)
        val tagNumberView = view.findViewById<TextView>(R.id.tag_number)
        val nameView = view.findViewById<TextView>(R.id.livestock_name)
        val typeview = view.findViewById<TextView>(R.id.type)
        val breedview = view.findViewById<TextView>(R.id.breed)
        val ageView = view.findViewById<TextView>(R.id.age)
        val genderView = view.findViewById<TextView>(R.id.gender)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivestockViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.livestock_layout, parent, false)
        return LivestockViewHolder(view)
    }

    override fun getItemCount(): Int {
        return livestock.size
    }

    override fun onBindViewHolder(holder: LivestockViewHolder, position: Int) {

        Picasso.get().load(livestock[position].image).into(holder.imageView)
        holder.tagNumberView.text = livestock[position].type
        holder.nameView.text = livestock[position].type
        holder.typeview.text = livestock[position].type
        holder.breedview.text = livestock[position].breed
        holder.ageView.text = livestock[position].type
        holder.genderView.text = livestock[position].type
    }
}