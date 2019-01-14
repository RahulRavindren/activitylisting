package com.activitylisting.domain.repository

import io.reactivex.Flowable

interface ListingRepository {
    fun fetchLisiting(): Flowable<Any>
}