package sb.pma.domain.productCategory.gateway

import sb.pma.domain.productCategory.model.ProductCategory
import sb.pma.useCase.productCategory.findByName.FindProductCategoryByNameInput
import java.util.Optional

interface ProductCategoryGateway {
    fun save(productCategory: ProductCategory): ProductCategory

    fun delete(productCategory: ProductCategory)

    fun findAll(): MutableList<ProductCategory>

    fun findById(id: Long): Optional<ProductCategory>

    fun findByName(name: String): Optional<ProductCategory>

    fun findOrCreateProductCategory(payload: FindProductCategoryByNameInput): ProductCategory
}