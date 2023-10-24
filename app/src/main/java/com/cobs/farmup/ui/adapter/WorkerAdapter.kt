package com.cobs.farmup.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cobs.farmup.R
import com.cobs.farmup.data.model.Worker

class WorkerAdapter(val context: Context, val workers:List<Worker>):RecyclerView.Adapter<WorkerAdapter.WorkerViewHolder>() {

    class WorkerViewHolder(view: View):RecyclerView.ViewHolder(view){
        val firstNameView = view.findViewById<TextView>(R.id.first_name)
        val lastNameView = view.findViewById<TextView>(R.id.second_name)
        val phoneView = view.findViewById<TextView>(R.id.worker_phone)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkerViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.worker_layout, parent, false)
        return WorkerViewHolder(view)
    }

    override fun getItemCount(): Int {
       return workers.size
    }

    override fun onBindViewHolder(holder: WorkerViewHolder, position: Int) {
        holder.firstNameView.text =workers[position].f_name
        holder.lastNameView.text = workers[position].l_name
        holder.phoneView.text = workers[position].phone
    }
}