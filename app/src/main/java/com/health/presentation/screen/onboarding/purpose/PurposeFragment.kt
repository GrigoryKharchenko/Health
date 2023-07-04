package com.health.presentation.screen.onboarding.purpose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.health.databinding.FragmentPurposeBinding
import com.health.di.ViewModelFactory
import com.health.extension.launchWhenStarted
import com.health.presentation.base.BaseFragment
import javax.inject.Inject

class PurposeFragment : BaseFragment() {

    private var _binding: FragmentPurposeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var defaultViewModelFactory: ViewModelFactory

    private val viewModel by viewModels<PurposeViewModel> { defaultViewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPurposeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            tvSicknessDescription.setOnClickListener {
                viewModel.perform(PurposeViewEvent.OpenSymptomsDialogFragment)
            }
            rgPurpose.setOnCheckedChangeListener { _, _ ->
                viewModel.perform(PurposeViewEvent.CheckPurposeGroupView)
            }
            rgSickness.setOnCheckedChangeListener { _, _ ->
                viewModel.perform(PurposeViewEvent.CheckSicknessGroup)
            }
            launchWhenStarted(viewModel.state, ::handleState)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun handleState(state: PurposeViewState) {
        binding.btnNext.isVisible = state.isVisibleNextButton
    }

    companion object {
        fun newInstance() = PurposeFragment()
    }
}
