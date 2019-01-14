package com.acitivylisting

import android.os.Bundle
import androidx.navigation.Navigator
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.activitylisting.common.basecommons.BaseActivity
import kotlinx.android.synthetic.main.activity_base_listing.*
/**
 * @Author rahulravindran
 */
class ActivityListingBaseActivity: BaseActivity(), Navigator.OnNavigatorBackPressListener{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_listing)

        setupNavController()
    }

    private fun setupNavController() {
        val hostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(bottom_nav_frag, hostFragment.navController)
        bottom_nav_frag.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.activitites_frag -> {
                    hostFragment.navController.navigate(R.id.activitites_frag)
                    true
                }
                R.id.eat_out_frag -> {
                    hostFragment.navController.navigate(R.id.eat_out_frag)
                    true
                }
                R.id.events_frag -> {
                    hostFragment.navController.navigate(R.id.events_frag)
                    true
                }
                R.id.you_frag -> {
                    hostFragment.navController.navigate(R.id.you_frag)
                    true
                }
                else -> false
            }
        }
    }


    override fun onPopBackStack(navigator: Navigator<*>) {
        // kill activity if backpressed
        finish()
    }
}