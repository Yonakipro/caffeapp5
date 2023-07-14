package com.yonakipro.caffeapp5.ui

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.yonakipro.caffeapp5.payment.Payment
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class SecondFragmentArgs(
  public val payment: Payment?
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Payment::class.java)) {
      result.putParcelable("payment", this.payment as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Payment::class.java)) {
      result.putSerializable("payment", this.payment as Serializable?)
    } else {
      throw UnsupportedOperationException(Payment::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Payment::class.java)) {
      result.set("payment", this.payment as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Payment::class.java)) {
      result.set("payment", this.payment as Serializable?)
    } else {
      throw UnsupportedOperationException(Payment::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): SecondFragmentArgs {
      bundle.setClassLoader(SecondFragmentArgs::class.java.classLoader)
      val __payment : Payment?
      if (bundle.containsKey("payment")) {
        if (Parcelable::class.java.isAssignableFrom(Payment::class.java) ||
            Serializable::class.java.isAssignableFrom(Payment::class.java)) {
          __payment = bundle.get("payment") as Payment?
        } else {
          throw UnsupportedOperationException(Payment::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"payment\" is missing and does not have an android:defaultValue")
      }
      return SecondFragmentArgs(__payment)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): SecondFragmentArgs {
      val __payment : Payment?
      if (savedStateHandle.contains("payment")) {
        if (Parcelable::class.java.isAssignableFrom(Payment::class.java) ||
            Serializable::class.java.isAssignableFrom(Payment::class.java)) {
          __payment = savedStateHandle.get<Payment?>("payment")
        } else {
          throw UnsupportedOperationException(Payment::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"payment\" is missing and does not have an android:defaultValue")
      }
      return SecondFragmentArgs(__payment)
    }
  }
}
