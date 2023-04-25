package product.truckkz.windows.home;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import product.truckkz.R;

public class HomeFragmentDirections {
  private HomeFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionHomeFragmentToHomeInfoFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_homeInfoFragment);
  }
}
