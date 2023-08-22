package sb.pma.useCase.product.findAll

import org.springframework.stereotype.Service
import sb.pma.domain.extraProductIngredient.gateway.ExtraProductIngredientGateway
import sb.pma.domain.product.gateway.ProductGateway
import sb.pma.useCase.product.ProductOutput

@Service
class FindAllProductUseCase(
    val extraProductIngredientGateway: ExtraProductIngredientGateway,
    val productGateway: ProductGateway,
) {

    operator fun invoke(): List<ProductOutput> {
        return  productGateway.findAll().map {
            ProductOutput(it, extraProductIngredientGateway.findIngredientsByProduct(it))
        }
    }
}