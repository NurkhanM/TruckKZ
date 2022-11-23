package product.truckkz.windows.home;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import product.truckkz.R;

public class HomeInfoFragmentDirections {
  private HomeInfoFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionHomeInfoFragmentToFullRegistrationFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeInfoFragment_to_fullRegistrationFragment);
  }

  @NonNull
  public static NavDirections actionHomeInfoFragmentToCalendarFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeInfoFragment_to_calendarFragment);
  }
}
