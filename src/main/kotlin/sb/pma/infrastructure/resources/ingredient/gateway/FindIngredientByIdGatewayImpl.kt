package sb.pma.infrastructure.resources.ingredient.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.ingredient.gateway.FindIngredientByIdGateway
import sb.pma.core.domain.ingredient.model.Ingredient
import sb.pma.infrastructure.config.db.repository.IngredientRepository
import sb.pma.infrastructure.resources.ingredient.adapter.IngredientAdapter
import java.util.Optional

@Component
class FindIngredientByIdGatewayImpl(
    private val ingredientAdapter: IngredientAdapter,
    private val ingredientRepository: IngredientRepository
): FindIngredientByIdGateway {

    override fun execute(id: Long): Optional<Ingredient> {
        return ingredientRepository.findById(id).map { ingredientAdapter.toDomain(it) }
    }
}