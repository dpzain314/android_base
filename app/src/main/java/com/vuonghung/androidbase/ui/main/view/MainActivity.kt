package com.vuonghung.androidbase.ui.main.view

import android.app.AlertDialog
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.vuonghung.androidbase.R
import com.vuonghung.androidbase.data.model.User
import com.vuonghung.androidbase.ui.base.BaseActivity
import com.vuonghung.androidbase.ui.main.adapter.MainAdapter
import com.vuonghung.androidbase.ui.main.viewmodel.MainViewModel
import com.vuonghung.androidbase.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var adapter: MainAdapter

    override fun getLayout(): Int = R.layout.activity_main

    override fun initial() {
        setupUI()
        setupObserver()
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(this, arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        mainViewModel.listUsers.observe(this, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users.items!!) }
                    recyclerView.visibility = View.VISIBLE
                }
                Resource.Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Resource.Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    AlertDialog.Builder(this)
                        .setTitle(it.message)
                        .setPositiveButton("OK") { p0, p1 -> }
                        .show()
                }
            }
        })
    }

    private fun renderList(users: List<User>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }
}