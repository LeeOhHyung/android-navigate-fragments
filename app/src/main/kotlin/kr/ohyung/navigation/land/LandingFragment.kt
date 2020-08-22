/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.land

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kr.ohyung.navigation.R
import kr.ohyung.navigation.base.BaseFragment
import kr.ohyung.navigation.databinding.FragmentLandingBinding
import kr.ohyung.navigation.utility.toast
import kr.ohyung.navigation.utility.viewBinding

internal class LandingFragment : BaseFragment<FragmentLandingBinding,
        LandingViewModel>(R.layout.fragment_landing) {

    override val binding by viewBinding(FragmentLandingBinding::bind)
    override val viewModel by viewModels<LandingViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.uiState.observe(viewLifecycleOwner, Observer(::updateUi))
    }

    private fun updateUi(state: LandingUiState) {
        when(state) {
            is LandingUiState.Loading -> toast("Loading...")
            is LandingUiState.Failed -> toast("Landing is failed...")
        }
    }
}
