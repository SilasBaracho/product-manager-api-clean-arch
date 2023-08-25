package sb.pma.core.useCase.product.delete

import sb.pma.core.domain.extraProductIngredient.gateway.ExtraProductIngredientGateway
import sb.pma.core.domain.product.gateway.ProductGateway
import sb.pma.core.domain.product.useCase.DeleteProductUseCase
import sb.pma.infrastructure.exception.NotFoundException

class DeleteProductUseCaseImpl(
    val extraProductIngredientGateway: ExtraProductIngredientGateway,
    val productGateway: ProductGateway,
): DeleteProductUseCase {

    override operator fun invoke(payload: DeleteProductInput){
        val product = productGateway.findById(payload.id).orElseThrow { NotFoundException("Product Not Found") }

        extraProductIngredientGateway.findIngredientsByProduct(product).map {
            extraProductIngredientGateway.delete(it)
        }

        productGateway.delete(product)
    }
}