package sb.pma.core.useCase.extraProductIngredient.findByIdProduct

import java.util.UUID

data class FindExtraIngredientsByProductInput(
    val idProduct: UUID
): java.io.Serializable {}
