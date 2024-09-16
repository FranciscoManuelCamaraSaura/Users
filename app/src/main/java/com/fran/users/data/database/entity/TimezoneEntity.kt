package com.fran.users.data.database.entity

import com.google.gson.annotations.SerializedName

data class TimezoneEntity(
	@SerializedName("offset")
	val offsetEntity: String,
	@SerializedName("description")
	val descriptionEntity: String

)
