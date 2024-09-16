package com.fran.users.data.database.entity

import com.google.gson.annotations.SerializedName

data class UsersEntity(
	@SerializedName("results")
	val usersEntity: MutableList<UserEntity>? = null

)
