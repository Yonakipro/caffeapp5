package com.yonakipro.caffeapp5.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.yonakipro.caffeapp5.payment.Payment
import com.yonakipro.caffeapp5.repository.PaymentRepository
import kotlinx.coroutines.launch

class PaymentViewModel (private val repository: PaymentRepository): ViewModel(){
    val allPayments: LiveData<List<Payment>> = repository.allPayments.asLiveData()

    fun insert(payment: Payment) = viewModelScope.launch {
        repository.insertPayment(payment)
    }

    fun delete(payment: Payment) = viewModelScope.launch {
        repository.deletePayment(payment)
    }

    fun update (payment: Payment) = viewModelScope.launch {
        repository.updatePayment(payment)
    }
}

class PaymentViewModelFactory(private val repository: PaymentRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((PaymentViewModel::class.java))) {
            return PaymentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknow Viewmodel class")
    }
}