package product.truckkz.models.authDate

data class AuthDateModels(
    val accessToken: String,
    val dateOfBirth: Any,
    val email: String,
    val firstName: String,
    val id: Int,
    val imageUser: List<ImageUser>,
    val lastName: Any,
    val middleName: Any,
    val phoneNumber: Any,
    val refreshToken: String,
    val registrationComplete: Boolean,
    val role: String,
    val status: String,
    val type: String,
    val verifiedByTechSupport: Boolean
)