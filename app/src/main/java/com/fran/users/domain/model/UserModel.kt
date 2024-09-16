package com.fran.users.domain.model

data class UserModel(
	val genderModel: String,
	val nameModel: NameModel,
	val locationModel: LocationModel,
	val emailModel: String,
	val dobModel: DobModel,
	val phoneModel: String,
	val cellModel: String,
	val pictureModel: PictureModel,
	val nationalityModel: String

)
