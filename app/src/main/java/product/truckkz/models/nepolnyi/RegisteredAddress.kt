package product.truckkz.models.nepolnyi

data class RegisteredAddress(
    val apartmentNumber: Int,
    val cityOrVillage: String,
    val district: String,
    val houseNumber: Int,
    val id: Int,
    val region: String,
    val street: String
)