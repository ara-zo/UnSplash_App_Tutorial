package com.arazo.unsplash_app_tutorial

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.arazo.unsplash_app_tutorial.retrofit.RetrofitManager
import com.arazo.unsplash_app_tutorial.utils.Constants.TAG
import com.arazo.unsplash_app_tutorial.utils.RESPONSE_STATE
import com.arazo.unsplash_app_tutorial.utils.SEARCH_TYPE
import com.arazo.unsplash_app_tutorial.utils.onMyTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_button_search.*

class MainActivity : AppCompatActivity() {

	private var currentSearchType: SEARCH_TYPE = SEARCH_TYPE.PHOTO

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

		Log.d(TAG, "onCreate: called")

		// 라디오 그룹 가져오기
		search_term_radio_group.setOnCheckedChangeListener { _, checkedId ->
			when (checkedId) {
				R.id.photo_search_radio_btn -> {
					Log.d(TAG, "onCreate: 사진검색 버튼 클릭!")
					search_term_text_layout.hint = "사진검색"
					search_term_text_layout.startIconDrawable =
						resources.getDrawable(R.drawable.ic_baseline_photo_library_24,
							resources.newTheme())
					this.currentSearchType = SEARCH_TYPE.PHOTO
				}
				R.id.user_search_radio_btn -> {
					Log.d(TAG, "onCreate: 사용자검색 버튼 클릭!")
					search_term_text_layout.hint = "사용자검색"
					search_term_text_layout.startIconDrawable =
						resources.getDrawable(R.drawable.ic_baseline_person_24,
							resources.newTheme())
					this.currentSearchType = SEARCH_TYPE.USER
				}
			}
			Log.d(TAG, "onCheckedChange() called / currentSearchType: $currentSearchType")
		}

		// 텍스트가 변경이 되었을때
		search_term_edit_text.onMyTextChanged {
			// 입력된 글자가 하나라도 있다면
			if (it.toString().count() > 0) {
				// 검색 버튼을 보여준다.
				frame_search_btn.visibility = View.VISIBLE
				search_term_text_layout.helperText = ""

				// 스크롤뷰를 올린다.
				main_scrollview.scrollTo(0, 200)

			} else {
				frame_search_btn.visibility = View.INVISIBLE
				search_term_text_layout.helperText = "검색어를 입력해주세요"
			}

			if (it.toString().count() == 12) {
				Log.d(TAG, "onCreate: 에러 띄우기")
				Toast.makeText(this, "검색어는 12자까지만 입력 가능합니다.", Toast.LENGTH_SHORT).show()
			}
		}

		// 버튼 클릭시
		btn_search.setOnClickListener {
			Log.d(TAG, "onCreate: 검색 버튼이 클릭되었다. / currentSearchType: $currentSearchType")

			// 검색api 호출
			RetrofitManager.instance.searchPhotos(searchTerm = search_term_edit_text.toString(),
				completion = {
					responseState, responseBody ->

					when(responseState) {
						RESPONSE_STATE.OKAY -> {
							Log.d(TAG, "api 호출 성공: $responseBody")
						}
						RESPONSE_STATE.FAIL -> {
							Toast.makeText(this, "api 호출 에러입니다.", Toast.LENGTH_SHORT).show()
							Log.d(TAG, "api 호출 실패: $responseBody")
						}
					}
				})

			this.handleSearchButtonUi()
		}
	}

	private fun handleSearchButtonUi() {
		btn_progress.visibility = View.VISIBLE
		btn_search.visibility = View.INVISIBLE
		btn_search.text = ""

		Handler(Looper.getMainLooper()).postDelayed({
			btn_progress.visibility = View.INVISIBLE
			btn_search.visibility = View.VISIBLE
			btn_search.text = "검색"
		}, 1500)
	}
}