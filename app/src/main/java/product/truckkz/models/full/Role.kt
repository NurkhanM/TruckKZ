package product.truckkz.models.full

data class Role(
    val id: Int,
    val name: String,
    val permissions: List<Permission>
)