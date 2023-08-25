package sb.pma.core.domain.extraProductIngredient.output

import sb.pma.core.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.core.domain.ingredient.output.IngredientOutput
import sb.pma.core.domain.ingredient.output.IngredientOutputImpl
import java.math.BigDecimal

data class ExtraProductIngredientsOutputImpl(
    override var ingredient: IngredientOutput? = null,
    override val additionalCost: BigDecimal?
): ExtraProductIngredientsOutput, java.io.Serializable{

    constructor(extraProductIngredients: ExtraProductIngredient) : this(
        ingredient = IngredientOutputImpl(extraProductIngredients.ingredient),
        additionalCost = extraProductIngredients.additionalCost
    )
}
