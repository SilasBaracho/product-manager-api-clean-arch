package sb.pma.core.useCase.productCategory.delete

import sb.pma.core.domain.productCategory.useCase.DeleteProductCategoryUseCase
import sb.pma.infrastructure.exception.NotFoundException
import sb.pma.infrastructure.resources.productCategory.gateway.ProductCategoryDatabaseGateway

class DeleteProductCategoryUseCaseImpl(
    private val productCategoryDatabaseGateway: ProductCategoryDatabaseGateway
): DeleteProductCategoryUseCase {

    override operator fun invoke(payload: DeleteProductCategoryInput){
        val product = productCategoryDatabaseGateway.findById(payload.id).orElseThrow { NotFoundException("Category Not Found") }
        productCategoryDatabaseGateway.delete(product)
    }
}