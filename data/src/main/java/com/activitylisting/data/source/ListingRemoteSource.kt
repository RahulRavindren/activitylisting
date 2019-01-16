package com.activitylisting.data.source

import com.activitylisting.data.store.ListingDateStore
import com.activitylisting.domain.entity.CategoryEntity
import com.activitylisting.domain.entity.ListingEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.lang.UnsupportedOperationException

/**
 * @Author rahulravindran
 */
class ListingRemoteSource(): ListingDateStore<ListingEntity> {

    override fun clearListing(): Completable {
        throw UnsupportedOperationException()
    }

    override fun getListing(): Flowable<ListingEntity> {
        throw UnsupportedOperationException()
    }

    override fun saveListing(data: Any): Completable {
        throw UnsupportedOperationException()

    }

    override fun isCached(): Single<Boolean> {
        throw UnsupportedOperationException()

    }
}