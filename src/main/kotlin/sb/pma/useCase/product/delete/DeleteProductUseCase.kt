package sb.pma.useCase.product.delete

import org.springframework.stereotype.Service
import sb.pma.domain.extraProductIngredient.gateway.ExtraProductIngredientGateway
import sb.pma.domain.product.gateway.ProductGateway
import sb.pma.infrastructure.exception.NotFoundException

@Service
class DeleteProductUseCase(
    val extraProductIngredientGateway: ExtraProductIngredientGateway,
    val productGateway: ProductGateway,
) {

    operator fun invoke(payload: DeleteProductInput){
        val product = productGateway.findById(payload.id).orElseThrow { NotFoundException("Product Not Found") }

        extraProductIngredientGateway.findIngredientsByProduct(product).map {
            extraProductIngredientGateway.delete(it)
        }

        productGateway.delete(product)
    }
}