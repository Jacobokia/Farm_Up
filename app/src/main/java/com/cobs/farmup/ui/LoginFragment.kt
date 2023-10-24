package com.cobs.farmup.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.cobs.farmup.R
import com.cobs.farmup.data.retrofit.AuthRetrofitService
import com.cobs.farmup.data.retrofit.WorkerRetrofitInstance
import com.cobs.farmup.databinding.FragmentLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoginFragment : Fragment() {


    private var _binding: FragmentLoginBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            login.setOnClickListener {
                when {

                    userPassword.text!!.isEmpty() ->{
                    showDialog("Invalid input", "Empty phone number")
                    }
                    userPhone.text!!.isEmpty() ->{
                        showDialog("Invalid input", "Empty password")
                    }
                    else ->{
                        val phone = userPhone.text.toString()
                        val password = userPassword.text.toString()
                        login(phone,password)
                    }
                }
            }
        }
    }

    private fun showDialog(title:String, message:String){
        val alert = AlertDialog.Builder(requireContext()).setTitle(title).setMessage(message)
            .setNegativeButton("Cancel"){p0, p1 -> p0?.dismiss()}
        alert.create()
        alert.show()

    }

    private fun login(phone:String, password:String) {
        lifecycleScope.launch(Dispatchers.Main) {
            try {
                val retrofitService = AuthRetrofitService().createResponseService()
                val loginResponse = retrofitService.loginUser(phone,password)

                withContext(Dispatchers.Main){
                    if(loginResponse.response.id == "1"){
                        findNavController().navigate(R.id.action_loginFragment_to_ownerFragment)
                    }else{
                        findNavController().navigate(R.id.action_loginFragment_to_workerFragment2)
                    }
                }

            }catch (t:Throwable){
                withContext(Dispatchers.Main){

                }

            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}