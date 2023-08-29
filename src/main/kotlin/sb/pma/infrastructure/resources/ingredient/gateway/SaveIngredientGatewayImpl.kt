package sb.pma.infrastructure.resources.ingredient.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.ingredient.gateway.SaveIngredientGateway
import sb.pma.core.domain.ingredient.model.Ingredient
import sb.pma.infrastructure.config.db.repository.IngredientRepository
import sb.pma.infrastructure.resources.ingredient.adapter.IngredientAdapter

@Component
class SaveIngredientGatewayImpl(
    private val ingredientAdapter: IngredientAdapter,
    private val ingredientRepository: IngredientRepository
): SaveIngredientGateway {

    override fun execute(ingredient: Ingredient): Ingredient {
        return ingredientRepository.save(
            ingredientAdapter.toSchema(ingredient)
        ).let {
            ingredientAdapter.toDomain(it)
        }
    }
}