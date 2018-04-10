package com.bego.kotlinapp.db

import android.provider.BaseColumns

/**
 * Created by humaira on 4/9/2018.
 */

object DbUser {
    internal var TABLE_USER = "table_user"

    internal class UserColumns : BaseColumns {
        companion object {
            var USERNAME = "username"
            var PASSWORD = "password"
            var FULLNAME = "fullname"
        }

    }
}
