package sb.pma.infrastructure.config.useCase.extraProducyIngredient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.extraProductIngredient.useCase.CreateExtraProductIngredientsUseCase
import sb.pma.core.useCase.extraProductIngredient.create.CreateExtraProductIngredientsUseCaseImpl
import sb.pma.infrastructure.resources.extraProductIngredient.gateway.ExtraProductIngredientDatabaseGateway
import sb.pma.infrastructure.resources.product.gateway.ProductDatabaseGateway

@Configuration
class CreateExtraProductIngredientsConfig {

    @Bean
    fun createExtraProductIngredientsUseCase(
        extraProductIngredientGateway: ExtraProductIngredientDatabaseGateway,
        productGateway: ProductDatabaseGateway
    ): CreateExtraProductIngredientsUseCase {
        return CreateExtraProductIngredientsUseCaseImpl(extraProductIngredientGateway, productGateway)
    }
}