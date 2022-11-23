package product.truckkz.windows.authorization.fullRegistration;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import product.truckkz.R;

public class FullRegistrationFragment3Directions {
  private FullRegistrationFragment3Directions() {
  }

  @NonNull
  public static NavDirections actionFullRegistrationFragment3ToHomeFragment() {
    return new ActionOnlyNavDirections(R.id.action_fullRegistrationFragment3_to_homeFragment);
  }
}
