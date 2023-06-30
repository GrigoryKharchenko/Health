package com.health.presentation.screen.onboarding.dailyactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.health.databinding.FragmentDailyActivityBinding
import com.health.di.ViewModelFactory
import com.health.extension.launchWhenStarted
import com.health.presentation.base.BaseFragment
import javax.inject.Inject

class DailyActivityFragment : BaseFragment() {

    private var _binding: FragmentDailyActivityBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy {
        DailyActivityAdapter(
            onItemClick = { id ->
                viewModel.perform(
                    DailyActivityEvent.SelectDailyActivity(
                        dailyActivityId = id
                    )
                )
            }
        )
    }

    @Inject
    lateinit var defaultViewModelFactory: ViewModelFactory

    private val viewModel by viewModels<DailyActivityViewModel> { defaultViewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDailyActivityBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            rvActivity.adapter = adapter
            launchWhenStarted(viewModel.dailyActivityFlow, ::handleUiState)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvActivity.adapter = null
        _binding = null
    }

    private fun handleUiState(state: DailyActivityViewState) {
        adapter.submitList(state.dailyActivities)
        binding.btnNext.isVisible = state.isVisibleBtnNext
    }

    companion object {
        fun newInstance() = DailyActivityFragment()
    }
}
