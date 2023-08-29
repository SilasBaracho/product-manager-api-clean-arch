package sb.pma.infrastructure.resources.ingredient.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.ingredient.gateway.FindIngredientByNameGateway
import sb.pma.core.domain.ingredient.model.Ingredient
import sb.pma.infrastructure.config.db.repository.IngredientRepository
import sb.pma.infrastructure.resources.ingredient.adapter.IngredientAdapter
import java.util.Optional

@Component
class FindIngredientByNameGatewayImpl(
    private val ingredientAdapter: IngredientAdapter,
    private val ingredientRepository: IngredientRepository
): FindIngredientByNameGateway {

    override fun execute(name: String): Optional<Ingredient> {
        return ingredientRepository.findByName(name).map { ingredientAdapter.toDomain(it) }
    }
}