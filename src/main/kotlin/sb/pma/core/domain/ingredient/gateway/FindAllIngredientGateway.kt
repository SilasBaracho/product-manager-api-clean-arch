package sb.pma.core.domain.ingredient.gateway

import sb.pma.core.domain.ingredient.model.Ingredient

interface FindAllIngredientGateway {

    fun execute(): MutableList<Ingredient>
}