package sb.pma.core.domain.extraProductIngredient.useCase

import sb.pma.core.useCase.extraProductIngredient.delete.DeleteExtraIngredientsByProductInput

interface DeleteExtraIngredientsByProductUseCase {
    operator fun invoke(input: DeleteExtraIngredientsByProductInput)
}