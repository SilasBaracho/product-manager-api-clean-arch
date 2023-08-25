package sb.pma.core.useCase.product.create

import sb.pma.core.domain.extraProductIngredient.gateway.ExtraProductIngredientGateway
import sb.pma.core.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.core.domain.product.gateway.ProductGateway
import sb.pma.core.domain.product.model.ProductImpl
import sb.pma.core.domain.productCategory.gateway.ProductCategoryGateway
import sb.pma.core.domain.product.output.ProductOutput
import sb.pma.core.domain.product.output.ProductOutputImpl
import sb.pma.core.domain.product.useCase.CreateProductUseCase

class CreateProductUseCaseImpl(
    private val productGateway: ProductGateway,
    private val productCategoryGateway: ProductCategoryGateway,
    private val extraProductIngredientGateway: ExtraProductIngredientGateway
): CreateProductUseCase {

    override operator fun invoke(payload: CreateProductInput): ProductOutput {
        val productCategory = productCategoryGateway.findOrCreateProductCategory(payload.productCategory)

        val product = productGateway.save(
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
                    extraProductIngredientGateway.createProductIngredientsSet(it, product)
                )

                extraProductIngredients.add(extraProductIngredientSaved)
            }
        }

        return ProductOutputImpl(product, extraProductIngredients)
    }

    fun saveExtraProductIngredient(extraProductIngredients: ExtraProductIngredient): ExtraProductIngredient {
        extraProductIngredients.let {
           return extraProductIngredientGateway.save(it)
        }
    }

}