package com.fran.users.data.database.entity

import com.google.gson.annotations.SerializedName

data class NameEntity(
	@SerializedName("title")
	val titleEntity: String,
	@SerializedName("first")
	val firstEntity: String,
	@SerializedName("last")
	val lastEntity: String

)
