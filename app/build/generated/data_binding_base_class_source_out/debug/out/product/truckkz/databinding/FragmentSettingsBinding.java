// Generated by view binder compiler. Do not edit!
package product.truckkz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import product.truckkz.R;

public final class FragmentSettingsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout Toolbar;

  @NonNull
  public final MaterialButton authBtnPost;

  @NonNull
  public final TextInputEditText editEmail;

  @NonNull
  public final TextInputEditText editName;

  @NonNull
  public final TextInputEditText editNewPassword;

  @NonNull
  public final TextInputEditText editNewPassword2;

  @NonNull
  public final ImageView ochBackCard;

  @NonNull
  public final ProgressBar profileProgress;

  @NonNull
  public final ScrollView profilteRegisterConstreite;

  @NonNull
  public final LinearLayout removeUser;

  @NonNull
  public final LinearLayout selectImg;

  @NonNull
  public final CircleImageView userImg;

  private FragmentSettingsBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout Toolbar, @NonNull MaterialButton authBtnPost,
      @NonNull TextInputEditText editEmail, @NonNull TextInputEditText editName,
      @NonNull TextInputEditText editNewPassword, @NonNull TextInputEditText editNewPassword2,
      @NonNull ImageView ochBackCard, @NonNull ProgressBar profileProgress,
      @NonNull ScrollView profilteRegisterConstreite, @NonNull LinearLayout removeUser,
      @NonNull LinearLayout selectImg, @NonNull CircleImageView userImg) {
    this.rootView = rootView;
    this.Toolbar = Toolbar;
    this.authBtnPost = authBtnPost;
    this.editEmail = editEmail;
    this.editName = editName;
    this.editNewPassword = editNewPassword;
    this.editNewPassword2 = editNewPassword2;
    this.ochBackCard = ochBackCard;
    this.profileProgress = profileProgress;
    this.profilteRegisterConstreite = profilteRegisterConstreite;
    this.removeUser = removeUser;
    this.selectImg = selectImg;
    this.userImg = userImg;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_settings, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSettingsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Toolbar;
      ConstraintLayout Toolbar = ViewBindings.findChildViewById(rootView, id);
      if (Toolbar == null) {
        break missingId;
      }

      id = R.id.authBtnPost;
      MaterialButton authBtnPost = ViewBindings.findChildViewById(rootView, id);
      if (authBtnPost == null) {
        break missingId;
      }

      id = R.id.editEmail;
      TextInputEditText editEmail = ViewBindings.findChildViewById(rootView, id);
      if (editEmail == null) {
        break missingId;
      }

      id = R.id.editName;
      TextInputEditText editName = ViewBindings.findChildViewById(rootView, id);
      if (editName == null) {
        break missingId;
      }

      id = R.id.editNewPassword;
      TextInputEditText editNewPassword = ViewBindings.findChildViewById(rootView, id);
      if (editNewPassword == null) {
        break missingId;
      }

      id = R.id.editNewPassword2;
      TextInputEditText editNewPassword2 = ViewBindings.findChildViewById(rootView, id);
      if (editNewPassword2 == null) {
        break missingId;
      }

      id = R.id.ochBackCard;
      ImageView ochBackCard = ViewBindings.findChildViewById(rootView, id);
      if (ochBackCard == null) {
        break missingId;
      }

      id = R.id.profileProgress;
      ProgressBar profileProgress = ViewBindings.findChildViewById(rootView, id);
      if (profileProgress == null) {
        break missingId;
      }

      id = R.id.profilteRegisterConstreite;
      ScrollView profilteRegisterConstreite = ViewBindings.findChildViewById(rootView, id);
      if (profilteRegisterConstreite == null) {
        break missingId;
      }

      id = R.id.removeUser;
      LinearLayout removeUser = ViewBindings.findChildViewById(rootView, id);
      if (removeUser == null) {
        break missingId;
      }

      id = R.id.selectImg;
      LinearLayout selectImg = ViewBindings.findChildViewById(rootView, id);
      if (selectImg == null) {
        break missingId;
      }

      id = R.id.userImg;
      CircleImageView userImg = ViewBindings.findChildViewById(rootView, id);
      if (userImg == null) {
        break missingId;
      }

      return new FragmentSettingsBinding((ConstraintLayout) rootView, Toolbar, authBtnPost,
          editEmail, editName, editNewPassword, editNewPassword2, ochBackCard, profileProgress,
          profilteRegisterConstreite, removeUser, selectImg, userImg);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
