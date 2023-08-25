package sb.pma.core.useCase.extraProductIngredient.create

import java.math.BigDecimal

data class CreateExtraProductIngredientsInput(
    val name: String,
    val additionalCost: BigDecimal?
): java.io.Serializable{}
