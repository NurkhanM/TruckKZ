package product.truckkz.windows.authorization;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import product.truckkz.R;

public class AuthorizationFragmentDirections {
  private AuthorizationFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionAuthorizationFragmentToRegistrationFragment() {
    return new ActionOnlyNavDirections(R.id.action_authorizationFragment_to_registrationFragment);
  }

  @NonNull
  public static NavDirections actionAuthorizationFragmentToResetFragment() {
    return new ActionOnlyNavDirections(R.id.action_authorizationFragment_to_resetFragment);
  }

  @NonNull
  public static NavDirections actionAuthorizationFragmentToProfileFragment() {
    return new ActionOnlyNavDirections(R.id.action_authorizationFragment_to_profileFragment);
  }
}
