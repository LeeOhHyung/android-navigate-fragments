/*
 * Created by Lee Oh Hyoung on 2020/08/06 .. 
 */
package kr.ohyung.navigation.user

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.ohyung.common.extensions.toast
import kr.ohyung.common.extensions.viewBinding
import kr.ohyung.navigation.R
import kr.ohyung.navigation.base.BaseFragment
import kr.ohyung.navigation.databinding.FragmentUserProfileBinding
import kr.ohyung.navigation.utility.extension.load

@AndroidEntryPoint
internal class UserProfileFragment : BaseFragment<FragmentUserProfileBinding,
        UserProfileViewModel, UserProfileUiState>(R.layout.fragment_user_profile) {

    override val binding by viewBinding(FragmentUserProfileBinding::bind)
    override val viewModel by navGraphViewModels<UserProfileViewModel>(R.id.nav_graph) { defaultViewModelProviderFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.uiState.observe(viewLifecycleOwner, Observer(::render))
    }

    override fun render(state: UserProfileUiState) {
        when(state) {
            UserProfileUiState.Loading -> toast("Loading...")
            is UserProfileUiState.Failed -> toast(state.errorMessage)
            is UserProfileUiState.UserProfile -> {
                with(binding) {
                    profileImage.load(imageUrl = state.avatarUrl, placeHolder = R.drawable.octocat)
                    userName.text = state.userName
                    bio.text = state.bio
                    company.text = state.company
                    email.text = state.email
                }
            }
        }
    }
}
