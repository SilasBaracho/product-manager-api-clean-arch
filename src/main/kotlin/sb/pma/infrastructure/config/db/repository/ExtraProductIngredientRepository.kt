package sb.pma.infrastructure.config.db.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import sb.pma.infrastructure.config.db.schema.ExtraProductIngredientSchema
import sb.pma.infrastructure.config.db.schema.ProductSchema
import sb.pma.infrastructure.config.db.schema.compositeKey.ProductIngredientId

@Repository
interface ExtraProductIngredientRepository: JpaRepository<ExtraProductIngredientSchema, ProductIngredientId> {
    fun findIngredientsByProduct(@Param("product") product: ProductSchema): Set<ExtraProductIngredientSchema>
}