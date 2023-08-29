package sb.pma.core.useCase.product.create

import sb.pma.core.domain.extraProductIngredient.gateway.CreateProductIngredientGateway
import sb.pma.core.domain.extraProductIngredient.gateway.SaveExtraProductIngredientGateway
import sb.pma.core.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.core.domain.product.gateway.SaveProductGateway
import sb.pma.core.domain.product.model.ProductImpl
import sb.pma.core.domain.product.output.ProductOutput
import sb.pma.core.domain.product.output.ProductOutputImpl
import sb.pma.core.domain.product.useCase.CreateProductUseCase
import sb.pma.core.domain.productCategory.gateway.FindOrCreateProductCategoryGateway

class CreateProductUseCaseImpl(
    private val createProductIngredientGateway: CreateProductIngredientGateway,
    private val findOrCreateProductCategoryGateway: FindOrCreateProductCategoryGateway,
    private val saveProductGateway: SaveProductGateway,
    private val saveExtraProductIngredientGateway: SaveExtraProductIngredientGateway,
): CreateProductUseCase {

    override operator fun invoke(payload: CreateProductInput): ProductOutput {
        val productCategory = findOrCreateProductCategoryGateway.execute(payload.productCategory)

        val product = saveProductGateway.execute(
            ProductImpl(
                idPartner = payload.idPartner,
                name = payload.name,
                price = payload.price,
                description = payload.description,
                extraIngredientLimit = payload.extraIngredientLimit,
                productCategory = productCategory
            )
        )

        val extraProductIngredients = mutableSetOf<ExtraProductIngredient>()
        payload.extraProductIngredients?.takeIf {
            it.isNotEmpty()
        }.let {
            payload.extraProductIngredients?.map {
                val extraProductIngredientSaved = saveExtraProductIngredient(
                    createProductIngredientGateway.execute(it, product)
                )

                extraProductIngredients.add(extraProductIngredientSaved)
            }
        }

        return ProductOutputImpl(product, extraProductIngredients)
    }

    private fun saveExtraProductIngredient(extraProductIngredients: ExtraProductIngredient): ExtraProductIngredient {
        extraProductIngredients.let {
           return saveExtraProductIngredientGateway.execute(it)
        }
    }

}