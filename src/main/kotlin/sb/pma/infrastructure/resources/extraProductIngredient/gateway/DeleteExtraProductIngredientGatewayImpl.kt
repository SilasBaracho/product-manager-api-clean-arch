package sb.pma.infrastructure.resources.extraProductIngredient.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.extraProductIngredient.gateway.DeleteExtraProductIngredientGateway
import sb.pma.core.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.infrastructure.config.db.repository.ExtraProductIngredientRepository
import sb.pma.infrastructure.resources.extraProductIngredient.adapter.ExtraProductIngredientAdapter

@Component
class DeleteExtraProductIngredientGatewayImpl(
    private val extraProductIngredientAdapter: ExtraProductIngredientAdapter,
    private val extraProductIngredientRepository: ExtraProductIngredientRepository
): DeleteExtraProductIngredientGateway {

    override fun execute(extraProductIngredient: ExtraProductIngredient) {
        return extraProductIngredientRepository.delete(extraProductIngredientAdapter.toSchema(extraProductIngredient))
    }

}