package product.truckkz.models.nepolnyi

data class Role(
    val id: Int,
    val name: String,
    val permissions: List<Permission>
)