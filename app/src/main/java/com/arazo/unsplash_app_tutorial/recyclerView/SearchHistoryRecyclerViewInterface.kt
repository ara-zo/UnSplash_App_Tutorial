package com.arazo.unsplash_app_tutorial.recyclerView

/**
 * Created by arazo on 2022-02-21.
 */
interface SearchHistoryRecyclerViewInterface {
	// 검색 아이템 삭제 버튼 클릭
	fun onSearchItemDeleteClicked(position: Int)

	// 검색 버튼 클릭
	fun onSearchItemClicked(position: Int)

}