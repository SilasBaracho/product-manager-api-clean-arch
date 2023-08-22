package sb.pma.useCase.productCategory.findByName

import org.springframework.stereotype.Service
import sb.pma.infrastructure.exception.NotFoundException
import sb.pma.infrastructure.resources.productCategory.gateway.ProductCategoryDatabaseGateway
import sb.pma.useCase.productCategory.ProductCategoryOutput

@Service
class FindProductCategoryByNameUseCase(
    val productCategoryDatabaseGateway: ProductCategoryDatabaseGateway
) {

    operator fun invoke(payload: FindProductCategoryByNameInput): ProductCategoryOutput {
        return productCategoryDatabaseGateway.findByName(payload.name)
            .orElseThrow { NotFoundException("Category not found") }
            .let { ProductCategoryOutput(it) }
    }
}