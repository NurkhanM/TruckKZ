// Generated by view binder compiler. Do not edit!
package product.truckkz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import product.truckkz.R;

public final class ActivityCreateBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LinearLayout createProductConnect;

  @NonNull
  public final LinearLayout createProductDisconnect;

  private ActivityCreateBinding(@NonNull ConstraintLayout rootView,
      @NonNull LinearLayout createProductConnect, @NonNull LinearLayout createProductDisconnect) {
    this.rootView = rootView;
    this.createProductConnect = createProductConnect;
    this.createProductDisconnect = createProductDisconnect;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCreateBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCreateBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_create, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCreateBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.createProductConnect;
      LinearLayout createProductConnect = ViewBindings.findChildViewById(rootView, id);
      if (createProductConnect == null) {
        break missingId;
      }

      id = R.id.createProductDisconnect;
      LinearLayout createProductDisconnect = ViewBindings.findChildViewById(rootView, id);
      if (createProductDisconnect == null) {
        break missingId;
      }

      return new ActivityCreateBinding((ConstraintLayout) rootView, createProductConnect,
          createProductDisconnect);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
