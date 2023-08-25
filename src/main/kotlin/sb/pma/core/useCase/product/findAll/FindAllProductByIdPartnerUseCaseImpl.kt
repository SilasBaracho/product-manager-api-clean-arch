package sb.pma.core.useCase.product.findAll

import sb.pma.core.domain.extraProductIngredient.gateway.ExtraProductIngredientGateway
import sb.pma.core.domain.product.gateway.ProductGateway
import sb.pma.core.domain.product.output.ProductOutput
import sb.pma.core.domain.product.output.ProductOutputImpl
import sb.pma.core.domain.product.useCase.FindAllProductByIdPartnerUseCase
import java.util.UUID

class FindAllProductByIdPartnerUseCaseImpl(
    val extraProductIngredientGateway: ExtraProductIngredientGateway,
    val productGateway: ProductGateway,
): FindAllProductByIdPartnerUseCase {

    override operator fun invoke(idPartner: UUID): List<ProductOutput> {
        return productGateway.findAllProductByIdPartner(idPartner).map {
            ProductOutputImpl(it, extraProductIngredientGateway.findIngredientsByProduct(it))
        }
    }
}