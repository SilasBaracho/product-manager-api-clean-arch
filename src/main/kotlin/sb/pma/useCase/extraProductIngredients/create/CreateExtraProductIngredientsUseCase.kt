package sb.pma.useCase.extraProductIngredients.create

import org.springframework.stereotype.Service
import sb.pma.domain.extraProductIngredient.gateway.ExtraProductIngredientGateway
import sb.pma.domain.product.gateway.ProductGateway
import sb.pma.infrastructure.exception.NotFoundException
import sb.pma.useCase.extraProductIngredients.ExtraProductIngredientsOutput
import java.util.UUID

@Service
class CreateExtraProductIngredientsUseCase(
    val extraProductIngredientGateway: ExtraProductIngredientGateway,
    val productGateway: ProductGateway,
) {

    operator fun invoke(payload: CreateExtraProductIngredientsInput, idProduct: UUID): ExtraProductIngredientsOutput {
        val product = productGateway.findById(idProduct).orElseThrow { NotFoundException("Product not found") }

        val extraProductIngredients = extraProductIngredientGateway.createProductIngredientsSet(payload, product)

        extraProductIngredients.let {
            extraProductIngredientGateway.save(it)
        }

        return ExtraProductIngredientsOutput(extraProductIngredients)
    }
}