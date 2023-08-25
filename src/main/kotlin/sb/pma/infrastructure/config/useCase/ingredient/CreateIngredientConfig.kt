package sb.pma.infrastructure.config.useCase.ingredient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.ingredient.useCase.CreateIngredientUseCase
import sb.pma.core.useCase.ingredient.create.CreateIngredientUseCaseImpl
import sb.pma.infrastructure.resources.ingredient.gateway.IngredientDatabaseGateway

@Configuration
class CreateIngredientConfig {

    @Bean
    fun createIngredientUseCase(ingredientGateway: IngredientDatabaseGateway): CreateIngredientUseCase {
        return CreateIngredientUseCaseImpl(ingredientGateway)
    }
}