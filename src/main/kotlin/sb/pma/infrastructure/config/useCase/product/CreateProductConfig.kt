package sb.pma.infrastructure.config.useCase.product

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.product.useCase.CreateProductUseCase
import sb.pma.core.useCase.product.create.CreateProductUseCaseImpl
import sb.pma.infrastructure.resources.extraProductIngredient.gateway.ExtraProductIngredientDatabaseGateway
import sb.pma.infrastructure.resources.product.gateway.ProductDatabaseGateway
import sb.pma.infrastructure.resources.productCategory.gateway.ProductCategoryDatabaseGateway

@Configuration
class CreateProductConfig {

    @Bean
    fun createProductUseCase(
        productGateway: ProductDatabaseGateway,
        productCategoryGateway: ProductCategoryDatabaseGateway,
        extraProductIngredientGateway: ExtraProductIngredientDatabaseGateway
    ): CreateProductUseCase{
        return CreateProductUseCaseImpl(productGateway, productCategoryGateway, extraProductIngredientGateway)
    }
}