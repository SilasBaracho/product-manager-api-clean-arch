package sb.pma.useCase.productCategory.findAll

import org.springframework.stereotype.Service
import sb.pma.infrastructure.resources.productCategory.gateway.ProductCategoryDatabaseGateway
import sb.pma.useCase.productCategory.ProductCategoryOutput

@Service
class FindAllProductCategoryUseCase(
    val productCategoryDatabaseGateway: ProductCategoryDatabaseGateway
) {

    operator fun invoke(): List<ProductCategoryOutput> {
        return productCategoryDatabaseGateway.findAll().map { ProductCategoryOutput(it) }
    }
}