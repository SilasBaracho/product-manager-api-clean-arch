package sb.pma.infrastructure.config.useCase.ingredient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.ingredient.useCase.FindIngredientByIdUseCase
import sb.pma.core.useCase.ingredient.findById.FindIngredientByIdUseCaseImpl
import sb.pma.infrastructure.resources.ingredient.gateway.IngredientDatabaseGateway

@Configuration
class FindIngredientByIdConfig {

    @Bean
    fun findIngredientByIdUseCase(ingredientGateway: IngredientDatabaseGateway): FindIngredientByIdUseCase {
        return FindIngredientByIdUseCaseImpl(ingredientGateway)
    }
}