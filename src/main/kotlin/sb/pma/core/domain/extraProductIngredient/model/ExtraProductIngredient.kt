package sb.pma.core.domain.extraProductIngredient.model

import sb.pma.core.domain.ingredient.model.Ingredient
import sb.pma.core.domain.product.model.Product
import java.math.BigDecimal

interface ExtraProductIngredient {
    val product: Product
    val ingredient: Ingredient
    val additionalCost: BigDecimal?
}