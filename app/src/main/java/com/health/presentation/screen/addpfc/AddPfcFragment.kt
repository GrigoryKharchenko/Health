package com.health.presentation.screen.addpfc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.health.databinding.FragmentAddPfcBinding
import com.health.di.ViewModelFactory
import com.health.presentation.base.BaseFragment
import javax.inject.Inject

class AddPfcFragment : BaseFragment() {

    private var _binding: FragmentAddPfcBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var defaultViewModelFactory: ViewModelFactory

    private val viewModel by viewModels<AddPfcViewModel> { defaultViewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddPfcBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            toolBar.setNavigationOnClickListener {
                viewModel.perform(AddPfcViewEvent.GoBack)
            }
            btnAddPfc.setOnClickListener {
                viewModel.perform(
                    AddPfcViewEvent.UpdatePfc(
                        etAddCalories.text.toString(),
                        etAddProtein.text.toString(),
                        etAddFats.text.toString(),
                        etAddCarbs.text.toString()
                    )
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = AddPfcFragment()
    }
}