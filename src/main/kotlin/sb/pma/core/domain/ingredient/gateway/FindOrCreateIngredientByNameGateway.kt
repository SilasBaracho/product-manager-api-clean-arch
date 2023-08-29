package sb.pma.core.domain.ingredient.gateway

import sb.pma.core.domain.ingredient.model.Ingredient

interface FindOrCreateIngredientByNameGateway {

    fun execute(name: String): Ingredient
}