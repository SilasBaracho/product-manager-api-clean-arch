package sb.pma.core.useCase.product.create

import sb.pma.core.domain.extraProductIngredient.gateway.CreateProductIngredientGateway
import sb.pma.core.domain.extraProductIngredient.gateway.SaveExtraProductIngredientGateway
import sb.pma.core.domain.extraProductIngredient.model.ExtraProductIngredient
import sb.pma.core.domain.product.gateway.FindProductByNameAndActiveGateway
import sb.pma.core.domain.product.gateway.SaveProductGateway
import sb.pma.core.domain.product.model.ProductImpl
import sb.pma.core.domain.product.output.ProductOutput
import sb.pma.core.domain.product.output.ProductOutputImpl
import sb.pma.core.domain.product.useCase.CreateProductUseCase
import sb.pma.core.domain.productCategory.gateway.FindOrCreateProductCategoryGateway
import sb.pma.infrastructure.exception.IllegalBusinessException
import sb.pma.infrastructure.exception.NotFoundException

class CreateProductUseCaseImpl(
    private val createProductIngredientGateway: CreateProductIngredientGateway,
    private val findOrCreateProductCategoryGateway: FindOrCreateProductCategoryGateway,
    private val findProductByNameAndActiveGateway: FindProductByNameAndActiveGateway,
    private val saveProductGateway: SaveProductGateway,
    private val saveExtraProductIngredientGateway: SaveExtraProductIngredientGateway,
): CreateProductUseCase {

    override operator fun invoke(payload: CreateProductInput): ProductOutput {
        findProductByNameAndActiveGateway.execute(payload.name).ifPresent {
            throw IllegalBusinessException("There is already a product with the registered name and it is active.")
        }

        payload.extraProductIngredients?.takeIf {
            it.isNotEmpty()
        }?.let {
            if (payload.extraIngredientLimit!! < payload.extraProductIngredients.size)
                throw IllegalBusinessException("Quantity reported in the limit of extra ingredients is less than the quantity of items entered.")
        }

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