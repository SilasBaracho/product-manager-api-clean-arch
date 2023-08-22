package sb.pma.infrastructure.resources.extraProductIngredient.adapter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Component
import sb.pma.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.domain.extraProductIngredient.model.ExtraProductIngredientImpl
import sb.pma.infrastructure.config.db.schema.ExtraProductIngredientSchema
import sb.pma.infrastructure.resources.ingredient.adapter.IngredientAdapter
import sb.pma.infrastructure.resources.product.adapter.ProductAdapter

@Component
class ExtraProductIngredientAdapterImpl(
    private val ingredientAdapter: IngredientAdapter,
): ExtraProductIngredientAdapter {

    @Autowired
    private lateinit var productAdapter: ProductAdapter

    override fun toSchema(extraProductIngredient: ExtraProductIngredient): ExtraProductIngredientSchema {
        return ExtraProductIngredientSchema(
            product = productAdapter.toSchema(extraProductIngredient.product),
            ingredient = ingredientAdapter.toSchema(extraProductIngredient.ingredient),
            additionalCost = extraProductIngredient.additionalCost
        )
    }

    override fun toDomain(extraProductIngredientSchema: ExtraProductIngredientSchema): ExtraProductIngredientImpl {
        return ExtraProductIngredientImpl(
            product = productAdapter.toDomain(extraProductIngredientSchema.product),
            ingredient = ingredientAdapter.toDomain(extraProductIngredientSchema.ingredient),
            additionalCost = extraProductIngredientSchema.additionalCost
        )
    }
}