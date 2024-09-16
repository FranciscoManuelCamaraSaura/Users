package com.fran.users.feature.users.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fran.users.R
import com.fran.users.databinding.FragmentUsersBinding
import com.fran.users.feature.users.adapter.UsersAdapter
import com.fran.users.feature.activity.viewmodel.UsersViewModel
import com.fran.users.feature.users.listener.OnClickUser
import com.fran.users.utils.Constants

class UsersFragment : Fragment(), OnClickUser {
	private lateinit var binding: FragmentUsersBinding
	private val viewModel: UsersViewModel by activityViewModels()

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = FragmentUsersBinding.inflate(inflater, container, false)

		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		viewModel.users.observe(viewLifecycleOwner) { users ->
			if(users.users.size != 0) {
				val usersAdapter = UsersAdapter(requireContext(), users.users, this)

				binding.usersRecyclerView.apply {
					layoutManager = LinearLayoutManager(requireContext())
					adapter = usersAdapter
					setHasFixedSize(true)
				}

				binding.progressBar.progressBar.visibility = View.GONE
			} else {
				findNavController().navigate(R.id.errorFragment)
			}
		}
	}

	override fun onResume() {
		super.onResume()

		if(viewModel.getUserSize() == 0) {
			viewModel.getUsers()
		}
	}

	override fun onClickUser(userId: Int) {
		val arguments = Bundle()

		arguments.putString(Constants.PARAM_USER_ID, userId.toString())
		findNavController().navigate(R.id.userDetailFragment, arguments)
	}

}
