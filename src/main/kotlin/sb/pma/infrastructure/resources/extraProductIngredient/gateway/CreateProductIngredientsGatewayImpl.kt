package sb.pma.infrastructure.resources.extraProductIngredient.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.extraProductIngredient.gateway.CreateProductIngredientGateway
import sb.pma.core.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.core.domain.extraProductIngredient.model.ExtraProductIngredientImpl
import sb.pma.core.domain.ingredient.gateway.FindOrCreateIngredientByNameGateway
import sb.pma.core.useCase.extraProductIngredient.create.CreateExtraProductIngredientsInput
import sb.pma.core.domain.product.model.Product

@Component
class CreateProductIngredientsGatewayImpl(
    private val findOrCreateIngredientByNameGateway: FindOrCreateIngredientByNameGateway
): CreateProductIngredientGateway {

    override fun execute(
        payload: CreateExtraProductIngredientsInput,
        product: Product
    ): ExtraProductIngredient {
        val extraProductIngredient: ExtraProductIngredient

        payload.let {
            val ingredient = findOrCreateIngredientByNameGateway.execute(it.name)
            extraProductIngredient = ExtraProductIngredientImpl(
                product = product,
                ingredient = ingredient,
                additionalCost = it.additionalCost
            )
        }

        return extraProductIngredient
    }
}