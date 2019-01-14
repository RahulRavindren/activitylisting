package com.acitivylisting.adapter

import android.util.SparseArray
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.activitylisting.common.basecommons.BaseFragment


class CategoryPagerAdapter(val fm: FragmentManager, val categories: List<Any>) : FragmentPagerAdapter(fm) {
    val arrayDict = SparseArray<BaseFragment>()

    override fun getItem(position: Int): Fragment {
        return Fragment()
    }

    override fun getCount(): Int {
        return categories.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        arrayDict.remove(position)
        super.destroyItem(container, position, `object`)
    }
}