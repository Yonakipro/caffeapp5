package com.yonakipro.caffeapp5.application

import android.app.Application
import com.yonakipro.caffeapp5.repository.PaymentRepository

class PaymentApp: Application() {
    val database by lazy { PaymentDatabase.getDatabase(this) }
    val repository by lazy { PaymentRepository(database.paymentDao()) }
}