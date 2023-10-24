package com.cobs.farmup.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cobs.farmup.R
import com.cobs.farmup.databinding.FragmentWorkerBinding


class WorkerFragment : Fragment() {

    private var _binding: FragmentWorkerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkerBinding.inflate(inflater, container, false)
        val view = binding.root

        val workerCardLivestock = binding.workerCardLivestock
        val workerCardSales = binding.workerCardSales
        val workerCardPurchases = binding.workerCardPurchases

        workerCardLivestock.setOnClickListener {
            findNavController().navigate(R.id.action_workerFragment2_to_id_livestock_fragment)
        }

        workerCardSales.setOnClickListener {
            findNavController().navigate(R.id.action_workerFragment2_to_id_sales_fragment)
        }

        workerCardPurchases.setOnClickListener {
            findNavController().navigate(R.id.action_workerFragment2_to_id_purchases_fragment)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    }