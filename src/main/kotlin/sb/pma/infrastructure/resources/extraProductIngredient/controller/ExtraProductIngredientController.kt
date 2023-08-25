package sb.pma.infrastructure.resources.extraProductIngredient.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sb.pma.core.domain.extraProductIngredient.output.ExtraProductIngredientsOutput
import sb.pma.core.domain.extraProductIngredient.useCase.CreateExtraProductIngredientsUseCase
import sb.pma.core.domain.extraProductIngredient.useCase.DeleteExtraIngredientsByProductUseCase
import sb.pma.core.domain.extraProductIngredient.useCase.FindExtraIngredientsByProductUseCase
import sb.pma.core.useCase.extraProductIngredient.create.CreateExtraProductIngredientsInput
import sb.pma.core.useCase.extraProductIngredient.delete.DeleteExtraIngredientsByProductInput
import sb.pma.core.useCase.extraProductIngredient.findByIdProduct.FindExtraIngredientsByProductInput
import sb.pma.infrastructure.utils.ConstantsUtils.ConstantConfig.EXTRA_PRODUCT_INGREDIENTS_URI_RESOURCE_V1
import sb.pma.core.useCase.product.delete.DeleteProductInput
import java.util.UUID

@RestController
@RequestMapping(EXTRA_PRODUCT_INGREDIENTS_URI_RESOURCE_V1)
class ExtraProductIngredientController(
    val createExtraProductIngredientsUseCase: CreateExtraProductIngredientsUseCase,
    val deleteExtraIngredientsByProductUseCase: DeleteExtraIngredientsByProductUseCase,
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
        deleteExtraIngredientsByProductUseCase.invoke(DeleteExtraIngredientsByProductInput(idProduct))
    }
}