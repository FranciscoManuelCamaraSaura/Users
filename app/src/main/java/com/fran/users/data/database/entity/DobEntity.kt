package com.fran.users.data.database.entity

import com.google.gson.annotations.SerializedName

data class DobEntity(
	@SerializedName("date")
	val dateEntity: String,
	@SerializedName("age")
	val ageEntity: Int

)
