package sb.pma.core.useCase.productCategory.findById

import sb.pma.infrastructure.exception.NotFoundException
import sb.pma.infrastructure.resources.productCategory.gateway.ProductCategoryDatabaseGateway
import sb.pma.core.domain.productCategory.output.ProductCategoryOutput
import sb.pma.core.domain.productCategory.output.ProductCategoryOutputImpl
import sb.pma.core.domain.productCategory.useCase.FindProductCategoryByIdUseCase

class FindProductCategoryByIdUseCaseImpl(
    private val productCategoryDatabaseGateway: ProductCategoryDatabaseGateway
): FindProductCategoryByIdUseCase {

    override operator fun invoke(payload: FindProductCategoryByIdInput): ProductCategoryOutput {
        return productCategoryDatabaseGateway.findById(payload.id)
            .orElseThrow { NotFoundException("Category Not found") }
            .let { ProductCategoryOutputImpl(it) }
    }
}