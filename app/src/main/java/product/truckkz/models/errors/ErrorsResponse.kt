package product.truckkz.models.errors

data class ErrorsResponse(
    val errors: List<String>,
    val message: String,
    val statusCode: Int,
    val timestamp: String
)