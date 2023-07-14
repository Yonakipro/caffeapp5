package com.yonakipro.caffeapp5.ui

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.yonakipro.caffeapp5.R
import com.yonakipro.caffeapp5.payment.Payment
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class FirstFragmentDirections private constructor() {
  private data class ActionFirstFragmentToSecondFragment(
    public val payment: Payment?
  ) : NavDirections {
    public override val actionId: Int = R.id.action_FirstFragment_to_SecondFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
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
  }

  public companion object {
    public fun actionFirstFragmentToSecondFragment(payment: Payment?): NavDirections =
        ActionFirstFragmentToSecondFragment(payment)

    public fun actionFirstFragmentToAboutMe(): NavDirections =
        ActionOnlyNavDirections(R.id.action_FirstFragment_to_aboutMe)

    public fun actionFirstFragmentToContacMe(): NavDirections =
        ActionOnlyNavDirections(R.id.action_FirstFragment_to_contacMe)
  }
}
