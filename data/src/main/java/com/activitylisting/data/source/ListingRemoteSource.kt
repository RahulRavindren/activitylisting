package com.activitylisting.data.source

import com.activitylisting.data.network.NetworkStoreImpl
import com.activitylisting.data.store.ListingDateStore
import com.activitylisting.domain.entity.ListingEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * @Author rahulravindran
 */
class ListingRemoteSource : ListingDateStore<ListingEntity> {
    var remoteStoreImpl: NetworkStoreImpl? = null

    override fun clearListing(): Completable {
        throw UnsupportedOperationException()
    }

    override fun getListing(): Flowable<ListingEntity> {
        if (remoteStoreImpl == null) {
            remoteStoreImpl = NetworkStoreImpl()
        }
        return remoteStoreImpl?.fetchListing()!!
    }

    override fun saveListing(data: Any): Completable {
        throw UnsupportedOperationException()

    }

    override fun isCached(): Single<Boolean> {
        throw UnsupportedOperationException()

    }
}