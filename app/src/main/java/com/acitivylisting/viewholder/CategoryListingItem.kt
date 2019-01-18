package com.acitivylisting.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.acitivylisting.interfaces.ViewHolderType
import com.activitylisting.common.utils.Image
import com.activitylisting.domain.entity.CollectionEntity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.collection_listing_item.*

/**
 * @Author rahulravindran
 */
class CategoryListingItem(val view: View) : RecyclerView.ViewHolder(view), ViewHolderType, LayoutContainer {

    override fun bind(data: Any) {
        val listingEntity = data as CollectionEntity
        listing_item_title.setText(listingEntity.collectionName)
        listing_item_subtitle.setText(listingEntity.countText)

        Image.load(listingEntity.image, listing_item_image)
    }

    override val containerView: View?
        get() = view
}