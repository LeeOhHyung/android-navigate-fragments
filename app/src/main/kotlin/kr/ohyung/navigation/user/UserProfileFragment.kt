/*
 * Created by Lee Oh Hyoung on 2020/08/06 .. 
 */
package kr.ohyung.navigation.user

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import kr.ohyung.navigation.R
import kr.ohyung.navigation.databinding.FragmentUserProfileBinding
import kr.ohyung.navigation.utility.sharedViewModel
import kr.ohyung.navigation.utility.toast
import kr.ohyung.navigation.utility.viewBinding

internal class UserProfileFragment : Fragment(R.layout.fragment_user_profile) {

    private val binding by viewBinding(FragmentUserProfileBinding::bind)
    private val viewModel by viewModels<UserProfileViewModel> { getFactory() }

    private val args: UserProfileFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.uiState.observe(viewLifecycleOwner, Observer(::updateUi))
    }

    private fun updateUi(state: UserProfileUiState) {
        when(state) {
            UserProfileUiState.Loading -> toast("Loading...")
            is UserProfileUiState.UserProfile -> {
                binding.textView.text = state.toString()
            }
            is UserProfileUiState.Failed -> toast(state.errorMessage)
        }
    }

    private fun getFactory() = UserProfileViewModelFactory(sharedViewModel, args.userName)
}
