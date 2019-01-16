package com.acitivylisting.presenter

import com.acitivylisting.interfaces.ActivitiesFragmentView
import com.activitylisting.common.basecommons.BasePresenter
import com.activitylisting.data.ListingDataRepository
import com.activitylisting.data.cache.CacheStoreImpl
import com.activitylisting.data.source.ListingCacheSource
import com.activitylisting.data.source.ListingRemoteSource
import com.activitylisting.domain.entity.CategoryEntity
import com.activitylisting.domain.entity.CollectionEntity
import com.activitylisting.domain.entity.ListingEntity
import io.reactivex.Flowable
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
        lisitingRepository = ListingDataRepository(
            ListingCacheSource(CacheStoreImpl()),
            ListingRemoteSource()
        )

    }

    override fun stop() {
        compositeDisposable.dispose()
    }

    fun subscribe(category:CategoryEntity?, consumer:Consumer<List<CollectionEntity>>) {
        compositeDisposable.add(lisitingRepository?.fetchLisiting(true)
            ?.flatMap{t -> Flowable.fromIterable(t.collections)}
            ?.filter { t -> t.categories.contains(category?.id)}
            ?.toList()?.subscribe(consumer)!!)
    }

    fun initialFetch() {
        compositeDisposable.add(lisitingRepository?.fetchLisiting(true)
            ?.subscribe { t: ListingEntity? -> run{
                view.buildCarousel(t?.editorial?.carousel)
                view.buildViewPager(t?.categories)
            }}!!)
    }


}