package sb.pma.useCase.ingredient.findById

import org.springframework.stereotype.Service
import sb.pma.domain.ingredient.gateway.IngredientGateway
import sb.pma.infrastructure.exception.NotFoundException
import sb.pma.useCase.ingredient.IngredientOutput

@Service
class FindIngredientByIdUseCase(
    val ingredientGateway: IngredientGateway
) {

    operator fun invoke(payload: FindIngredientByIdInput): IngredientOutput {
        return ingredientGateway.findById(payload.id)
            .orElseThrow { NotFoundException("Product not found") }
            .let { IngredientOutput(it) }
    }
}