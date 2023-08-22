package sb.pma.infrastructure.resources.extraProductIngredient.adapter

import sb.pma.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.infrastructure.config.db.schema.ExtraProductIngredientSchema

interface ExtraProductIngredientAdapter {
    fun toSchema(extraProductIngredient: ExtraProductIngredient): ExtraProductIngredientSchema

    fun toDomain(extraProductIngredientSchema: ExtraProductIngredientSchema): ExtraProductIngredient
}