/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.splash

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.ohyung.common.extensions.toast
import kr.ohyung.common.extensions.viewBinding
import kr.ohyung.navigation.R
import kr.ohyung.navigation.base.BaseFragment
import kr.ohyung.navigation.databinding.FragmentSplashBinding

@AndroidEntryPoint
internal class SplashFragment : BaseFragment<FragmentSplashBinding,
        SplashViewModel, SplashUiState>(R.layout.fragment_splash) {

    override val binding by viewBinding(FragmentSplashBinding::bind)
    override val viewModel by navGraphViewModels<SplashViewModel>(R.id.nav_graph) { defaultViewModelProviderFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.uiState.observe(viewLifecycleOwner, Observer(::render))
    }

    override fun render(state: SplashUiState) {
        when(state) {
            is SplashUiState.Loading -> toast("Loading...")
            is SplashUiState.Failed -> toast("Landing is failed...")
        }
    }
}
