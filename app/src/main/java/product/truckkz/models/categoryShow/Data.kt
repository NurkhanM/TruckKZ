package product.truckkz.models.categoryShow

data class Data(
    val children: List<Children>?,
    val created_at: String,
    val description: String,
    val id: Int,
    val img: String,
    val img_app: String,
    val name: String,
    val parent_id: Int,
    val slug: String
)