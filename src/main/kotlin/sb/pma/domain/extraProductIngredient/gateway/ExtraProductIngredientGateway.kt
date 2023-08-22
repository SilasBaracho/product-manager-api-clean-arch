package sb.pma.domain.extraProductIngredient.gateway

import sb.pma.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.domain.product.model.Product
import sb.pma.useCase.extraProductIngredients.create.CreateExtraProductIngredientsInput

interface ExtraProductIngredientGateway {
    fun save(extraProductIngredient: ExtraProductIngredient): ExtraProductIngredient

    fun delete(extraProductIngredient: ExtraProductIngredient)

    fun findIngredientsByProduct(product: Product): Set<ExtraProductIngredient>

    fun createProductIngredientsSet(
        payload: CreateExtraProductIngredientsInput,
        product: Product
    ): ExtraProductIngredient
}