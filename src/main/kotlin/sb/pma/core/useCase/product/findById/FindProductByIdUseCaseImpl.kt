package sb.pma.core.useCase.product.findById

import sb.pma.core.domain.extraProductIngredient.gateway.ExtraProductIngredientGateway
import sb.pma.core.domain.product.gateway.ProductGateway
import sb.pma.infrastructure.exception.NotFoundException
import sb.pma.core.domain.product.output.ProductOutput
import sb.pma.core.domain.product.output.ProductOutputImpl
import sb.pma.core.domain.product.useCase.FindProductByIdUseCase

class FindProductByIdUseCaseImpl(
    val extraProductIngredientGateway: ExtraProductIngredientGateway,
    val productGateway: ProductGateway,
): FindProductByIdUseCase {

    override operator fun invoke(payload: FindProductByIdInput): ProductOutput {
        return productGateway.findById(payload.id)
            .orElseThrow { NotFoundException("Product not found") }
            .let { ProductOutputImpl(it, extraProductIngredientGateway.findIngredientsByProduct(it)) }
    }
}