package sb.pma.infrastructure.config.useCase.ingredient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.ingredient.useCase.DeleteIngredientUseCase
import sb.pma.core.useCase.ingredient.delete.DeleteIngredientUseCaseImpl
import sb.pma.infrastructure.resources.ingredient.gateway.DeleteIngredientGatewayImpl
import sb.pma.infrastructure.resources.ingredient.gateway.FindIngredientByIdGatewayImpl

@Configuration
class DeleteIngredientConfig {

    @Bean
    fun deleteIngredientUseCase(
        deleteIngredientGateway: DeleteIngredientGatewayImpl,
        findIngredientByIdGateway: FindIngredientByIdGatewayImpl
    ): DeleteIngredientUseCase {
        return DeleteIngredientUseCaseImpl(
            deleteIngredientGateway,
            findIngredientByIdGateway
        )
    }
}