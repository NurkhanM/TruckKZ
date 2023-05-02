package product.truckkz.models.products.show

data class Data(
    val brand: Brand,
    val categories: List<Category>,
    val characteristics: List<Characteristic>,
    val created_at: String,
    val updated_at: String,
    val description: Any,
    val gallery: List<String>,
    val id: Int,
    val img: String,
    val isLike: Boolean,
    val key: Any,
    val price: String,
    val slug: String,
    val title: String,
    val user: User
)