package com.cobs.farmup

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.cobs.farmup.data.retrofit.SalesRetrofitInstance
import com.cobs.farmup.databinding.FragmentCreateSalesBinding
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext


class CreateSalesFragment : Fragment() {
private var _binding: FragmentCreateSalesBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCreateSalesBinding.inflate(layoutInflater,container,false)
        val root:View =binding.root

        binding.makeSalesBtn.setOnClickListener {
           val x = CoroutineScope(Dispatchers.IO).launch {

                try {
                    val animalId = binding.animalIdSales.text.toString()
                    val animalPrice = binding.priceSales.text.toString()
                    val quantitySales = binding.quantitySales.text.toString()
                    val soldBy = binding.soldBySales.text.toString()
                    val soldTo = binding.soldToSales.text.toString()

                    val retrofit = SalesRetrofitInstance()
                    val service = retrofit.createSalesService()
                    val sales = service.makeSales(
                        animalId,
                        animalPrice,
                        quantitySales,
                        soldBy,
                        soldTo
                    )

                }catch (e:Throwable){
                   withContext(Dispatchers.Main){
                       var name =binding.animalIdSales.text.toString()
                       Toast.makeText(requireContext(), "$e", Toast.LENGTH_LONG).show()

                       Log.d("make sales", "$name")

                   }
                }
          }
        }

        return root
    }


}
