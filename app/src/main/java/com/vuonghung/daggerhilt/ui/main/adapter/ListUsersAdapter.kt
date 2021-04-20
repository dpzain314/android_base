package com.vuonghung.daggerhilt.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vuonghung.daggerhilt.R
import com.vuonghung.daggerhilt.data.model.User

class ListUsersAdapter(
    private val users: ArrayList<User>
) : RecyclerView.Adapter<ListUsersAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewUserName: TextView = itemView.findViewById(R.id.textViewUserName)
        private val textViewUserPhone: TextView = itemView.findViewById(R.id.textViewUserPhone)
        fun bind(user: User) {
            textViewUserName.text = user.name
            textViewUserPhone.text = user.phone
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users[position])

    fun addData(list: List<User>) {
        users.addAll(list)
    }

}