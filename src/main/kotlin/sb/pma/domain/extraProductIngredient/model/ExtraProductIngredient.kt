package sb.pma.domain.extraProductIngredient.model

import sb.pma.domain.ingredient.model.Ingredient
import sb.pma.domain.product.model.Product
import java.math.BigDecimal

interface ExtraProductIngredient {
    val product: Product
    val ingredient: Ingredient
    val additionalCost: BigDecimal?
}