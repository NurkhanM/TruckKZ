package product.truckkz.windows.authorization.fullRegistration

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import product.truckkz.FormFullRegistration.apartmentNumberList
import product.truckkz.FormFullRegistration.apartmentNumberList2
import product.truckkz.FormFullRegistration.authorityDoc
import product.truckkz.FormFullRegistration.cityOrVillageList
import product.truckkz.FormFullRegistration.cityOrVillageList2
import product.truckkz.FormFullRegistration.dateOfBirth
import product.truckkz.FormFullRegistration.dateOfIssueDoc
import product.truckkz.FormFullRegistration.districtList
import product.truckkz.FormFullRegistration.districtList2
import product.truckkz.FormFullRegistration.firstNameUser
import product.truckkz.FormFullRegistration.houseNumberList
import product.truckkz.FormFullRegistration.houseNumberList2
import product.truckkz.FormFullRegistration.idDoc
import product.truckkz.FormFullRegistration.idList
import product.truckkz.FormFullRegistration.idList2
import product.truckkz.FormFullRegistration.idUser
import product.truckkz.FormFullRegistration.lastNameUser
import product.truckkz.FormFullRegistration.phoneUser
import product.truckkz.FormFullRegistration.regionList
import product.truckkz.FormFullRegistration.regionList2
import product.truckkz.FormFullRegistration.streetList
import product.truckkz.FormFullRegistration.streetList2
import product.truckkz.FormFullRegistration.tinDoc
import product.truckkz.R
import product.truckkz.UserDate
import product.truckkz.UserDate.TOKEN_USER
import product.truckkz.UserDate.USER_STATUS_FULL
import product.truckkz.viewModels.HomeViewModels
import com.google.gson.JsonObject
import gun0912.tedimagepicker.builder.TedImagePicker
import kotlinx.android.synthetic.main.fragment_full_registration3.view.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.ByteArrayOutputStream


class FullRegistrationFragment3 : Fragment() {

    private lateinit var viewModel: HomeViewModels
    private var stateSelectImageFirst = false
    private var stateSelectImageFirst2 = false
    private var stateSelectImageFirst3 = false

    val list: ArrayList<MultipartBody.Part> = ArrayList()
    lateinit var dialog: Dialog
    lateinit var dialog2: Dialog

    private var filePart: MultipartBody.Part? = null
    private var filePart2: MultipartBody.Part? = null
    private var filePart3: MultipartBody.Part? = null

    private var filePartAll = ArrayList<MultipartBody.Part?>()

    private lateinit var preferencesUserId: SharedPreferences
    private lateinit var preferencesUserStatus: SharedPreferences
    private lateinit var preferencesTOKEN: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[HomeViewModels::class.java]
        val view = inflater.inflate(R.layout.fragment_full_registration3, container, false)
        dialog = Dialog(requireContext())
        dialog2 = Dialog(requireContext())

        setNormalSingleButton(view)
        setNormalSingleButton2(view)
        setNormalSingleButton3(view)



        preferencesUserId = (activity as AppCompatActivity).getSharedPreferences(
            UserDate.APP_PREFERENCES,
            Context.MODE_PRIVATE
        )

        preferencesUserStatus = (activity as AppCompatActivity).getSharedPreferences(
            UserDate.APP_PREFERENCES,
            Context.MODE_PRIVATE
        )

        preferencesTOKEN = (activity as AppCompatActivity).getSharedPreferences(
            UserDate.APP_PREFERENCES,
            Context.MODE_PRIVATE
        )


        idUser = preferencesUserId.getString(UserDate.KEY_USER_ID, "0").toString()
        TOKEN_USER = preferencesTOKEN.getString(UserDate.KEY_TOKEN, "").toString()

        view.nextPage.setOnClickListener {

            if (view.editNumberCard.text.isNotEmpty() && view.editDateOfIssue.text.isNotEmpty() && view.editAuthority.text.isNotEmpty() &&
                    stateSelectImageFirst && stateSelectImageFirst2 && stateSelectImageFirst3) {

                view.linScreens.visibility = View.GONE
                view.prevPage.visibility = View.GONE
                view.nextPage.visibility = View.GONE
                view.gifLoader.visibility = View.VISIBLE

                tinDoc = view.editNumberCard.text.toString()
                dateOfIssueDoc = view.editDateOfIssue.text.toString()
                authorityDoc = view.editAuthority.text.toString()
                filePartAll.clear()
                filePartAll.add(filePart)
                filePartAll.add(filePart2)
                filePartAll.add(filePart3)


                val oneJSONObject = JsonObject()
                oneJSONObject.addProperty("id", idUser)
                oneJSONObject.addProperty("firstName", firstNameUser)
                oneJSONObject.addProperty("lastName", lastNameUser)
                oneJSONObject.addProperty("phoneNumber", phoneUser)
                oneJSONObject.addProperty("dateOfBirth", dateOfBirth)


                val passportDataOBJ = JsonObject()
                passportDataOBJ.addProperty("id", idDoc)
                passportDataOBJ.addProperty("tin", tinDoc)
                passportDataOBJ.addProperty("dateOfIssue", dateOfIssueDoc)
                passportDataOBJ.addProperty("authority", authorityDoc)
                oneJSONObject.add("passportData", passportDataOBJ)


                val registeredAddressOBJ = JsonObject()
                registeredAddressOBJ.addProperty("id", idList)
                registeredAddressOBJ.addProperty("region", regionList)
                registeredAddressOBJ.addProperty("cityOrVillage", cityOrVillageList)
                registeredAddressOBJ.addProperty("district", districtList)
                registeredAddressOBJ.addProperty("street", streetList)
                registeredAddressOBJ.addProperty("houseNumber", houseNumberList)
                registeredAddressOBJ.addProperty("apartmentNumber", apartmentNumberList)
                oneJSONObject.add("registeredAddress", registeredAddressOBJ)


                val registeredAddressOBJ2 = JsonObject()
                registeredAddressOBJ2.addProperty("id", idList2)
                registeredAddressOBJ2.addProperty("region", regionList2)
                registeredAddressOBJ2.addProperty("cityOrVillage", cityOrVillageList2)
                registeredAddressOBJ2.addProperty("district", districtList2)
                registeredAddressOBJ2.addProperty("street", streetList2)
                registeredAddressOBJ2.addProperty("houseNumber", houseNumberList2)
                registeredAddressOBJ2.addProperty("apartmentNumber", apartmentNumberList2)
                oneJSONObject.add("residenceAddress", registeredAddressOBJ2)

                viewModel.postUserFullRegister("Bearer $TOKEN_USER", oneJSONObject, filePartAll)

            } else {
                Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT)
                    .show()
            }


        }

        viewModel.myUserFullRegister.observe(viewLifecycleOwner) { list ->


            if (list.isSuccessful) {
                USER_STATUS_FULL = true
                preferencesUserStatus.edit().putBoolean(UserDate.KEY_USER_STATUS_FULL, USER_STATUS_FULL).apply()
                alertDialogCancel2(view)

            } else {
                view.linScreens.visibility = View.VISIBLE
                view.prevPage.visibility = View.VISIBLE
                view.nextPage.visibility = View.VISIBLE
                view.gifLoader.visibility = View.GONE
                val jsonObj = JSONObject(list.errorBody()!!.charStream().readText())
                alertDialogCancel(
                    jsonObj.getString("message").toString(),
                    jsonObj.getString("errors").toString()
                )
            }

        }

        view.prevPage.setOnClickListener {
            activity?.onBackPressed()
        }


        return view
    }

    private fun sendFileRequest(image: Bitmap): MultipartBody.Part {
        val stream = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.JPEG, 80, stream)
        val byteArray = stream.toByteArray()

        return MultipartBody.Part.createFormData(
            "multipartFiles",
            "photo",
            byteArray.toRequestBody("image/*".toMediaTypeOrNull(), 0, byteArray.size)
        )

    }


    private fun setNormalSingleButton(v: View) {
        v.imageFront.setOnClickListener {
            TedImagePicker.with(requireContext())
                .start { uri ->
                    showSingleImage(v, uri)
                }
        }
    }

    private fun setNormalSingleButton2(v: View) {
        v.imageBack.setOnClickListener {
            TedImagePicker.with(requireContext())
                .start { uri ->
                    showSingleImage2(v, uri)
                }
        }
    }

    private fun setNormalSingleButton3(v: View) {
        v.imageUserCard.setOnClickListener {
            TedImagePicker.with(requireContext())
                .start { uri ->
                    showSingleImage3(v, uri)
                }
        }
    }


    @SuppressLint("Recycle")
    private fun showSingleImage(v: View, uri: Uri) {
        try {
            v.imageFront.scaleType = ImageView.ScaleType.CENTER_INSIDE
            Glide.with(requireContext()).load(uri)
                .thumbnail(Glide.with(requireContext()).load(R.drawable.loader))
                .into(v.imageFront)

            stateSelectImageFirst = true
            filePart = sendFileRequest(MediaStore.Images.Media.getBitmap(requireContext().contentResolver, uri))

        } catch (e: Exception) {
            e.printStackTrace()
            Glide.with(requireContext()).load(R.drawable.image_add)
                .thumbnail(Glide.with(requireContext()).load(R.drawable.loader))
                .fitCenter()
                .into(v.imageFront)
            Toast.makeText(requireContext(), "Нет фотографии", Toast.LENGTH_LONG)
                .show()
        }
    }

    @SuppressLint("Recycle")
    private fun showSingleImage2(v: View, uri: Uri) {
        try {
            v.imageBack.scaleType = ImageView.ScaleType.CENTER_INSIDE
            Glide.with(requireContext()).load(uri)
                .thumbnail(Glide.with(requireContext()).load(R.drawable.loader))
                .into(v.imageBack)
            stateSelectImageFirst2 = true
            filePart2 = sendFileRequest(MediaStore.Images.Media.getBitmap(requireContext().contentResolver, uri))


        } catch (e: Exception) {
            e.printStackTrace()
            Glide.with(requireContext()).load(R.drawable.image_add)
                .thumbnail(Glide.with(requireContext()).load(R.drawable.loader))
                .fitCenter()
                .into(v.imageBack)
            Toast.makeText(requireContext(), "Нет фотографии", Toast.LENGTH_LONG)
                .show()
        }
    }

    @SuppressLint("Recycle")
    private fun showSingleImage3(v: View, uri: Uri) {
        try {
            v.imageUserCard.scaleType = ImageView.ScaleType.CENTER_INSIDE
            Glide.with(requireContext()).load(uri)
                .thumbnail(Glide.with(requireContext()).load(R.drawable.loader))
                .into(v.imageUserCard)

            stateSelectImageFirst3 = true
            filePart3 = sendFileRequest(MediaStore.Images.Media.getBitmap(requireContext().contentResolver, uri))


        } catch (e: Exception) {
            e.printStackTrace()
            Glide.with(requireContext()).load(R.drawable.image_add)
                .thumbnail(Glide.with(requireContext()).load(R.drawable.loader))
                .fitCenter()
                .into(v.imageUserCard)
            Toast.makeText(requireContext(), "Нет фотографии", Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun alertDialogCancel(title: String, descrip: String) {

        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(R.layout.dialog_error_auth)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val buttonYES = dialog.findViewById<ImageView>(R.id.dialog_yes)
        val textTitle = dialog.findViewById<TextView>(R.id.txt_title)
        val textDescrip = dialog.findViewById<TextView>(R.id.txt_descript)
        textTitle.text = title
        textDescrip.text = descrip
        buttonYES.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }

    private fun alertDialogCancel2(v: View) {

        dialog2.setCancelable(false)
        dialog2.setCanceledOnTouchOutside(false)
        dialog2.setContentView(R.layout.dialog_succes_register)
        dialog2.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val buttonYES = dialog2.findViewById<ImageView>(R.id.dialog_yes)
        buttonYES.setOnClickListener {
            Navigation.findNavController(v)
                .navigate(R.id.action_fullRegistrationFragment3_to_homeFragment)
            dialog2.dismiss()
        }
        dialog2.show()

    }


}