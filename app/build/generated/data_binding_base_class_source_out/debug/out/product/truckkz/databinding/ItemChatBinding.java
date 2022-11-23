// Generated by view binder compiler. Do not edit!
package product.truckkz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import product.truckkz.R;

public final class ItemChatBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView textDate;

  @NonNull
  public final TextView textDescription;

  @NonNull
  public final TextView textName;

  private ItemChatBinding(@NonNull ConstraintLayout rootView, @NonNull TextView textDate,
      @NonNull TextView textDescription, @NonNull TextView textName) {
    this.rootView = rootView;
    this.textDate = textDate;
    this.textDescription = textDescription;
    this.textName = textName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemChatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_chat, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemChatBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.textDate;
      TextView textDate = ViewBindings.findChildViewById(rootView, id);
      if (textDate == null) {
        break missingId;
      }

      id = R.id.textDescription;
      TextView textDescription = ViewBindings.findChildViewById(rootView, id);
      if (textDescription == null) {
        break missingId;
      }

      id = R.id.textName;
      TextView textName = ViewBindings.findChildViewById(rootView, id);
      if (textName == null) {
        break missingId;
      }

      return new ItemChatBinding((ConstraintLayout) rootView, textDate, textDescription, textName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
