package sb.pma.core.useCase.ingredient.findById

import sb.pma.core.domain.ingredient.gateway.FindIngredientByIdGateway
import sb.pma.infrastructure.exception.NotFoundException
import sb.pma.core.domain.ingredient.output.IngredientOutput
import sb.pma.core.domain.ingredient.output.IngredientOutputImpl
import sb.pma.core.domain.ingredient.useCase.FindIngredientByIdUseCase

class FindIngredientByIdUseCaseImpl(
    private val findIngredientByIdGateway: FindIngredientByIdGateway
): FindIngredientByIdUseCase {

    override operator fun invoke(payload: FindIngredientByIdInput): IngredientOutput {
        return findIngredientByIdGateway.execute(payload.id)
            .orElseThrow { NotFoundException("Product not found") }
            .let { IngredientOutputImpl(it) }
    }
}