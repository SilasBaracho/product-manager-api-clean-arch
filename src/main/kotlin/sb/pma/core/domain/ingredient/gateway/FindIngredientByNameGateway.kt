package sb.pma.core.domain.ingredient.gateway

import sb.pma.core.domain.ingredient.model.Ingredient
import java.util.Optional

interface FindIngredientByNameGateway {

    fun execute(name: String): Optional<Ingredient>
}