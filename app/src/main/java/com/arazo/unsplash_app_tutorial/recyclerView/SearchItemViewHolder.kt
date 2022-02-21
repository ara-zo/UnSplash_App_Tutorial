package com.arazo.unsplash_app_tutorial.recyclerView

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.arazo.unsplash_app_tutorial.model.SearchData
import com.arazo.unsplash_app_tutorial.utils.Constants.TAG
import kotlinx.android.synthetic.main.layout_search_item.view.*

/**
 * Created by arazo on 2022-02-10.
 */
class SearchItemViewHolder(
	itemView: View,
	searchHistoryRecyclerViewInterface: SearchHistoryRecyclerViewInterface,
) : RecyclerView.ViewHolder(itemView),
	View.OnClickListener {

	private lateinit var mySearchHistoryRecyclerViewInterface: SearchHistoryRecyclerViewInterface


	// 뷰 가져오기
	private val searchTermTextView = itemView.search_term_text
	private val whenSearchTextView = itemView.when_searched_text
	private val deleteSearchBtn = itemView.delete_search_button
	private val constrintSearchItem = itemView.constraint_search_item

	init {
		Log.d(TAG, "SearchItemViewHolder - init() called")
		// 리스너 연결
		deleteSearchBtn.setOnClickListener(this)
		constrintSearchItem.setOnClickListener(this)
		this.mySearchHistoryRecyclerViewInterface = searchHistoryRecyclerViewInterface
	}

	// 데이터와 뷰를 묶는다.
	fun bindWithView(searchItem: SearchData) {
		Log.d(TAG, "SearchItemViewHolder - bindWithView() called")

		whenSearchTextView.text = searchItem.timeStamp

		searchTermTextView.text = searchItem.term
	}

	override fun onClick(view: View?) {
		Log.d(TAG, "SearchItemViewHolder - onClick() called")

		when (view) {
			deleteSearchBtn -> {
				Log.d(TAG, "SearchItemViewHolder - onClick() called / 검색 삭제 버튼 클릭")
				this.mySearchHistoryRecyclerViewInterface.onSearchItemDeleteClicked(adapterPosition)
			}
			constrintSearchItem -> {
				Log.d(TAG, "SearchItemViewHolder - onClick() called / 검색 아이템 클릭")
				this.mySearchHistoryRecyclerViewInterface.onSearchItemClicked(adapterPosition)
			}
		}
	}
}