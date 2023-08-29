package sb.pma.core.domain.extraProductIngredient.gateway

import sb.pma.core.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.core.useCase.extraProductIngredient.create.CreateExtraProductIngredientsInput
import sb.pma.core.domain.product.model.Product

interface CreateProductIngredientGateway {

    fun execute(
        payload: CreateExtraProductIngredientsInput,
        product: Product
    ): ExtraProductIngredient
}