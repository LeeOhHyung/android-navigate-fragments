package kr.ohyung.navigation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.ohyung.common.extensions.viewBinding
import kr.ohyung.navigation.databinding.ActivityParentBinding
import kr.ohyung.navigation.splash.SplashFragmentArgs
import kr.ohyung.navigation.splash.SplashFragmentDirections

@AndroidEntryPoint
class ParentActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityParentBinding::inflate)
    internal val sharedViewModel by viewModels<SharedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val startArgs = SplashFragmentArgs(2500L).toBundle()
        findNavController(R.id.nav_host).setGraph(R.navigation.nav_graph, startArgs)
    }

    internal fun navigate(action: NavigationAction) =
        when(val navAction = action as? NavigationAction) {
            is NavigationAction.ToUserProfile -> {
                navigate(SplashFragmentDirections.toUserProfile(navAction.userName))
            }
            NavigationAction.Done -> finish()
            else -> throw IllegalStateException("this action is not a proper navigation action.")
        }

    private fun navigate(direction: NavDirections) = findNavController(R.id.nav_host).navigate(direction)
}
