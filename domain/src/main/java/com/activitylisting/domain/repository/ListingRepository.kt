package com.activitylisting.domain.repository

import com.activitylisting.domain.entity.CategoryEntity
import io.reactivex.Single

interface ListingRepository<T>{
    fun fetchLisiting(categoryEntity: CategoryEntity?, isCached: Boolean): Single<T>
}