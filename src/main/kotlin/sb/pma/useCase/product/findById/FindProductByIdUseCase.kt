package sb.pma.useCase.product.findById

import org.springframework.stereotype.Service
import sb.pma.domain.extraProductIngredient.gateway.ExtraProductIngredientGateway
import sb.pma.domain.product.gateway.ProductGateway
import sb.pma.infrastructure.exception.NotFoundException
import sb.pma.useCase.product.ProductOutput

@Service
class FindProductByIdUseCase(
    val extraProductIngredientGateway: ExtraProductIngredientGateway,
    val productGateway: ProductGateway,
) {

    operator fun invoke(payload: FindProductByIdInput): ProductOutput {
        return productGateway.findById(payload.id)
            .orElseThrow { NotFoundException("Product not found") }
            .let { ProductOutput(it, extraProductIngredientGateway.findIngredientsByProduct(it)) }
    }
}