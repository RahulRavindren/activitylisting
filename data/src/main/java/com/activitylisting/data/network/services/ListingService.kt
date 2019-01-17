package com.activitylisting.data.network.services

import com.activitylisting.domain.entity.ListingEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Author rahulravindran
 */
interface ListingService {

    @GET("/local/api/v1/ttd/search")
    fun getLisiting(@Query("sct") sct:String = "IN",
                    @Query("editorial") editorial:Boolean = true,
                    @Query("city") city:String = "chennai",
                    @Query("scr") scr: String = "INR"
    ): Single<ListingEntity>
}