package com.fran.users.data.database.entity

import com.google.gson.annotations.SerializedName

data class UserEntity(
	@SerializedName("gender")
	val genderEntity: String,
	@SerializedName("name")
	val nameEntity: NameEntity,
	@SerializedName("location")
	val locationEntity: LocationEntity,
	@SerializedName("email")
	val emailEntity: String,
	@SerializedName("dob")
	val dobEntity: DobEntity,
	@SerializedName("phone")
	val phoneEntity: String,
	@SerializedName("cell")
	val cellEntity: String,
	@SerializedName("picture")
	val pictureEntity: PictureEntity,
	@SerializedName("nat")
	val nationalityEntity: String

)
