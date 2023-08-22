package sb.pma.useCase.ingredient.create

import org.springframework.stereotype.Service
import sb.pma.domain.ingredient.gateway.IngredientGateway
import sb.pma.domain.ingredient.model.IngredientImpl
import sb.pma.useCase.ingredient.IngredientOutput

@Service
class CreateIngredientUseCase(
    val ingredientGateway: IngredientGateway
) {

    operator fun invoke(payload: CreateIngredientInput): IngredientOutput {
        return IngredientOutput(ingredientGateway.save(IngredientImpl(name = payload.name)))
    }
}