package product.truckkz.windows.splash;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import product.truckkz.R;

public class SplashFragmentDirections {
  private SplashFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSplashFragmentToHomeFragment() {
    return new ActionOnlyNavDirections(R.id.action_splashFragment_to_homeFragment);
  }
}
