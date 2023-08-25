package sb.pma.core.domain.extraProductIngredient.gateway

import sb.pma.core.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.core.useCase.extraProductIngredient.create.CreateExtraProductIngredientsInput
import sb.pma.core.domain.product.model.Product

interface ExtraProductIngredientGateway {
    fun save(extraProductIngredient: ExtraProductIngredient): ExtraProductIngredient

    fun delete(extraProductIngredient: ExtraProductIngredient)

    fun findIngredientsByProduct(product: Product): Set<ExtraProductIngredient>

    fun createProductIngredientsSet(
        payload: CreateExtraProductIngredientsInput,
        product: Product
    ): ExtraProductIngredient
}