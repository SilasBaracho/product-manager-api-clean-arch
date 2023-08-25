package sb.pma.infrastructure.config.useCase.ingredient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.ingredient.useCase.DeleteIngredientUseCase
import sb.pma.core.useCase.ingredient.delete.DeleteIngredientUseCaseImpl
import sb.pma.infrastructure.resources.ingredient.gateway.IngredientDatabaseGateway

@Configuration
class DeleteIngredientConfig {

    @Bean
    fun deleteIngredientUseCase(ingredientGateway: IngredientDatabaseGateway): DeleteIngredientUseCase {
        return DeleteIngredientUseCaseImpl(ingredientGateway)
    }
}