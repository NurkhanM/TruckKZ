package product.truckkz.windows.authorization.registration

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import product.truckkz.R
import product.truckkz.UserDate
import product.truckkz.viewModels.HomeViewModels
import com.google.gson.JsonObject
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import product.truckkz.MainActivity
import product.truckkz.MyUtils
import product.truckkz.databinding.ActivityMainBinding
import product.truckkz.databinding.FragmentRegistrationBinding
import java.io.ByteArrayOutputStream

class RegistrationFragment : Fragment() {
    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HomeViewModels
    lateinit var dialog: Dialog
    lateinit var dialog2: Dialog
    private var filePart: MultipartBody.Part? = null
    private var stateSelectImageFirst = false
    private lateinit var preferencesUSERSTATUS: SharedPreferences

    private var activityBinding: ActivityMainBinding? = null


    @Suppress("DEPRECATION")
    @SuppressLint("UseCompatLoadingForColorStateLists")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[HomeViewModels::class.java]
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        val view = binding

        dialog = Dialog(requireContext())
        dialog2 = Dialog(requireContext())

        preferencesUSERSTATUS = (activity as AppCompatActivity).getSharedPreferences(
            UserDate.APP_PREFERENCES,
            Context.MODE_PRIVATE
        )


        view.btnBackStack.setOnClickListener {
            activity?.onBackPressed()
        }

        viewModel.myRegisterList.observe(viewLifecycleOwner) { list ->
            if (list.isSuccessful) {
                activity?.onBackPressed()
                alertDialogCancel2()
            } else {
                view.scrollConst.visibility = View.VISIBLE
                view.loafer.visibility = View.GONE
                val jsonObj = JSONObject(list.errorBody()!!.charStream().readText())
                val jsonObjError = JSONObject(jsonObj.getString("errors"))
                var message = ""

                for (name in jsonObjError.keys()){

                    val nameArray = jsonObjError.getJSONArray(name)

                    for (i in 0 until nameArray.length()){
                        message = nameArray.getString(i)
                    }

                }
                alertDialogCancel(message)
            }
        }

        view.btnRegistration.setOnClickListener {
            if (view.authPhone.text!!.isNotEmpty() &&
                view.authEditName.text!!.isNotEmpty() &&
                view.authEditEmail.text!!.isNotEmpty() &&
                view.authEditPassword.text!!.isNotEmpty() &&
                view.authEditPassword2.text!!.isNotEmpty()
            ) {
                if (view.authEditPassword.text.toString() == view.authEditPassword2.text.toString()) {
                    if (view.checkboxState.isChecked) {
                        view.scrollConst.visibility = View.GONE
                        view.loafer.visibility = View.VISIBLE
                        val paramObjectt = JsonObject()
                        paramObjectt.addProperty(
                            "firstName",
                            view.authEditName.text.toString().trim()
                        )
                        paramObjectt.addProperty("email", view.authEditEmail.text.toString().trim())
                        paramObjectt.addProperty(
                            "password",
                            view.authEditPassword.text.toString().trim()
                        )

                        viewModel.pushRegist(rb(view.authEditName.text.toString()), rb(view.authEditEmail.text.toString()),
                            rb(view.authEditPassword.text.toString()),rb(view.authEditPassword2.text.toString()),
                            rb(view.authPhone.text.toString()), filePart)
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Нужно согласиться с пользовательским соглашением",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }

                } else {

                    Toast.makeText(requireContext(), "Пароли не совпадают", Toast.LENGTH_SHORT)
                        .show()
                }

            } else {
                Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT)
                    .show()
            }

        }

        binding.authImg.setOnClickListener {
            stateSelectImageFirst = false
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 302)
        }

        return view.root
    }

    fun rb(value: String): RequestBody {
        return value.toRequestBody("text/plain".toMediaTypeOrNull())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получаем ссылку на ViewBinding активити
        activityBinding = (requireActivity() as? MainActivity)?.binding

        // Используем ссылку на ViewBinding активити, чтобы получить доступ к View
        activityBinding?.bottomAppBar?.visibility = View.GONE
        activityBinding?.floatBottom?.visibility = View.GONE
    }

    private fun alertDialogCancel(descrip: String) {

        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(R.layout.dialog_error_auth)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val buttonYES = dialog.findViewById<ImageView>(R.id.dialog_yes)
        val textDescrip = dialog.findViewById<TextView>(R.id.txt_descript)
        textDescrip.text = descrip
        buttonYES.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }

    private fun alertDialogCancel2() {

        dialog2.setCancelable(false)
        dialog2.setCanceledOnTouchOutside(false)
        dialog2.setContentView(R.layout.dialog_succes_register)
        dialog2.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val buttonYES = dialog2.findViewById<ImageView>(R.id.dialog_yes)
        buttonYES.setOnClickListener {
            dialog2.dismiss()
        }
        dialog2.show()

    }

    private fun sendFileRequest(image: Bitmap) {
        val stream = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.JPEG, 80, stream)
        val byteArray = stream.toByteArray()

        filePart = MultipartBody.Part.createFormData(
            "img",
            "photo",
            byteArray.toRequestBody("image/*".toMediaTypeOrNull(), 0, byteArray.size)
        )

    }

    @Suppress("DEPRECATION")
    @SuppressLint("Recycle")
    private fun filePartScopMetod(uri: Uri) {
        try {
            binding.authImg.scaleType = ImageView.ScaleType.CENTER_CROP
            MyUtils.uGlide(requireContext(), binding.authImg, uri)
            sendFileRequest(
                MediaStore.Images.Media.getBitmap(
                    requireContext().contentResolver,
                    uri
                )
            )
            stateSelectImageFirst = true
        } catch (e: Exception) {
            e.printStackTrace()
            binding.authImg.scaleType = ImageView.ScaleType.FIT_CENTER
            MyUtils.uGlide(requireContext(), binding.authImg, R.drawable.ic_add)
            Toast.makeText(
                requireContext(),
                resources.getText(R.string.not_selected_photo),
                Toast.LENGTH_LONG
            )
                .show()
        }
    }



    private fun startCropActivity(imageUri: Uri?) {

        CropImage.activity(imageUri)
            .setGuidelines(CropImageView.Guidelines.ON)
            .setAspectRatio(1, 1)
            .setMaxCropResultSize(2500, 2500)
            .setCropShape(CropImageView.CropShape.RECTANGLE)
            .start(requireActivity(), this)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 302 && resultCode == Activity.RESULT_OK && data != null) {
            startCropActivity(data.data)
        } else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (data != null) {
                val result: CropImage.ActivityResult = CropImage.getActivityResult(data)
                if (resultCode == Activity.RESULT_OK) {
                    filePartScopMetod(result.uri)
                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    Toast.makeText(requireContext(), "Opps image eerror", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        activityBinding = null
    }

}