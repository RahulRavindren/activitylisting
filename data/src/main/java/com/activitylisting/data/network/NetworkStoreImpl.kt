package com.activitylisting.data.network

import com.activitylisting.data.network.services.ListingService
import com.activitylisting.domain.entity.ListingEntity
import com.redbussearch.cache.RequestHandler
import com.redbussearch.network.RetrofitAdapter
import io.reactivex.Single

/**
 * @Author rahulravindran
 */
class NetworkStoreImpl : RequestHandler<ListingEntity> {

    override fun request(): Single<ListingEntity> {
        return RetrofitAdapter.Factory()
            .getRestService(ListingService::class.java, listOf())
            .getLisiting()
    }
}