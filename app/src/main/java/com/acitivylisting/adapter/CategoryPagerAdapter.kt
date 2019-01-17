package com.acitivylisting.adapter

import android.os.Bundle
import android.util.SparseArray
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.acitivylisting.fragments.CategoryListingFragment
import com.activitylisting.common.C
import com.activitylisting.common.basecommons.BaseFragment
import com.activitylisting.domain.entity.CategoryEntity


class CategoryPagerAdapter(val fm: FragmentManager?, val categories: List<CategoryEntity>?) : FragmentPagerAdapter(fm) {
    val arrayDict = SparseArray<BaseFragment>()

    override fun getItem(position: Int): Fragment {
        if (arrayDict[position] != null) {
            return arrayDict[position]
        }

        val category = categories?.get(position)
        val bundle = Bundle()
        bundle.putSerializable(C.CATEGORY_ENTITY, category)
        val fragment = CategoryListingFragment.getInstance(bundle)
        arrayDict.put(position, fragment)
        return fragment
    }

    override fun getCount(): Int {
        return categories?.size!!
    }

    fun getFragmentDataPair(position: Int): Pair<CategoryEntity?, Fragment?> {
        return Pair(categories?.get(position), arrayDict?.get(position))
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return categories?.get(position)?.name
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        arrayDict.remove(position)
        super.destroyItem(container, position, `object`)
    }
}