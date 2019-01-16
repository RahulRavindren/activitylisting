package com.activitylisting.domain.entity

import java.io.Serializable

/**
 * @Author rahulravindran
 */
data class IDEntity(
    val p: Map<String,String>,
    val cp: List<Int>
) : Serializable