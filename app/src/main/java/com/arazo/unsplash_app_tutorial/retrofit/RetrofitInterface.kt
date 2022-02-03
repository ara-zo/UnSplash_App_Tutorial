package com.arazo.unsplash_app_tutorial.retrofit

import com.arazo.unsplash_app_tutorial.utils.API
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by arazo on 2022-02-03.
 */
interface RetrofitInterface {

	// https://www.unsplash.com/search/photos/?query="{searchTerm}'
	@GET(API.SEARCH_PHOTO)
	fun searchPhotos(@Query("query") searchTerm: String): Call<JsonElement>

	@GET(API.SEARCH_USERS)
	fun searchUsers(@Query("query") searchTerm: String): Call<JsonElement>
}