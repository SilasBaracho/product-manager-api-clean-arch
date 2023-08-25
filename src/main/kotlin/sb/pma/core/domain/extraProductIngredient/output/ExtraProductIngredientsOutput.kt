package sb.pma.core.domain.extraProductIngredient.output

import sb.pma.core.domain.ingredient.output.IngredientOutput
import java.math.BigDecimal

interface ExtraProductIngredientsOutput {
    var ingredient: IngredientOutput?
    val additionalCost: BigDecimal?
}