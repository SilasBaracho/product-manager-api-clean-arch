package sb.pma.core.domain.ingredient.useCase

import sb.pma.core.useCase.ingredient.delete.DeleteIngredientInput

interface DeleteIngredientUseCase {

    operator fun invoke(payload: DeleteIngredientInput)
}