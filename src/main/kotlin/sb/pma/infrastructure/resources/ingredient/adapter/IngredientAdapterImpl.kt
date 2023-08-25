package sb.pma.infrastructure.resources.ingredient.adapter

import org.springframework.stereotype.Component
import sb.pma.core.domain.ingredient.model.Ingredient
import sb.pma.core.domain.ingredient.model.IngredientImpl
import sb.pma.infrastructure.config.db.schema.IngredientSchema

@Component
class IngredientAdapterImpl: IngredientAdapter {
    override fun toSchema(ingredient: Ingredient): IngredientSchema {
        return IngredientSchema(
            id = ingredient.id,
            name = ingredient.name,
            createdAt = ingredient.createdAt,
            updatedAt = ingredient.updatedAt
        )
    }

    override fun toDomain(ingredientSchema: IngredientSchema): Ingredient {
        return IngredientImpl(
            ingredientSchema.id,
            ingredientSchema.name,
            ingredientSchema.createdAt,
            ingredientSchema.updatedAt
        )
    }
}