package com.cobs.farmup.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cobs.farmup.R
import com.cobs.farmup.data.retrofit.LivestockRetrofitInstance

import com.cobs.farmup.ui.adapter.LivestockAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LivestockFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_livestock, container, false)
        val livestockFab = view.findViewById<FloatingActionButton>(R.id.floatingActionButtonForLivestock)
        livestockFab.setOnClickListener {
            findNavController().navigate(R.id.action_id_livestock_fragment_to_createLivestockFragment)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch{
            val retrofit = LivestockRetrofitInstance()
            val service = retrofit.createLivestockService()
            val livestock = service.getLivestock().response
            withContext(Dispatchers.Main){

                val recyclerview = view.findViewById<RecyclerView>(R.id.livestock_recyclerView)
                val adapter = LivestockAdapter(requireContext(), livestock)
                recyclerview.adapter = adapter
                recyclerview.layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }


}