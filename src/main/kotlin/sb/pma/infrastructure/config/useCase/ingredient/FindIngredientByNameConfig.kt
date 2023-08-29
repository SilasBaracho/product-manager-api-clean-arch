package sb.pma.infrastructure.config.useCase.ingredient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.ingredient.useCase.FindIngredientByNameUseCase
import sb.pma.core.useCase.ingredient.findByName.FindIngredientByNameUseCaseImpl
import sb.pma.infrastructure.resources.ingredient.gateway.FindIngredientByNameGatewayImpl

@Configuration
class FindIngredientByNameConfig {

    @Bean
    fun findIngredientByNameUseCase(
        findIngredientByNameGateway: FindIngredientByNameGatewayImpl
    ): FindIngredientByNameUseCase {
        return FindIngredientByNameUseCaseImpl(
            findIngredientByNameGateway
        )
    }
}