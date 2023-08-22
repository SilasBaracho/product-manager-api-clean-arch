package sb.pma.infrastructure.resources.extraProductIngredient.gateway

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import sb.pma.domain.extraProductIngredient.gateway.ExtraProductIngredientGateway
import sb.pma.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.domain.extraProductIngredient.model.ExtraProductIngredientImpl
import sb.pma.domain.ingredient.gateway.IngredientGateway
import sb.pma.domain.product.model.Product
import sb.pma.infrastructure.config.db.repository.ExtraProductIngredientRepository
import sb.pma.infrastructure.resources.extraProductIngredient.adapter.ExtraProductIngredientAdapter
import sb.pma.infrastructure.resources.product.adapter.ProductAdapter
import sb.pma.useCase.extraProductIngredients.create.CreateExtraProductIngredientsInput

@Component
class ExtraProductIngredientDatabaseGateway(
    private val extraProductIngredientAdapter: ExtraProductIngredientAdapter,
    private val extraProductIngredientRepository: ExtraProductIngredientRepository,
    private val ingredientGateway: IngredientGateway,
): ExtraProductIngredientGateway {
    @Autowired
    private lateinit var productAdapter: ProductAdapter

    override fun save(extraProductIngredient: ExtraProductIngredient): ExtraProductIngredient {
        return extraProductIngredientRepository.save(
            extraProductIngredientAdapter.toSchema(extraProductIngredient)
        ).let {
            extraProductIngredientAdapter.toDomain(it)
        }
    }

    override fun delete(extraProductIngredient: ExtraProductIngredient) {
        return extraProductIngredientRepository.delete(extraProductIngredientAdapter.toSchema(extraProductIngredient))
    }


    override fun findIngredientsByProduct(product: Product): Set<ExtraProductIngredient> {
        val productSchema = productAdapter.toSchema(product)

        return extraProductIngredientRepository.findIngredientsByProduct(productSchema).map {
            extraProductIngredientAdapter.toDomain(it)
        }.toSet()
    }

    override fun createProductIngredientsSet(
        payload: CreateExtraProductIngredientsInput,
        product: Product
    ): ExtraProductIngredient {
        val extraProductIngredient: ExtraProductIngredient

        payload.let {
            val ingredient = ingredientGateway.findOrCreateIngredientByName(it.name)
            extraProductIngredient = ExtraProductIngredientImpl(
                product = product,
                ingredient = ingredient,
                additionalCost = it.additionalCost
            )
        }

        return extraProductIngredient
    }
}