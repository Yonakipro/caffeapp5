// Generated by view binder compiler. Do not edit!
package com.yonakipro.caffeapp5.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.yonakipro.caffeapp5.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemPaymentBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView OrderTextView;

  @NonNull
  public final TextView addressTextView;

  @NonNull
  public final TextView chargeTextView;

  @NonNull
  public final TextView nameOrderTextView;

  private ItemPaymentBinding(@NonNull ConstraintLayout rootView, @NonNull TextView OrderTextView,
      @NonNull TextView addressTextView, @NonNull TextView chargeTextView,
      @NonNull TextView nameOrderTextView) {
    this.rootView = rootView;
    this.OrderTextView = OrderTextView;
    this.addressTextView = addressTextView;
    this.chargeTextView = chargeTextView;
    this.nameOrderTextView = nameOrderTextView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemPaymentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemPaymentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_payment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemPaymentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.OrderTextView;
      TextView OrderTextView = ViewBindings.findChildViewById(rootView, id);
      if (OrderTextView == null) {
        break missingId;
      }

      id = R.id.addressTextView;
      TextView addressTextView = ViewBindings.findChildViewById(rootView, id);
      if (addressTextView == null) {
        break missingId;
      }

      id = R.id.chargeTextView;
      TextView chargeTextView = ViewBindings.findChildViewById(rootView, id);
      if (chargeTextView == null) {
        break missingId;
      }

      id = R.id.nameOrderTextView;
      TextView nameOrderTextView = ViewBindings.findChildViewById(rootView, id);
      if (nameOrderTextView == null) {
        break missingId;
      }

      return new ItemPaymentBinding((ConstraintLayout) rootView, OrderTextView, addressTextView,
          chargeTextView, nameOrderTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
