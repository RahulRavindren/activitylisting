package com.redbussearch.data.source

import com.activitylisting.domain.entity.RedbusEntity
import com.redbussearch.data.store.RedbusSearchDataStore
import com.redbussearch.data.store.RedbusSearchRemote

/**
 * @Author rahulravindran
 */
class RedbusSearchListingRemoteStore(val redbusremote: RedbusSearchRemote) : RedbusSearchDataStore {

    override fun getSearchListing(): RedbusEntity? {
        return redbusremote.getBusSearchListing()
    }

    override fun clearSearchListing() {
        throw  UnsupportedOperationException()
    }

    override fun isCached(): Boolean {
        throw UnsupportedOperationException()
    }

}