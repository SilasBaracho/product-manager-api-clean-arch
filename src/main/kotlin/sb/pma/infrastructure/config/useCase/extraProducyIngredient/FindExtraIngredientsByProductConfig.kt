package sb.pma.infrastructure.config.useCase.extraProducyIngredient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.extraProductIngredient.useCase.FindExtraIngredientsByProductUseCase
import sb.pma.core.useCase.extraProductIngredient.findByIdProduct.FindExtraIngredientsByProductUseCaseImpl
import sb.pma.infrastructure.resources.extraProductIngredient.gateway.FindExtraProductIngredientsGatewayImpl
import sb.pma.infrastructure.resources.product.gateway.FindProductByIdGatewayImpl

@Configuration
class FindExtraIngredientsByProductConfig {

    @Bean
    fun findExtraIngredientsByProductUseCase(
        findProductByIdGateway: FindProductByIdGatewayImpl,
        findExtraIngredientsByProductGateway: FindExtraProductIngredientsGatewayImpl
    ): FindExtraIngredientsByProductUseCase {
        return FindExtraIngredientsByProductUseCaseImpl(
            findProductByIdGateway,
            findExtraIngredientsByProductGateway
        )
    }
}