package sb.pma.core.useCase.product.findAll

import sb.pma.core.domain.extraProductIngredient.gateway.FindExtraIngredientsByProductGateway
import sb.pma.core.domain.product.output.ProductOutput
import sb.pma.core.domain.product.output.ProductOutputImpl
import sb.pma.core.domain.product.useCase.FindAllProductByIdPartnerUseCase
import sb.pma.infrastructure.resources.product.gateway.FindAllProductByIdPartnerGatewayImpl
import java.util.UUID

class FindAllProductByIdPartnerUseCaseImpl(
    private val findAllProductByIdPartnerGateway: FindAllProductByIdPartnerGatewayImpl,
    private val findExtraIngredientsByProductGateway: FindExtraIngredientsByProductGateway
): FindAllProductByIdPartnerUseCase {

    override operator fun invoke(idPartner: UUID): List<ProductOutput> {
        return findAllProductByIdPartnerGateway.execute(idPartner).map {
            ProductOutputImpl(it, findExtraIngredientsByProductGateway.execute(it))
        }
    }
}