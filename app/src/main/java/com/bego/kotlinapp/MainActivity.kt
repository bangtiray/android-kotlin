package com.bego.kotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.bego.kotlinapp.db.UserHelper

class MainActivity : AppCompatActivity() {

    private var username: EditText? = null
    private var password: EditText? = null
    private var fullname: EditText? = null
    private var btn_simpan: Button? = null
    private var dbUserHelper: UserHelper? = null
    internal lateinit var _username: String
    internal lateinit var _password: String
    internal lateinit var _fullname: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById<View>(R.id.username) as EditText
        password = findViewById<View>(R.id.password) as EditText
        fullname = findViewById<View>(R.id.fullname) as EditText
        btn_simpan = findViewById<View>(R.id.btn_save) as Button
        _username = username!!.text.toString()
        _password = password!!.text.toString()
        _fullname = fullname!!.text.toString()
        btn_simpan!!.setOnClickListener {
            if (!validate()) {
                errors()
            }
            simpan()
        }
    }

    private fun errors() {
        Toast.makeText(this, "Masih Kosong", Toast.LENGTH_LONG).show()
    }

    private fun simpan() {
        dbUserHelper = UserHelper(this)
        dbUserHelper!!.open()
        dbUserHelper!!.beginTransaction()
        val itemUser = ItemUser()
        itemUser.username = username!!.text.toString()
        itemUser.password = password!!.text.toString()
        itemUser.fullname = fullname!!.text.toString()
        dbUserHelper!!.insert(itemUser)
        dbUserHelper!!.setTransactionSuccess()
        dbUserHelper!!.endTransaction()
        dbUserHelper!!.close()
        sukses()
    }

    private fun sukses() {
        Toast.makeText(this, "Sukses", Toast.LENGTH_LONG).show()
        username!!.setText("")
        password!!.setText("")
        fullname!!.setText("")

        val intent = Intent(this@MainActivity, Main2Activity::class.java)
        startActivity(intent)
    }


    private fun validate(): Boolean {

        return if (username!!.toString().equals("") || password!!.toString().equals("") || fullname!!.toString().equals("")) {

            false
        } else {
            true
        }
    }
}
