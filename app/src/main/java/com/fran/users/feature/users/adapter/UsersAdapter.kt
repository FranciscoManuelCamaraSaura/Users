package com.fran.users.feature.users.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fran.users.R
import com.fran.users.databinding.ItemUserBinding
import com.fran.users.feature.users.listener.OnClickUser
import com.fran.users.feature.users.model.User

class UsersAdapter(
	private val context: Context,
	private val users: MutableList<User>,
	private val listener: OnClickUser
) :
	RecyclerView.Adapter<UsersAdapter.ViewHolder>() {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val binding = ItemUserBinding.inflate(
			LayoutInflater.from(parent.context),
			parent,
			false
		)

		return ViewHolder(binding)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.bind(users[position])
		holder.userContainer.setOnClickListener(holder.redirectToUser(position))
	}

	override fun getItemCount(): Int = users.size

	inner class ViewHolder(private val binding: ItemUserBinding) :
		RecyclerView.ViewHolder(binding.root) {
		val userContainer = binding.userContainer

		fun bind(item: User) {
			Glide.with(context).load(item.picture.thumbnail).into(binding.imageView)
			binding.textViewUserName.text = context.getString(R.string.user_name, item.name.title, item.name.first, item.name.last)
			binding.textViewUserEmail.text = item.email
		}

		fun redirectToUser(userId: Int): View.OnClickListener {
			return View.OnClickListener {
				listener.onClickUser(userId)
			}
		}
	}

}
