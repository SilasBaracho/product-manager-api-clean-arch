package sb.pma.infrastructure.config.useCase.productCategory

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.productCategory.useCase.FindProductCategoryByIdUseCase
import sb.pma.core.useCase.productCategory.findById.FindProductCategoryByIdUseCaseImpl
import sb.pma.infrastructure.resources.productCategory.gateway.ProductCategoryDatabaseGateway

@Configuration
class FindProductCategoryByIdConfig {

    @Bean
    fun findProductCategoryByIdUseCase(
        productCategoryDatabaseGateway: ProductCategoryDatabaseGateway
    ): FindProductCategoryByIdUseCase {
        return FindProductCategoryByIdUseCaseImpl(productCategoryDatabaseGateway)
    }
}