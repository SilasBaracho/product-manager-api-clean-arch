package sb.pma.useCase.ingredient.delete

import org.springframework.stereotype.Service
import sb.pma.domain.ingredient.gateway.IngredientGateway
import sb.pma.infrastructure.exception.NotFoundException

@Service
class DeleteIngredientUseCase(
    val ingredientGateway: IngredientGateway
) {

    operator fun invoke(payload: DeleteIngredientInput){
        val ingredient = ingredientGateway.findById(payload.id).orElseThrow { NotFoundException("Ingredient not found") }
        ingredientGateway.delete(ingredient)
    }
}