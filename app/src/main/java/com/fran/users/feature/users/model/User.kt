package com.fran.users.feature.users.model

data class User(
	val gender: String,
	val name: Name,
	val location: Location,
	val email: String,
	val dob: Dob,
	val phone: String,
	val cell: String,
	val picture: Picture,
	val nationality: String

)
