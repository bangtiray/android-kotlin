package com.bego.kotlinapp.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

import android.provider.BaseColumns._ID
import com.bego.kotlinapp.db.DbUser.TABLE_USER
import com.bego.kotlinapp.db.DbUser.UserColumns.Companion.USERNAME
import com.bego.kotlinapp.db.DbUser.UserColumns.Companion.PASSWORD
import com.bego.kotlinapp.db.DbUser.UserColumns.Companion.FULLNAME

/**
 * Created by humaira on 4/9/2018.
 */

class DbUserHelper(c: Context) : SQLiteOpenHelper(c, DB_NAME, null, DB_VER) {


    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_USER)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER)
        onCreate(sqLiteDatabase)
    }

    companion object {
        private val DB_NAME = "dbuser"
        private val DB_VER = 1

        var CREATE_TABLE_USER = "create table " + TABLE_USER +
                " (" + _ID + " integer primary key autoincrement, " +
                USERNAME + " text not null, " +
                PASSWORD + " text not null, " +
                FULLNAME + " text not null);"
    }
}
