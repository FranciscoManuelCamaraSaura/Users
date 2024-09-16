package com.fran.users.feature.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.fran.users.R
import com.fran.users.databinding.ActivityMainBinding
import com.fran.users.feature.activity.viewmodel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	private lateinit var appBarConfiguration: AppBarConfiguration
	private lateinit var navHostFragment: NavHostFragment
	private lateinit var navController: NavController
	private lateinit var toolbar: Toolbar
	private val viewModel: UsersViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = ActivityMainBinding.inflate(layoutInflater)

		viewModel.getUsers()

		setContentView(binding.root)
		setViews()
	}

	override fun onSupportNavigateUp(): Boolean {
		return NavigationUI.navigateUp(
			navController,
			appBarConfiguration
		) || super.onSupportNavigateUp()
	}

	private fun setViews() {
		toolbar = binding.appBarMain.toolbar
		navHostFragment =
			supportFragmentManager.findFragmentById(R.id.navigationHostFragment) as NavHostFragment
		navController = navHostFragment.navController

		setSupportActionBar(toolbar)

		navController.popBackStack(navController.graph.startDestinationId, false)
		appBarConfiguration = AppBarConfiguration.Builder(navController.graph).build()

		NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)
	}

}
