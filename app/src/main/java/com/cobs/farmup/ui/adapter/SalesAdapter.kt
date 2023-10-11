package com.cobs.farmup.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cobs.farmup.R
import com.cobs.farmup.data.model.Sales

class SalesAdapter(val context: Context, val sales:List<Sales>):RecyclerView.Adapter<SalesAdapter.SalesViewHolder>() {

    class SalesViewHolder(view: View):RecyclerView.ViewHolder(view){

        val animalIdView = view.findViewById<TextView>(R.id.animal_id)
        val priceView = view.findViewById<TextView>(R.id.animal_price)
        val soldToView = view.findViewById<TextView>(R.id.sold_to)
        val sellingDateView = view.findViewById<TextView>(R.id.selling_date)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalesViewHolder {
       val view = LayoutInflater.from(context).inflate(R.layout.sales_layout, parent, false)
        return SalesViewHolder(view)
    }

    override fun getItemCount(): Int {
       return sales.size
    }

    override fun onBindViewHolder(holder: SalesViewHolder, position: Int) {
        holder.animalIdView.text = sales[position].animal_id
        holder.priceView.text = sales[position].price
        holder.soldToView.text = sales[position].sold_to
        holder.sellingDateView.text = sales[position].selling_date
    }
}