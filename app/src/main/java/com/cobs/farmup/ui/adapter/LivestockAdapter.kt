package com.cobs.farmup.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cobs.farmup.R
import com.cobs.farmup.data.model.Livestock

class LivestockAdapter(val context: Context, val livestock:List<Livestock>):RecyclerView.Adapter<LivestockAdapter.LivestockViewHolder>() {

    class LivestockViewHolder(view: View):RecyclerView.ViewHolder(view){
        val typeview = view.findViewById<TextView>(R.id.type)
        val breedview = view.findViewById<TextView>(R.id.breed)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivestockViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.livestock_layout, parent, false)
        return LivestockViewHolder(view)
    }

    override fun getItemCount(): Int {
        return livestock.size
    }

    override fun onBindViewHolder(holder: LivestockViewHolder, position: Int) {
        holder.typeview.text = livestock[position].type
        holder.breedview.text = livestock[position].breed
    }
}