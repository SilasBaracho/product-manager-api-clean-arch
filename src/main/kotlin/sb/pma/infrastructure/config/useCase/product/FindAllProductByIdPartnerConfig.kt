package sb.pma.infrastructure.config.useCase.product

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.product.useCase.FindAllProductByIdPartnerUseCase
import sb.pma.core.useCase.product.findAll.FindAllProductByIdPartnerUseCaseImpl
import sb.pma.infrastructure.resources.extraProductIngredient.gateway.ExtraProductIngredientDatabaseGateway
import sb.pma.infrastructure.resources.product.gateway.ProductDatabaseGateway

@Configuration
class FindAllProductByIdPartnerConfig {

    @Bean
    fun findAllProductByIdPartnerUseCase(
        extraProductIngredientGateway: ExtraProductIngredientDatabaseGateway,
        productGateway: ProductDatabaseGateway

    ): FindAllProductByIdPartnerUseCase {
        return FindAllProductByIdPartnerUseCaseImpl(extraProductIngredientGateway, productGateway)
    }
}