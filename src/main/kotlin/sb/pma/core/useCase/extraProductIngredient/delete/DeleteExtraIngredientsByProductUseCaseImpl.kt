package sb.pma.core.useCase.extraProductIngredient.delete

import sb.pma.core.domain.extraProductIngredient.gateway.ExtraProductIngredientGateway
import sb.pma.core.domain.extraProductIngredient.useCase.DeleteExtraIngredientsByProductUseCase
import sb.pma.core.domain.product.gateway.ProductGateway
import sb.pma.infrastructure.exception.NotFoundException

class DeleteExtraIngredientsByProductUseCaseImpl(
    private val extraProductIngredientGateway: ExtraProductIngredientGateway,
    private val productGateway: ProductGateway,
): DeleteExtraIngredientsByProductUseCase {

    override operator fun invoke(input: DeleteExtraIngredientsByProductInput){
        val product = productGateway.findById(input.idProduct).orElseThrow { NotFoundException("Product not found") }
        extraProductIngredientGateway.findIngredientsByProduct(product).map {
            extraProductIngredientGateway.delete(it)
        }
    }
}