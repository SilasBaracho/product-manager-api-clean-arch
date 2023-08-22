package sb.pma.infrastructure.resources.extraProductIngredient.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sb.pma.infrastructure.utils.ConstantsUtils.ConstantConfig.EXTRA_PRODUCT_INGREDIENTS_URI_RESOURCE_V1
import sb.pma.useCase.extraProductIngredients.ExtraProductIngredientsOutput
import sb.pma.useCase.extraProductIngredients.create.CreateExtraProductIngredientsInput
import sb.pma.useCase.extraProductIngredients.create.CreateExtraProductIngredientsUseCase
import sb.pma.useCase.extraProductIngredients.delete.DeleteExtraIngredientsByProductInput
import sb.pma.useCase.extraProductIngredients.delete.DeleteExtraProductIngredientsUseCase
import sb.pma.useCase.extraProductIngredients.findById.FindExtraIngredientsByProductInput
import sb.pma.useCase.extraProductIngredients.findById.FindExtraIngredientsByProductUseCase
import sb.pma.useCase.product.delete.DeleteProductInput
import java.util.UUID

@RestController
@RequestMapping(EXTRA_PRODUCT_INGREDIENTS_URI_RESOURCE_V1)
class ExtraProductIngredientController(
    val createExtraProductIngredientsUseCase: CreateExtraProductIngredientsUseCase,
    val deleteExtraProductIngredientsUseCase: DeleteExtraProductIngredientsUseCase,
    val findExtraIngredientsByProductUseCase: FindExtraIngredientsByProductUseCase
) {

    @PostMapping("/{id_product}")
    fun create(
        @RequestBody payload: CreateExtraProductIngredientsInput,
        @PathVariable("id_product") idProduct: UUID
    ): ExtraProductIngredientsOutput {
        return createExtraProductIngredientsUseCase.invoke(payload, idProduct)
    }

    @GetMapping("/{id_product}")
    fun findIngredientsByProduct(@PathVariable("id_product") idProduct: UUID): List<ExtraProductIngredientsOutput> {
        return findExtraIngredientsByProductUseCase.invoke(FindExtraIngredientsByProductInput(idProduct))
    }

    @DeleteMapping("/{id_product}")
    fun delete(@PathVariable("id_product") idProduct: UUID){
        val payload = DeleteProductInput(idProduct)
        deleteExtraProductIngredientsUseCase.invoke(DeleteExtraIngredientsByProductInput(idProduct))
    }
}