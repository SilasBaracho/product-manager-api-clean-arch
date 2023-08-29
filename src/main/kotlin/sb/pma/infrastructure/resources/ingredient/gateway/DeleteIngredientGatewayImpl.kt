package sb.pma.infrastructure.resources.ingredient.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.ingredient.gateway.DeleteIngredientGateway
import sb.pma.core.domain.ingredient.model.Ingredient
import sb.pma.infrastructure.config.db.repository.IngredientRepository
import sb.pma.infrastructure.resources.ingredient.adapter.IngredientAdapter

@Component
class DeleteIngredientGatewayImpl(
    private val ingredientAdapter: IngredientAdapter,
    private val ingredientRepository: IngredientRepository
): DeleteIngredientGateway {

    override fun execute(ingredient: Ingredient) {
        val ingredientSchema = ingredientAdapter.toSchema(ingredient)
        ingredientRepository.delete(ingredientSchema)
    }
}