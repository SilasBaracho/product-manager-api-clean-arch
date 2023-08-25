package sb.pma.infrastructure.config.useCase.extraProducyIngredient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.extraProductIngredient.useCase.DeleteExtraIngredientsByProductUseCase
import sb.pma.core.useCase.extraProductIngredient.delete.DeleteExtraIngredientsByProductUseCaseImpl
import sb.pma.infrastructure.resources.extraProductIngredient.gateway.ExtraProductIngredientDatabaseGateway
import sb.pma.infrastructure.resources.product.gateway.ProductDatabaseGateway

@Configuration
class DeleteExtraIngredientsByProductConfig {

    @Bean
    fun deleteExtraIngredientsByProductUseCase(
        extraProductIngredientGateway: ExtraProductIngredientDatabaseGateway,
        productGateway: ProductDatabaseGateway
    ): DeleteExtraIngredientsByProductUseCase {
        return DeleteExtraIngredientsByProductUseCaseImpl(extraProductIngredientGateway, productGateway)
    }
}