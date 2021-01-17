package com.deependra.week6assignmrent1.model

import android.os.Parcel
import android.os.Parcelable

data class studentDetails (
    val studentId: Int? = null,
    val studentName: String? = null,
    val studentImage: String? = null,
    val studentAddress: String? = null,
    val studentAge: Int? = null,
    val studentGender: String? = null
):Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readString()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeValue(studentId)
                parcel.writeString(studentName)
                parcel.writeString(studentImage)
                parcel.writeString(studentAddress)
                parcel.writeValue(studentAge)
                parcel.writeString(studentGender)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<studentDetails> {
                override fun createFromParcel(parcel: Parcel): studentDetails {
                        return studentDetails(parcel)
                }

                override fun newArray(size: Int): Array<studentDetails?> {
                        return arrayOfNulls(size)
                }
        }
}
