// Generated by view binder compiler. Do not edit!
package product.truckkz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public final class ActivityGoogleSignInBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button logout;

  @NonNull
  public final TextView textDisplayEmail;

  @NonNull
  public final TextView textDisplayName;

  private ActivityGoogleSignInBinding(@NonNull ConstraintLayout rootView, @NonNull Button logout,
      @NonNull TextView textDisplayEmail, @NonNull TextView textDisplayName) {
    this.rootView = rootView;
    this.logout = logout;
    this.textDisplayEmail = textDisplayEmail;
    this.textDisplayName = textDisplayName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityGoogleSignInBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityGoogleSignInBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_google_sign_in, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityGoogleSignInBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.logout;
      Button logout = ViewBindings.findChildViewById(rootView, id);
      if (logout == null) {
        break missingId;
      }

      id = R.id.text_display_email;
      TextView textDisplayEmail = ViewBindings.findChildViewById(rootView, id);
      if (textDisplayEmail == null) {
        break missingId;
      }

      id = R.id.text_display_name;
      TextView textDisplayName = ViewBindings.findChildViewById(rootView, id);
      if (textDisplayName == null) {
        break missingId;
      }

      return new ActivityGoogleSignInBinding((ConstraintLayout) rootView, logout, textDisplayEmail,
          textDisplayName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
