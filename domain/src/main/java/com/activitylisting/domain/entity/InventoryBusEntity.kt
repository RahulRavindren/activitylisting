package com.activitylisting.domain.entity

import java.io.Serializable

/**
 * @Author rahulravindran
 */
data class InventoryBusEntity(
    val travelsName: Int,
    val regno: String,
    val type: Int
) : Serializable