package sb.pma.useCase.productCategory.delete

import org.springframework.stereotype.Service
import sb.pma.infrastructure.exception.NotFoundException
import sb.pma.infrastructure.resources.productCategory.gateway.ProductCategoryDatabaseGateway

@Service
class DeleteProductCategoryUseCase(
    val productCategoryDatabaseGateway: ProductCategoryDatabaseGateway
) {

    operator fun invoke(payload: DeleteProductCategoryInput){
        val product = productCategoryDatabaseGateway.findById(payload.id).orElseThrow { NotFoundException("Category Not Found") }
        productCategoryDatabaseGateway.delete(product)
    }
}