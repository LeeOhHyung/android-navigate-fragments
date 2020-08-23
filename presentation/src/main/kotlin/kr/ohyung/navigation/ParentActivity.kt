package kr.ohyung.navigation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.ohyung.navigation.databinding.ActivityParentBinding
import kr.ohyung.navigation.land.LandingFragmentArgs
import kr.ohyung.navigation.land.LandingFragmentDirections
import kr.ohyung.navigation.shared.NavigationAction
import kr.ohyung.navigation.shared.SharedViewModel
import kr.ohyung.navigation.utility.viewBinding

@AndroidEntryPoint
class ParentActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityParentBinding::inflate)
    internal val sharedViewModel by viewModels<SharedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val startArgs = LandingFragmentArgs(2500L).toBundle()
        findNavController(R.id.nav_host).setGraph(R.navigation.nav_graph, startArgs)
    }

    internal fun navigate(action: NavigationAction) =
        when(action) {
            is NavigationAction.ToUserProfile -> {
                navigate(LandingFragmentDirections.toUserProfile(action.userName))
            }
            NavigationAction.Done -> finish()
        }

    private fun navigate(direction: NavDirections) = findNavController(R.id.nav_host).navigate(direction)
}