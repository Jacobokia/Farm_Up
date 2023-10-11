package com.cobs.farmup.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cobs.farmup.R
import com.cobs.farmup.data.retrofit.SalesRetrofitInstance
import com.cobs.farmup.ui.adapter.SalesAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SalesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view =inflater.inflate(R.layout.fragment_sales, container, false)

        val salesFab = view.findViewById<FloatingActionButton>(R.id.floatingActionButtonForSales)
        salesFab.setOnClickListener {
            findNavController().navigate(R.id.action_id_sales_fragment_to_createSalesFragment)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("sales", "sales fragment")

        CoroutineScope(Dispatchers.IO).launch{
            val retrofit = SalesRetrofitInstance()
            val service = retrofit.createSalesService()
            val sales= service.getSales().response
            withContext(Dispatchers.Main){

                val recyclerview = view.findViewById<RecyclerView>(R.id.sales_recyclerview)
                val adapter = SalesAdapter(requireContext(), sales)
                recyclerview.adapter = adapter
                recyclerview.layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }

}