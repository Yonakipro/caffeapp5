package com.yonakipro.caffeapp5.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.yonakipro.caffeapp5.payment.Payment
import kotlinx.coroutines.flow.Flow

@Dao
interface PaymentDao {
    @Query("SELECT * FROM `payment12_table` ORDER BY `order` ASC")
    fun getAllPayment(): Flow<List<Payment>>

    @Insert
    suspend fun insertPayment(payment: Payment)

    @Delete
    suspend fun deletePayment(payment: Payment)

    @Update
    fun updatePayment(payment: Payment)
}