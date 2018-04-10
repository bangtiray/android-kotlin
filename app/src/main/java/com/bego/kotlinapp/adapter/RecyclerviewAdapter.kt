package com.bego.kotlinapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.bego.kotlinapp.ItemUser
import com.bego.kotlinapp.R

import java.util.ArrayList

/**
 * Created by humaira on 4/10/2018.
 */

class RecyclerviewAdapter(private val c: Context) : RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {
    private val inflater: LayoutInflater
    private var mData = ArrayList<ItemUser>()

    init {
        inflater = c.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    }

    fun addItem(mData: ArrayList<ItemUser>) {
        this.mData = mData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.username.text = mData[position].username
        holder.password.text = mData[position].password
        holder.fullname.text = mData[position].fullname

    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var username: TextView
        internal var password: TextView
        internal var fullname: TextView

        init {
            username = itemView.findViewById<View>(R.id.username) as TextView
            password = itemView.findViewById<View>(R.id.password) as TextView
            fullname = itemView.findViewById<View>(R.id.fullname) as TextView
        }
    }
}
