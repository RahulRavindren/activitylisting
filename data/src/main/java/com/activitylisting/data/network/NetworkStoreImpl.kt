package com.activitylisting.data.network

import com.activitylisting.data.store.ListingRemoteSource
import com.activitylisting.domain.entity.CollectionEntity
import com.redbussearch.network.RetrofitAdapter
import com.activitylisting.data.network.services.ListingService
import com.activitylisting.domain.entity.ListingEntity
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * @Author rahulravindran
 */
class NetworkStoreImpl : ListingRemoteSource<ListingEntity>{

    override fun fetchListing(): Flowable<ListingEntity> {
        return RetrofitAdapter.Factory()
            .getRestService(ListingService::class.java, listOf())
            .getLisiting()
    }
}