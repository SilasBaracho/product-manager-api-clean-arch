package sb.pma.core.domain.ingredient.gateway

import sb.pma.core.domain.ingredient.model.Ingredient

import java.util.Optional

interface IngredientGateway {
    fun save(ingredient: Ingredient): Ingredient

    fun delete(ingredient: Ingredient)

    fun findAll(): MutableList<Ingredient>

    fun findById(id: Long): Optional<Ingredient>

    fun findByName(name: String): Optional<Ingredient>

    fun findOrCreateIngredientByName(name: String): Ingredient
}