package com.example.financialapp.Domain

import android.os.Parcel
import android.os.Parcelable

data class ExpenseDomain(
    var tile:String="",
    var price:Double=0.0,
    var pic:String="",
    var time:String=""
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readDouble(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tile)
        parcel.writeDouble(price)
        parcel.writeString(pic)
        parcel.writeString(time)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExpenseDomain> {
        override fun createFromParcel(parcel: Parcel): ExpenseDomain {
            return ExpenseDomain(parcel)
        }

        override fun newArray(size: Int): Array<ExpenseDomain?> {
            return arrayOfNulls(size)
        }
    }

}
