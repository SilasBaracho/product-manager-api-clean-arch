package sb.pma.useCase.ingredient.findAll

import org.springframework.stereotype.Service
import sb.pma.domain.ingredient.gateway.IngredientGateway
import sb.pma.useCase.ingredient.IngredientOutput

@Service
class FindAllIngredientUseCase(
    val ingredientGateway: IngredientGateway
) {

    operator fun invoke(): List<IngredientOutput> {
        return ingredientGateway.findAll().map { it -> IngredientOutput(it) }
    }
}