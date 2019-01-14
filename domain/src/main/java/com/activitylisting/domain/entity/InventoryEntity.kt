package com.activitylisting.domain.entity

import java.io.Serializable

/**
 * @Author rahulravindran
 */
data class InventoryEntity(
    val startTime: String,
    val duration: Int,
    val reachesLocationIn: Int,
    val rating: Float,
    val nosRating: Int,
    val seats: InventorySeatsEntity,
    val bus: InventoryBusEntity
) : Serializable {

    companion object {
        val byTimeDesc = object : Comparator<InventoryEntity> {
            override fun compare(p0: InventoryEntity?, p1: InventoryEntity?): Int = when {
                p0?.component3()!! < p1?.component3()!! -> 1
                else -> -1
            }
        }
        val byTimeAsec = object : Comparator<InventoryEntity> {
            override fun compare(p0: InventoryEntity?, p1: InventoryEntity?): Int = when {
                p0?.component3()!! > p1?.component3()!! -> 1
                else -> -1
            }
        }

        val bypriceAsec = object : Comparator<InventoryEntity> {
            override fun compare(p0: InventoryEntity?, p1: InventoryEntity?): Int = when {
                p0?.component6()?.component2()!! > p1?.component6()?.component2()!! -> 1
                else -> -1
            }
        }
        val bypriceDesc = object : Comparator<InventoryEntity> {
            override fun compare(p0: InventoryEntity?, p1: InventoryEntity?): Int = when {
                p0?.component6()?.component2()!! < p1?.component6()?.component2()!! -> 1
                else -> -1
            }
        }


    }
}