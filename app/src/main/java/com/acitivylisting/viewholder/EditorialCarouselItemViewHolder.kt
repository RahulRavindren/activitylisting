package com.acitivylisting.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.acitivylisting.interfaces.ViewHolderType
import com.activitylisting.common.utils.Image
import com.activitylisting.domain.entity.CarouselEntity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.editorial_carousel_item.*

/**
 * @Author rahulravindran
 */
class EditorialCarouselItemViewHolder(val view: View) : RecyclerView.ViewHolder(view), ViewHolderType, LayoutContainer {

    override fun bind(data: Any) {
        val carouselItem = data as CarouselEntity
        editorial_carousel_item_title.setText(carouselItem.title)
        editorail_carousel_item_subtitle.setText(carouselItem.subTitle)

        Image.load(carouselItem.images[0].img, editorial_carousel_item_image)
    }

    override val containerView: View?
        get() = view
}