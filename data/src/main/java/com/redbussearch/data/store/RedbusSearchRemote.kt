package com.redbussearch.data.store

import com.activitylisting.domain.entity.RedbusEntity

/**
 * @Author rahulravindran
 */
interface RedbusSearchRemote {
    fun getBusSearchListing(): RedbusEntity?
}