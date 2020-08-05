/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.land

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import kr.ohyung.navigation.R
import kr.ohyung.navigation.databinding.FragmentLandingBinding
import kr.ohyung.navigation.utility.sharedViewModel
import kr.ohyung.navigation.utility.toast
import kr.ohyung.navigation.utility.viewBinding

internal class LandingFragment : Fragment(R.layout.fragment_landing) {

    private val binding by viewBinding(FragmentLandingBinding::bind)
    private val viewModel by viewModels<LandingViewModel> { getFactory() }

    private val args: LandingFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.uiState.observe(viewLifecycleOwner, Observer(::updateUi))
    }

    private fun updateUi(state: LandingUiState) {
        when(state) {
            is LandingUiState.Loading -> toast("Loading...")
            is LandingUiState.Failed -> toast("Landing is failed...")
        }
    }

    private fun getFactory() = LandingViewModelFactory(sharedViewModel, args.duration)
}
