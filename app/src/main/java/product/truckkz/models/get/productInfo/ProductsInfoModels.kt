package product.truckkz.models.get.productInfo

data class ProductsInfoModels(
    val active: Boolean,
    val characteristics: Any?,
    val clickNumber: Int,
    val description: String,
    val favorite: Boolean,
    val images: List<Images>?,
    val location: Location,
    val minimumBookingNumberDay: Int,
    val price: Int,
    val productId: Int,
    val reviews: List<Any>,
    val title: String
)