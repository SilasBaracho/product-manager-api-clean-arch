package sb.pma.core.useCase.productCategory.findAll

import sb.pma.infrastructure.resources.productCategory.gateway.ProductCategoryDatabaseGateway
import sb.pma.core.domain.productCategory.output.ProductCategoryOutput
import sb.pma.core.domain.productCategory.output.ProductCategoryOutputImpl
import sb.pma.core.domain.productCategory.useCase.FindAllProductCategoryUseCase

class FindAllProductCategoryUseCaseImpl(
    private val productCategoryDatabaseGateway: ProductCategoryDatabaseGateway
): FindAllProductCategoryUseCase {

    override operator fun invoke(): List<ProductCategoryOutput> {
        return productCategoryDatabaseGateway.findAll().map { ProductCategoryOutputImpl(it) }
    }
}