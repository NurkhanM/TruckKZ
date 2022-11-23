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
import pl.droidsonroids.gif.GifImageView;
import product.truckkz.R;

public final class ItemUpdateImageArrayBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final GifImageView imageArrayUpdate;

  @NonNull
  public final LinearLayout itemImageFocus;

  private ItemUpdateImageArrayBinding(@NonNull ConstraintLayout rootView,
      @NonNull GifImageView imageArrayUpdate, @NonNull LinearLayout itemImageFocus) {
    this.rootView = rootView;
    this.imageArrayUpdate = imageArrayUpdate;
    this.itemImageFocus = itemImageFocus;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemUpdateImageArrayBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemUpdateImageArrayBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_update_image_array, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemUpdateImageArrayBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.image_array_update;
      GifImageView imageArrayUpdate = ViewBindings.findChildViewById(rootView, id);
      if (imageArrayUpdate == null) {
        break missingId;
      }

      id = R.id.item_image_focus;
      LinearLayout itemImageFocus = ViewBindings.findChildViewById(rootView, id);
      if (itemImageFocus == null) {
        break missingId;
      }

      return new ItemUpdateImageArrayBinding((ConstraintLayout) rootView, imageArrayUpdate,
          itemImageFocus);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
