package product.truckkz.models.products.index

data class Data(
    val characteristics: List<Characteristic>,
    val created_at: String,
    val description: String,
    val gallery: List<String>,
    val id: Int,
    val img: String,
    val key: Any,
    val price: String,
    val slug: String,
    val title: String
)