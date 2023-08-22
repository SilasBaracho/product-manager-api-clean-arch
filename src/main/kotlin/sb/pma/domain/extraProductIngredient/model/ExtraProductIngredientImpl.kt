package sb.pma.domain.extraProductIngredient.model

import sb.pma.domain.ingredient.model.Ingredient
import sb.pma.domain.product.model.Product
import java.math.BigDecimal

data class ExtraProductIngredientImpl(
    override val product: Product,
    override val ingredient: Ingredient,
    override val additionalCost: BigDecimal?
): ExtraProductIngredient, java.io.Serializable{}
