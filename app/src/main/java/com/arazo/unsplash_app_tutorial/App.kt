package com.arazo.unsplash_app_tutorial

import android.app.Application

/**
 * Created by arazo on 2022-02-07.
 */
// AppCompatActivity가 아닌 경우에서 context를 가져올 경우
// 전역으로 사용할 수 있는 instance를 만듬
// 만든 후에 manifests에 추가 (android:name=".App")
class App : Application() {
	companion object {
		lateinit var instance: App
			private set
	}

	override fun onCreate() {
		super.onCreate()
		instance = this
	}
}