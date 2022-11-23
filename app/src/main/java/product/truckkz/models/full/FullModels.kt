package product.truckkz.models.full

data class FullModels(
    val dateOfBirth: String,
    val email: String,
    val firstName: String,
    val id: Int,
    val imageUser: List<ImageUser>,
    val lastName: String,
    val middleName: Any,
    val passportData: PassportData,
    val phoneNumber: String,
    val registeredAddress: RegisteredAddress,
    val registrationComplete: Boolean,
    val residenceAddress: ResidenceAddress,
    val role: Role,
    val status: String,
    val verifiedByTechSupport: Boolean
)