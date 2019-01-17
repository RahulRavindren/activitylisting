package com.acitivylisting.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.acitivylisting.R
import com.activitylisting.common.basecommons.BaseFragment

/**
 * @Author rahulravindran
 */
class EatOutFragment: BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_empty, container, false)
    }
}