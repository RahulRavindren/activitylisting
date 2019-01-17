package com.acitivylisting.presenter

import com.acitivylisting.interfaces.ActivitiesFragmentView
import com.activitylisting.common.basecommons.BasePresenter
import com.activitylisting.data.ListingDataRepository
import com.activitylisting.data.cache.CacheStoreImpl
import com.activitylisting.data.source.ListingCacheSource
import com.activitylisting.domain.entity.CategoryEntity
import com.activitylisting.domain.entity.CollectionEntity
import com.activitylisting.domain.entity.ListingEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer

class ActivityListingPresenter(val view: ActivitiesFragmentView) : BasePresenter() {
    private var lisitingRepository:ListingDataRepository? = null
    private var compositeDisposable = CompositeDisposable()

    override fun start() {
        initRepository()
        initialFetch()
    }

    private fun initRepository() {
        lisitingRepository = ListingDataRepository(ListingCacheSource(CacheStoreImpl()))
    }

    override fun stop() {
        compositeDisposable.dispose()
    }

    fun subscribe(category:CategoryEntity?, consumer:Consumer<List<CollectionEntity>>) {
        compositeDisposable.add(lisitingRepository?.fetchLisiting(category, true)
            ?.flattenAsFlowable { it.collections }
            ?.filter { t ->
                if (t.categories != null) {
                    t.categories.contains(category?.id)
                } else {
                    false
                }
            }
            ?.toList()
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(consumer)!!)
    }

    fun initialFetch() {
        compositeDisposable.add(
            lisitingRepository?.fetchLisiting(null, false)
                ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe { t: ListingEntity? -> run{
                view.buildCarousel(t?.editorial?.carousel)
                view.buildViewPager(t?.categories)
            }}!!)
    }


}