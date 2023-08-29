package sb.pma.infrastructure.config.useCase.extraProducyIngredient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.extraProductIngredient.useCase.DeleteExtraIngredientsByProductUseCase
import sb.pma.core.useCase.extraProductIngredient.delete.DeleteExtraIngredientsByProductUseCaseImpl
import sb.pma.infrastructure.resources.extraProductIngredient.gateway.DeleteExtraProductIngredientGatewayImpl
import sb.pma.infrastructure.resources.extraProductIngredient.gateway.FindExtraProductIngredientsGatewayImpl
import sb.pma.infrastructure.resources.product.gateway.FindProductByIdGatewayImpl

@Configuration
class DeleteExtraIngredientsByProductConfig {

    @Bean
    fun deleteExtraIngredientsByProductUseCase(
        findExtraIngredientsByProductGateway: FindExtraProductIngredientsGatewayImpl,
        findProductByIdGateway: FindProductByIdGatewayImpl,
        deleteExtraProductIngredientGateway: DeleteExtraProductIngredientGatewayImpl
    ): DeleteExtraIngredientsByProductUseCase {
        return DeleteExtraIngredientsByProductUseCaseImpl(
            findExtraIngredientsByProductGateway,
            findProductByIdGateway,
            deleteExtraProductIngredientGateway
        )
    }
}