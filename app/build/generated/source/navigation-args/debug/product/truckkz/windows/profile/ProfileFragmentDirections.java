package product.truckkz.windows.profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import product.truckkz.R;

public class ProfileFragmentDirections {
  private ProfileFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionProfileFragmentToMyAdsFragment() {
    return new ActionOnlyNavDirections(R.id.action_profileFragment_to_myAdsFragment);
  }

  @NonNull
  public static NavDirections actionProfileFragmentToSettingsFragment() {
    return new ActionOnlyNavDirections(R.id.action_profileFragment_to_settingsFragment);
  }

  @NonNull
  public static NavDirections actionProfileFragmentToFullRegistrationFragment() {
    return new ActionOnlyNavDirections(R.id.action_profileFragment_to_fullRegistrationFragment);
  }

  @NonNull
  public static NavDirections actionProfileFragmentToAuthorizationFragment() {
    return new ActionOnlyNavDirections(R.id.action_profileFragment_to_authorizationFragment);
  }
}
