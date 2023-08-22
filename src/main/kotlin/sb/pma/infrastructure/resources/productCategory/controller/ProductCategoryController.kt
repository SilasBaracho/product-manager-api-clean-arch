package sb.pma.infrastructure.resources.productCategory.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sb.pma.infrastructure.utils.ConstantsUtils.ConstantConfig.PRODUCT_CATEGORY_URI_RESOURCE_V1
import sb.pma.useCase.productCategory.ProductCategoryOutput
import sb.pma.useCase.productCategory.create.CreateProductCategoryInput
import sb.pma.useCase.productCategory.create.CreateProductCategoryUseCase
import sb.pma.useCase.productCategory.delete.DeleteProductCategoryInput
import sb.pma.useCase.productCategory.delete.DeleteProductCategoryUseCase
import sb.pma.useCase.productCategory.findAll.FindAllProductCategoryUseCase
import sb.pma.useCase.productCategory.findById.FindProductCategoryByIdInput
import sb.pma.useCase.productCategory.findById.FindProductCategoryByIdUseCase
import sb.pma.useCase.productCategory.findByName.FindProductCategoryByNameInput
import sb.pma.useCase.productCategory.findByName.FindProductCategoryByNameUseCase

@RestController
@RequestMapping(PRODUCT_CATEGORY_URI_RESOURCE_V1)
class ProductCategoryController(
    val createProductCategoryUseCase: CreateProductCategoryUseCase,
    val deleteProductCategoryUseCase: DeleteProductCategoryUseCase,
    val findAllProductCategoryUseCase: FindAllProductCategoryUseCase,
    val findProductCategoryByIdUseCase: FindProductCategoryByIdUseCase,
    val findProductCategoryByNameUseCase: FindProductCategoryByNameUseCase
) {

    @PostMapping
    fun create(@RequestBody payload: CreateProductCategoryInput): ProductCategoryOutput {
        return createProductCategoryUseCase.invoke(payload)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long){
        val payload = DeleteProductCategoryInput(id)
        deleteProductCategoryUseCase.invoke(payload)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") idProduct: Long): ProductCategoryOutput {
        val payload = FindProductCategoryByIdInput(id = idProduct)
        return findProductCategoryByIdUseCase.invoke(payload)
    }

    @GetMapping("find-by-name/{name}")
    fun findByName(@PathVariable("name") name: String): ProductCategoryOutput {
        val payload = FindProductCategoryByNameInput(name = name)
        return findProductCategoryByNameUseCase.invoke(payload)
    }

    @GetMapping("/find-all")
    fun findAll(): List<ProductCategoryOutput> {
        return findAllProductCategoryUseCase.invoke()
    }


}