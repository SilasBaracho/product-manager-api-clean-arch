package sb.pma.infrastructure.config.useCase.extraProducyIngredient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.extraProductIngredient.useCase.CreateExtraProductIngredientsUseCase
import sb.pma.core.useCase.extraProductIngredient.create.CreateExtraProductIngredientsUseCaseImpl
import sb.pma.infrastructure.resources.extraProductIngredient.gateway.CreateProductIngredientsGatewayImpl
import sb.pma.infrastructure.resources.extraProductIngredient.gateway.SaveExtraProductIngredientGatewayImpl
import sb.pma.infrastructure.resources.product.gateway.FindProductByIdGatewayImpl

@Configuration
class CreateExtraProductIngredientsConfig {

    @Bean
    fun createExtraProductIngredientsUseCase(
        createProductIngredientGateway: CreateProductIngredientsGatewayImpl,
        findProductByIdGateway: FindProductByIdGatewayImpl,
        saveExtraProductIngredientGateway: SaveExtraProductIngredientGatewayImpl
    ): CreateExtraProductIngredientsUseCase {
        return CreateExtraProductIngredientsUseCaseImpl(
            createProductIngredientGateway,
            findProductByIdGateway,
            saveExtraProductIngredientGateway
        )
    }
}