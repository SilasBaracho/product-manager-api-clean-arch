package sb.pma.core.useCase.extraProductIngredient.findByIdProduct

import org.springframework.stereotype.Service
import sb.pma.core.domain.extraProductIngredient.gateway.ExtraProductIngredientGateway
import sb.pma.core.domain.extraProductIngredient.output.ExtraProductIngredientsOutput
import sb.pma.core.domain.extraProductIngredient.useCase.FindExtraIngredientsByProductUseCase
import sb.pma.core.domain.extraProductIngredient.output.ExtraProductIngredientsOutputImpl
import sb.pma.core.domain.product.gateway.ProductGateway
import sb.pma.infrastructure.exception.NotFoundException

@Service
class FindExtraIngredientsByProductUseCaseImpl(
    val extraProductIngredientGateway: ExtraProductIngredientGateway,
    val productGateway: ProductGateway,
): FindExtraIngredientsByProductUseCase {

    override operator fun invoke(input: FindExtraIngredientsByProductInput): List<ExtraProductIngredientsOutput> {
        val product = productGateway.findById(input.idProduct).orElseThrow { NotFoundException("Product not found") }

        return extraProductIngredientGateway.findIngredientsByProduct(product).map { ExtraProductIngredientsOutputImpl(it) }
    }
}