package sb.pma.core.useCase.productCategory.create

import sb.pma.core.domain.productCategory.model.ProductCategoryImpl
import sb.pma.infrastructure.resources.productCategory.gateway.ProductCategoryDatabaseGateway
import sb.pma.core.domain.productCategory.output.ProductCategoryOutput
import sb.pma.core.domain.productCategory.output.ProductCategoryOutputImpl
import sb.pma.core.domain.productCategory.useCase.CreateProductCategoryUseCase
import java.time.LocalDateTime

class CreateProductCategoryUseCaseImpl(
    private val productCategoryDatabaseGateway: ProductCategoryDatabaseGateway
): CreateProductCategoryUseCase {

    override operator fun invoke(payload: CreateProductCategoryInput): ProductCategoryOutput {
        return ProductCategoryOutputImpl(
            productCategoryDatabaseGateway.save(
                ProductCategoryImpl(
                    name = payload.name,
                    createdAt = LocalDateTime.now()
                )
            )
        )
    }
}