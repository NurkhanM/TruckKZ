package product.truckkz.models.category

data class Data(
    val children: ArrayList<Children>,
    val created_at: String,
    val description: String,
    val id: Int,
    val img: String,
    val name: String,
    val parent_id: Any,
    val slug: String
)