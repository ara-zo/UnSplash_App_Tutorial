package com.arazo.unsplash_app_tutorial.recyclerView

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arazo.unsplash_app_tutorial.R
import com.arazo.unsplash_app_tutorial.model.SearchData
import com.arazo.unsplash_app_tutorial.utils.Constants.TAG

/**
 * Created by arazo on 2022-02-10.
 */
class SearchHistoryRecyclerViewAdapter(searchHistoryRecyclerViewInterface: SearchHistoryRecyclerViewInterface) : RecyclerView.Adapter<SearchItemViewHolder>() {

	private var searchHistoryList: ArrayList<SearchData> = ArrayList()

	private var searchHistoryRecyclerViewInterface: SearchHistoryRecyclerViewInterface? = null

	init {
		Log.d(TAG, "SearchHistoryRecyclerViewAdapter - init() called")
		this.searchHistoryRecyclerViewInterface = searchHistoryRecyclerViewInterface
	}

	// 뷰홀더가 메모리에 올라갔을때
	// 뷰홀더와 레이아웃을 연결 시켜준다.
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchItemViewHolder {
		val searchItemViewHolder = SearchItemViewHolder(
			LayoutInflater
				.from(parent.context)
				.inflate(R.layout.layout_search_item, parent, false)
				, this.searchHistoryRecyclerViewInterface!!
		)

		return searchItemViewHolder
	}

	override fun onBindViewHolder(holder: SearchItemViewHolder, position: Int) {
		val dataItem: SearchData = this.searchHistoryList[position]

		holder.bindWithView(dataItem)
	}

	override fun getItemCount(): Int {
		return searchHistoryList.size
	}

	// 외부에서 어답터에 데이터 배열을 넣어준다.
	fun submitList(searchHistoryList: ArrayList<SearchData>) {
		this.searchHistoryList = searchHistoryList
	}
}