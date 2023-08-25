package sb.pma.core.domain.product.gateway

import sb.pma.core.domain.product.model.Product
import java.util.Optional
import java.util.UUID

interface ProductGateway {
    fun save(product: Product): Product

    fun delete(product: Product)

    fun findById(id: UUID): Optional<Product>

    fun findAllProductByIdPartner(idPartner: UUID): MutableList<Product>
}