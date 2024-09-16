package com.fran.users.data.network.service

import android.util.Log
import com.fran.users.data.database.entity.UsersEntity
import com.fran.users.data.network.UsersApiClient
import com.fran.users.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsersService @Inject constructor(
	private val usersApiClient: UsersApiClient
) {
	suspend fun getUsers(): UsersEntity {
		return withContext(Dispatchers.IO) {
			try {
				val response = usersApiClient.getUsers(
					Constants.RESULT,
					Constants.INC
				)

				Log.i("Response", response.body().toString())

				response.body() ?: UsersEntity()
			} catch (exception: Exception) {
				exception.message?.let { message -> Log.i("Response", message) }

				UsersEntity()
			}
		}
	}

}
