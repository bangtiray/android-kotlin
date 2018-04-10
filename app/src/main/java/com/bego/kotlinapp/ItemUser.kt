package com.bego.kotlinapp

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by humaira on 4/9/2018.
 */

class ItemUser : Parcelable {
    var _id: Int = 0
    var username: String? = null
    var password: String? = null
    var fullname: String? = null


    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(this._id)
        dest.writeString(this.username)
        dest.writeString(this.password)
        dest.writeString(this.fullname)
    }

    constructor() {}

    protected constructor(`in`: Parcel) {
        this._id = `in`.readInt()
        this.username = `in`.readString()
        this.password = `in`.readString()
        this.fullname = `in`.readString()
    }

    companion object {

        val CREATOR: Parcelable.Creator<ItemUser> = object : Parcelable.Creator<ItemUser> {
            override fun createFromParcel(source: Parcel): ItemUser {
                return ItemUser(source)
            }

            override fun newArray(size: Int): Array<ItemUser?> {
                return arrayOfNulls(size)
            }
        }
    }
}
