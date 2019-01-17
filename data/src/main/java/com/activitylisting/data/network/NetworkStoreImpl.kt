package com.activitylisting.data.network

import com.activitylisting.data.network.services.ListingService
import com.activitylisting.data.store.ListingRemoteSource
import com.activitylisting.domain.entity.ListingEntity
import com.redbussearch.network.RetrofitAdapter
import io.reactivex.Flowable

/**
 * @Author rahulravindran
 */
class NetworkStoreImpl : ListingRemoteSource<ListingEntity> {

    override fun fetchListing(): Flowable<ListingEntity> {
        return RetrofitAdapter.Factory()
            .getRestService(ListingService::class.java, listOf())
            .getLisiting()
    }
}