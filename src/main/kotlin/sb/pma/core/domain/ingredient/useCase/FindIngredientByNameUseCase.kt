package sb.pma.core.domain.ingredient.useCase

import sb.pma.core.domain.ingredient.output.IngredientOutput
import sb.pma.core.useCase.ingredient.findByName.FindIngredientByNameInput

interface FindIngredientByNameUseCase {

    operator fun invoke(payload: FindIngredientByNameInput): IngredientOutput

}