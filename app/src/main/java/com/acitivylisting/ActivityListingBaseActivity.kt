package com.acitivylisting

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigator
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.activitylisting.common.basecommons.BaseActivity
import kotlinx.android.synthetic.main.activity_base_listing.*

/**
 * @Author rahulravindran
 */
class ActivityListingBaseActivity : BaseActivity(), Navigator.OnNavigatorBackPressListener {
    private var hostFragment:Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_listing)
        setupNavController()
    }

    override fun onStart() {
        super.onStart()
    }

    private fun setupNavController() {
        val hostFragment = NavHostFragment.create(R.navigation.bottom_navigation)
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, hostFragment)
            .setPrimaryNavigationFragment(hostFragment)
            .commitNow()

        hostFragment.navController.let {
            NavigationUI.setupWithNavController(bottom_nav_frag, hostFragment.navController)
            bottom_nav_frag.setOnNavigationItemSelectedListener { item ->
                when(item.itemId) {
                    R.id.activities_menu -> {
                        hostFragment.navController.navigate(R.id.activitites_frag)
                        true
                    }
                    R.id.eatout_menu -> {
                        hostFragment.navController.navigate(R.id.eat_out_frag)
                        true
                    }
                    R.id.events_menu -> {
                        hostFragment.navController.navigate(R.id.events_frag)
                        true
                    }
                    R.id.you_menu -> {
                        hostFragment.navController.navigate(R.id.you_frag)
                        true
                    }
                    else -> false
                }
            }
        }
    }


    override fun onPopBackStack(navigator: Navigator<*>) {
        // kill activity if backpressed
        finish()
    }


}