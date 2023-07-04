package com.health.presentation.screen.navview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.health.R
import com.health.databinding.FragmentNavViewBinding
import com.health.di.ViewModelFactory
import com.health.presentation.base.BaseFragment
import javax.inject.Inject

class NavViewFragment : BaseFragment() {

    private var _binding: FragmentNavViewBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var defaultViewModelFactory: ViewModelFactory

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val viewModel by viewModels<NavViewViewModel> { defaultViewModelFactory }

    private val navigator by lazy { AppNavigator(requireActivity(), R.id.fragmentContainer) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNavViewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigatorHolder.setNavigator(navigator)
        initUi()
        viewModel.perform(NavViewViewEvent.OpenHomeFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initUi() {
        with(binding) {
            bottomNavigation.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.homePage -> viewModel.perform(NavViewViewEvent.OpenHomeFragment)
                    R.id.searchPage -> {}
                    R.id.profilePage -> {}
                    else -> throw IllegalStateException("Bottom Navigation has’t got this fragment")
                }
                true
            }
        }
    }

    companion object {
        fun newInstance() = NavViewFragment()
    }
}
