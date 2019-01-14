package com.activitylisting.common.annotations

import kotlin.reflect.KClass

/**
 * @Author rahulravindran
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class DomainViewModel(val param: KClass<*>)