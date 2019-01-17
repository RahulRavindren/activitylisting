package com.acitivylisting.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.viewpager.widget.ViewPager
import com.acitivylisting.R
import com.acitivylisting.adapter.CarouselAdapter
import com.acitivylisting.adapter.CategoryPagerAdapter
import com.acitivylisting.interfaces.ActivitiesFragmentView
import com.acitivylisting.presenter.ActivityListingPresenter
import com.activitylisting.common.basecommons.BaseFragment
import com.activitylisting.domain.entity.CarouselEntity
import com.activitylisting.domain.entity.CategoryEntity
import com.activitylisting.domain.entity.CollectionEntity
import com.google.android.material.tabs.TabLayout
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.carousel_container.*
import kotlinx.android.synthetic.main.fragment_activitiy_listing.*

/**
 * @Author rahulravindran
 */
class ActivitiesFragment : BaseFragment(), ActivitiesFragmentView {
    private var mPresenter:ActivityListingPresenter? = null
    private var mPagerAdapter: CategoryPagerAdapter? = null

    private val pageSelectedListener = object: ViewPager.OnPageChangeListener{
        override fun onPageScrollStateChanged(state: Int) {

        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

        }

        override fun onPageSelected(position: Int) {
            val fragment = mPagerAdapter?.getFragmentDataPair(position)
            if (fragment?.first != null && fragment?.second != null) {
                mPresenter?.subscribe(fragment.first, fragment.second as Consumer<List<CollectionEntity>>)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = ActivityListingPresenter(this).apply {
            start()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_activitiy_listing, container, false)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        //subscribe to observer here
        super.setUserVisibleHint(isVisibleToUser)
    }


    override fun buildViewPager(categoriesList: List<CategoryEntity>?) {
        mPagerAdapter = CategoryPagerAdapter(fragmentManager, categoriesList)
        category_viewpager.adapter = mPagerAdapter
        category_tabs.setupWithViewPager(category_viewpager)
        category_viewpager.addOnPageChangeListener(pageSelectedListener)

        //disable tab selection
        category_tabs.setOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {}

            override fun onTabUnselected(p0: TabLayout.Tab?) {}

            override fun onTabSelected(p0: TabLayout.Tab?) {}
        })
    }

    override fun buildCarousel(carouselList: List<CarouselEntity>?) {
        //build carousel
        featured_list.apply {
            adapter = CarouselAdapter(carouselList!!)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        val pagerSnaper = PagerSnapHelper()
        pagerSnaper.attachToRecyclerView(featured_list)
    }

    override fun showProgress(state: Boolean) {
        //show progress
    }

    override fun showErrorPage(state: Boolean) {

    }
}