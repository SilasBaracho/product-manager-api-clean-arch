package sb.pma.core.useCase.extraProductIngredient.delete

import java.util.UUID

data class DeleteExtraIngredientsByProductInput(
    val idProduct: UUID
): java.io.Serializable {}
