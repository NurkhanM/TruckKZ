package product.truckkz.windows.profile.edit

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Intent
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
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.prongbang.dialog.SmartDialogFragment
import com.prongbang.dialog.SmartIcon
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import product.truckkz.MyUtils.uGlide
import product.truckkz.MyUtils.uToast
import product.truckkz.R
import product.truckkz.UserDate.USER_TOKEN
import product.truckkz.databinding.FragmentEditBinding
import product.truckkz.viewModels.HomeViewModels
import java.io.ByteArrayOutputStream

class EditFragment : Fragment() {

    private var _binding: FragmentEditBinding? = null
    private val binding get() = _binding!!
    private var filePart: MultipartBody.Part? = null

    private lateinit var dialog: Dialog

    private var userImg = ""
    private var userName = ""
    private var userEmail = ""
    private lateinit var viewModel: HomeViewModels

    private val params = HashMap<String, RequestBody>()

    @Suppress("DEPRECATION")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[HomeViewModels::class.java]
        _binding = FragmentEditBinding.inflate(inflater, container, false)
        dialog = Dialog(requireContext())

        val args = arguments
        userImg = args?.getString("User_img").toString()
        userName = args?.getString("User_name").toString()
        userEmail = args?.getString("User_email").toString()


        uGlide(requireContext(), binding.userImg, userImg)
        binding.editName.setText(userName)
        binding.editEmail.setText(userEmail)

        binding.userImg.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, 300)
        }

        binding.selectImg.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, 300)
        }


        binding.removeUser.setOnClickListener {
            alertDialogCancel()
        }
        binding.ochBackCard.setOnClickListener {
            activity?.onBackPressed()
        }


        binding.authBtnPost.setOnClickListener {
            params.clear()

            params["_method"] = rb("put")

            if (binding.editName.text?.isNotEmpty() == true) {
                params["name"] = rb(binding.editName.text.toString().trim())
            }
//                if (view.editEmail.text?.isNotEmpty() == true){
//                    if (view.editEmail.text.toString() == posEmail){
//                        params["email"] = rb("")
//                    }else{
//                        params["email"] = rb(view.editEmail.text.toString().trim())
//                    }
//
//                }

            if (binding.editNewPassword.text?.isNotEmpty() == true) {
                params["password"] = rb(binding.editNewPassword.text.toString())
            }

            if (binding.editNewPassword2.text?.isNotEmpty() == true) {
                params["password_confirmation"] = rb(binding.editNewPassword2.text.toString())
            }

            viewModel.updateUserPost(
                "Bearer $USER_TOKEN",
                params,
                filePart
            )


            binding.profilteRegisterConstreite.visibility = View.GONE
            binding.authBtnPost.visibility = View.GONE
            binding.profileProgress.visibility = View.VISIBLE


        }



        viewModel.myUpdateUserPost.observe(viewLifecycleOwner) { list ->

            if (list.isSuccessful) {
                withStyle()
                binding.profilteRegisterConstreite.visibility = View.VISIBLE
                binding.authBtnPost.visibility = View.VISIBLE
                binding.profileProgress.visibility = View.GONE
            } else {
                val jsonObj = JSONObject(list.errorBody()!!.charStream().readText())
                val jsonObjError = JSONObject(jsonObj.getString("errors"))
                for (name in jsonObjError.keys()) {

                    val nameArray = jsonObjError.getJSONArray(name)

                    for (i in 0 until nameArray.length()) {
                        uToast(requireContext(), nameArray.getString(i))
                    }

                }
                binding.profilteRegisterConstreite.visibility = View.VISIBLE
                binding.authBtnPost.visibility = View.VISIBLE
                binding.profileProgress.visibility = View.GONE
            }
        }



        return binding.root
    }

    private fun alertDialogCancel() {

        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(R.layout.dialog_user_remove)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val buttonExit = dialog.findViewById<ImageView>(R.id.dialog_exit)
        val buttonYes = dialog.findViewById<Button>(R.id.dialog_yes)
        val buttonNo = dialog.findViewById<TextView>(R.id.dialog_no)
        buttonExit.setOnClickListener {
            dialog.dismiss()
        }
        buttonYes.setOnClickListener {
            dialog.dismiss()
        }
        buttonNo.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }


    private fun startCropActivity(imageUri: Uri?) {

        CropImage.activity(imageUri)
            .setGuidelines(CropImageView.Guidelines.ON)
            .setAspectRatio(1, 1)
            .setMaxCropResultSize(2200, 2500)
            .setCropShape(CropImageView.CropShape.OVAL)
            .start(requireActivity(), this)

    }

    @Deprecated("Deprecated in Java")
    @Suppress("DEPRECATION")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 300 && resultCode == Activity.RESULT_OK && data != null) {
            startCropActivity(data.data)
        } else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (data != null) {
                val result: CropImage.ActivityResult = CropImage.getActivityResult(data)
                if (resultCode == Activity.RESULT_OK) {
                    filePartScopMetod(result.uri)
                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    uToast(requireContext(), "Opps image eerror")
                }
            } else {
                uToast(requireContext(), resources.getString(R.string.not_selected_photo))
            }
        }
    }

    private fun rb(value: String): RequestBody {
        return value.toRequestBody("text/plain".toMediaTypeOrNull())
    }

    @Suppress("DEPRECATION")
    @SuppressLint("Recycle")
    private fun filePartScopMetod(uri: Uri) {
        try {
//            v.authImg.scaleType = ImageView.ScaleType.CENTER_CROP
            uGlide(requireContext(), binding.userImg, uri)
            sendFileRequest(
                MediaStore.Images.Media.getBitmap(
                    requireContext().contentResolver,
                    uri
                )
            )

        } catch (e: Exception) {
            e.printStackTrace()
            uGlide(requireContext(), binding.userImg, R.drawable.ic_add2)
            Toast.makeText(
                requireContext(),
                resources.getText(R.string.not_selected_photo),
                Toast.LENGTH_LONG
            )
                .show()
        }
    }

    @Suppress("DEPRECATION")
    private fun withStyle() {

        SmartDialogFragment.Builder((activity as AppCompatActivity).supportFragmentManager)
            .setIcon(SmartIcon.SUCCESS)
            .setTitle("УСПЕХ!!!")
            .setMessage("Профиль Было изменено")
            .setPositiveButton("Выйти") {
                activity?.onBackPressed()
            }

            .build()
            .show()
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


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}