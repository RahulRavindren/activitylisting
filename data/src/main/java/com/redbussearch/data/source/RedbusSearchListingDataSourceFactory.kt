package com.redbussearch.data.source

import com.redbussearch.data.store.RebusSearchCache
import com.redbussearch.data.store.RedbusSearchDataStore

/**
 * @Author rahulravindran
 */
open class RedbusSearchListingDataSourceFactory(
    private val cache: RebusSearchCache,
    private val cacheStore: RedbusSearchListingCacheStore,
    private val remoteStore: RedbusSearchListingRemoteStore
) {

    open fun retrieveSearchListingStore(isCached: Boolean): RedbusSearchDataStore {
        if (isCached && !cache.isExpired()) {
            return retrieveSearchListingCache()
        }
        return retrieveSearchListingRemote()
    }


    open fun retrieveSearchListingCache(): RedbusSearchListingCacheStore {
        return cacheStore
    }

    open fun retrieveSearchListingRemote(): RedbusSearchListingRemoteStore {
        return remoteStore
    }
}