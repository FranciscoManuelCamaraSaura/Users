package com.fran.users.feature.userdetail.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.fran.users.R
import com.fran.users.databinding.FragmentUserDetailBinding
import com.fran.users.feature.activity.viewmodel.UsersViewModel
import com.fran.users.feature.users.model.User
import com.fran.users.utils.Constants

class UserDetailFragment : Fragment() {
	private lateinit var binding: FragmentUserDetailBinding
	private lateinit var user: User
	private val viewModel: UsersViewModel by activityViewModels()

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = FragmentUserDetailBinding.inflate(inflater, container, false)

		arguments?.getString(Constants.PARAM_USER_ID)?.toInt()?.let { userId ->
			user = viewModel.getUser(userId)
		}

		setViews()

		return binding.root
	}

	private fun setViews() {
		Glide.with(requireContext()).load(user.picture.large).into(binding.imageView)
		binding.textViewUserName.text = requireContext().getString(
			R.string.user_name,
			user.name.title,
			user.name.first,
			user.name.last
		)
		binding.textViewUserGender.text = user.gender
		binding.textViewUserAge.text = user.dob.age.toString()
		binding.textViewUserEmail.text = user.email
		binding.textViewUserLocation.text = requireContext().getString(
			R.string.user_location,
			user.location.street.name,
			user.location.street.number,
			user.location.city,
			user.location.state,
			user.location.country
		)
		binding.textViewUserPhone.text = user.phone
		binding.textViewUserCell.text = user.cell
	}

}
