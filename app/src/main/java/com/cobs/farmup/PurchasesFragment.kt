package com.cobs.farmup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cobs.farmup.data.retrofit.PurchasesRetrofitInstance
import com.cobs.farmup.ui.adapter.PurchasesAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class PurchasesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_purchases, container, false)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch{
            val retrofit = PurchasesRetrofitInstance()
            val service = retrofit.createPurchaseService()
            val purchases = service.getPurchases().response

            withContext(Dispatchers.Main){
                val recyclerView = view.findViewById<RecyclerView>(R.id.purchases_recyclerView)
                val adapter = PurchasesAdapter(requireContext(), purchases)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(context)
            }
        }

    }


}