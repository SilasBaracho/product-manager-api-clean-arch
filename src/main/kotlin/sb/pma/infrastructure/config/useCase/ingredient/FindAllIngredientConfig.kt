package sb.pma.infrastructure.config.useCase.ingredient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.ingredient.useCase.FindAllIngredientUseCase
import sb.pma.core.useCase.ingredient.findAll.FindAllIngredientUseCaseImpl
import sb.pma.infrastructure.resources.ingredient.gateway.FindAllIngredientGatewayImpl

@Configuration
class FindAllIngredientConfig {

    @Bean
    fun findAllIngredientUseCase(
        findAllIngredientGateway: FindAllIngredientGatewayImpl
    ): FindAllIngredientUseCase {
        return FindAllIngredientUseCaseImpl(
            findAllIngredientGateway
        )
    }
}