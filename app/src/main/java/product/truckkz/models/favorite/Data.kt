package product.truckkz.models.favorite

data class Data(
    val characteristics: List<Characteristic>,
    val created_at: String,
    val description: Any,
    val gallery: List<String>,
    val id: Int,
    val img: String,
    val isLike: Boolean,
    val key: Any,
    val likeCount: Int,
    val price: String,
    val slug: String,
    val title: String,
    val updated_at: String
)