package com.activitylisting.common.interfaces

import com.activitylisting.common.entity.PreferenceType

/**
 * @Author rahulravindran
 */
interface SavedPreference {
    fun getPreferenceType(): PreferenceType
    fun getName(): String
}