// Generated by view binder compiler. Do not edit!
package product.truckkz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import product.truckkz.R;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView clickUpdateBackCard;

  @NonNull
  public final NestedScrollView fragmentContainerUpdate;

  @NonNull
  public final ConstraintLayout homeToolbar;

  @NonNull
  public final ImageView imgAuthHome;

  @NonNull
  public final RecyclerView rvCategory;

  @NonNull
  public final RecyclerView rvProduct;

  @NonNull
  public final RecyclerView rvProduct2;

  @NonNull
  public final SwipeRefreshLayout tiRefreshLayout;

  @NonNull
  public final ConstraintLayout updateToolbar;

  private FragmentHomeBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView clickUpdateBackCard, @NonNull NestedScrollView fragmentContainerUpdate,
      @NonNull ConstraintLayout homeToolbar, @NonNull ImageView imgAuthHome,
      @NonNull RecyclerView rvCategory, @NonNull RecyclerView rvProduct,
      @NonNull RecyclerView rvProduct2, @NonNull SwipeRefreshLayout tiRefreshLayout,
      @NonNull ConstraintLayout updateToolbar) {
    this.rootView = rootView;
    this.clickUpdateBackCard = clickUpdateBackCard;
    this.fragmentContainerUpdate = fragmentContainerUpdate;
    this.homeToolbar = homeToolbar;
    this.imgAuthHome = imgAuthHome;
    this.rvCategory = rvCategory;
    this.rvProduct = rvProduct;
    this.rvProduct2 = rvProduct2;
    this.tiRefreshLayout = tiRefreshLayout;
    this.updateToolbar = updateToolbar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.clickUpdateBackCard;
      ImageView clickUpdateBackCard = ViewBindings.findChildViewById(rootView, id);
      if (clickUpdateBackCard == null) {
        break missingId;
      }

      id = R.id.fragmentContainerUpdate;
      NestedScrollView fragmentContainerUpdate = ViewBindings.findChildViewById(rootView, id);
      if (fragmentContainerUpdate == null) {
        break missingId;
      }

      id = R.id.homeToolbar;
      ConstraintLayout homeToolbar = ViewBindings.findChildViewById(rootView, id);
      if (homeToolbar == null) {
        break missingId;
      }

      id = R.id.img_auth_home;
      ImageView imgAuthHome = ViewBindings.findChildViewById(rootView, id);
      if (imgAuthHome == null) {
        break missingId;
      }

      id = R.id.rv_category;
      RecyclerView rvCategory = ViewBindings.findChildViewById(rootView, id);
      if (rvCategory == null) {
        break missingId;
      }

      id = R.id.rv_product;
      RecyclerView rvProduct = ViewBindings.findChildViewById(rootView, id);
      if (rvProduct == null) {
        break missingId;
      }

      id = R.id.rv_product2;
      RecyclerView rvProduct2 = ViewBindings.findChildViewById(rootView, id);
      if (rvProduct2 == null) {
        break missingId;
      }

      id = R.id.tiRefreshLayout;
      SwipeRefreshLayout tiRefreshLayout = ViewBindings.findChildViewById(rootView, id);
      if (tiRefreshLayout == null) {
        break missingId;
      }

      id = R.id.updateToolbar;
      ConstraintLayout updateToolbar = ViewBindings.findChildViewById(rootView, id);
      if (updateToolbar == null) {
        break missingId;
      }

      return new FragmentHomeBinding((ConstraintLayout) rootView, clickUpdateBackCard,
          fragmentContainerUpdate, homeToolbar, imgAuthHome, rvCategory, rvProduct, rvProduct2,
          tiRefreshLayout, updateToolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
