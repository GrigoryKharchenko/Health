package com.health.presentation.screen.onboarding.gender

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.viewModels
import com.health.R
import com.health.databinding.FragmentGenderBinding
import com.health.di.ViewModelFactory
import com.health.presentation.base.BaseFragment
import javax.inject.Inject

class GenderFragment : BaseFragment() {

    private var _binding: FragmentGenderBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var defaultViewModelFactory: ViewModelFactory

    private val viewModel by viewModels<GenderViewModel> { defaultViewModelFactory }

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
            btnNext.setOnClickListener {
                viewModel.perform(GenderEvent.OpenDailyActivityFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = GenderFragment()
    }
}
