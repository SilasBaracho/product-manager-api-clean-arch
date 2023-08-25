package sb.pma.core.useCase.ingredient.findAll

import sb.pma.core.domain.ingredient.gateway.IngredientGateway
import sb.pma.core.domain.ingredient.output.IngredientOutput
import sb.pma.core.domain.ingredient.output.IngredientOutputImpl
import sb.pma.core.domain.ingredient.useCase.FindAllIngredientUseCase

class FindAllIngredientUseCaseImpl(
    private val ingredientGateway: IngredientGateway
): FindAllIngredientUseCase {

    override operator fun invoke(): List<IngredientOutput> {
        return ingredientGateway.findAll().map { IngredientOutputImpl(it) }
    }
}