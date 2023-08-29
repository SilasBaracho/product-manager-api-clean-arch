package sb.pma.infrastructure.resources.extraProductIngredient.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.extraProductIngredient.gateway.SaveExtraProductIngredientGateway
import sb.pma.core.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.infrastructure.config.db.repository.ExtraProductIngredientRepository
import sb.pma.infrastructure.resources.extraProductIngredient.adapter.ExtraProductIngredientAdapter

@Component
class SaveExtraProductIngredientGatewayImpl(
    private val extraProductIngredientAdapter: ExtraProductIngredientAdapter,
    private val extraProductIngredientRepository: ExtraProductIngredientRepository,
): SaveExtraProductIngredientGateway {

    override fun execute(extraProductIngredient: ExtraProductIngredient): ExtraProductIngredient {
        return extraProductIngredientRepository.save(
            extraProductIngredientAdapter.toSchema(extraProductIngredient)
        ).let {
            extraProductIngredientAdapter.toDomain(it)
        }
    }
}