package product.truckkz.windows.authorization.fullRegistration

import android.app.DatePickerDialog
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import product.truckkz.FormFullRegistration.dateOfBirth
import product.truckkz.FormFullRegistration.firstNameUser
import product.truckkz.FormFullRegistration.lastNameUser
import product.truckkz.FormFullRegistration.phoneUser
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_full_registration.view.*
import kotlinx.android.synthetic.main.fragment_full_registration.view.nextPage
import product.truckkz.R
import java.text.SimpleDateFormat
import java.util.*


class FullRegistrationFragment : Fragment(), DatePickerDialog.OnDateSetListener {

    private val calendar = Calendar.getInstance()
    private val formatterDay = SimpleDateFormat("dd", Locale.getDefault())
    private val formatterMonth = SimpleDateFormat("MMMM", Locale.getDefault())
    private val formatterYear = SimpleDateFormat("yyyy", Locale.getDefault())
    private val formatterBACKPOST = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_full_registration, container, false)

        (activity as AppCompatActivity).bottomAppBar.visibility = View.GONE
        (activity as AppCompatActivity).floatBottom.visibility = View.GONE

        view.datePickerButton.setOnClickListener {
            datePick()
        }
        view.datePickerButton2.setOnClickListener {
            datePick()
        }
        view.datePickerButton3.setOnClickListener {
            datePick()
        }

        view.nextPage.setOnClickListener {
            if(view.textFirstName.text.isNotEmpty() && view.textLastName.text.isNotEmpty() && view.textPhone.text.isNotEmpty() && view.textDay.text != "ДД"){
                firstNameUser = view.textFirstName.text.toString()
                lastNameUser = view.textLastName.text.toString()
                phoneUser = view.textPhone.text.toString()
                Navigation.findNavController(view).navigate(R.id.action_fullRegistrationFragment_to_fullRegistrationFragment2)
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

    private fun datePick(){
        DatePickerDialog(
            requireContext(),
            android.R.style.Theme_Holo_Light_Panel,
            this,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        calendar.set(year, month, dayOfMonth)
        displayFormattedDate(calendar.timeInMillis)
    }

    private fun displayFormattedDate(timeInMillis: Long) {
        view?.textDay?.text = formatterDay.format(timeInMillis)
        view?.textMonth?.text = formatterMonth.format(timeInMillis)
        view?.textYear?.text = formatterYear.format(timeInMillis)
        dateOfBirth = formatterBACKPOST.format(timeInMillis)
        Log.d(TAG, "postUserFullRegister dateOfBirth: " +
                    "\n TOKEN_USER -> ${dateOfBirth}"  )
    }


}