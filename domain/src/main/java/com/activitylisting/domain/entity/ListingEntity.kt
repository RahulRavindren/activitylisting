package com.activitylisting.domain.entity

import java.io.Serializable

/**
 * @Author rahulravindran
 */
data class ListingEntity(
    val editorial:EditorialEntity,
    val src:String,
    val sct:String,
    val collections:List<CollectionEntity>,
    val city: Map<String,String>,
    val categories:List<CategoryEntity>,
    val sid:String
): Serializable