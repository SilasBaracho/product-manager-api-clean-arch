package sb.pma.useCase.product.findAll

import org.springframework.stereotype.Service
import sb.pma.domain.extraProductIngredient.gateway.ExtraProductIngredientGateway
import sb.pma.domain.product.gateway.ProductGateway
import sb.pma.useCase.product.ProductOutput
import java.util.UUID

@Service
class FindAllProductByIdPartnerUseCase(
    val extraProductIngredientGateway: ExtraProductIngredientGateway,
    val productGateway: ProductGateway,
) {

    operator fun invoke(idPartner: UUID): List<ProductOutput> {
        return  productGateway.findAllProductByIdPartner(idPartner).map {
            ProductOutput(it, extraProductIngredientGateway.findIngredientsByProduct(it))
        }
    }
}