// Generated by view binder compiler. Do not edit!
package product.truckkz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public final class DialogSuccesRegisterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView dialogYes;

  @NonNull
  public final ImageView imageTitle;

  @NonNull
  public final TextView txtDescript;

  private DialogSuccesRegisterBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView dialogYes, @NonNull ImageView imageTitle, @NonNull TextView txtDescript) {
    this.rootView = rootView;
    this.dialogYes = dialogYes;
    this.imageTitle = imageTitle;
    this.txtDescript = txtDescript;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogSuccesRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogSuccesRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_succes_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogSuccesRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.dialog_yes;
      ImageView dialogYes = ViewBindings.findChildViewById(rootView, id);
      if (dialogYes == null) {
        break missingId;
      }

      id = R.id.image_title;
      ImageView imageTitle = ViewBindings.findChildViewById(rootView, id);
      if (imageTitle == null) {
        break missingId;
      }

      id = R.id.txt_descript;
      TextView txtDescript = ViewBindings.findChildViewById(rootView, id);
      if (txtDescript == null) {
        break missingId;
      }

      return new DialogSuccesRegisterBinding((ConstraintLayout) rootView, dialogYes, imageTitle,
          txtDescript);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
