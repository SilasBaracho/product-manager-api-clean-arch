package sb.pma.useCase.product.create

import sb.pma.useCase.extraProductIngredients.create.CreateExtraProductIngredientsInput
import sb.pma.useCase.productCategory.findByName.FindProductCategoryByNameInput
import java.math.BigDecimal
import java.util.UUID

data class CreateProductInput(
    val idPartner: UUID,
    val name: String,
    val description: String? = null,
    val price: BigDecimal,
    val extraIngredientLimit: Int?,
    val productCategory: FindProductCategoryByNameInput,
    val extraProductIngredients: Set<CreateExtraProductIngredientsInput>? = null
): java.io.Serializable {}