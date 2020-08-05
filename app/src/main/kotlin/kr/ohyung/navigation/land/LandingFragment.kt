/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.land

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import kr.ohyung.navigation.databinding.FragmentLandingBinding
import kr.ohyung.navigation.utility.sharedViewModel
import kr.ohyung.navigation.utility.toast

internal class LandingFragment : Fragment() {

    private lateinit var binding: FragmentLandingBinding
    private val viewModel by viewModels<LandingViewModel> { getFactory() }

    private val args: LandingFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLandingBinding.inflate(inflater, container, false)

        viewModel.uiState.observe(viewLifecycleOwner, Observer(::updateUi))

        return binding.root
    }

    private fun updateUi(state: LandingUiState) {
        when(state) {
            is LandingUiState.Loading -> toast("Loading...")
            is LandingUiState.Failed -> { /* explicitly empty */ }
        }
    }

    private fun getFactory() = LandingViewModelFactory(sharedViewModel, args.duration)
}
