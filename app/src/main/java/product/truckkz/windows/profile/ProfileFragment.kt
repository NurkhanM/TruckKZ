package product.truckkz.windows.profile

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import product.truckkz.MyUtils.uGlide
import product.truckkz.MyUtils.uToast
import product.truckkz.R
import product.truckkz.UserDate.USER_TOKEN
import product.truckkz.viewModels.HomeViewModels
import product.truckkz.windows.refresh.RefreshActivity
import product.truckkz.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: HomeViewModels
    var imgUser = ""
    lateinit var dialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[HomeViewModels::class.java]
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding
        val bundle = Bundle()

        dialog = Dialog(requireContext())
        viewModel.getUser("Bearer $USER_TOKEN")

        viewModel.myUser.observe(viewLifecycleOwner) { list ->
            if (list.isSuccessful) {

                view.consHome.visibility = View.VISIBLE
                view.loader.visibility = View.GONE

                uGlide(requireContext(), view.userImage, list.body()?.data?.img)
                imgUser = list.body()?.data?.img.toString()
                view.textProfileName.text = list.body()?.data?.name
                view.textProfileEmail.text = list.body()?.data?.email
            } else {
                uToast(requireContext(), "Профиль не загружен")
            }
        }

        view.textMyAds.setOnClickListener {
            Navigation.findNavController(view.root)
                .navigate(R.id.action_profileFragment_to_myAdsFragment)
        }

        view.textSettings.setOnClickListener {
            bundle.putString("User_img", imgUser)
            bundle.putString("User_name", view.textProfileName.text.toString())
            bundle.putString("User_email", view.textProfileEmail.text.toString())
            Navigation.findNavController(view.root)
                .navigate(R.id.action_profileFragment_to_settingsFragment, bundle)
        }

        view.nextFavorite.setOnClickListener {
                Navigation.findNavController(view.root)
                    .navigate(R.id.action_profileFragment_to_favoriteFragment)
        }

        view.nextExitUser.setOnClickListener {
            alertDialogCancel()
        }

        return view.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun alertDialogCancel() {

        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(R.layout.dialog_user_exit)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val buttonExit = dialog.findViewById<ImageView>(R.id.dialog_exit)
        val buttonYes = dialog.findViewById<Button>(R.id.dialog_yes)
        val buttonNo = dialog.findViewById<TextView>(R.id.dialog_no)
        buttonExit.setOnClickListener {
            dialog.dismiss()
        }
        buttonYes.setOnClickListener {
            dialog.dismiss()
            val intent = Intent(requireContext(), RefreshActivity::class.java)
            startActivity(intent)
            activity?.overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit)
            activity?.finish()
        }
        buttonNo.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }

}