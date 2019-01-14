package com.activitylisting.common.basecommons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.activitylisting.common.interfaces.BaseView
import kotlinx.android.synthetic.main.base_activity_layout.*
import kotlinx.android.synthetic.main.toolbar.*
import surveyapp.com.common.R

/**
 * @Author rahulravindran
 */
open class BaseActivity: AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.base_activity_layout)
    }

    override fun setContentView(layoutResID: Int) {
        if (layoutResID != View.NO_ID) {
            val infalter = LayoutInflater.from(baseContext)
                    .inflate(layoutResID, null, false)
            base_view_container.addView(infalter)
        }
    }


    protected fun initToolbar(status: Boolean) {
        if(status) {
            setSupportActionBar(app_toolbar)
            val supportActionBar = supportActionBar
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeButtonEnabled(true)
        }
    }

    override fun setContentView(view: View?) {
        base_view_container.removeView(view)
        base_view_container.addView(view)
    }

    override fun showProgress(state: Boolean) {
        base_view_container.visibility = if (state) View.GONE else View.VISIBLE
        base_view_progress.visibility = if (state) View.VISIBLE else View.GONE

    }

    override fun showErrorPage(state: Boolean) {
        base_view_container.visibility = if (state) View.GONE else View.VISIBLE
        base_view_progress.visibility = if (state) View.GONE else View.VISIBLE
        base_view_error_layout_container.visibility = if (state) View.VISIBLE else View.GONE
    }

}