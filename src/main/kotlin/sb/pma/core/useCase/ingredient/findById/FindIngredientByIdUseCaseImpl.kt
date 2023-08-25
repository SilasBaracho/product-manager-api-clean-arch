package sb.pma.core.useCase.ingredient.findById

import sb.pma.core.domain.ingredient.gateway.IngredientGateway
import sb.pma.infrastructure.exception.NotFoundException
import sb.pma.core.domain.ingredient.output.IngredientOutput
import sb.pma.core.domain.ingredient.output.IngredientOutputImpl
import sb.pma.core.domain.ingredient.useCase.FindIngredientByIdUseCase

class FindIngredientByIdUseCaseImpl(
    val ingredientGateway: IngredientGateway
): FindIngredientByIdUseCase {

    override operator fun invoke(payload: FindIngredientByIdInput): IngredientOutput {
        return ingredientGateway.findById(payload.id)
            .orElseThrow { NotFoundException("Product not found") }
            .let { IngredientOutputImpl(it) }
    }
}