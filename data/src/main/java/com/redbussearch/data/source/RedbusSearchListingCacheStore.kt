package com.redbussearch.data.source

import com.activitylisting.domain.entity.RedbusEntity
import com.redbussearch.data.store.RebusSearchCache
import com.redbussearch.data.store.RedbusSearchDataStore

/**
 * @Author rahulravindran
 */
class RedbusSearchListingCacheStore(val cacheStore: RebusSearchCache) : RedbusSearchDataStore {

    override fun clearSearchListing() {}

    override fun getSearchListing(): RedbusEntity {
        return cacheStore.getSearchListing()
    }

    override fun isCached(): Boolean {
        return false
    }
}