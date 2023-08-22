package sb.pma.useCase.extraProductIngredients

import sb.pma.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.useCase.ingredient.IngredientOutput
import java.math.BigDecimal

data class ExtraProductIngredientsOutput(
    var ingredient: IngredientOutput? = null,
    val additionalCost: BigDecimal?
): java.io.Serializable{

    constructor(extraProductIngredients: ExtraProductIngredient) : this(
        ingredient = IngredientOutput(extraProductIngredients.ingredient),
        additionalCost = extraProductIngredients.additionalCost
    )
}
