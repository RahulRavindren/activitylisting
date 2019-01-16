package com.activitylisting.data

import com.activitylisting.data.source.ListingCacheSource
import com.activitylisting.data.source.ListingRemoteSource
import com.activitylisting.data.store.ListingCacheStore
import com.activitylisting.data.store.ListingDateStore
import com.activitylisting.domain.entity.CategoryEntity
import com.activitylisting.domain.entity.CollectionEntity
import com.activitylisting.domain.entity.ListingEntity
import com.activitylisting.domain.repository.ListingRepository
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * @Author rahulravindran
 */
class ListingDataRepository(private val cacheStore:ListingCacheSource,
                            private val remoteStore:ListingRemoteSource
                            ): ListingRepository<ListingEntity> {

    override fun fetchLisiting(isCached: Boolean): Flowable<ListingEntity> {
        return cacheStore.isCached()
            .flatMapPublisher { t ->
                if (isCached && t)
                    cacheStore.getListing()
                else remoteStore.getListing()
            }
    }

}