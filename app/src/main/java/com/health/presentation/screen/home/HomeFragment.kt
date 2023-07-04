package com.health.presentation.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.health.R
import com.health.databinding.FragmentHomeBinding
import com.health.di.ViewModelFactory
import com.health.extension.launchWhenStarted
import com.health.presentation.base.BaseFragment
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var defaultViewModelFactory: ViewModelFactory

    private val viewModel by viewModels<HomeViewModel> { defaultViewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchWhenStarted(viewModel.state, ::handleState)
        binding.btnAddPfc.setOnClickListener {
            viewModel.perform(HomeViewEvent.OpenAddPfcFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.perform(HomeViewEvent.UpdateDailyPfc)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun handleState(state: HomeViewState) {
        with(binding) {
            tvAmountCalories.text = getString(R.string.calories, state.amountCalories)
            tvAmountProtein.text = getString(R.string.protein, state.amountProtein)
            tvAmountFats.text = getString(R.string.fats, state.amountFats)
            tvAmountCarbs.text = getString(R.string.crabs, state.amountCrabs)
            tvBodyMassIndex.text = state.indexMass
            tvPurpose.text = state.purpose
            tvDailyAmountCalories.text = getString(R.string.calories, state.dailyCalories)
            tvDailyAmountProtein.text = getString(R.string.protein, state.dailyProtein)
            tvDailyAmountFats.text = getString(R.string.fats, state.dailyFats)
            tvDailyAmountCarbs.text = getString(R.string.crabs, state.dailyCarbs)
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
