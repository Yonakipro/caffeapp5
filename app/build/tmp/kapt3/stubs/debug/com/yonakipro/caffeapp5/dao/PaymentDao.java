package com.yonakipro.caffeapp5.dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0019\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/yonakipro/caffeapp5/dao/PaymentDao;", "", "deletePayment", "", "payment", "Lcom/yonakipro/caffeapp5/payment/Payment;", "(Lcom/yonakipro/caffeapp5/payment/Payment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPayment", "Lkotlinx/coroutines/flow/Flow;", "", "insertPayment", "updatePayment", "app_debug"})
public abstract interface PaymentDao {
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM `payment12_table` ORDER BY `order` ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.yonakipro.caffeapp5.payment.Payment>> getAllPayment();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert
    public abstract java.lang.Object insertPayment(@org.jetbrains.annotations.NotNull
    com.yonakipro.caffeapp5.payment.Payment payment, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Delete
    public abstract java.lang.Object deletePayment(@org.jetbrains.annotations.NotNull
    com.yonakipro.caffeapp5.payment.Payment payment, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @androidx.room.Update
    public abstract void updatePayment(@org.jetbrains.annotations.NotNull
    com.yonakipro.caffeapp5.payment.Payment payment);
}