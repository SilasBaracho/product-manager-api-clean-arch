package sb.pma.infrastructure.resources.productCategory.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.productCategory.gateway.ProductCategoryGateway
import sb.pma.core.domain.productCategory.model.ProductCategory
import sb.pma.core.domain.productCategory.model.ProductCategoryImpl
import sb.pma.infrastructure.config.db.repository.ProductCategoryRepository
import sb.pma.infrastructure.resources.productCategory.adapter.ProductCategoryAdapter
import sb.pma.core.useCase.productCategory.findByName.FindProductCategoryByNameInput
import java.time.LocalDateTime
import java.util.Optional

@Component
class ProductCategoryDatabaseGateway(
    private val productCategoryAdapter: ProductCategoryAdapter,
    private val productCategoryRepository: ProductCategoryRepository
): ProductCategoryGateway {

    override fun save(productCategory: ProductCategory): ProductCategory {
        return productCategoryRepository.save(
            productCategoryAdapter.toSchema(productCategory)
        ).let {
            productCategoryAdapter.toDomain(it)
        }
    }

    override fun delete(productCategory: ProductCategory) {
        val productCategorySchema = productCategoryAdapter.toSchema(productCategory)
        productCategoryRepository.delete(productCategorySchema)
    }

    override fun findAll(): MutableList<ProductCategory> {
        val productCategories = mutableListOf<ProductCategory>()
        productCategoryRepository.findAll().map {
            val productCategory = productCategoryAdapter.toDomain(it)
            productCategories.add(productCategory)
        }

        return productCategories
    }

    override fun findById(id: Long): Optional<ProductCategory> {
        return productCategoryRepository.findById(id).map { productCategoryAdapter.toDomain(it) }
    }

    override fun findByName(name: String): Optional<ProductCategory> {
        return productCategoryRepository.findByName(name).map { productCategoryAdapter.toDomain(it) }
    }

    override fun findOrCreateProductCategory(payload: FindProductCategoryByNameInput): ProductCategory {
        return this.findByName(payload.name)
            .orElseGet {
                this.save(
                    ProductCategoryImpl(name = payload.name, createdAt = LocalDateTime.now())
                )
            }
    }
}