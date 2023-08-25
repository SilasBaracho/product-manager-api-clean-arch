package sb.pma.core.domain.extraProductIngredient.model

import sb.pma.core.domain.ingredient.model.Ingredient
import sb.pma.core.domain.product.model.Product
import java.math.BigDecimal

data class ExtraProductIngredientImpl(
    override val product: Product,
    override val ingredient: Ingredient,
    override val additionalCost: BigDecimal?
): ExtraProductIngredient, java.io.Serializable{}
