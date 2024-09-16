package com.fran.users.data.database.entity

import com.google.gson.annotations.SerializedName

data class CoordinatesEntity(
	@SerializedName("latitude")
	val latitudeEntity: String,
	@SerializedName("longitude")
	val longitudeEntity: String

)
