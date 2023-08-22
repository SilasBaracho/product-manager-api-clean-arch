package sb.pma.infrastructure.resources.ingredient.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sb.pma.infrastructure.utils.ConstantsUtils.ConstantConfig.INGREDIENT_URI_RESOURCE_V1
import sb.pma.useCase.ingredient.IngredientOutput
import sb.pma.useCase.ingredient.create.CreateIngredientInput
import sb.pma.useCase.ingredient.create.CreateIngredientUseCase
import sb.pma.useCase.ingredient.delete.DeleteIngredientInput
import sb.pma.useCase.ingredient.delete.DeleteIngredientUseCase
import sb.pma.useCase.ingredient.findAll.FindAllIngredientUseCase
import sb.pma.useCase.ingredient.findById.FindIngredientByIdInput
import sb.pma.useCase.ingredient.findById.FindIngredientByIdUseCase
import sb.pma.useCase.ingredient.findByName.FindIngredientByNameInput
import sb.pma.useCase.ingredient.findByName.FindIngredientByNameUseCase

@RestController
@RequestMapping(INGREDIENT_URI_RESOURCE_V1)
class IngredientController(
    val createIngredientUseCase: CreateIngredientUseCase,
    val deleteIngredientUseCase: DeleteIngredientUseCase,
    val findIngredientByIdUseCase: FindIngredientByIdUseCase,
    val findIngredientByNameUseCase: FindIngredientByNameUseCase,
    val findAllIngredientUseCase: FindAllIngredientUseCase
) {

    @PostMapping
    fun create(@RequestBody payload: CreateIngredientInput): IngredientOutput {
        return createIngredientUseCase.invoke(payload)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long){
        val payload = DeleteIngredientInput(id)
        deleteIngredientUseCase.invoke(payload)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long): IngredientOutput {
        val payload = FindIngredientByIdInput(id)
        return findIngredientByIdUseCase.invoke(payload)
    }

    @GetMapping("find-by-name/{name}")
    fun findByName(@PathVariable("name") name: String): IngredientOutput {
        val payload = FindIngredientByNameInput(name = name)
        return findIngredientByNameUseCase.invoke(payload)
    }

    @GetMapping("/find-all")
    fun findAll(): List<IngredientOutput> {
        return findAllIngredientUseCase.invoke()
    }
}