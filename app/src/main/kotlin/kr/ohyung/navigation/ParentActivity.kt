package kr.ohyung.navigation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import kr.ohyung.navigation.databinding.ActivityParentBinding
import kr.ohyung.navigation.land.LandingFragmentArgs
import kr.ohyung.navigation.land.LandingFragmentDirections
import kr.ohyung.navigation.shared.NavigationAction
import kr.ohyung.navigation.shared.SharedViewModel
import kr.ohyung.navigation.shared.SharedViewModelFactory
import kr.ohyung.navigation.utility.viewBinding

class ParentActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityParentBinding::inflate)
    private val backendConfiguration = BackendConfiguration(BuildConfig.BASE_URL)
    internal val sharedViewModel: SharedViewModel by viewModels { SharedViewModelFactory(backendConfiguration) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val startArgs = LandingFragmentArgs(LANDING_DURATION).toBundle()
        findNavController(R.id.nav_host).setGraph(R.navigation.nav_graph, startArgs)

        sharedViewModel.navigationAction.observe(this, Observer(::navigate))
    }

    private fun navigate(action: NavigationAction) =
        when(action) {
            is NavigationAction.ToUserProfile -> {
                navigate(LandingFragmentDirections.toUserProfile(action.userName))
            }
            NavigationAction.Done -> finish()
        }

    private fun navigate(direction: NavDirections) = findNavController(R.id.nav_host).navigate(direction)

    companion object {

        private const val LANDING_DURATION = 2500L
    }
}
