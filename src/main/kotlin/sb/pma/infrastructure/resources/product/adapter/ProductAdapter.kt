package sb.pma.infrastructure.resources.product.adapter

import sb.pma.domain.product.model.Product
import sb.pma.infrastructure.config.db.schema.ProductSchema

interface ProductAdapter {
    fun toSchema(product: Product): ProductSchema

    fun toDomain(productSchema: ProductSchema): Product
}