package sb.pma.core.useCase.ingredient.findByName

import sb.pma.core.domain.ingredient.gateway.FindIngredientByNameGateway
import sb.pma.infrastructure.exception.NotFoundException
import sb.pma.core.domain.ingredient.output.IngredientOutput
import sb.pma.core.domain.ingredient.output.IngredientOutputImpl
import sb.pma.core.domain.ingredient.useCase.FindIngredientByNameUseCase

class FindIngredientByNameUseCaseImpl(
    private val findIngredientByNameGateway: FindIngredientByNameGateway
): FindIngredientByNameUseCase {

    override operator fun invoke(payload: FindIngredientByNameInput): IngredientOutput {
        return findIngredientByNameGateway.execute(payload.name)
            .orElseThrow { NotFoundException("Ingredient not found") }
            .let { IngredientOutputImpl(it) }
    }
}