package product.truckkz.windows.createProduct

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import product.truckkz.R
import product.truckkz.viewModels.HomeViewModels
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.prongbang.dialog.SmartDialogFragment
import com.prongbang.dialog.SmartIcon
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import gun0912.tedimagepicker.builder.TedImagePicker
import gun0912.tedimagepicker.builder.type.ButtonGravity
import gun0912.tedimagepicker.builder.type.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONException
import org.json.JSONObject
import product.truckkz.MyUtils
import product.truckkz.UserDate.GET_BRAND_ID
import product.truckkz.UserDate.GET_CATEGORY_ID
import product.truckkz.UserDate.USER_TOKEN
import product.truckkz.databinding.FragmentCreateBinding
import product.truckkz.`interface`.IClickListnearUpdateImage
import product.truckkz.windows.createProduct.brandSelect.BrandSelectFragment
import product.truckkz.windows.createProduct.categorySelect.CategorySelectFragment
import java.io.ByteArrayOutputStream
import java.io.File


class CreateFragment : Fragment() {

    private var _binding: FragmentCreateBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerViewCreate: RecyclerView
    lateinit var adapterProduct: ProductCreateAdapter
    private lateinit var viewModel: HomeViewModels
    private var selectedUriList: ArrayList<Uri>? = null
    private lateinit var filePart2: List<MultipartBody.Part>
    private var stateSelectImageMulti = false
    private var filePart: MultipartBody.Part? = null
    private var stateSelectImageFirst = false
    private lateinit var dialog: Dialog
    private lateinit var dialog2: Dialog
    lateinit var dialogSheet: BottomSheetDialog

    private val params = HashMap<String, RequestBody>()
    private val fields = HashMap<String, RequestBody>()

    val editTextListName = mutableListOf<EditText>()
    val editTextListValue = mutableListOf<EditText>() // список для сохранения ссылок на созданные EditText



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[HomeViewModels::class.java]
        _binding = FragmentCreateBinding.inflate(inflater, container, false)
        val view = binding

        dialog = Dialog(requireContext())
        dialog2 = Dialog(requireContext())
        dialogSheet = BottomSheetDialog(requireContext())

        recyclerViewCreate = binding.rvCreate
        adapterProduct = ProductCreateAdapter(object : IClickListnearUpdateImage {
            override fun clickListener(baseID: String, index: Int) {
                adapterProduct.deleteMyEducations(index)
                if (selectedUriList?.size in 0..9) {
                    binding.cardImageAdd.visibility = View.VISIBLE
                } else {
                    binding.cardImageAdd.visibility = View.GONE
                }
            }

        })
        recyclerViewCreate.adapter = adapterProduct


        binding.imgMain.setOnClickListener {
            stateSelectImageFirst = false
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 302)
        }
        setNormalMultiButton()

        binding.nextSelectedCategory.setOnClickListener {

            val fragment = CategorySelectFragment()
            fragment.setTargetFragment(this, 50)
            parentFragmentManager.beginTransaction()
                .add(fragment, fragment.tag)
                .commit()


        }

        binding.nextSelectedBrand.setOnClickListener {

            val fragment = BrandSelectFragment()
            fragment.setTargetFragment(this, 51)
            parentFragmentManager.beginTransaction()
                .add(fragment, fragment.tag)
                .commit()


        }

        view.clickBackCard.setOnClickListener {
            activity?.onBackPressed()
        }



        view.btnSendCreate.setOnClickListener {
            isCreateGONE()
            if (
                view.editDescription.text?.isNotEmpty() == true &&
                view.editTitle.text?.isNotEmpty() == true &&
                view.editPrice.text?.isNotEmpty() == true &&
                GET_CATEGORY_ID != -1 &&
                GET_BRAND_ID != -1
            ) {
                if (stateSelectImageFirst && stateSelectImageMulti) {
                    uploadProduct()
                } else {
                    isCreateVISIBLE()
                    Toast.makeText(
                        requireContext(),
                        resources.getText(R.string.selected_photo),
                        Toast.LENGTH_SHORT
                    ).show()
                }


            } else {
                isCreateVISIBLE()
                Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT).show()
            }


        }


        viewModel.myProductCreate.observe(viewLifecycleOwner) { list ->
            if (list.isSuccessful) {
                withStyle()
            } else {

                isCreateVISIBLE()

                try {

                    val jsonObj = JSONObject(list.errorBody()!!.charStream().readText())
                    val jsonObjError = JSONObject(jsonObj.getString("errors"))
                    var message = ""

                    for (name in jsonObjError.keys()) {

                        val nameArray = jsonObjError.getJSONArray(name)

                        for (i in 0 until nameArray.length()) {
                            message = nameArray.getString(i)
                        }

                    }

                    alertDialogCancel(message)

                } catch (e: JSONException) {
                    Toast.makeText(requireContext(), "Error Server", Toast.LENGTH_SHORT).show()
                }
            }

        }

        newCreateViewFields()

        return view.root
    }

    private fun isCreateVISIBLE() {
        binding.constraintFon1.visibility = View.VISIBLE
        binding.toolBar.visibility = View.VISIBLE
        binding.btnSendCreate.visibility = View.VISIBLE
        binding.constraintFon2.visibility = View.GONE
        binding.textTitle.text = resources.getString(R.string.create_ads)
    }

    private fun isCreateGONE() {
        binding.constraintFon1.visibility = View.GONE
        binding.toolBar.visibility = View.GONE
        binding.btnSendCreate.visibility = View.GONE
        binding.constraintFon2.visibility = View.VISIBLE
        binding.textTitle.text = resources.getString(R.string.wait)
    }


    private fun uploadProduct() {
        params.clear()
        params["title"] = rb(binding.editTitle.text.toString().trim())
        params["description"] = rb(binding.editDescription.text.toString().trim())
        params["category_id"] = rb(GET_CATEGORY_ID.toString())
        params["brand_id"] = rb(GET_BRAND_ID.toString())

        if (binding.editPrice.length() != 0) {
            params["price"] = rb((binding.editPrice).text.toString().trim())
        } else {
            params["price"] = rb("Договорная")
        }


        // Получение значений каждого EditText из списка
        val editTextName = editTextListName.map { editText -> editText.text.toString() }
        val editTextValues = editTextListValue.map { editText -> editText.text.toString() }

        if (editTextName.isNotEmpty()) {
            editTextName.forEachIndexed { index, s ->
                params["characteristics[$index][name]"] = rb(s)
                params["characteristics[$index][value]"] = rb(editTextValues[index])
            }
        }



        viewModel.pushProductCreate(
            "Bearer $USER_TOKEN",
            params,
            fields,
            filePart,
            filePart2
        )
    }


    @Suppress("DEPRECATION")
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun newCreateViewFields() {

        binding.addButton.setOnClickListener {

            val containerLayout = LinearLayout(requireContext())
            containerLayout.orientation = LinearLayout.VERTICAL
            containerLayout.background = resources.getDrawable(R.drawable.button_background2)
            containerLayout.setPadding(16.dpToPx(), 16.dpToPx(), 16.dpToPx(), 16.dpToPx()) // add padding

            // Set marginBottom of 16dp
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0, 8.dpToPx(), 0, 8.dpToPx())
            containerLayout.layoutParams = layoutParams

            val editTextName = EditText(requireContext())
            editTextName.hint = "Введите имя"
            containerLayout.addView(editTextName)
            editTextListName.add(editTextName)

            val editTextValue = EditText(requireContext())
            editTextValue.hint = "Введите значение"
            containerLayout.addView(editTextValue)
            editTextListValue.add(editTextValue) // сохраняем ссылку на созданный EditText в списке

            val deleteButton = TextView(requireContext())
            deleteButton.text = resources.getString(R.string.delete)
            deleteButton.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.END
            }
            deleteButton.setTextColor(Color.RED)
            deleteButton.setTypeface(null, Typeface.NORMAL)
            deleteButton.setPadding(0, 10.dpToPx(), 6.dpToPx(), 0)

            // Сохраняем ссылки на созданные элементы
            val viewsToDelete = listOf(containerLayout, editTextName, editTextValue, deleteButton)

            deleteButton.setOnClickListener {
                // Используем сохраненные ссылки для удаления элементов
                viewsToDelete.forEach { view -> binding.linearLayout.removeView(view) }
                editTextListName.remove(editTextName)
                editTextListValue.remove(editTextValue) // удаляем ссылку на удаленный EditText из списка

            }

            containerLayout.addView(deleteButton)
            binding.linearLayout.addView(containerLayout)
        }

    }

    private fun Int.dpToPx(): Int {
        val displayMetrics = Resources.getSystem().displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), displayMetrics).toInt()
    }


    private fun rb(value: String): RequestBody {
        return value.toRequestBody("text/plain".toMediaTypeOrNull())
    }


    private fun setNormalMultiButton() {
        binding.cardImageAdd.setOnClickListener {
            TedImagePicker.with(requireContext())
                .max(10, resources.getText(R.string.maximum_10).toString())
                .mediaType(MediaType.IMAGE)
                //.scrollIndicatorDateFormat("YYYYMMDD")
                .buttonGravity(ButtonGravity.BOTTOM)
                //.buttonBackground(R.drawable.btn_sample_done_button)
                //.buttonTextColor(R.color.sample_yellow)
                .errorListener { message -> Log.d("ted", "message: $message") }
                .selectedUri(selectedUriList)
                .startMultiImage { list: List<Uri> ->
                    showMultiImage(list as ArrayList<Uri>)
                }
        }
    }


    @SuppressLint("Recycle")
    private fun showMultiImage(uriList: ArrayList<Uri>) {
        try {
            this.selectedUriList = uriList
            adapterProduct.setList(uriList)
            val list: ArrayList<MultipartBody.Part> = ArrayList()
            for (i in 0 until uriList.size) {
                val f = File.createTempFile("suffix", "prefix", requireContext().cacheDir)
                f.outputStream()
                    .use {
                        requireContext().contentResolver.openInputStream(uriList[i])?.copyTo(it)
                        val requestBody = f.asRequestBody("multipart/form-data".toMediaTypeOrNull())
                        list.add(MultipartBody.Part.createFormData("gallery[]", f.name, requestBody))
                    }
                filePart2 = list
                stateSelectImageMulti = true
            }


        } catch (e: Exception) {
            e.printStackTrace()
            this.selectedUriList = uriList
            adapterProduct.setList(uriList)
            Toast.makeText(
                requireContext(),
                resources.getText(R.string.not_selected_photo),
                Toast.LENGTH_LONG
            )
                .show()
        }
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

    @Suppress("DEPRECATION")
    private fun withStyle() {

        SmartDialogFragment.Builder(parentFragmentManager)
            .setIcon(SmartIcon.SUCCESS)
            .setTitle(resources.getText(R.string.successfully))
            .setMessage(resources.getText(R.string.yeah_product))
            .setPositiveButton(resources.getText(R.string.close)) {
                GET_CATEGORY_ID = -1
                GET_BRAND_ID = -1
                activity?.onBackPressed()
            }

            .build()
            .show()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 50 && resultCode == Activity.RESULT_OK) {
            val result = data?.getStringExtra("result")
            if (result != null) {
                binding.txtNameCategory.text = result
                binding.txtNameCategory.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.black
                    )
                )
//                uploadProductElectronic(getCategoryID)
            }
        } else if (requestCode == 51 && resultCode == Activity.RESULT_OK) {
            val result = data?.getStringExtra("brand")
            if (result != null) {
                binding.txtNameBrand.text = result
                binding.txtNameBrand.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.black
                    )
                )
//                uploadProductElectronic(getCategoryID)
            }
        } else if (requestCode == 302 && resultCode == Activity.RESULT_OK && data != null) {
            startCropActivity(data.data)
        } else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (data != null) {
                val result: CropImage.ActivityResult = CropImage.getActivityResult(data)
                if (resultCode == Activity.RESULT_OK) {
                    filePartScopMetod(result.uri)
                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    MyUtils.uToast(requireContext(), "Opps image eerror")
                }
            } else {
                MyUtils.uToast(requireContext(), resources.getString(R.string.not_selected_photo))
            }
        }
    }


    @Suppress("DEPRECATION")
    @SuppressLint("Recycle")
    private fun filePartScopMetod(uri: Uri) {
        try {
            binding.imgMain.scaleType = ImageView.ScaleType.CENTER_CROP
            MyUtils.uGlide(requireContext(), binding.imgMain, uri)
            sendFileRequest(
                MediaStore.Images.Media.getBitmap(
                    requireContext().contentResolver,
                    uri
                )
            )
            stateSelectImageFirst = true
        } catch (e: Exception) {
            e.printStackTrace()
            binding.imgMain.scaleType = ImageView.ScaleType.FIT_CENTER
            MyUtils.uGlide(requireContext(), binding.imgMain, R.drawable.ic_add2)
            Toast.makeText(
                requireContext(),
                resources.getText(R.string.not_selected_photo),
                Toast.LENGTH_LONG
            )
                .show()
        }
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


    private fun startCropActivity(imageUri: Uri?) {

        CropImage.activity(imageUri)
            .setGuidelines(CropImageView.Guidelines.ON)
            .setAspectRatio(1, 1)
            .setMaxCropResultSize(3200, 3500)
            .setCropShape(CropImageView.CropShape.RECTANGLE)
            .start(requireActivity(), this)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}