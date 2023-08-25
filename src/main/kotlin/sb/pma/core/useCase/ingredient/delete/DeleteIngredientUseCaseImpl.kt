package sb.pma.core.useCase.ingredient.delete

import sb.pma.core.domain.ingredient.gateway.IngredientGateway
import sb.pma.core.domain.ingredient.useCase.DeleteIngredientUseCase
import sb.pma.infrastructure.exception.NotFoundException

class DeleteIngredientUseCaseImpl(
    private val ingredientGateway: IngredientGateway
): DeleteIngredientUseCase {

    override operator fun invoke(payload: DeleteIngredientInput){
        val ingredient = ingredientGateway.findById(payload.id).orElseThrow { NotFoundException("Ingredient not found") }
        ingredientGateway.delete(ingredient)
    }
}