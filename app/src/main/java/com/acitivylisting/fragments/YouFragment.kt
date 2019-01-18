package com.acitivylisting.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.acitivylisting.R
import com.activitylisting.common.basecommons.BaseFragment
import com.activitylisting.common.utils.Utils
import kotlinx.android.synthetic.main.fragment_you.*

/**
 * @Author rahulravindran
 */
class YouFragment: BaseFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_you, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message_greet.setText(
            Utils.getString(R.string.morning_messsage),
            resources.getColor(R.color.colorPrimaryDark), resources.getColor(android.R.color.white)
        )
    }
}