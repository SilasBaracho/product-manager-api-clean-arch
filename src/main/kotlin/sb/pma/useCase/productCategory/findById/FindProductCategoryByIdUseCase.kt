package sb.pma.useCase.productCategory.findById

import org.springframework.stereotype.Service
import sb.pma.infrastructure.exception.NotFoundException
import sb.pma.infrastructure.resources.productCategory.gateway.ProductCategoryDatabaseGateway
import sb.pma.useCase.productCategory.ProductCategoryOutput

@Service
class FindProductCategoryByIdUseCase(
    val productCategoryDatabaseGateway: ProductCategoryDatabaseGateway
) {

    operator fun invoke(payload: FindProductCategoryByIdInput): ProductCategoryOutput {
        return productCategoryDatabaseGateway.findById(payload.id)
            .orElseThrow { NotFoundException("Category Not found") }
            .let { ProductCategoryOutput(it) }
    }
}