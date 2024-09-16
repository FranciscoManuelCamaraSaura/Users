package com.fran.users.data.dagger

import com.fran.users.data.network.UsersApiClient
import com.fran.users.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
	@Singleton
	@Provides
	fun provideRetrofit(): Retrofit {
		return Retrofit.Builder()
			.baseUrl(Constants.REMOTE_URL)
			.addConverterFactory(
				GsonConverterFactory.create()
			).build()
	}

	@Singleton
	@Provides
	fun provideUsersClient(retrofit: Retrofit): UsersApiClient {
		return retrofit.create(UsersApiClient::class.java)
	}

}
