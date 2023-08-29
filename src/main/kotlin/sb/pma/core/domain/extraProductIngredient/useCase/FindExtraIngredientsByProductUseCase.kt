package sb.pma.core.domain.extraProductIngredient.useCase

import sb.pma.core.useCase.extraProductIngredient.findByIdProduct.FindExtraIngredientsByProductInput
import sb.pma.core.domain.extraProductIngredient.output.ExtraProductIngredientsOutput

interface FindExtraIngredientsByProductUseCase {

    operator fun invoke(input: FindExtraIngredientsByProductInput): List<ExtraProductIngredientsOutput>
}