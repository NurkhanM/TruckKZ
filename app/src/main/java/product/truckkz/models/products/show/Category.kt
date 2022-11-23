package product.truckkz.models.products.show

data class Category(
    val created_at: String,
    val description: String,
    val id: Int,
    val img: String,
    val name: String,
    val parent_id: Int,
    val slug: String
)