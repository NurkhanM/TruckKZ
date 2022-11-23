// Generated by view binder compiler. Do not edit!
package product.truckkz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import pl.droidsonroids.gif.GifImageView;
import product.truckkz.R;

public final class ItemTovarBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView cardV;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final ImageView imgFavorite;

  @NonNull
  public final LinearLayout itemFavorite;

  @NonNull
  public final GifImageView itemHomeImages;

  @NonNull
  public final CardView itemStateFast;

  @NonNull
  public final ConstraintLayout rowCostom;

  @NonNull
  public final RatingBar svgRating;

  @NonNull
  public final TextView textName;

  @NonNull
  public final TextView textPrice;

  @NonNull
  public final TextView textRatingSize;

  private ItemTovarBinding(@NonNull ConstraintLayout rootView, @NonNull CardView cardV,
      @NonNull ConstraintLayout constraintLayout, @NonNull ImageView imgFavorite,
      @NonNull LinearLayout itemFavorite, @NonNull GifImageView itemHomeImages,
      @NonNull CardView itemStateFast, @NonNull ConstraintLayout rowCostom,
      @NonNull RatingBar svgRating, @NonNull TextView textName, @NonNull TextView textPrice,
      @NonNull TextView textRatingSize) {
    this.rootView = rootView;
    this.cardV = cardV;
    this.constraintLayout = constraintLayout;
    this.imgFavorite = imgFavorite;
    this.itemFavorite = itemFavorite;
    this.itemHomeImages = itemHomeImages;
    this.itemStateFast = itemStateFast;
    this.rowCostom = rowCostom;
    this.svgRating = svgRating;
    this.textName = textName;
    this.textPrice = textPrice;
    this.textRatingSize = textRatingSize;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemTovarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemTovarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_tovar, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemTovarBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardV;
      CardView cardV = ViewBindings.findChildViewById(rootView, id);
      if (cardV == null) {
        break missingId;
      }

      id = R.id.constraintLayout;
      ConstraintLayout constraintLayout = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout == null) {
        break missingId;
      }

      id = R.id.img_favorite;
      ImageView imgFavorite = ViewBindings.findChildViewById(rootView, id);
      if (imgFavorite == null) {
        break missingId;
      }

      id = R.id.item_favorite;
      LinearLayout itemFavorite = ViewBindings.findChildViewById(rootView, id);
      if (itemFavorite == null) {
        break missingId;
      }

      id = R.id.item_home_images;
      GifImageView itemHomeImages = ViewBindings.findChildViewById(rootView, id);
      if (itemHomeImages == null) {
        break missingId;
      }

      id = R.id.item_state_fast;
      CardView itemStateFast = ViewBindings.findChildViewById(rootView, id);
      if (itemStateFast == null) {
        break missingId;
      }

      ConstraintLayout rowCostom = (ConstraintLayout) rootView;

      id = R.id.svgRating;
      RatingBar svgRating = ViewBindings.findChildViewById(rootView, id);
      if (svgRating == null) {
        break missingId;
      }

      id = R.id.text_name;
      TextView textName = ViewBindings.findChildViewById(rootView, id);
      if (textName == null) {
        break missingId;
      }

      id = R.id.text_price;
      TextView textPrice = ViewBindings.findChildViewById(rootView, id);
      if (textPrice == null) {
        break missingId;
      }

      id = R.id.text_rating_size;
      TextView textRatingSize = ViewBindings.findChildViewById(rootView, id);
      if (textRatingSize == null) {
        break missingId;
      }

      return new ItemTovarBinding((ConstraintLayout) rootView, cardV, constraintLayout, imgFavorite,
          itemFavorite, itemHomeImages, itemStateFast, rowCostom, svgRating, textName, textPrice,
          textRatingSize);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}