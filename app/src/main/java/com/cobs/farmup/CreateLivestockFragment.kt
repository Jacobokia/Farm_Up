package com.cobs.farmup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.cobs.farmup.data.retrofit.LivestockRetrofitInstance
import com.cobs.farmup.databinding.FragmentCreateLivestockBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CreateLivestockFragment : Fragment() {
    private var _binding:FragmentCreateLivestockBinding? = null
    private val binding get()  = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentCreateLivestockBinding.inflate(inflater,container, false)
        val root:View = binding.root

        val saveAnimal = binding.saveAnimal

        saveAnimal.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO){

                try {

                    val animalTag = binding.animalTagNumber.text.toString()
                    val animalName = binding.animalName.text.toString()
                    val animalAge = binding.animalAge.text.toString()
                    val animalType = binding.animalType.text.toString()
                    val animalBreed = binding.animalBreed.text.toString()
                    val animalImage = binding.animalImage.text.toString()
                    val animalGender = binding.animalSex.text.toString()
                    val animalColor = binding.animalSex.text.toString()
                    val animalWeight = binding.animalWeight.text.toString()

                    val retrofit = LivestockRetrofitInstance().createLivestockService()
                    val service = retrofit.insertLivestock(
                        animalTag,
                        animalAge,
                        animalType,
                        animalBreed,
                        animalImage,
                        animalGender,
                        animalName,
                        animalWeight,
                        animalColor,
                    )

                }catch (e:Throwable){

                }


            }
        }



        return root
    }


}