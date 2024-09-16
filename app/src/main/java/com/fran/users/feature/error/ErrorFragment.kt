package com.fran.users.feature.error

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fran.users.databinding.FragmentErrorBinding

class ErrorFragment: Fragment() {
	private lateinit var binding: FragmentErrorBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = FragmentErrorBinding.inflate(inflater, container, false)

		binding.buttonRetry.setOnClickListener {
			requireActivity().supportFragmentManager.popBackStack()
		}

		return binding.root
	}

}
