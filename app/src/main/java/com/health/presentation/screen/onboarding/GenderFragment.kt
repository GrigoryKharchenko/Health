package com.health.presentation.screen.onboarding

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import com.health.R
import com.health.databinding.FragmentGenderBinding
import com.health.presentation.base.BaseFragment

class GenderFragment : BaseFragment() {

    private var _binding: FragmentGenderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGenderBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            tvMan.setOnClickListener {
                tvMan.setBackgroundResource(R.drawable.blue_bg)
                tvWoman.setBackgroundColor(Color.TRANSPARENT)
                btnNext.isGone = false
            }
            tvWoman.setOnClickListener {
                tvWoman.setBackgroundResource(R.drawable.pink_bg)
                tvMan.setBackgroundColor(Color.TRANSPARENT)
                btnNext.isGone = false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
