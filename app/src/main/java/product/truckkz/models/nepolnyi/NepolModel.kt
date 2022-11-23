package product.truckkz.models.nepolnyi

data class NepolModel(
    val dateOfBirth: Any,
    val email: String,
    val firstName: String,
    val id: Int,
    val imageUser: List<ImageUser>,
    val lastName: Any,
    val middleName: Any,
    val passportData: PassportData,
    val phoneNumber: Any,
    val registeredAddress: RegisteredAddress,
    val registrationComplete: Boolean,
    val residenceAddress: ResidenceAddress,
    val role: Role,
    val status: String,
    val verifiedByTechSupport: Boolean
)