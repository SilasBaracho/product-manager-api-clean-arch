package sb.pma.infrastructure.resources.ingredient.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.ingredient.gateway.FindIngredientByNameGateway
import sb.pma.core.domain.ingredient.gateway.FindOrCreateIngredientByNameGateway
import sb.pma.core.domain.ingredient.gateway.SaveIngredientGateway
import sb.pma.core.domain.ingredient.model.Ingredient
import sb.pma.core.domain.ingredient.model.IngredientImpl
import java.time.LocalDateTime

@Component
class FindOrCreateIngredientByNameGatewayImpl(
    private val findIngredientByNameGateway: FindIngredientByNameGateway,
    private val saveIngredientGateway: SaveIngredientGateway
): FindOrCreateIngredientByNameGateway {

    override fun execute(name: String): Ingredient {
        return findIngredientByNameGateway.execute(name)
            .orElseGet {
                saveIngredientGateway.execute(
                    IngredientImpl(name = name, createdAt = LocalDateTime.now())
                )
            }
    }
}