package sb.pma.useCase.extraProductIngredients.delete

import java.util.UUID

data class DeleteExtraIngredientsByProductInput(
    val idProduct: UUID
): java.io.Serializable {}
