package product.truckkz.models.category

data class Children(
    val children: List<Any>,
    val created_at: String,
    val description: String,
    val id: Int,
    val img: String,
    val name: String,
    val parent_id: Int,
    val slug: String
)