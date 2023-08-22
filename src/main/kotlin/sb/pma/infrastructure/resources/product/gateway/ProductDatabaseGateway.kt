package sb.pma.infrastructure.resources.product.gateway

import org.springframework.stereotype.Component
import sb.pma.domain.product.gateway.ProductGateway
import sb.pma.domain.product.model.Product
import sb.pma.infrastructure.config.db.repository.ProductRepository
import sb.pma.infrastructure.resources.product.adapter.ProductAdapter
import java.util.Optional
import java.util.UUID

@Component
class ProductDatabaseGateway(
    private val productAdapter: ProductAdapter,
    private val productRepository: ProductRepository
): ProductGateway {

    override fun save(product: Product): Product {
        return productRepository.save(
            productAdapter.toSchema(product)
        ).let {
            productAdapter.toDomain(it)
        }
    }

    override fun delete(product: Product) {
        val productSchema = productRepository.findById(product.idProduct)
            .orElseThrow { NoSuchElementException("Product not found with id ${product.idProduct}") }

        return productRepository.delete(productSchema)
    }

    override fun findById(id: UUID): Optional<Product> {
        val product = productRepository.findById(id).orElse(null)
        return if (product != null) {
            Optional.of(
                productAdapter.toDomain(product)
            )
        } else {
            Optional.empty()
        }
    }

    override fun findAll(): MutableList<Product> {
        val products = productRepository.findAll()
        return products.map { product -> productAdapter.toDomain(product) }.toMutableList()
    }

}