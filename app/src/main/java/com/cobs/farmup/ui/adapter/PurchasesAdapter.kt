package com.cobs.farmup.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cobs.farmup.R
import com.cobs.farmup.data.model.Purchases

class PurchasesAdapter(val context: Context, val purchases:List<Purchases>):RecyclerView.Adapter<PurchasesAdapter.PurchasesViewHolder>() {

    class PurchasesViewHolder(view: View):RecyclerView.ViewHolder(view){

        val productView = view.findViewById<TextView>(R.id.product_name)
        val priceView = view.findViewById<TextView>(R.id.product_price)
       val quantityView = view.findViewById<TextView>(R.id.product_quantity)

        val purchasedFromView = view.findViewById<TextView>(R.id.purchased_from)
        val purchasesOnView = view.findViewById<TextView>(R.id.purchased_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchasesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.purchases_layout,parent,false)
        return PurchasesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return purchases.size
    }

    override fun onBindViewHolder(holder: PurchasesViewHolder, position: Int) {
        holder.productView.text=purchases[position].product
        holder.priceView.text = purchases[position].price
        holder.quantityView.text = purchases[position].quantity
        holder.purchasedFromView.text = purchases[position].purchased_from
        holder.purchasesOnView.text = purchases[position].purchased_on
    }
}