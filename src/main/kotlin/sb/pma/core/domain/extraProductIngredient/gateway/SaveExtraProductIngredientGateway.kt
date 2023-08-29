package sb.pma.core.domain.extraProductIngredient.gateway

import sb.pma.core.domain.extraProductIngredient.model.ExtraProductIngredient

interface SaveExtraProductIngredientGateway {

    fun execute(extraProductIngredient: ExtraProductIngredient): ExtraProductIngredient
}