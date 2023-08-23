package sb.pma.domain.product.model

import sb.pma.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.domain.productCategory.model.ProductCategory
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

interface Product {
    val idProduct: UUID
    val idPartner: UUID
    val name: String
    val description: String?
    val price: BigDecimal
    val active: Boolean?
    val extraIngredientLimit: Int?
    val createAt: LocalDateTime
    val updateAt: LocalDateTime?
    var productCategory: ProductCategory
    var extraProductIngredients: Set<ExtraProductIngredient>?
}