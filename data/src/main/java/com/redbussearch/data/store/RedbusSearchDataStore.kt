package com.redbussearch.data.store

import com.activitylisting.domain.entity.RedbusEntity

/**
 * @Author rahulravindran
 */
interface RedbusSearchDataStore {
    fun clearSearchListing()
    fun getSearchListing(): RedbusEntity?
    fun isCached(): Boolean
}