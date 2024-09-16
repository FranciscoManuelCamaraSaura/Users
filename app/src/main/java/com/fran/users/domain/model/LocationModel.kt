package com.fran.users.domain.model

data class LocationModel(
	val streetModel: StreetModel,
	val cityModel: String,
	val stateModel: String,
	val countryModel: String,
	val postcodeModel: Int,
	val coordinatesModel: CoordinatesModel,
	val timezoneModel: TimezoneModel

)
