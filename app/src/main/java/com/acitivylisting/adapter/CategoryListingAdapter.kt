package com.acitivylisting.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acitivylisting.R
import com.acitivylisting.interfaces.ViewHolderType
import com.acitivylisting.viewholder.CategoryListingItem
import com.activitylisting.common.utils.Utils
import com.activitylisting.domain.entity.CollectionEntity

/**
 * @Author rahulravindran
 */
class CategoryListingAdapter(val listing: List<CollectionEntity>) : RecyclerView.Adapter<CategoryListingItem>() {
    val inflater: LayoutInflater = lazy {
        LayoutInflater.from(Utils.application)
    }.value

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListingItem {
        val rootView = inflater.inflate(R.layout.collection_listing_item, parent, false)
        return CategoryListingItem(rootView)
    }

    override fun getItemCount(): Int {
        return listing.size
    }

    override fun onBindViewHolder(holder: CategoryListingItem, position: Int) {
        (holder as ViewHolderType?)?.bind(listing.get(position))
    }
}