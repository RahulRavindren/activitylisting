package com.activitylisting.domain.entity

import java.io.Serializable

/**
 * @Author rahulravindran
 */
data class RedbusEntity(
    val inventory: List<InventoryEntity>,
    val busType: Map<String, String>,
    val travels: Map<String, String>
) : Serializable