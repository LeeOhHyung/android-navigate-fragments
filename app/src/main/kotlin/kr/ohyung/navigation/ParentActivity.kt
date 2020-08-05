package kr.ohyung.navigation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import kr.ohyung.navigation.databinding.ActivityParentBinding
import kr.ohyung.navigation.land.LandingFragmentArgs
import kr.ohyung.navigation.shared.NavigationAction
import kr.ohyung.navigation.shared.SharedViewModel
import kr.ohyung.navigation.shared.SharedViewModelFactory

class ParentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityParentBinding
    internal val sharedViewModel: SharedViewModel by viewModels { SharedViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val startArgs = LandingFragmentArgs(LANDING_DURATION).toBundle()
        findNavController(R.id.nav_host).setGraph(R.navigation.nav_graph, startArgs)

        sharedViewModel.navigationAction.observe(this, Observer(::navigate))
    }

    private fun navigate(action: NavigationAction) = when(action) {
        else -> { /* explicitly empty */ }
    }

    private fun navigate(direction: NavDirections) = findNavController(R.id.nav_host).navigate(direction)

    companion object {

        private const val LANDING_DURATION = 2500L
    }
}
