package sb.pma.core.useCase.productCategory.findByName

import org.springframework.stereotype.Service
import sb.pma.infrastructure.exception.NotFoundException
import sb.pma.infrastructure.resources.productCategory.gateway.ProductCategoryDatabaseGateway
import sb.pma.core.domain.productCategory.output.ProductCategoryOutput
import sb.pma.core.domain.productCategory.output.ProductCategoryOutputImpl
import sb.pma.core.domain.productCategory.useCase.FindProductCategoryByNameUseCase

///@Service
class FindProductCategoryByNameUseCaseImpl(
    private val productCategoryDatabaseGateway: ProductCategoryDatabaseGateway
): FindProductCategoryByNameUseCase {

    override operator fun invoke(payload: FindProductCategoryByNameInput): ProductCategoryOutput {
        return productCategoryDatabaseGateway.findByName(payload.name)
            .orElseThrow { NotFoundException("Category not found") }
            .let { ProductCategoryOutputImpl(it) }
    }
}