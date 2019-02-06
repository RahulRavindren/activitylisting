package com.acitivylisting.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.acitivylisting.R
import com.acitivylisting.adapter.CategoryListingAdapter
import com.activitylisting.common.C
import com.activitylisting.common.basecommons.BaseFragment
import com.activitylisting.domain.entity.CategoryEntity
import com.activitylisting.domain.entity.CollectionEntity
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.fragment_category_listing.*

/**
 * @Author rahulravindran
 */
class CategoryListingFragment : BaseFragment(), Consumer<List<CollectionEntity>> {

    companion object {
        fun getInstance(bundle: Bundle): CategoryListingFragment {
            val fragment = CategoryListingFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val category = arguments?.getSerializable(C.CATEGORY_ENTITY) as CategoryEntity

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category_listing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initList()
    }

    private fun initList() {
        category_list.apply {
            layoutManager = GridLayoutManager(context, 2).apply {
                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        if (position % 3 == 0) {
                            return 2
                        }
                        return 1
                    }
                }
            }
        }

    }

    override fun accept(t: List<CollectionEntity>?) {
        if (!t.isNullOrEmpty() && isViewVisible) {
            category_list.adapter = CategoryListingAdapter(t)
        }
    }

}