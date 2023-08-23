package sb.pma.domain.product.model

import sb.pma.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.domain.productCategory.model.ProductCategory
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

data class ProductImpl(
    override val idProduct: UUID = UUID.randomUUID(),
    override val idPartner: UUID,
    override val name: String,
    override val description: String?,
    override val price: BigDecimal,
    override val active: Boolean? = true,
    override val extraIngredientLimit: Int?,
    override val createAt: LocalDateTime = LocalDateTime.now(),
    override val updateAt: LocalDateTime? = null,
    override var productCategory: ProductCategory,
    override var extraProductIngredients: Set<ExtraProductIngredient>? = null,
): Product, java.io.Serializable {

    fun addProductIngredients(extraProductIngredient: ExtraProductIngredient) {
        extraProductIngredients = extraProductIngredients?.plus(extraProductIngredient)
    }
}