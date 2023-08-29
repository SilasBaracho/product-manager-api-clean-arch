package sb.pma.core.useCase.product.delete

import sb.pma.core.domain.extraProductIngredient.gateway.DeleteExtraProductIngredientGateway
import sb.pma.core.domain.extraProductIngredient.gateway.FindExtraIngredientsByProductGateway
import sb.pma.core.domain.product.gateway.DeleteProductGateway
import sb.pma.core.domain.product.gateway.FindProductByIdGateway
import sb.pma.core.domain.product.useCase.DeleteProductUseCase
import sb.pma.infrastructure.exception.NotFoundException

class DeleteProductUseCaseImpl(
    private val deleteProductGateway: DeleteProductGateway,
    private val deleteExtraProductIngredientGateway: DeleteExtraProductIngredientGateway,
    private val findExtraIngredientsByProductGateway: FindExtraIngredientsByProductGateway,
    private val findProductByIdGateway: FindProductByIdGateway,
): DeleteProductUseCase {

    override operator fun invoke(payload: DeleteProductInput){
        val product = findProductByIdGateway.execute(payload.id).orElseThrow { NotFoundException("Product Not Found") }

        findExtraIngredientsByProductGateway.execute(product).map {
            deleteExtraProductIngredientGateway.execute(it)
        }

        deleteProductGateway.execute(product)
    }
}