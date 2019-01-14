package com.redbussearch.data.remote.services

import com.activitylisting.domain.entity.RedbusEntity
import com.redbussearch.data.store.RedbusSearchRemote
import com.redbussearch.network.RetrofitAdapter
import io.reactivex.Flowable
import retrofit2.http.GET
import java.util.Collections.emptyList

/**
 * @Author rahulravindran
 */
interface BusResultService {

    @GET("/test/generated.json")
    fun fetchBusListingResults(): Flowable<RedbusEntity>
}

class FetchResultPageService() : RedbusSearchRemote {

    val apiservice = lazy {
        RetrofitAdapter.Factory()
            .getRestService(BusResultService::class.java, emptyList())
    }


    override fun getBusSearchListing(): RedbusEntity? {
        try {
            return apiservice.value.fetchBusListingResults().blockingSingle()
        } catch (e: Exception) {
            return null
        }
    }
}