package sb.pma.infrastructure.resources.ingredient.adapter

import sb.pma.domain.ingredient.model.Ingredient
import sb.pma.infrastructure.config.db.schema.IngredientSchema

interface IngredientAdapter {
    fun toSchema(ingredient: Ingredient): IngredientSchema

    fun toDomain(ingredientSchema: IngredientSchema): Ingredient
}