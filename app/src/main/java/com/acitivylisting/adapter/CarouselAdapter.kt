package com.acitivylisting.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acitivylisting.R
import com.acitivylisting.interfaces.ViewHolderType
import com.acitivylisting.viewholder.EditorialCarouselItemViewHolder
import com.activitylisting.common.utils.Utils
import com.activitylisting.domain.entity.CarouselEntity

/**
 * @Author rahulravindran
 */
class CarouselAdapter(val carouselItems: List<CarouselEntity>) :
    RecyclerView.Adapter<EditorialCarouselItemViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(Utils.application)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditorialCarouselItemViewHolder {
        val rootView = inflater.inflate(R.layout.editorial_carousel_item, parent, false)
        return EditorialCarouselItemViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return carouselItems.size
    }

    override fun onBindViewHolder(holder: EditorialCarouselItemViewHolder, position: Int) {
        (holder as ViewHolderType).bind(carouselItems[position])
    }
}