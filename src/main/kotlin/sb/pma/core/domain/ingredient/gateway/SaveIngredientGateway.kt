package sb.pma.core.domain.ingredient.gateway

import sb.pma.core.domain.ingredient.model.Ingredient

interface SaveIngredientGateway {

    fun execute(ingredient: Ingredient): Ingredient
}