package sb.pma.core.domain.extraProductIngredient.gateway

import sb.pma.core.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.core.domain.product.model.Product

interface FindExtraIngredientsByProductGateway {

    fun execute(product: Product): Set<ExtraProductIngredient>
}