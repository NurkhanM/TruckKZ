package product.truckkz.models.user

data class UserModels(
    val expires_at: String,
    val token: String,
    val token_type: String,
    val user: User
)