package com.bego.kotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText

import com.bego.kotlinapp.adapter.RecyclerviewAdapter
import com.bego.kotlinapp.db.UserHelper

import java.util.ArrayList

class Main2Activity : AppCompatActivity() {
    internal var userHelper: UserHelper? = null
    internal var recyclerView: RecyclerView? = null
    internal var itemUsers: ArrayList<ItemUser>? = null
    internal var adapter: RecyclerviewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        recyclerView = findViewById<View>(R.id.recyclerview) as RecyclerView

        showList()
    }

    private fun showList() {
        userHelper = UserHelper(this)
        adapter = RecyclerviewAdapter(this)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.adapter = adapter
        userHelper!!.open()
        itemUsers = userHelper!!.user
        userHelper!!.close()
        adapter!!.addItem(itemUsers!!)

    }
}
