package product.truckkz.windows.newCreateProduct

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.ContentValues.TAG
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import product.truckkz.FormCreateProducts.ID_CATEGORY_SELECTED
import product.truckkz.FormCreateProducts.category_Name
import product.truckkz.R
import product.truckkz.UserDate.TOKEN_USER
import product.truckkz.`interface`.IClickListnearHomeCategory
import product.truckkz.viewModels.HomeViewModels
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.gson.JsonObject
import gun0912.tedimagepicker.builder.TedImagePicker
import kotlinx.android.synthetic.main.fragment_create.view.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.ByteArrayOutputStream


class CreateFragment : Fragment() {

//    private lateinit var recyclerViewCategory: RecyclerView


    private lateinit var viewModel: HomeViewModels
    private val edString = ArrayList<String>()
    private val edValue = ArrayList<EditText>()
    private val oneJSONObject = JsonObject()
    private val oneJSONObject2 = JsonObject()
    var filePart1: MultipartBody.Part? = null
    var filePart2: MultipartBody.Part? = null
    var filePart3: MultipartBody.Part? = null
    var filePart4: MultipartBody.Part? = null
    var filePart5: MultipartBody.Part? = null
    var shaffle = ArrayList<Int>()
    var filePartAll = ArrayList<MultipartBody.Part?>()
    var chet = 1
    lateinit var dialog: Dialog
    lateinit var dialog2: Dialog
    lateinit var dialogSheet: BottomSheetDialog


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[HomeViewModels::class.java]
        val view = inflater.inflate(R.layout.fragment_create, container, false)

        dialog = Dialog(requireContext())
        dialog2 = Dialog(requireContext())
        dialogSheet = BottomSheetDialog(requireContext())




        view.cardImage_Add.setOnClickListener {

            chet = stateIntSHAFFLE()
            when (chet) {
                1 -> filePart1 = setNormalSingleButton(view.image_1, view.cardImage_1)
                2 -> filePart2 = setNormalSingleButton(view.image_2, view.cardImage_2)
                3 -> filePart3 = setNormalSingleButton(view.image_3, view.cardImage_3)
                4 -> filePart4 = setNormalSingleButton(view.image_4, view.cardImage_4)
                5 -> filePart5 = setNormalSingleButton(view.image_5, view.cardImage_5)
                else -> Toast.makeText(
                    requireContext(),
                    "???????????????????????? ?????????????????????? 5",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }





        view.imageDelete_1.setOnClickListener {
            view.cardImage_1.visibility = View.GONE
            filePart1 = null
            chet--
            shaffle = removeItem(shaffle, 1)
            filePartAll.removeAt(0)
        }
        view.imageDelete_2.setOnClickListener {
            view.cardImage_2.visibility = View.GONE
            filePart2 = null
            chet--
            shaffle = removeItem(shaffle, 2)
            filePartAll.removeAt(1)
        }
        view.imageDelete_3.setOnClickListener {
            view.cardImage_3.visibility = View.GONE
            filePart3 = null
            chet--
            shaffle = removeItem(shaffle, 3)
            filePartAll.removeAt(2)
        }
        view.imageDelete_4.setOnClickListener {
            view.cardImage_4.visibility = View.GONE
            filePart4 = null
            chet--
            shaffle = removeItem(shaffle, 4)
            filePartAll.removeAt(3)
        }
        view.imageDelete_5.setOnClickListener {
            view.cardImage_5.visibility = View.GONE
            filePart5 = null
            chet--
            shaffle = removeItem(shaffle, 5)
            filePartAll.removeAt(4)
        }


        view.nextSelectedCategory.setOnClickListener {
//            Navigation.findNavController(view).navigate(R.id.action_createFragment2_to_selectedCategoryFragment)
            bottomSheetsDialog(view)
        }

        view.clickBackCard.setOnClickListener {
            activity?.onBackPressed()
        }

        viewModel.myNewProductsCreate.observe(viewLifecycleOwner) { list ->
            if (list.isSuccessful) {
                if (shaffle.size != 0) {
                    for (i in 0 until filePartAll.size) {
                        viewModel.pushImageProducts(
                            "Bearer $TOKEN_USER",
                            list.body()?.productId!!.toInt(),
                            i + 1,
                            filePartAll[i]
                        )
                    }
                }
            } else {
                view.constraintFon1.visibility = View.VISIBLE
                view.btnSendCreate.visibility = View.VISIBLE
                view.Toolbar.visibility = View.VISIBLE
                view.constraintFon2.visibility = View.GONE
                val jsonObj = JSONObject(list.errorBody()!!.charStream().readText())
                alertDialogCancel(
                    jsonObj.getString("message").toString(),
                    jsonObj.getString("errors").toString()
                )
            }
        }

        viewModel.myImageCreate.observe(viewLifecycleOwner) { list ->
            if (list.isSuccessful) {
                alertDialogCancel2("??????????!", list.body().toString())
            } else {
                view.constraintFon1.visibility = View.VISIBLE
                view.btnSendCreate.visibility = View.VISIBLE
                view.Toolbar.visibility = View.VISIBLE
                view.constraintFon2.visibility = View.GONE
                val jsonObj = JSONObject(list.errorBody()!!.charStream().readText())
                alertDialogCancel(
                    jsonObj.getString("message").toString(),
                    jsonObj.getString("errors").toString()
                )
            }
        }

        view.btnSendCreate.setOnClickListener {

            if (view.txtNameCategory.text.toString() != "??????????????????" &&
                view.editTitle.text?.isNotEmpty() == true &&
                view.editPrice.text?.isNotEmpty() == true &&
                view.editRent.text?.isNotEmpty() == true &&
                view.editDescription.text?.isNotEmpty() == true
            ) {
                if (chet != 1) {
                    if (rbViewBoolean()) {
                        Toast.makeText(
                            requireContext(),
                            "?????????????????? ?????? ???????????????????????????? ????????",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        oneJSONObject.addProperty("title", view.editTitle.text.toString())
                        oneJSONObject.addProperty(
                            "description",
                            view.editDescription.text.toString()
                        )
                        oneJSONObject.addProperty("price", view.editPrice.text.toString().toInt())
                        oneJSONObject.addProperty(
                            "minimumBookingNumberDay",
                            view.editRent.text.toString().toInt()
                        )
                        oneJSONObject.addProperty("bookDateFrom", "2022-11-20")
                        oneJSONObject.addProperty("bookDateTill", "2022-11-26")
                        oneJSONObject.addProperty("locationX", 0)
                        oneJSONObject.addProperty("locationY", 0)
                        oneJSONObject.addProperty("categoryId", ID_CATEGORY_SELECTED)
                        for (i in 0 until edString.size) {
                            oneJSONObject2.addProperty(edString[i], rbView(edValue[i]))
                        }
                        oneJSONObject.add("fieldValue", oneJSONObject2)

                        viewModel.postNewProductsCreate("Bearer $TOKEN_USER", oneJSONObject)

                        view.constraintFon1.visibility = View.GONE
                        view.btnSendCreate.visibility = View.GONE
                        view.Toolbar.visibility = View.GONE
                        view.constraintFon2.visibility = View.VISIBLE
                    }

                } else {
                    Toast.makeText(
                        requireContext(),
                        "???????????????? ?????????????? 1 ????????????????",
                        Toast.LENGTH_SHORT
                    ).show()
                }


            } else {
                Toast.makeText(requireContext(), "?????????????????? ?????? ????????", Toast.LENGTH_SHORT).show()
            }


        }

        return view
    }

    private fun stateIntSHAFFLE(): Int {
        var int = 0


        if (!shaffle.contains(5)) {
            int = 5
        }
        if (!shaffle.contains(4)) {
            int = 4
        }

        if (!shaffle.contains(3)) {
            int = 3
        }
        if (!shaffle.contains(2)) {
            int = 2
        }
        if (!shaffle.contains(1)) {
            int = 1
        }

        return int
    }


    private fun removeItem(array: ArrayList<Int>, value: Int): ArrayList<Int> {
        val arr = array.filter { it != value }.toIntArray()
        return arr.toCollection(ArrayList())
    }

    private fun rbView(edit: EditText): String {

        return edit.text.toString()
    }

    private fun rbViewBoolean(): Boolean {

        var boolean = false
        for (i in 0 until edValue.size) {
            if (edValue[i].text.isEmpty()) {
                boolean = true
                break
            }
        }

        return boolean
    }

    private fun setNormalSingleButton(image: ImageView, card: CardView): MultipartBody.Part? {
        var part: MultipartBody.Part? = null
        TedImagePicker.with(requireContext())
            .start { uri ->
                part = showSingleImage(uri, image, card)
            }
        return part
    }


    @SuppressLint("Recycle")
    private fun showSingleImage(uri: Uri, image: ImageView, card: CardView): MultipartBody.Part? {
        var part: MultipartBody.Part? = null
        try {
            image.scaleType = ImageView.ScaleType.CENTER_CROP
            Glide.with(requireContext()).load(uri)
                .thumbnail(Glide.with(requireContext()).load(R.drawable.loader))
                .into(image)
            part = sendFileRequest(
                MediaStore.Images.Media.getBitmap(
                    requireContext().contentResolver,
                    uri
                )
            )
            if (chet < 6) {
                shaffle.add(chet++)
                filePartAll.add(part)
            }
            Log.d(TAG, "stateSHET : $chet ")
            card.visibility = View.VISIBLE


        } catch (e: Exception) {
            e.printStackTrace()
            Glide.with(requireContext()).load(R.drawable.image_add)
                .thumbnail(Glide.with(requireContext()).load(R.drawable.loader))
                .fitCenter()
                .into(image.image_1)
            Toast.makeText(requireContext(), "ErrorImage", Toast.LENGTH_LONG)
                .show()


        }


        return part

    }

    private fun sendFileRequest(image: Bitmap): MultipartBody.Part {
        val stream = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.JPEG, 80, stream)
        val byteArray = stream.toByteArray()

        return MultipartBody.Part.createFormData(
            "file",
            "photo",
            byteArray.toRequestBody("image/*".toMediaTypeOrNull(), 0, byteArray.size)
        )

    }


    @SuppressLint("UseCompatLoadingForDrawables")
    @Suppress("DEPRECATION")
    private fun uploadProductElectronic(v: View) {


        viewModel.getFieldsCategory(ID_CATEGORY_SELECTED)

        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )


        layoutParams.topMargin = 50

        val layoutEdit = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )


        val layoutText = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        val layoutView = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutView.topMargin = 300


        viewModel.myFieldsCategory.observe(viewLifecycleOwner) { list ->

            v.linFieldsFill.removeAllViews()
            edString.clear()
            edValue.clear()

            for (i in 0 until list.body()?.size!!) {

                val linearLayout2 = LinearLayout(v.linFieldsFill.context)
                linearLayout2.removeAllViews()
                linearLayout2.setPadding(15, 10, 15, 10)
                linearLayout2.background =
                    context?.resources?.getDrawable(R.drawable.button_background2);
                linearLayout2.orientation = LinearLayout.VERTICAL
                linearLayout2.layoutParams = layoutParams

                val textView = TextView(linearLayout2.context)
                textView.textSize = 16f
                textView.text = list.body()!![i]
                textView.layoutParams = layoutText

                val editText = EditText(linearLayout2.context)
                editText.layoutParams = layoutEdit
                editText.inputType = EditorInfo.TYPE_CLASS_NUMBER
                editText.background.mutate()
                    .setColorFilter(
                        resources.getColor(R.color.green_txt),
                        PorterDuff.Mode.SRC_ATOP
                    )

                linearLayout2.addView(textView)
                linearLayout2.addView(editText)

                v.linFieldsFill.addView(linearLayout2)
                edString.add(list.body()!![i])
                edValue.add(editText)
            }

            val linearLayout = LinearLayout(v.linFieldsFill.context)
            linearLayout.layoutParams = layoutParams
            val view = View(linearLayout.context)
            view.layoutParams = layoutView
            linearLayout.addView(view)
            v.linFieldsFill.addView(linearLayout)
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

    private fun alertDialogCancel2(title: String, descrip: String) {

        dialog2.setCancelable(false)
        dialog2.setCanceledOnTouchOutside(false)
        dialog2.setContentView(R.layout.dialog_error_auth)
        dialog2.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val buttonYES = dialog2.findViewById<ImageView>(R.id.dialog_yes)
        val textTitle = dialog2.findViewById<TextView>(R.id.txt_title)
        val textDescrip = dialog2.findViewById<TextView>(R.id.txt_descript)
        textTitle.text = title
        textDescrip.text = descrip
        buttonYES.setOnClickListener {
            dialog2.dismiss()
            ID_CATEGORY_SELECTED = -1
            category_Name = "????????????"
            activity?.onBackPressed()
        }
        dialog2.show()

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun bottomSheetsDialog(v: View) {

        dialogSheet.setContentView(R.layout.bottom_category)
        val recyclerViewCategory = dialogSheet.findViewById<RecyclerView>(R.id.rv_category)
        val adapterCategory = SelectedAdapterCategory(object : IClickListnearHomeCategory {
            override fun clickListener(baseID: Int, name: String) {
                ID_CATEGORY_SELECTED = baseID
                v.txtNameCategory.text = name
                v.txtNameCategory.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                uploadProductElectronic(v)
                dialogSheet.dismiss()
            }
        })
        recyclerViewCategory?.adapter = adapterCategory
        recyclerViewCategory?.setHasFixedSize(true)
        viewModel.getCategory()
        viewModel.myCategory.observe(viewLifecycleOwner) { list ->
            if (list.isSuccessful) {
                list.body()?.data!![0].children.let { adapterCategory.setList(it) }
            }

        }

        dialogSheet.show()

    }

}