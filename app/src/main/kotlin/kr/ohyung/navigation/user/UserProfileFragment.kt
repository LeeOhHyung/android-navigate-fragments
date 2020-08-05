/*
 * Created by Lee Oh Hyoung on 2020/08/06 .. 
 */
package kr.ohyung.navigation.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import kr.ohyung.navigation.databinding.FragmentUserProfileBinding
import kr.ohyung.navigation.utility.sharedViewModel
import kr.ohyung.navigation.utility.toast

internal class UserProfileFragment : Fragment() {

    private lateinit var binding: FragmentUserProfileBinding
    private val viewModel by viewModels<UserProfileViewModel> { getFactory() }

    private val args: UserProfileFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        viewModel.uiState.observe(viewLifecycleOwner, Observer(::updateUi))

        return binding.root
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
