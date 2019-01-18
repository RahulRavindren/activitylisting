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
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.carousel_container.*
import kotlinx.android.synthetic.main.fragment_activitiy_listing.*

/**
 * @Author rahulravindran
 */
class ActivitiesFragment : BaseFragment(), ActivitiesFragmentView {
    private var mPresenter:ActivityListingPresenter? = null
    private lateinit var mPagerAdapter: CategoryPagerAdapter

    private val pageSelectedListener = object: ViewPager.OnPageChangeListener{
        override fun onPageScrollStateChanged(state: Int) {

        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

        }

        override fun onPageSelected(position: Int) {
            if (!::mPagerAdapter.isInitialized) {
                return
            }

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
        if (!::mPagerAdapter.isInitialized) {
            mPagerAdapter = CategoryPagerAdapter(fragmentManager,
                categoriesList?.sortedBy { categoryEntity -> categoryEntity.name })
            category_viewpager.offscreenPageLimit = 1
            category_viewpager.adapter = mPagerAdapter
            mPagerAdapter.notifyDataSetChanged()
            category_tabs.setupWithViewPager(category_viewpager)
            category_viewpager.addOnPageChangeListener(pageSelectedListener)
            showProgress(false)

            category_viewpager.postDelayed(object : Runnable {
                override fun run() {
                    pageSelectedListener?.onPageSelected(0)
                }
            }, 1000)
        }

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
        activities_app_bar_layout.visibility = if (state) View.GONE else View.VISIBLE
        loading_progress.visibility = if (state) View.VISIBLE else View.GONE
        category_viewpager.visibility = if (state) View.GONE else View.VISIBLE
    }

    override fun showErrorPage(state: Boolean) {

    }
}