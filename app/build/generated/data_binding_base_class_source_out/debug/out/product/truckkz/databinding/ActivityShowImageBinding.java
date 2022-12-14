// Generated by view binder compiler. Do not edit!
package product.truckkz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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

public final class ActivityShowImageBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LinearLayout ShowConnect;

  @NonNull
  public final LinearLayout ShowDisconnect;

  @NonNull
  public final FrameLayout containerShowActivity;

  private ActivityShowImageBinding(@NonNull ConstraintLayout rootView,
      @NonNull LinearLayout ShowConnect, @NonNull LinearLayout ShowDisconnect,
      @NonNull FrameLayout containerShowActivity) {
    this.rootView = rootView;
    this.ShowConnect = ShowConnect;
    this.ShowDisconnect = ShowDisconnect;
    this.containerShowActivity = containerShowActivity;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityShowImageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityShowImageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_show_image, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityShowImageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ShowConnect;
      LinearLayout ShowConnect = ViewBindings.findChildViewById(rootView, id);
      if (ShowConnect == null) {
        break missingId;
      }

      id = R.id.ShowDisconnect;
      LinearLayout ShowDisconnect = ViewBindings.findChildViewById(rootView, id);
      if (ShowDisconnect == null) {
        break missingId;
      }

      id = R.id.containerShowActivity;
      FrameLayout containerShowActivity = ViewBindings.findChildViewById(rootView, id);
      if (containerShowActivity == null) {
        break missingId;
      }

      return new ActivityShowImageBinding((ConstraintLayout) rootView, ShowConnect, ShowDisconnect,
          containerShowActivity);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
