package product.truckkz.windows.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import product.truckkz.R
import product.truckkz.UserDate.TOKEN_USER
import product.truckkz.viewModels.HomeViewModels
import product.truckkz.windows.refresh.RefreshActivity
import product.truckkz.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: HomeViewModels


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[HomeViewModels::class.java]
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding

//        (activity as AppCompatActivity).bottomAppBar.visibility = View.VISIBLE
//        (activity as AppCompatActivity).floatBottom.visibility = View.VISIBLE

        if (TOKEN_USER == "") {
            view.isProfileLiner.visibility = View.GONE
            view.nextMyAds.visibility = View.GONE
            view.nextSettings.visibility = View.GONE
//            stateFullRegister(view)
            view.nextExitUser.visibility = View.GONE

        } else {
            view.isProfileLiner.visibility = View.VISIBLE
            view.nextMyAds.visibility = View.VISIBLE
            view.nextSettings.visibility = View.VISIBLE
//            stateFullRegister(view)
            view.nextExitUser.visibility = View.VISIBLE
//            viewModel.getUser("Bearer $TOKEN_USER", idUser.toInt())
        }


        val str = "https://shutniks.com/wp-content/uploads/2020/01/smeshnoy_spanch_bob_35_01155103.jpg"


//        viewModel.myUser.observe(viewLifecycleOwner) { list ->
//            if (list.isSuccessful) {
//                if (list.body()?.imageUser!![0].image.url.isEmpty()){
//                    Glide.with(requireContext())
//                        .load(list.body()?.imageUser!![0].image.url)
//                        .into(view.userImage)
//                } else{
//                    Glide.with(requireContext())
//                        .load(str)
//                        .into(view.userImage)
//                }
//
//                view.textProfileName.text = list.body()?.firstName
//                view.textProfileEmail.text = list.body()?.email
//            } else {
//                Toast.makeText(requireContext(), "Профиль не загружен", Toast.LENGTH_SHORT)
//                    .show()
//            }
//        }



        view.textMyAds.setOnClickListener {
            Navigation.findNavController(view.root)
                .navigate(R.id.action_profileFragment_to_myAdsFragment)
        }

        view.textSettings.setOnClickListener {
            Navigation.findNavController(view.root)
                .navigate(R.id.action_profileFragment_to_settingsFragment)
        }

//        view.nextFullRegister.setOnClickListener {
//                Navigation.findNavController(view)
//                    .navigate(R.id.action_profileFragment_to_authorizationFragment)
//            Navigation.findNavController(view)
//                .navigate(R.id.action_profileFragment_to_fullRegistrationFragment)
//        }

        view.nextExitUser.setOnClickListener {
            val intent = Intent(requireContext(), RefreshActivity::class.java)
            startActivity(intent)
            activity?.overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit)
            activity?.finish()
        }


        return view.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}