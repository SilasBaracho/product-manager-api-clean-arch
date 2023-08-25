package sb.pma.core.domain.ingredient.useCase

import sb.pma.core.domain.ingredient.output.IngredientOutput

interface FindAllIngredientUseCase {

    operator fun invoke(): List<IngredientOutput>
}