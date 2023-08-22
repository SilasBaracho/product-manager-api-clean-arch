package sb.pma.useCase.extraProductIngredients.delete

import org.springframework.stereotype.Service
import sb.pma.domain.extraProductIngredient.gateway.ExtraProductIngredientGateway
import sb.pma.domain.product.gateway.ProductGateway
import sb.pma.infrastructure.exception.NotFoundException

@Service
class DeleteExtraProductIngredientsUseCase(
    val extraProductIngredientGateway: ExtraProductIngredientGateway,
    val productGateway: ProductGateway,
) {

    operator fun invoke(input: DeleteExtraIngredientsByProductInput){
        val product = productGateway.findById(input.idProduct).orElseThrow { NotFoundException("Product not found") }
        extraProductIngredientGateway.findIngredientsByProduct(product).map {
            extraProductIngredientGateway.delete(it)
        }
    }
}