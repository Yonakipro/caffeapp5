package com.yonakipro.caffeapp5.repository

import com.yonakipro.caffeapp5.dao.PaymentDao
import com.yonakipro.caffeapp5.payment.Payment
import kotlinx.coroutines.flow.Flow

class PaymentRepository(private val paymentDao: PaymentDao) {
    val allPayments: Flow<List< Payment>> = paymentDao.getAllPayment()

    suspend fun insertPayment(payment: Payment) {
        paymentDao.insertPayment(payment)
    }

    suspend fun deletePayment(payment: Payment) {
        paymentDao.deletePayment(payment)
    }

    fun updatePayment(payment: Payment) {
        paymentDao.updatePayment(payment)
    }
}