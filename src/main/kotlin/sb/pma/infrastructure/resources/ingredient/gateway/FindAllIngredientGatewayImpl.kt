package sb.pma.infrastructure.resources.ingredient.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.ingredient.gateway.FindAllIngredientGateway
import sb.pma.core.domain.ingredient.model.Ingredient
import sb.pma.infrastructure.config.db.repository.IngredientRepository
import sb.pma.infrastructure.resources.ingredient.adapter.IngredientAdapter

@Component
class FindAllIngredientGatewayImpl(
    private val ingredientAdapter: IngredientAdapter,
    private val ingredientRepository: IngredientRepository
): FindAllIngredientGateway {

    override fun execute(): MutableList<Ingredient> {
        val ingredients = mutableListOf<Ingredient>()
        ingredientRepository.findAll().map {
            val ingredient = ingredientAdapter.toDomain(it)
            ingredients.add(ingredient)
        }

        return ingredients
    }
}