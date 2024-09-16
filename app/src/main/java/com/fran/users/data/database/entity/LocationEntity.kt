package com.fran.users.data.database.entity

import com.google.gson.annotations.SerializedName

data class LocationEntity(
	@SerializedName("street")
	val streetEntity: StreetEntity,
	@SerializedName("city")
	val cityEntity: String,
	@SerializedName("state")
	val stateEntity: String,
	@SerializedName("country")
	val countryEntity: String,
	@SerializedName("postcode")
	val postcodeEntity: Int,
	@SerializedName("coordinates")
	val coordinatesEntity: CoordinatesEntity,
	@SerializedName("timezone")
	val timezoneEntity: TimezoneEntity

)
