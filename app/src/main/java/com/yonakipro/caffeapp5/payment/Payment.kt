package com.yonakipro.caffeapp5.payment

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "payment12_table")
data class Payment (
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val address: String,
    val nameOrder: String,
    val order: String,
    val charge: String,
    val latitude: Double?,
    val longitude: Double?
) : Parcelable