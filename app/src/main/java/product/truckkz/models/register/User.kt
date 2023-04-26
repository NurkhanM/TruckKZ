package product.truckkz.models.register

data class User(
    val created_at: String,
    val email: String,
    val email_verified_at: Any,
    val id: Int,
    val img: String,
    val name: String,
    val phone: String,
    val status: String
)