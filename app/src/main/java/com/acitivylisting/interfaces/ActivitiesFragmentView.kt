package com.acitivylisting.interfaces

import com.activitylisting.common.interfaces.BaseView
import com.activitylisting.domain.entity.CarouselEntity
import com.activitylisting.domain.entity.CategoryEntity

interface ActivitiesFragmentView : BaseView {
    fun buildViewPager(categoriesList:List<CategoryEntity>?)
    fun buildCarousel(carouselList:List<CarouselEntity>?)
}