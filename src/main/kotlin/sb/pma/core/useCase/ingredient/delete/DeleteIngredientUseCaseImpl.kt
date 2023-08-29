package sb.pma.core.useCase.ingredient.delete

import sb.pma.core.domain.ingredient.gateway.DeleteIngredientGateway
import sb.pma.core.domain.ingredient.gateway.FindIngredientByIdGateway
import sb.pma.core.domain.ingredient.useCase.DeleteIngredientUseCase
import sb.pma.infrastructure.exception.NotFoundException

class DeleteIngredientUseCaseImpl(
    private val deleteIngredientGateway: DeleteIngredientGateway,
    private val findIngredientByIdGateway: FindIngredientByIdGateway
): DeleteIngredientUseCase {

    override operator fun invoke(payload: DeleteIngredientInput){
        val ingredient = findIngredientByIdGateway.execute(payload.id).orElseThrow { NotFoundException("Ingredient not found") }
        deleteIngredientGateway.execute(ingredient)
    }
}