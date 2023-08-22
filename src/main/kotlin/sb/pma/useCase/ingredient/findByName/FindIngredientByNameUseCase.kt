package sb.pma.useCase.ingredient.findByName

import org.springframework.stereotype.Service
import sb.pma.domain.ingredient.gateway.IngredientGateway
import sb.pma.infrastructure.exception.NotFoundException
import sb.pma.useCase.ingredient.IngredientOutput

@Service
class FindIngredientByNameUseCase(
    val ingredientGateway: IngredientGateway
) {

    operator fun invoke(payload: FindIngredientByNameInput): IngredientOutput {
        return ingredientGateway.findByName(payload.name)
            .orElseThrow { NotFoundException("Ingredient not found") }
            .let { IngredientOutput(it) }
    }
}