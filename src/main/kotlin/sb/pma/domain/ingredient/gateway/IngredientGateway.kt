package sb.pma.domain.ingredient.gateway

import sb.pma.domain.ingredient.model.Ingredient
import sb.pma.domain.ingredient.model.IngredientImpl
import java.util.Optional

interface IngredientGateway {
    fun save(ingredient: Ingredient): Ingredient

    fun delete(ingredient: Ingredient)

    fun findAll(): MutableList<Ingredient>

    fun findById(id: Long): Optional<Ingredient>

    fun findByName(name: String): Optional<Ingredient>

    fun findOrCreateIngredientByName(name: String): Ingredient
}