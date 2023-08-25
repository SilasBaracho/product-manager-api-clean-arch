package sb.pma.infrastructure.config.useCase.productCategory

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.productCategory.useCase.CreateProductCategoryUseCase
import sb.pma.core.useCase.productCategory.create.CreateProductCategoryUseCaseImpl
import sb.pma.infrastructure.resources.productCategory.gateway.ProductCategoryDatabaseGateway

@Configuration
class CreateProductCategoryConfig {

    @Bean
    fun createProductCategoryUseCase(
        productCategoryDatabaseGateway: ProductCategoryDatabaseGateway
    ): CreateProductCategoryUseCase {
        return CreateProductCategoryUseCaseImpl(productCategoryDatabaseGateway)
    }
}