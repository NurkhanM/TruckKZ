package product.truckkz.windows.authorization.fullRegistration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import product.truckkz.FormFullRegistration.apartmentNumberList
import product.truckkz.FormFullRegistration.apartmentNumberList2
import product.truckkz.FormFullRegistration.cityOrVillageList
import product.truckkz.FormFullRegistration.cityOrVillageList2
import product.truckkz.FormFullRegistration.districtList
import product.truckkz.FormFullRegistration.districtList2
import product.truckkz.FormFullRegistration.houseNumberList
import product.truckkz.FormFullRegistration.houseNumberList2
import product.truckkz.FormFullRegistration.regionList
import product.truckkz.FormFullRegistration.regionList2
import product.truckkz.FormFullRegistration.streetList
import product.truckkz.FormFullRegistration.streetList2
import product.truckkz.R
import kotlinx.android.synthetic.main.fragment_full_registration2.view.*
import kotlinx.android.synthetic.main.fragment_full_registration2.view.nextPage
import kotlinx.android.synthetic.main.fragment_full_registration2.view.prevPage


class FullRegistrationFragment2 : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_full_registration2, container, false)


        view.chbSimilar.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                view.edt11.setText(view.edt1.text.toString())
                view.edt12.setText(view.edt2.text.toString())
                view.edt13.setText(view.edt3.text.toString())
                view.edt14.setText(view.edt4.text.toString())
                view.edt15.setText(view.edt5.text.toString())
                view.edt16.setText(view.edt6.text.toString())
            }else{
                view.edt11.setText("")
                view.edt12.setText("")
                view.edt13.setText("")
                view.edt14.setText("")
                view.edt15.setText("")
                view.edt16.setText("")
            }
        }

        view.nextPage.setOnClickListener {

            if (view.edt1.text.isNotEmpty() && view.edt2.text.isNotEmpty() && view.edt3.text.isNotEmpty() &&
                view.edt4.text.isNotEmpty() && view.edt5.text.isNotEmpty() &&
                view.edt11.text.isNotEmpty() && view.edt12.text.isNotEmpty() && view.edt13.text.isNotEmpty() &&
                view.edt14.text.isNotEmpty() && view.edt15.text.isNotEmpty()) {

                regionList = view.edt1.text.toString()
                cityOrVillageList = view.edt2.text.toString()
                districtList = view.edt3.text.toString()
                streetList = view.edt4.text.toString()
                houseNumberList = view.edt5.text.toString()
                apartmentNumberList = view.edt6.text.toString()

                regionList2 = view.edt11.text.toString()
                cityOrVillageList2 = view.edt12.text.toString()
                districtList2 = view.edt13.text.toString()
                streetList2 = view.edt14.text.toString()
                houseNumberList2 = view.edt15.text.toString()
                apartmentNumberList2 = view.edt16.text.toString()
                Navigation.findNavController(view).navigate(R.id.action_fullRegistrationFragment2_to_fullRegistrationFragment3)
            } else {
                Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT)
                    .show()
            }




        }

        view.prevPage.setOnClickListener {
            activity?.onBackPressed()
        }

        return view
    }


}