package com.cobs.farmup.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cobs.farmup.R
import com.cobs.farmup.databinding.FragmentOwnerBinding


class OwnerFragment : Fragment() {

    private var _binding: FragmentOwnerBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOwnerBinding.inflate(inflater, container, false)
        val view = binding.root

        val workerCard = binding.workerCard
        val livestockCard = binding.cardLivestock
        val salesCard = binding.cardSales
        val purchasesCard = binding.cardPurchases

        workerCard.setOnClickListener {
            findNavController().navigate(R.id.action_ownerFragment_to_id_workers_fragment)
        }

        livestockCard.setOnClickListener {
            findNavController().navigate(R.id.action_ownerFragment_to_id_livestock_fragment)
        }

        salesCard.setOnClickListener {
            findNavController().navigate(R.id.action_ownerFragment_to_id_sales_fragment)
        }

        purchasesCard.setOnClickListener {
            findNavController().navigate(R.id.action_ownerFragment_to_id_purchases_fragment)
        }
        return view
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}