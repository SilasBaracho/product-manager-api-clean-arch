package sb.pma.core.useCase.extraProductIngredient.create

import sb.pma.core.domain.extraProductIngredient.gateway.ExtraProductIngredientGateway
import sb.pma.core.domain.extraProductIngredient.output.ExtraProductIngredientsOutput
import sb.pma.core.domain.extraProductIngredient.useCase.CreateExtraProductIngredientsUseCase
import sb.pma.core.domain.extraProductIngredient.output.ExtraProductIngredientsOutputImpl
import sb.pma.core.domain.product.gateway.ProductGateway
import sb.pma.infrastructure.exception.NotFoundException
import java.util.UUID

class CreateExtraProductIngredientsUseCaseImpl(
    private val extraProductIngredientGateway: ExtraProductIngredientGateway,
    private val productGateway: ProductGateway,
): CreateExtraProductIngredientsUseCase {

    override operator fun invoke(payload: CreateExtraProductIngredientsInput, idProduct: UUID): ExtraProductIngredientsOutput {
        val product = productGateway.findById(idProduct).orElseThrow { NotFoundException("Product not found") }

        val extraProductIngredients = extraProductIngredientGateway.createProductIngredientsSet(payload, product)

        extraProductIngredients.let {
            extraProductIngredientGateway.save(it)
        }

        return ExtraProductIngredientsOutputImpl(extraProductIngredients)
    }
}