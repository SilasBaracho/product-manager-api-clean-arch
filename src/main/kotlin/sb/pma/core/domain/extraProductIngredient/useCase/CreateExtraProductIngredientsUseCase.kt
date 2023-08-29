package sb.pma.core.domain.extraProductIngredient.useCase

import sb.pma.core.domain.extraProductIngredient.output.ExtraProductIngredientsOutput
import sb.pma.core.useCase.extraProductIngredient.create.CreateExtraProductIngredientsInput
import java.util.UUID

interface CreateExtraProductIngredientsUseCase {

    operator fun invoke(payload: CreateExtraProductIngredientsInput, idProduct: UUID): ExtraProductIngredientsOutput
}