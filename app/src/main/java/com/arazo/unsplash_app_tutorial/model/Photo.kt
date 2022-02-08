package com.arazo.unsplash_app_tutorial.model

import java.io.Serializable

/**
 * Created by arazo on 2022-02-07.
 */
data class Photo(
	var thumbnail: String?,
	var author: String?,
	var createAt: String?,
	var likesCount: Int?,
) : Serializable {

}