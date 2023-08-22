package sb.pma.useCase.productCategory.create

import org.springframework.stereotype.Service
import sb.pma.domain.productCategory.model.ProductCategoryImpl
import sb.pma.infrastructure.resources.productCategory.gateway.ProductCategoryDatabaseGateway
import sb.pma.useCase.productCategory.ProductCategoryOutput
import java.time.LocalDateTime

@Service
class CreateProductCategoryUseCase(
    val productCategoryDatabaseGateway: ProductCategoryDatabaseGateway
) {

    operator fun invoke(payload: CreateProductCategoryInput): ProductCategoryOutput {
        return ProductCategoryOutput(
            productCategoryDatabaseGateway.save(
                ProductCategoryImpl(
                    name = payload.name,
                    createdAt = LocalDateTime.now()
                )
            )
        )
    }
}