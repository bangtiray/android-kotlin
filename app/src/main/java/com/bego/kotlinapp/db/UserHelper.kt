package com.bego.kotlinapp.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase

import com.bego.kotlinapp.ItemUser

import java.util.ArrayList

import android.provider.BaseColumns._ID
import com.bego.kotlinapp.db.DbUser.UserColumns.Companion.PASSWORD
import com.bego.kotlinapp.db.DbUser.TABLE_USER
import com.bego.kotlinapp.db.DbUser.UserColumns.Companion.FULLNAME
import com.bego.kotlinapp.db.DbUser.UserColumns.Companion.USERNAME

/**
 * Created by humaira on 4/9/2018.
 */

class UserHelper(private val c: Context) {
    private var dbUserHelper: DbUserHelper? = null
    private var database: SQLiteDatabase? = null
    val user: ArrayList<ItemUser>
        get() {
            val result = ""
            val cursor = database!!.query(TABLE_USER, null, null, null, null, null, _ID + " ASC", null)
            cursor.moveToFirst()
            val arrayList = ArrayList<ItemUser>()
            var itemUser: ItemUser
            if (cursor.count > 0) {
                do {
                    itemUser = ItemUser()
                    itemUser._id = cursor.getInt(cursor.getColumnIndexOrThrow(_ID))
                    itemUser.username = cursor.getString(cursor.getColumnIndexOrThrow(USERNAME))
                    itemUser.password = cursor.getString(cursor.getColumnIndexOrThrow(PASSWORD))
                    itemUser.fullname = cursor.getString(cursor.getColumnIndexOrThrow(FULLNAME))

                    arrayList.add(itemUser)
                    cursor.moveToNext()
                } while (!cursor.isAfterLast)
            }
            cursor.close()
            return arrayList
        }

    @Throws(SQLException::class)
    fun open(): UserHelper {
        dbUserHelper = DbUserHelper(c)
        database = dbUserHelper!!.writableDatabase
        return this
    }

    fun close() {
        dbUserHelper!!.close()
    }

    fun insert(itemUser: ItemUser): Long {
        val values = ContentValues()
        values.put(USERNAME, itemUser.username)
        values.put(PASSWORD, itemUser.password)
        values.put(FULLNAME, itemUser.fullname)
        return database?.insert(TABLE_USER, null, values)!!
    }

    fun beginTransaction() {
        database!!.beginTransaction()
    }

    fun setTransactionSuccess() {
        database!!.setTransactionSuccessful()
    }

    fun endTransaction() {
        database!!.endTransaction()
    }
}
