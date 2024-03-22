package com.softyorch.beerchat.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.softyorch.beerchat.R
import com.softyorch.beerchat.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.btnChat.setOnClickListener {
            if (!binding.tiedName.text.isNullOrEmpty())
                findNavController().navigate(R.id.action_main_fragment_to_chat_fragment)
        }

        return binding.root
    }

}