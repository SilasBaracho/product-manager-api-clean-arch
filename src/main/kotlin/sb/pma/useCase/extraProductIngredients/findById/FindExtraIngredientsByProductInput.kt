package sb.pma.useCase.extraProductIngredients.findById

import java.util.UUID

data class FindExtraIngredientsByProductInput(
    val idProduct: UUID
): java.io.Serializable {}
