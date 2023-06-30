package com.health.presentation.screen.onboarding.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.health.databinding.FragmentCharactersBinding
import com.health.di.ViewModelFactory
import com.health.extension.launchWhenStarted
import com.health.presentation.base.BaseFragment
import javax.inject.Inject

class CharactersFragment : BaseFragment() {

    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var defaultViewModelFactory: ViewModelFactory

    private val viewModel by viewModels<CharactersViewModel> { defaultViewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchWhenStarted(viewModel.state, ::handleState)
        initUi()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initUi() {
        with(binding) {
            btnNext.setOnClickListener {
                viewModel.perform(
                    CharactersViewEvent.CheckValidation(
                        age = etAge.text.toString(),
                        height = etHeight.text.toString(),
                        weight = etWeight.text.toString()
                    )
                )
                etAge.setOnFocusChangeListener { _, _ ->
                    viewModel.perform(CharactersViewEvent.HideAgeError)
                }
                etHeight.setOnFocusChangeListener { _, _ ->
                    viewModel.perform(CharactersViewEvent.HideHeightError)
                }
                etWeight.setOnFocusChangeListener { _, _ ->
                    viewModel.perform(CharactersViewEvent.HideWeightError)
                }
            }
        }
    }

    private fun handleState(state: CharactersViewState) {
        with(binding) {
            tilAge.error = getString(state.ageError)
            tilHeight.error = getString(state.heightError)
            tilWeight.error = getString(state.weightError)
        }
    }

    companion object {
        fun newInstance() = CharactersFragment()
    }
}
