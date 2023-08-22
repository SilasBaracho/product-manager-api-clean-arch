package sb.pma.useCase.productCategory

import sb.pma.domain.productCategory.model.ProductCategory
import java.time.LocalDateTime

data class ProductCategoryOutput(
    val id: Long,
    val name: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime? = null
): java.io.Serializable{

    constructor(productCategory: ProductCategory) : this(
        id = productCategory.id!!,
        name = productCategory.name,
        createdAt = productCategory.createdAt,
        updatedAt = productCategory.updatedAt
    )


}
