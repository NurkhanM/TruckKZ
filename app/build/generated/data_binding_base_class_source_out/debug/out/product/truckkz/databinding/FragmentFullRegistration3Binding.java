// Generated by view binder compiler. Do not edit!
package product.truckkz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import pl.droidsonroids.gif.GifImageView;
import product.truckkz.R;

public final class FragmentFullRegistration3Binding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText editAuthority;

  @NonNull
  public final EditText editDateOfIssue;

  @NonNull
  public final EditText editNumberCard;

  @NonNull
  public final GifImageView gifLoader;

  @NonNull
  public final ImageView imageBack;

  @NonNull
  public final ImageView imageFront;

  @NonNull
  public final ImageView imageUserCard;

  @NonNull
  public final LinearLayout linScreens;

  @NonNull
  public final MaterialButton nextPage;

  @NonNull
  public final LinearLayout prevPage;

  private FragmentFullRegistration3Binding(@NonNull ConstraintLayout rootView,
      @NonNull EditText editAuthority, @NonNull EditText editDateOfIssue,
      @NonNull EditText editNumberCard, @NonNull GifImageView gifLoader,
      @NonNull ImageView imageBack, @NonNull ImageView imageFront, @NonNull ImageView imageUserCard,
      @NonNull LinearLayout linScreens, @NonNull MaterialButton nextPage,
      @NonNull LinearLayout prevPage) {
    this.rootView = rootView;
    this.editAuthority = editAuthority;
    this.editDateOfIssue = editDateOfIssue;
    this.editNumberCard = editNumberCard;
    this.gifLoader = gifLoader;
    this.imageBack = imageBack;
    this.imageFront = imageFront;
    this.imageUserCard = imageUserCard;
    this.linScreens = linScreens;
    this.nextPage = nextPage;
    this.prevPage = prevPage;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentFullRegistration3Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentFullRegistration3Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_full_registration3, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentFullRegistration3Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.editAuthority;
      EditText editAuthority = ViewBindings.findChildViewById(rootView, id);
      if (editAuthority == null) {
        break missingId;
      }

      id = R.id.editDateOfIssue;
      EditText editDateOfIssue = ViewBindings.findChildViewById(rootView, id);
      if (editDateOfIssue == null) {
        break missingId;
      }

      id = R.id.editNumberCard;
      EditText editNumberCard = ViewBindings.findChildViewById(rootView, id);
      if (editNumberCard == null) {
        break missingId;
      }

      id = R.id.gifLoader;
      GifImageView gifLoader = ViewBindings.findChildViewById(rootView, id);
      if (gifLoader == null) {
        break missingId;
      }

      id = R.id.imageBack;
      ImageView imageBack = ViewBindings.findChildViewById(rootView, id);
      if (imageBack == null) {
        break missingId;
      }

      id = R.id.imageFront;
      ImageView imageFront = ViewBindings.findChildViewById(rootView, id);
      if (imageFront == null) {
        break missingId;
      }

      id = R.id.imageUserCard;
      ImageView imageUserCard = ViewBindings.findChildViewById(rootView, id);
      if (imageUserCard == null) {
        break missingId;
      }

      id = R.id.linScreens;
      LinearLayout linScreens = ViewBindings.findChildViewById(rootView, id);
      if (linScreens == null) {
        break missingId;
      }

      id = R.id.nextPage;
      MaterialButton nextPage = ViewBindings.findChildViewById(rootView, id);
      if (nextPage == null) {
        break missingId;
      }

      id = R.id.prevPage;
      LinearLayout prevPage = ViewBindings.findChildViewById(rootView, id);
      if (prevPage == null) {
        break missingId;
      }

      return new FragmentFullRegistration3Binding((ConstraintLayout) rootView, editAuthority,
          editDateOfIssue, editNumberCard, gifLoader, imageBack, imageFront, imageUserCard,
          linScreens, nextPage, prevPage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
