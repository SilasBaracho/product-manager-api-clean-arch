package sb.pma.infrastructure.config.useCase.product

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.product.useCase.FindProductByIdUseCase
import sb.pma.core.useCase.product.findAll.FindAllProductByIdPartnerUseCaseImpl
import sb.pma.core.useCase.product.findById.FindProductByIdUseCaseImpl
import sb.pma.infrastructure.resources.extraProductIngredient.gateway.ExtraProductIngredientDatabaseGateway
import sb.pma.infrastructure.resources.product.gateway.ProductDatabaseGateway

@Configuration
class FindProductByIdConfig {

    @Bean
    fun findProductByIdUseCase(
        extraProductIngredientGateway: ExtraProductIngredientDatabaseGateway,
        productGateway: ProductDatabaseGateway

    ): FindProductByIdUseCase {
        return FindProductByIdUseCaseImpl(extraProductIngredientGateway, productGateway)
    }
}