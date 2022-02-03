package com.arazo.unsplash_app_tutorial.retrofit

import android.util.Log
import com.arazo.unsplash_app_tutorial.utils.API
import com.arazo.unsplash_app_tutorial.utils.Constants.TAG
import com.arazo.unsplash_app_tutorial.utils.RESPONSE_STATE
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response

/**
 * Created by arazo on 2022-02-03.
 */
class RetrofitManager {
	companion object {
		val instance = RetrofitManager()
	}

	// 레트로핏 인터페이스 가져오기
	private val retrofitInterface: RetrofitInterface? =
		RetrofitClient.getClient(API.BASE_URL)?.create(RetrofitInterface::class.java)

	// 사진 검색 api
	fun searchPhotos(searchTerm: String?, completion: (RESPONSE_STATE, String) -> Unit) {
		val term = searchTerm ?: ""

		val call = retrofitInterface?.searchPhotos(searchTerm = term) ?: return

		call.enqueue(object : retrofit2.Callback<JsonElement>{
			// 응답 성공시
			override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
				Log.d(TAG, "onResponse: called / response: ${response.raw()}")
				completion(RESPONSE_STATE.OKAY, response.body().toString())
			}

			// 응답 실패시
			override fun onFailure(call: Call<JsonElement>, t: Throwable) {
				Log.d(TAG, "onResponse: called / t: $t")
				completion(RESPONSE_STATE.FAIL, t.toString())
			}

		})
	}
}