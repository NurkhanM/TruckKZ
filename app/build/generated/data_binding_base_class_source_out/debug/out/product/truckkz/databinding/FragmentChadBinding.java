// Generated by view binder compiler. Do not edit!
package product.truckkz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import product.truckkz.R;

public final class FragmentChadBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout Toolbar;

  private FragmentChadBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout Toolbar) {
    this.rootView = rootView;
    this.Toolbar = Toolbar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentChadBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentChadBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_chad, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentChadBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Toolbar;
      ConstraintLayout Toolbar = ViewBindings.findChildViewById(rootView, id);
      if (Toolbar == null) {
        break missingId;
      }

      return new FragmentChadBinding((ConstraintLayout) rootView, Toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}