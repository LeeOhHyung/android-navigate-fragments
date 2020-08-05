package kr.ohyung.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import kr.ohyung.navigation.databinding.ActivityParentBinding
import kr.ohyung.navigation.shared.SharedViewModel

class ParentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityParentBinding
    internal val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
