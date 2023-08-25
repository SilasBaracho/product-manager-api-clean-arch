package sb.pma.infrastructure.config.useCase.extraProducyIngredient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.extraProductIngredient.useCase.FindExtraIngredientsByProductUseCase
import sb.pma.core.useCase.extraProductIngredient.findByIdProduct.FindExtraIngredientsByProductUseCaseImpl
import sb.pma.infrastructure.resources.extraProductIngredient.gateway.ExtraProductIngredientDatabaseGateway
import sb.pma.infrastructure.resources.product.gateway.ProductDatabaseGateway

@Configuration
class FindExtraIngredientsByProductConfig {

    @Bean
    fun findExtraIngredientsByProductUseCase(
        extraProductIngredientGateway: ExtraProductIngredientDatabaseGateway,
        productGateway: ProductDatabaseGateway
    ): FindExtraIngredientsByProductUseCase {
        return FindExtraIngredientsByProductUseCaseImpl(extraProductIngredientGateway, productGateway)
    }
}