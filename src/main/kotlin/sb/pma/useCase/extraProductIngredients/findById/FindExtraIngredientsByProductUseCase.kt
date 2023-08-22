package sb.pma.useCase.extraProductIngredients.findById

import org.springframework.stereotype.Service
import sb.pma.domain.extraProductIngredient.gateway.ExtraProductIngredientGateway
import sb.pma.domain.product.gateway.ProductGateway
import sb.pma.infrastructure.exception.NotFoundException
import sb.pma.useCase.extraProductIngredients.ExtraProductIngredientsOutput

@Service
class FindExtraIngredientsByProductUseCase(
    val extraProductIngredientGateway: ExtraProductIngredientGateway,
    val productGateway: ProductGateway,
) {

    operator fun invoke(input: FindExtraIngredientsByProductInput): List<ExtraProductIngredientsOutput> {
        val product = productGateway.findById(input.idProduct).orElseThrow { NotFoundException("Product not found") }

        return extraProductIngredientGateway.findIngredientsByProduct(product).map { ExtraProductIngredientsOutput(it) }
    }
}