package sb.pma.infrastructure.resources.extraProductIngredient.gateway

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import sb.pma.core.domain.extraProductIngredient.gateway.FindExtraIngredientsByProductGateway
import sb.pma.core.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.core.domain.product.model.Product
import sb.pma.infrastructure.config.db.repository.ExtraProductIngredientRepository
import sb.pma.infrastructure.resources.extraProductIngredient.adapter.ExtraProductIngredientAdapter
import sb.pma.infrastructure.resources.product.adapter.ProductAdapter

@Component
class FindExtraProductIngredientsGatewayImpl(
    private val extraProductIngredientAdapter: ExtraProductIngredientAdapter,
    private val extraProductIngredientRepository: ExtraProductIngredientRepository,
): FindExtraIngredientsByProductGateway {

    @Autowired
    private lateinit var productAdapter: ProductAdapter

    override fun execute(product: Product): Set<ExtraProductIngredient> {
        val productSchema = productAdapter.toSchema(product)

        return extraProductIngredientRepository.findIngredientsByProduct(productSchema).map {
            extraProductIngredientAdapter.toDomain(it)
        }.toSet()
    }

}