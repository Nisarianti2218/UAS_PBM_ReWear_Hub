package com.example.rewear_hub

import android.os.Parcel
import android.os.Parcelable

data class Tailor(
    val name: String,
    val rating: Double,
    val location: String,
    val imageResId: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeDouble(rating)
        parcel.writeString(location)
        parcel.writeInt(imageResId)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Tailor> {
        override fun createFromParcel(parcel: Parcel): Tailor = Tailor(parcel)
        override fun newArray(size: Int): Array<Tailor?> = arrayOfNulls(size)
    }
}
