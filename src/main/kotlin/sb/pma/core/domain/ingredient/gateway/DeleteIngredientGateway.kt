package sb.pma.core.domain.ingredient.gateway

import sb.pma.core.domain.ingredient.model.Ingredient

interface DeleteIngredientGateway {

    fun execute(ingredient: Ingredient)
}