/*
 * Created by Lee Oh Hyoung on 2020/08/06 .. 
 */
package kr.ohyung.navigation.user

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kr.ohyung.common.extensions.viewBinding
import kr.ohyung.navigation.R
import kr.ohyung.navigation.base.BaseFragment
import kr.ohyung.navigation.databinding.FragmentUserProfileBinding
import kr.ohyung.navigation.utility.toast

@AndroidEntryPoint
internal class UserProfileFragment : BaseFragment<FragmentUserProfileBinding,
        UserProfileViewModel, UserProfileUiState>(R.layout.fragment_user_profile) {

    override val binding by viewBinding(FragmentUserProfileBinding::bind)
    override val viewModel by viewModels<UserProfileViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.uiState.observe(viewLifecycleOwner, Observer(::render))
    }

    override fun render(state: UserProfileUiState) {
        when(state) {
            UserProfileUiState.Loading -> toast("Loading...")
            is UserProfileUiState.Failed -> toast(state.errorMessage)
            is UserProfileUiState.UserProfile -> {
                Glide.with(requireContext())
                    .load(state.avatarUrl)
                    .placeholder(R.drawable.octocat)
                    .into(binding.profileImage)

                binding.userName.text = state.userName
                binding.bio.text = state.bio
                binding.company.text = state.company
                binding.email.text = state.email
            }
        }
    }
}
