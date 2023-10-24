package com.cobs.farmup

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cobs.farmup.data.retrofit.WorkerRetrofitInstance
import com.cobs.farmup.databinding.FragmentCreateWorkerBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CreateWorkerFragment : Fragment() {

private var _binding:FragmentCreateWorkerBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       _binding = FragmentCreateWorkerBinding.inflate(layoutInflater,container,false)
        val root:View = binding.root

        binding.createWorkerBtn.setOnClickListener {
            val x = CoroutineScope(Dispatchers.IO).launch {
               try {
                   val firstName = binding.firstName.text.toString()
                   val lastName = binding.lastName.text.toString()
                   val workerTitle = binding.workerTitle.text.toString()
                   val workerPhone = binding.workerPhone.text.toString()
                   val workerPassword = binding.workerPassword.text.toString()
                   val workerGender = binding.workerGender.text.toString()

                   val retrofit = WorkerRetrofitInstance()
                   val service = retrofit.createWorkerService()
                   val worker = service.insertUsers(
                       firstName,
                       lastName,
                       workerTitle,
                       workerPhone,
                       workerPassword,
                       workerGender
                   )
               }catch (e:Throwable){
                   Log.d("create worker", "$e")
               }

            }
        }
        return root
    }


}