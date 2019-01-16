package com.activitylisting.domain.repository

import com.activitylisting.domain.entity.CategoryEntity
import io.reactivex.Flowable

interface ListingRepository<T>{
    fun fetchLisiting(isCached:Boolean): Flowable<T>
}