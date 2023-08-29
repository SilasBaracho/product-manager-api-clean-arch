package sb.pma.core.domain.extraProductIngredient.gateway

import sb.pma.core.domain.extraProductIngredient.model.ExtraProductIngredient

interface DeleteExtraProductIngredientGateway {

    fun execute(extraProductIngredient: ExtraProductIngredient)
}