package sb.pma.core.domain.ingredient.useCase

import sb.pma.core.domain.ingredient.output.IngredientOutput
import sb.pma.core.useCase.ingredient.create.CreateIngredientInput

interface CreateIngredientUseCase {

    operator fun invoke(payload: CreateIngredientInput): IngredientOutput
}