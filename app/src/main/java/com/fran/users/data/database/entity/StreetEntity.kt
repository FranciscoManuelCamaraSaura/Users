package com.fran.users.data.database.entity

import com.google.gson.annotations.SerializedName

data class StreetEntity(
	@SerializedName("number")
	val numberEntity: Int,
	@SerializedName("name")
	val nameEntity: String

)
