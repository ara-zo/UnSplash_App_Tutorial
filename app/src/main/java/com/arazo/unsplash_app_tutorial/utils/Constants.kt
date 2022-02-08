package com.arazo.unsplash_app_tutorial.utils

/**
 * Created by arazo on 2022-02-03.
 */
object Constants {
	const val TAG: String = "로그"
}

enum class SEARCH_TYPE {
	PHOTO,
	USER,
}

enum class RESPONSE_STATUS {
	OKAY,
	FAIL,
	NO_CONTENT,
}

object API {
	const val BASE_URL : String = "https://api.unsplash.com/"

	// TODO commit전에 CLIENT_ID 값 지우기!
	const val CLIENT_ID : String = ""

	const val SEARCH_PHOTO: String = "search/photos"
	const val SEARCH_USERS: String = "search/users"
}