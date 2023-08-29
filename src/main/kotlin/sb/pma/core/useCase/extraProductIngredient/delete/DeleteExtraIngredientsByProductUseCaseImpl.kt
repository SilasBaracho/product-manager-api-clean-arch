package sb.pma.core.useCase.extraProductIngredient.delete

import sb.pma.core.domain.extraProductIngredient.gateway.DeleteExtraProductIngredientGateway
import sb.pma.core.domain.extraProductIngredient.gateway.FindExtraIngredientsByProductGateway
import sb.pma.core.domain.extraProductIngredient.useCase.DeleteExtraIngredientsByProductUseCase
import sb.pma.core.domain.product.gateway.FindProductByIdGateway
import sb.pma.infrastructure.exception.NotFoundException

class DeleteExtraIngredientsByProductUseCaseImpl(
    private val findExtraIngredientsByProductGateway: FindExtraIngredientsByProductGateway,
    private val findProductByIdGateway: FindProductByIdGateway,
    private val deleteExtraProductIngredientGateway: DeleteExtraProductIngredientGateway
): DeleteExtraIngredientsByProductUseCase {

    override operator fun invoke(input: DeleteExtraIngredientsByProductInput){
        val product = findProductByIdGateway.execute(input.idProduct).orElseThrow { NotFoundException("Product not found") }
        findExtraIngredientsByProductGateway.execute(product).map {
            deleteExtraProductIngredientGateway.execute(it)
        }
    }
}