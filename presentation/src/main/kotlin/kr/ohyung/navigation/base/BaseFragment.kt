package kr.ohyung.navigation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import kr.ohyung.common.shared.UiState
import kr.ohyung.navigation.utility.navigate

abstract class BaseFragment<T: ViewBinding, VM: BaseViewModel<State>, State: UiState>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    abstract val binding: T

    abstract val viewModel: VM

    abstract fun render(state: State)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.navigationAction.observe(viewLifecycleOwner, Observer(::navigate))
    }
}
