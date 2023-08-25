package sb.pma.core.useCase.ingredient.create

import sb.pma.core.domain.ingredient.gateway.IngredientGateway
import sb.pma.core.domain.ingredient.model.IngredientImpl
import sb.pma.core.domain.ingredient.output.IngredientOutput
import sb.pma.core.domain.ingredient.output.IngredientOutputImpl
import sb.pma.core.domain.ingredient.useCase.CreateIngredientUseCase

class CreateIngredientUseCaseImpl(
    private val ingredientGateway: IngredientGateway
): CreateIngredientUseCase {

    override fun invoke(payload: CreateIngredientInput): IngredientOutput {
        return IngredientOutputImpl(ingredientGateway.save(IngredientImpl(name = payload.name)))
    }
}