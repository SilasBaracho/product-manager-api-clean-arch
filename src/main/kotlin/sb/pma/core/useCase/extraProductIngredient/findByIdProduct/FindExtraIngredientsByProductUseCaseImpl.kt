package sb.pma.core.useCase.extraProductIngredient.findByIdProduct

import org.springframework.stereotype.Service
import sb.pma.core.domain.extraProductIngredient.gateway.FindExtraIngredientsByProductGateway
import sb.pma.core.domain.extraProductIngredient.output.ExtraProductIngredientsOutput
import sb.pma.core.domain.extraProductIngredient.useCase.FindExtraIngredientsByProductUseCase
import sb.pma.core.domain.extraProductIngredient.output.ExtraProductIngredientsOutputImpl
import sb.pma.core.domain.product.gateway.FindProductByIdGateway
import sb.pma.infrastructure.exception.NotFoundException

@Service
class FindExtraIngredientsByProductUseCaseImpl(
    private val findProductByIdGateway: FindProductByIdGateway,
    private val findExtraIngredientsByProductGateway: FindExtraIngredientsByProductGateway
): FindExtraIngredientsByProductUseCase {

    override operator fun invoke(input: FindExtraIngredientsByProductInput): List<ExtraProductIngredientsOutput> {
        val product = findProductByIdGateway.execute(input.idProduct).orElseThrow { NotFoundException("Product not found") }

        return findExtraIngredientsByProductGateway.execute(product).map { ExtraProductIngredientsOutputImpl(it) }
    }
}