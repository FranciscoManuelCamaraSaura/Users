package com.fran.users.feature.activity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fran.users.domain.usecase.UsersUseCase
import com.fran.users.feature.users.model.User
import com.fran.users.feature.users.model.Users
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
	private val usersUseCase: UsersUseCase
) : ViewModel() {
	private val _users = MutableLiveData<Users>()
	val users: LiveData<Users> = _users

	fun getUsers() {
		viewModelScope.launch {
			_users.value = usersUseCase()
		}
	}

	fun getUser(userId: Int): User {
		return users.value?.users?.get(userId)!!
	}

	fun getUserSize(): Int {
		return users.value?.users?.size ?: 0
	}

}
