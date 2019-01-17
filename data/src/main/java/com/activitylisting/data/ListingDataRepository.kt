package com.activitylisting.data

import com.activitylisting.data.source.ListingCacheSource
import com.activitylisting.domain.entity.CategoryEntity
import com.activitylisting.domain.entity.ListingEntity
import com.activitylisting.domain.repository.ListingRepository
import io.reactivex.Single

/**
 * @Author rahulravindran
 */
class ListingDataRepository(
    private val cacheStore: ListingCacheSource
                            ): ListingRepository<ListingEntity> {

    override fun fetchLisiting(categoryEntity: CategoryEntity?, isCached: Boolean): Single<ListingEntity> {
        return cacheStore.getListing(categoryEntity)
    }

}