package sb.pma.useCase.product

import sb.pma.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.domain.product.model.Product
import sb.pma.domain.product.model.ProductImpl
import sb.pma.domain.productCategory.model.ProductCategoryImpl
import sb.pma.useCase.extraProductIngredients.ExtraProductIngredientsOutput
import sb.pma.useCase.productCategory.ProductCategoryOutput
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

data class ProductOutput(
    val idProduct: UUID,
    val name: String,
    val description: String? = null,
    val price: BigDecimal,
    val active: Boolean?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime? = null,
    var productCategory: ProductCategoryOutput,
    val extraIngredients: List<ExtraProductIngredientsOutput>? = null
): java.io.Serializable {

    constructor(product: Product, extraProductIngredients: Set<ExtraProductIngredient>? = null): this(
        idProduct = product.idProduct,
        name = product.name,
        description = product.description,
        price = product.price,
        active = product.active,
        createdAt = product.createAt,
        updatedAt = product.updateAt,
        productCategory = ProductCategoryOutput(
            ProductCategoryImpl(
                product.productCategory.id,
                product.productCategory.name,
                product.productCategory.createdAt,
                product.productCategory.updatedAt,
            )
        ),
        extraIngredients = extraProductIngredients?.map { ExtraProductIngredientsOutput(it) }
    )

}