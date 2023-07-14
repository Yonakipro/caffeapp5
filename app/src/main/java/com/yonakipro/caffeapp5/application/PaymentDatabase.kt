package com.yonakipro.caffeapp5.application

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yonakipro.caffeapp5.dao.PaymentDao
import com.yonakipro.caffeapp5.payment.Payment

@Database(entities = [Payment::class], version = 1, exportSchema = false)
abstract class PaymentDatabase: RoomDatabase(){
    abstract fun paymentDao(): PaymentDao

    companion object{
        private var INSTANCE: PaymentDatabase? = null

        fun getDatabase(context: Context): PaymentDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PaymentDatabase::class.java,
                    "payment_database"
                )
                    .allowMainThreadQueries()
                    .build()

                INSTANCE =instance
                instance
            }
        }
    }
}