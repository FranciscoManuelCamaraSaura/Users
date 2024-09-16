package com.fran.users.data.database.entity

import com.google.gson.annotations.SerializedName

data class PictureEntity(
	@SerializedName("large")
	val largeEntity: String,
	@SerializedName("medium")
	val mediumEntity: String,
	@SerializedName("thumbnail")
	val thumbnailEntity: String

)
