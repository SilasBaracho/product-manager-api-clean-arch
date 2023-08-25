package sb.pma.core.domain.ingredient.useCase

import sb.pma.core.domain.ingredient.output.IngredientOutput
import sb.pma.core.useCase.ingredient.findById.FindIngredientByIdInput

interface FindIngredientByIdUseCase {

    operator fun invoke(payload: FindIngredientByIdInput): IngredientOutput
}