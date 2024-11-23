package com.example.androidtrafficlight

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.androidtrafficlight.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.inflateMenu(R.menu.main_menu)
        binding.toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.exit -> requireActivity().finishAffinity()
            }
            true
        }
        binding.goBTN.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_goFragment)
        }
        binding.attentionBTN.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_attentionFragment)
        }
        binding.stopBTN.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_stopFragment)
        }
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }
}