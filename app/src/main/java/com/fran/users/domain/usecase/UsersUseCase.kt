package com.fran.users.domain.usecase

import com.fran.users.data.repository.UsersRepository
import com.fran.users.domain.model.CoordinatesModel
import com.fran.users.domain.model.DobModel
import com.fran.users.domain.model.LocationModel
import com.fran.users.domain.model.NameModel
import com.fran.users.domain.model.PictureModel
import com.fran.users.domain.model.StreetModel
import com.fran.users.domain.model.TimezoneModel
import com.fran.users.feature.users.model.Coordinates
import com.fran.users.feature.users.model.Dob
import com.fran.users.feature.users.model.Location
import com.fran.users.feature.users.model.Name
import com.fran.users.feature.users.model.Picture
import com.fran.users.feature.users.model.Street
import com.fran.users.feature.users.model.Timezone
import com.fran.users.feature.users.model.User
import com.fran.users.feature.users.model.Users
import javax.inject.Inject

class UsersUseCase @Inject constructor(
	private val usersRepository: UsersRepository
) {
	suspend operator fun invoke(): Users {
		val usersModel = usersRepository.getUsers()
		val users: MutableList<User> = mutableListOf()

		usersModel.usersModel.forEach { userModel ->
			users.add(
				User(
					userModel.genderModel,
					getUserName(userModel.nameModel),
					getUserLocation(userModel.locationModel),
					userModel.emailModel,
					getUserDob(userModel.dobModel),
					userModel.phoneModel,
					userModel.cellModel,
					getUserPicture(userModel.pictureModel),
					userModel.nationalityModel
				)
			)
		}

		return Users(users)
	}

	private fun getUserName(nameModel: NameModel): Name {
		return Name(nameModel.titleModel, nameModel.firstModel, nameModel.lastModel)
	}

	private fun getUserLocation(locationModel: LocationModel): Location {
		return Location(
			getUserStreet(locationModel.streetModel),
			locationModel.cityModel,
			locationModel.stateModel,
			locationModel.countryModel,
			locationModel.postcodeModel,
			getUserCoordinates(locationModel.coordinatesModel),
			getUserTimezone(locationModel.timezoneModel)
		)
	}

	private fun getUserStreet(streetModel: StreetModel): Street {
		return Street(streetModel.numberModel, streetModel.nameModel)
	}

	private fun getUserCoordinates(coordinatesModel: CoordinatesModel): Coordinates {
		return Coordinates(coordinatesModel.latitudeModel, coordinatesModel.longitudeModel)
	}

	private fun getUserTimezone(timezoneModel: TimezoneModel): Timezone {
		return Timezone(timezoneModel.offsetModel, timezoneModel.descriptionModel)
	}

	private fun getUserDob(dobModel: DobModel): Dob {
		return Dob(dobModel.dateModel, dobModel.ageModel)
	}

	private fun getUserPicture(pictureModel: PictureModel): Picture {
		return Picture(
			pictureModel.largeModel,
			pictureModel.mediumModel,
			pictureModel.thumbnailModel
		)
	}

}
