package com.arazo.unsplash_app_tutorial.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by arazo on 2022-02-03.
 */
// 문자열이 json 형태인지
fun String?.isJsonObject(): Boolean = this?.startsWith("{") == true && this.endsWith("}")

// 문자열이 json 배열인지
fun String?.isJsonArray(): Boolean = this?.startsWith("[") == true && this.endsWith("]")

// 날짜 포맷
fun Date.toSimpleString() : String {
	val format = SimpleDateFormat("HH:mm:ss")
	return format.format(this)
}

// Edit Text에 대한 익스텐션
fun EditText.onMyTextChanged(completion: (Editable?) -> Unit) {
	this.addTextChangedListener(object : TextWatcher {

		override fun afterTextChanged(editable: Editable?) {
			completion(editable)
		}

		override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

		}

		override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

		}

	})
}