package sb.pma.core.useCase.extraProductIngredient.create

import sb.pma.core.domain.extraProductIngredient.gateway.CreateProductIngredientGateway
import sb.pma.core.domain.extraProductIngredient.gateway.SaveExtraProductIngredientGateway
import sb.pma.core.domain.extraProductIngredient.output.ExtraProductIngredientsOutput
import sb.pma.core.domain.extraProductIngredient.useCase.CreateExtraProductIngredientsUseCase
import sb.pma.core.domain.extraProductIngredient.output.ExtraProductIngredientsOutputImpl
import sb.pma.core.domain.product.gateway.FindProductByIdGateway
import sb.pma.infrastructure.exception.NotFoundException
import java.util.UUID

class CreateExtraProductIngredientsUseCaseImpl(
    private val createProductIngredientGateway: CreateProductIngredientGateway,
    private val findProductByIdGateway: FindProductByIdGateway,
    private val saveExtraProductIngredientGateway: SaveExtraProductIngredientGateway
): CreateExtraProductIngredientsUseCase {

    override operator fun invoke(payload: CreateExtraProductIngredientsInput, idProduct: UUID): ExtraProductIngredientsOutput {
        val product = findProductByIdGateway.execute(idProduct).orElseThrow { NotFoundException("Product not found") }

        val extraProductIngredients = createProductIngredientGateway.execute(payload, product)

        extraProductIngredients.let {
            saveExtraProductIngredientGateway.execute(it)
        }

        return ExtraProductIngredientsOutputImpl(extraProductIngredients)
    }
}