package com.activitylisting.domain.entity

import java.io.Serializable

/**
 * @Author rahulravindran
 */
data class InventorySeatsEntity(
    val seatsRemaining: Int,
    val baseFare: Int,
    val discount: Int
) : Serializable