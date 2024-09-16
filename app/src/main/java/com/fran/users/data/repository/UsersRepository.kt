package com.fran.users.data.repository

import com.fran.users.data.database.entity.CoordinatesEntity
import com.fran.users.data.database.entity.DobEntity
import com.fran.users.data.database.entity.LocationEntity
import com.fran.users.data.database.entity.NameEntity
import com.fran.users.data.database.entity.PictureEntity
import com.fran.users.data.database.entity.StreetEntity
import com.fran.users.data.database.entity.TimezoneEntity
import com.fran.users.data.network.service.UsersService
import com.fran.users.domain.model.CoordinatesModel
import com.fran.users.domain.model.DobModel
import com.fran.users.domain.model.LocationModel
import com.fran.users.domain.model.NameModel
import com.fran.users.domain.model.PictureModel
import com.fran.users.domain.model.StreetModel
import com.fran.users.domain.model.TimezoneModel
import com.fran.users.domain.model.UserModel
import com.fran.users.domain.model.UsersModel
import javax.inject.Inject

class UsersRepository @Inject constructor(
	private val api: UsersService
) {
	suspend fun getUsers(): UsersModel {
		val usersEntity = api.getUsers()
		val usersModel: MutableList<UserModel> = mutableListOf()

		usersEntity.usersEntity?.forEach { userEntity ->
			usersModel.add(
				UserModel(
					userEntity.genderEntity,
					getUserName(userEntity.nameEntity),
					getUserLocation(userEntity.locationEntity),
					userEntity.emailEntity,
					getUserDob(userEntity.dobEntity),
					userEntity.phoneEntity,
					userEntity.cellEntity,
					getUserPicture(userEntity.pictureEntity),
					userEntity.nationalityEntity
				)
			)
		}

		return UsersModel(usersModel)
	}

	private fun getUserName(nameEntity: NameEntity): NameModel {
		return NameModel(nameEntity.titleEntity, nameEntity.firstEntity, nameEntity.lastEntity)
	}

	private fun getUserLocation(locationEntity: LocationEntity): LocationModel {
		return LocationModel(
			getUserStreet(locationEntity.streetEntity),
			locationEntity.cityEntity,
			locationEntity.stateEntity,
			locationEntity.countryEntity,
			locationEntity.postcodeEntity,
			getUserCoordinates(locationEntity.coordinatesEntity),
			getUserTimezone(locationEntity.timezoneEntity)
		)
	}

	private fun getUserStreet(streetEntity: StreetEntity): StreetModel {
		return StreetModel(streetEntity.numberEntity, streetEntity.nameEntity)
	}

	private fun getUserCoordinates(coordinatesEntity: CoordinatesEntity): CoordinatesModel {
		return CoordinatesModel(coordinatesEntity.latitudeEntity, coordinatesEntity.longitudeEntity)
	}

	private fun getUserTimezone(timezoneEntity: TimezoneEntity): TimezoneModel {
		return TimezoneModel(timezoneEntity.offsetEntity, timezoneEntity.descriptionEntity)
	}

	private fun getUserDob(dobEntity: DobEntity): DobModel {
		return DobModel(dobEntity.dateEntity, dobEntity.ageEntity)
	}

	private fun getUserPicture(pictureEntity: PictureEntity): PictureModel {
		return PictureModel(
			pictureEntity.largeEntity,
			pictureEntity.mediumEntity,
			pictureEntity.thumbnailEntity
		)
	}

}
