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
import com.cobs.farmup.data.retrofit.WorkerRetrofitInstance
import com.cobs.farmup.ui.adapter.WorkerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class WorkersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_workers, container, false)

        val fab = view.findViewById<FloatingActionButton>(R.id.floating_action_button_for_workers)
        fab.setOnClickListener {
            findNavController().navigate(R.id.action_id_workers_fragment_to_createWorkerFragment)
        }
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("workers", "workers fragment")


        CoroutineScope(Dispatchers.IO).launch {
            val retrofit = WorkerRetrofitInstance()
            val service = retrofit.createWorkerService()
            val workers = service.getUsers().response
            withContext(Dispatchers.Main) {
                    val recyclerview = view.findViewById<RecyclerView>(R.id.worker_recyclerview)
                    val adapter = WorkerAdapter(requireContext(), workers)
                    recyclerview.adapter = adapter
                    recyclerview.layoutManager = LinearLayoutManager(requireContext())

            }
        }

    }


}