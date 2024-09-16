package com.fran.users.data.network

import com.fran.users.data.database.entity.UsersEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersApiClient {
	@GET("api/")
	suspend fun getUsers(
		@Query("results") usersNumber: String,
		@Query("inc") includeField: String
	): Response<UsersEntity>

}
