package com.activitylisting.domain.entity

import java.io.Serializable

/**
 * @Author rahulravindran
 */
data class EditorialEntity(
    val ttd: IDEntity,
    val fitness: IDEntity,
    val fnb: IDEntity,
    val carousel: List<CarouselEntity>,
    val events: IDEntity
): Serializable