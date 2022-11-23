package product.truckkz.models.createProducts.newProducts

data class NewProductsModels(
    val bookDateFrom: String,
    val bookDateTill: String,
    val categoryId: Int,
    val currency: String,
    val description: String,
    val fieldValue: FieldValue,
    val locationX: Double,
    val locationY: Double,
    val minimumBookingNumberDay: Int,
    val price: Int,
    val productId: Int?,
    val title: String
)