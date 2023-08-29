package sb.pma.core.useCase.ingredient.findAll

import sb.pma.core.domain.ingredient.gateway.FindAllIngredientGateway
import sb.pma.core.domain.ingredient.output.IngredientOutput
import sb.pma.core.domain.ingredient.output.IngredientOutputImpl
import sb.pma.core.domain.ingredient.useCase.FindAllIngredientUseCase

class FindAllIngredientUseCaseImpl(
    private val findAllIngredientGateway: FindAllIngredientGateway
): FindAllIngredientUseCase {

    override operator fun invoke(): List<IngredientOutput> {
        return findAllIngredientGateway.execute().map { IngredientOutputImpl(it) }
    }
}