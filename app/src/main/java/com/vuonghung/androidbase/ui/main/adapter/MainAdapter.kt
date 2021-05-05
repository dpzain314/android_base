package com.vuonghung.androidbase.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.vuonghung.androidbase.R
import com.vuonghung.androidbase.data.model.User

class MainAdapter(
    private val context : Context,
    private val users: ArrayList<User>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewUserName: TextView = itemView.findViewById(R.id.textViewUserName)
        private val textViewUserEmail: TextView = itemView.findViewById(R.id.textViewUserEmail)
        private val imageViewAvatar: ImageView = itemView.findViewById(R.id.imageViewAvatar)
        fun bind(user: User, context: Context) {
            textViewUserName.text = user.name
            textViewUserEmail.text = user.email
            imageViewAvatar.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_launcher_foreground))
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
        holder.bind(users[position], context)

    fun addData(list: List<User>) {
        users.addAll(list)
    }

}