package sb.pma.useCase.product.create

import org.springframework.stereotype.Service
import sb.pma.domain.extraProductIngredient.gateway.ExtraProductIngredientGateway
import sb.pma.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.domain.product.gateway.ProductGateway
import sb.pma.domain.product.model.ProductImpl
import sb.pma.domain.productCategory.gateway.ProductCategoryGateway
import sb.pma.useCase.product.ProductOutput

@Service
class CreateProductUseCase(
    val productGateway: ProductGateway,
    val productCategoryGateway: ProductCategoryGateway,
    val extraProductIngredientGateway: ExtraProductIngredientGateway
) {

    operator fun invoke(payload: CreateProductInput): ProductOutput {
        val productCategory = productCategoryGateway.findOrCreateProductCategory(payload.productCategory)

        val product = productGateway.save(
            ProductImpl(
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

        return ProductOutput(product, extraProductIngredients)
    }

    fun saveExtraProductIngredient(extraProductIngredients: ExtraProductIngredient): ExtraProductIngredient {
        extraProductIngredients.let {
           return extraProductIngredientGateway.save(it)
        }
    }

}