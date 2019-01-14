package com.acitivylisting.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.acitivylisting.R
import com.activitylisting.common.basecommons.BaseFragment
import com.activitylisting.common.utils.Logger
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * @Author rahulravindran
 */
class ActivitiesFragment : BaseFragment(), Observer<Any> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_activitiy_listing, container, false)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        //subscribe to observer here
        super.setUserVisibleHint(isVisibleToUser)
    }

    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(t: Any) {
        if (isViewVisible) {
            //take data
        }
    }

    override fun onError(e: Throwable) {
        Logger.error(e)
        if (isViewVisible) {
            //decide what to do with error
        }
    }
}